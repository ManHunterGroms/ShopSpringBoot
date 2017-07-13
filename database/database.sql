CREATE TABLE user (
  id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(30) NOT NULL,
  password VARCHAR(64) NOT NULL
);

CREATE TABLE role (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(15) NOT NULL
);

CREATE TABLE user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
)