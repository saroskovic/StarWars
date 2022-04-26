INSERT IGNORE INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT IGNORE INTO role (id, name) VALUES (2, 'ROLE_USER');
INSERT IGNORE INTO user (id, email, password, role, username) VALUES (1, 'zoran@mail.com', 'pass123', 1, 'zoran');
INSERT IGNORE INTO user (id, email, password, role, username) VALUES (2, 'pera@mail.com', 'pass123', 2 , 'pera');