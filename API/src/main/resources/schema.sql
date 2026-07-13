CREATE TABLE greeting (
    id INTEGER PRIMARY KEY,
    message VARCHAR(100)
);

CREATE TABLE planets (
    id INTEGER PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE routes (
    id INTEGER PRIMARY KEY,
    origin_planet_id INTEGER NOT NULL REFERENCES planets(id),
    destination_planet_id INTEGER NOT NULL REFERENCES planets(id),
    distance DECIMAL(6,2) NOT NULL
);
