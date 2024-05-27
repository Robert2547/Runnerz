CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    started_on timestamp NOT NULL,
    ended_on timestamp NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);