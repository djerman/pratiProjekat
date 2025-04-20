DROP PROCEDURE IF EXISTS radnoVremeOBD;
CREATE PROCEDURE radnoVremeOBD(_id int, _odDana datetime, _doDana datetime, _odSati int, _doSati int)
BEGIN
  DROP TEMPORARY TABLE IF EXISTS rezultat;
  CREATE TEMPORARY TABLE rezultat (
    datum date,
    pocetak datetime,
    kraj datetime,
    putRadno double
  ) ENGINE = MEMORY;

  INSERT INTO rezultat (datum, pocetak, kraj, putRadno)
  SELECT _datum, _pocetak, _kraj, _putRadno
  FROM (
    SELECT
      CAST(datumVreme AS DATE) AS _datum,
      MIN(datumVreme) AS _pocetak,
      MAX(datumVreme) AS _kraj,
      (MAX(ukupnoKm) - MIN(ukupnoKm)) AS _putRadno
    FROM prati.cg_obd
    WHERE objekatId = _id
      AND HOUR(datumVreme) >= _odSati AND HOUR(datumVreme) < _doSati
      AND datumVreme >= _odDana AND datumVreme < _doDana
      AND DAYOFWEEK(datumVreme) NOT IN (1, 7)
    GROUP BY CAST(datumVreme AS DATE)
  ) AS dt;

  SELECT * FROM rezultat ORDER BY datum ASC;
END