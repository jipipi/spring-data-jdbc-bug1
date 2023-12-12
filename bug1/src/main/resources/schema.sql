CREATE TABLE IF NOT EXISTS Car (
    id INTEGER IDENTITY PRIMARY KEY,
     name VARCHAR(100),
     -- UserAudit attributes
    modified_user  varchar(255),
    modified_date  timestamp,
    created_user   varchar(255),
    created_date   timestamp
     );

CREATE TABLE IF NOT EXISTS Car_Ok (
                                   id INTEGER IDENTITY PRIMARY KEY,
                                   name VARCHAR(100),
                                   modified_user  varchar(255),
                                   modified_date  timestamp,
                                   created_user   varchar(255),
                                   created_date   timestamp
);