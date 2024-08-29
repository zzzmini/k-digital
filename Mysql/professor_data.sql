DROP TABLE if exists professor;
CREATE TABLE professor
(
     p_id INT AUTO_INCREMENT,
     name VARCHAR(32) NOT NULL,
     belong VARCHAR(20) DEFAULT 'FOO',
     phone VARCHAR(20),
     PRIMARY KEY(p_id)
);

INSERT INTO professor
(name, belong, phone)
VALUES('유재석', 'COMPUTER','01012345678');

INSERT INTO professor
(name, belong, phone)
VALUES('황영조', 'SPORTS', '01021342443');

INSERT INTO professor
(name, belong, phone)
VALUES('케이멀', 'DANCE', '01023424343');

INSERT INTO professor
(name, belong, phone)
VALUES('호날두', 'ENGLISH', '01034343222');

INSERT INTO professor
(name, belong, phone)
VALUES('김형민','COMPUTER', '01023432432');
