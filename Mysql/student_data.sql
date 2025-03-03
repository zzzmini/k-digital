DROP TABLE if exists STUDENT;

CREATE TABLE student
(
     s_id CHAR(9),
     name VARCHAR(48) NOT NULL,
     belong VARCHAR(20),
     phone VARCHAR(20),
     status INT DEFAULT 0
);

INSERT INTO student VALUES('20090101', '루피', 'COMPUTER', '01012345678', 1);
INSERT INTO student VALUES('20100102', '조로', 'MUSIC', '01023435343', 2);
INSERT INTO student VALUES('20110103', '상디', 'SPORTS', '01021342443', 1);
INSERT INTO student VALUES('20100204', '버기', 'DANCE', '01023424343', 2);
INSERT INTO student VALUES('20110106', '프랑키', 'ENGLISH', '01034343222' , 1);
INSERT INTO student VALUES('20080104', '나미', 'COMPUTER', '01023432432', 3);
INSERT INTO student VALUES('20090105', '쵸파', 'MUSIC', '01012342433', 3);
INSERT INTO student VALUES('20090301', '에릭', 'DANCE', '01032424244', 2);
INSERT INTO student VALUES('20090302', '전진', 'COMPUTER', '01012321313', 3);
INSERT INTO student VALUES('20100505', '오공', 'MUSIC', '01023534644', 2);
INSERT INTO student VALUES('20110506', '오천', 'SPORTS', '01021334525', 1);
INSERT INTO student VALUES('20100507', '베지터', 'DANCE', '01023423623', 2);
INSERT INTO student VALUES('20110502', '부우', 'ENGLISH', '01034332634', 1);
INSERT INTO student VALUES('20080501', '크리링', 'COMPUTER', '01023436346', 2);
INSERT INTO student VALUES('20090503', '피콜로', 'MUSIC', '01013634645', 3);
INSERT INTO student VALUES('20090509', '셀', 'DANCE', '01032427535', 3);
