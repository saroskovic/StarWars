INSERT IGNORE INTO role (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT IGNORE INTO role (id, role) VALUES (2, 'ROLE_USER');
INSERT IGNORE INTO user (id, email, password, username) VALUES (1, 'zoran@mail.com', 'pass123', 'zoran');
INSERT IGNORE INTO user (id, email, password, username) VALUES (2, 'pera@mail.com', 'pass123', 'pera');
INSERT IGNORE INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT IGNORE INTO user_roles(user_id, role_id) VALUES (2, 2);
