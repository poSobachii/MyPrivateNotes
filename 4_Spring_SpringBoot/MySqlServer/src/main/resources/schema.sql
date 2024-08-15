create table USERS
(
    ID     int          not null AUTO_INCREMENT,
    NAME   varchar(100),
    SURNAME   varchar(100),
    AGE int,
    EMAIL varchar(100),
    ISALIVE boolean,
    PRIMARY KEY (ID)
);