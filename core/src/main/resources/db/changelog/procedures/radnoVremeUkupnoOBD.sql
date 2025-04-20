DROP PROCEDURE IF EXISTS radnoVremeUkupnoOBD;
CREATE PROCEDURE radnoVremeUkupnoOBD(_id int, _odDana datetime, _doDana datetime)
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
      AND datumVreme >= _odDana AND datumVreme < _doDana
    GROUP BY CAST(datumVreme AS DATE)
  ) AS dt;

  SELECT * FROM rezultat ORDER BY datum ASC;
END