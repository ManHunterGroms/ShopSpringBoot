CREATE TABLE user (
  id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstname  VARCHAR(15) NOT NULL,
  lastname   VARCHAR(20) NOT NULL,
  middlename VARCHAR(20) NOT NULL,
  address    VARCHAR(200),
  email      VARCHAR(30) NOT NULL,
  password   VARCHAR(64) NOT NULL
);

CREATE TABLE role (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(15) NOT NULL
);

CREATE TABLE user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (role_id) REFERENCES role (id)
);

insert into user VALUES (1, 'Test', 'Test', 'Test', 'Test', 'test@test.test', '$2a$04$o0nh7HX22CgnEr/KoRMTKu9nxnc8Evjx4ToYxav8WMsN311Mi3wSu');