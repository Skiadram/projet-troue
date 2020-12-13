CREATE TABLE IF NOT EXISTS user
(
    id_user INT NOT NULL,
    password VARCHAR(250) NOT NULL,
    nom VARCHAR(250) NOT NULL,
    PRIMARY KEY(id_user)

);


INSERT INTO user (id_user, password,nom ) VALUES (1,'password', 'root');
