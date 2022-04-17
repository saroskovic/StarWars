INSERT INTO role (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, role) VALUES (2, 'ROLE_USER');
INSERT INTO user (id, email, password, role_id, username) VALUES (1, 'zoran@mail.com', 'pass123', 1, 'zoran');
INSERT INTO user (id, email, password, role_id, username) VALUES (2, 'pera@mail.com', 'pass123', 2 , 'pera');