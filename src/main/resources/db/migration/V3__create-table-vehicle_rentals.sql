CREATE TABLE vehicle_rentals (
    id_rental UUID PRIMARY KEY,
    date_rental TIMESTAMP NOT NULL,
    date_return TIMESTAMP NOT NULL,

    client_rental_id UUID,
    vehicle_rental_id UUID,

    CONSTRAINT fk_client_rental
        FOREIGN KEY (client_rental_id)
        REFERENCES clients(id_client)
        ON DELETE SET NULL,

    CONSTRAINT fk_vehicle_rental
        FOREIGN KEY (vehicle_rental_id)
        REFERENCES vehicles(id_vehicle)
        ON DELETE SET NULL
);
