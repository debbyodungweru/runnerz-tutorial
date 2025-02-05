CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    started TIMESTAMP NOT NULL,
    ended TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(10) NOT NULL,
    version INT NOT NULL,
    PRIMARY KEY (id)
);