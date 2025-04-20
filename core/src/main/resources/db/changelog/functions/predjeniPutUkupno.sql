DROP FUNCTION IF EXISTS predjeniPutUkupno;

CREATE FUNCTION predjeniPutUkupno(id int, datum datetime) RETURNS double
BEGIN
  DECLARE rastojanje DOUBLE DEFAULT 0.00;
  DECLARE put DOUBLE DEFAULT 0.00;
  DECLARE gotovo BOOLEAN DEFAULT FALSE;
  DECLARE lat1 DOUBLE DEFAULT 0.00;
  DECLARE lon1 DOUBLE DEFAULT 0.00;
  DECLARE lat2 DOUBLE DEFAULT 0.00;
  DECLARE lon2 DOUBLE DEFAULT 0.00;

  DECLARE javljanja CURSOR FOR
    SELECT a.lat, a.lon
    FROM ce_javljanja a
    WHERE a.objekatId = id
      AND a.datumVreme >= (DATE(datum) + INTERVAL 0 SECOND)
      AND a.datumVreme <= ((DATE(datum) + 1) + INTERVAL 0 SECOND)
      AND a.brzina >= 5
    ORDER BY a.datumVreme ASC;

  DECLARE CONTINUE HANDLER FOR NOT FOUND SET gotovo = TRUE;
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET gotovo = TRUE;

  SET put = 0.00;
  OPEN javljanja;
  FETCH_LOOP: LOOP 
    IF gotovo THEN
      LEAVE FETCH_LOOP;
    END IF;

    SET lat1 = lat2;
    SET lon1 = lon2;
    FETCH javljanja INTO lat2, lon2;

    IF (lat1 <> 0.00 AND lat2 <> 0.00) THEN
      SELECT ST_Distance_Sphere(POINT(lat1, lon1), POINT(lat2, lon2)) INTO rastojanje;
      SET put = put + rastojanje;
    END IF;
  END LOOP FETCH_LOOP;

  CLOSE javljanja;
  RETURN ROUND(put / 1000);
END