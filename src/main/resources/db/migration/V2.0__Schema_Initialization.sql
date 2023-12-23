CREATE TABLE IF NOT EXISTS token
(
    id              UUID NOT NULL,
    creation_date   TIMESTAMP WITHOUT TIME ZONE,
    last_usage_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_token PRIMARY KEY (id)
);