DROP PROCEDURE IF EXISTS predjeniPutGPS;

CREATE PROCEDURE predjeniPutGPS(_id int, _odDana datetime, _doDana datetime)
BEGIN
   DROP TEMPORARY TABLE IF EXISTS rez;
   CREATE TEMPORARY TABLE rez ( pocetak double, kraj double, put double, maxBrzina double) ENGINE = MEMORY;

   INSERT INTO rez (pocetak, kraj, put, maxBrzina)
   SELECT _pocetak, _kraj, _put, _maxBrzina
   FROM (
     SELECT 
        MIN(virtualOdo) AS _pocetak,
        MAX(virtualOdo) AS _kraj,
        CASE 
            WHEN MAX(virtualOdo) >= MIN(virtualOdo) THEN (MAX(virtualOdo) - MIN(VirtualOdo)) 
            ELSE 0 
        END AS _put,
        MAX(brzina) AS _maxBrzina
     FROM prati.ce_javljanja
     WHERE objekatId = _id 
       AND datumVreme >= _odDana
       AND datumVreme < _doDana
       AND valid = 1
   ) AS dt;

   SELECT * FROM rez;
END