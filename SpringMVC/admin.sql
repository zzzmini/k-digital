CREATE TABLE public."admin" (
	a_id varchar NOT NULL,
	a_pw varchar NOT NULL,
	a_name varchar NOT NULL,
	a_phone varchar NULL,
	a_approval int4 NULL,
	CONSTRAINT admin_pk PRIMARY KEY (a_id)
);
