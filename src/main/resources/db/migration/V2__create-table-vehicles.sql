CREATE TABLE vehicles (
    id_vehicle UUID PRIMARY KEY,
    model_vehicle VARCHAR(255) NOT NULL,
    plate_number VARCHAR(255) NOT NULL UNIQUE,
    color_vehicle VARCHAR(255)
);
