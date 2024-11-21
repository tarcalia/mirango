CREATE TABLE company (
    id UUID                 PRIMARY KEY         NOT NULL,
    name                    VARCHAR(255)        NOT NULL,
    created_at              TIMESTAMP         DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_at             TIMESTAMP,
    version                 INTEGER DEFAULT 0 NOT NULL
);

CREATE TABLE employee (
    id UUID                 PRIMARY KEY         NOT NULL,
    name                    VARCHAR(255)        NOT NULL,
    created_at              TIMESTAMP         DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_at             TIMESTAMP,
    company_id UUID,
    version                 INTEGER DEFAULT 0 NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(id)
);