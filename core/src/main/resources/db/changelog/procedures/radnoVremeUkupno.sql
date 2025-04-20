DROP PROCEDURE IF EXISTS radnoVremeUkupno;
CREATE PROCEDURE radnoVremeUkupno(_id int, _odDana datetime, _doDana datetime)
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
      MIN(datumVreme) AS _pocetak,
      MAX(datumVreme) AS _kraj,
      MAX(brzina) AS _maxBrzina,
      (MAX(virtualOdo) - MIN(virtualOdo)) AS _putRadno
    FROM prati.ce_javljanja
    WHERE objekatId = _id
      AND datumVreme >= _odDana AND datumVreme < _doDana
      AND valid = 1
    GROUP BY CAST(datumVreme AS DATE)
  ) AS dt;

  SELECT * FROM rezultat ORDER BY datum ASC;
END