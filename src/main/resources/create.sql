CREATE TABLE IF NOT EXISTS User
(
    user_id     integer NOT NULL ,
    username    varchar(100) NOT NULL,
    nom         varchar(45) NOT NULL ,
    prenom      varchar(45) NOT NULL ,
    password    varchar(45) NOT NULL ,
    birthday    date NULL ,
    description nvarchar(200) NULL ,

    PRIMARY KEY (user_id)
    );

CREATE TABLE IF NOT EXISTS Post
(
    post_id integer NOT NULL ,
    text    nvarchar(45) NOT NULL ,
    user_id integer NOT NULL ,
    private_post binary NOT NULL ,

    PRIMARY KEY (post_id)
    );

ALTER TABLE Post
    ADD FOREIGN KEY (user_id)
        REFERENCES User(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
;

CREATE TABLE IF NOT EXISTS Friend
(
    person_id INT NOT NULL,
    friend_id INT NOT NULL,
    PRIMARY KEY(user_id, friend_id)
    );

ALTER TABLE Friend
    ADD FOREIGN KEY (person_id)
        REFERENCES User(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
;

ALTER TABLE Friend
    ADD FOREIGN KEY (friend_id)
        REFERENCES User(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
;

CREATE TABLE IF NOT EXISTS Request
(
    requester_id INT NOT NULL,
    requested_id INT NOT NULL,
    PRIMARY KEY(requester_id, requested_id)
);

ALTER TABLE Request
    ADD FOREIGN KEY (requester_id)
        REFERENCES User(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
;

ALTER TABLE Request
    ADD FOREIGN KEY (requested_id)
        REFERENCES User(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
;
