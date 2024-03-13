CREATE TABLE girl_group
(
  _id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL,
  debut DATE NOT NULL,
  hit_song_id INT
);

CREATE TABLE song
(
  _id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(32) NOT NULL,
  lyrics VARCHAR(32)
);