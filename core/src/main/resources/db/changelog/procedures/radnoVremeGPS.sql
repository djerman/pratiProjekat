DROP PROCEDURE IF EXISTS radnoVremeGPS;
CREATE PROCEDURE radnoVremeGPS(_id int, _odDana datetime, _doDana datetime, _odSati int, _doSati int)
BEGIN
  DROP TEMPORARY TABLE IF EXISTS rezultat;
  CREATE TEMPORARY TABLE rezultat (
    datum date,
    pocetak datetime,
    kraj datetime,
    maxBrzina double,
    putRadno double
  ) ENGINE = MEMORY;

  INSERT INTO rezultat (datum, pocetak, kraj, maxBrzina, putRadno)
  SELECT _datum, _pocetak, _kraj, _maxBrzina, _putRadno
  FROM (
    SELECT
      CAST(datumVreme AS DATE) AS _datum,
      MIN(CASE WHEN kontakt IS TRUE THEN datumVreme END) AS _pocetak,
      MAX(CASE WHEN kontakt IS TRUE THEN datumVreme END) AS _kraj,
      MAX(brzina) AS _maxBrzina,
      (MAX(virtualOdo) - MIN(virtualOdo)) AS _putRadno
    FROM prati.ce_javljanja
    WHERE objekatId = _id
      AND HOUR(datumVreme) >= _odSati AND HOUR(datumVreme) < _doSati
      AND datumVreme >= _odDana AND datumVreme < _doDana
      AND valid = 1
    GROUP BY CAST(datumVreme AS DATE)
  ) AS dt;

  SELECT * FROM rezultat ORDER BY datum ASC;
END