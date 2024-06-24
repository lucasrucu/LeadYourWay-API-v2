-- Insertar Gpses
INSERT INTO gpses (created_date, deleted, latitude,longitude)
VALUES
    (NOW(), 0, 0.0, 0.0),
    (NOW(), 0, 12.5, 10.0),
    (NOW(), 0, 9.0, 20.0),
    (NOW(), 0, 12.0, 25.0),
    (NOW(), 0, 11.0, 12.5),
    (NOW(), 0, 19.5, 8.0);

UPDATE bicycles SET gps_id = 1 WHERE id = 1;
UPDATE bicycles SET gps_id = 2 WHERE id = 2;
UPDATE bicycles SET gps_id = 3 WHERE id = 3;

UPDATE bicycles SET gps_id = 4 WHERE id = 4;
UPDATE bicycles SET gps_id = 5 WHERE id = 5;
UPDATE bicycles SET gps_id = 6 WHERE id = 6;
