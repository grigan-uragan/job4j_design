INSERT INTO role (role_id, role_name) VALUES (1, 'USER'), (2, 'ADMIN');

INSERT INTO users(users_id, user_name, role_id) VALUES (1, 'Bob', 1), (2, 'Tom', 2);

INSERT INTO rules(rules_id, rules_name) VALUES (1, 'User'), (2, 'Admin');

INSERT INTO role_rule(role_rule_id, role_id, rules_id) VALUES (1, 1, 1), (2, 2, 1), (3, 2, 2);

INSERT INTO category(category_id, category_name) VALUES (1, 'Technic'), (2, 'Other');

INSERT INTO state(state_id, state_name) VALUES (1, 'ACCEPT'), (2, 'FIXED'), (3, 'BUG');

INSERT INTO item(item_id, description, users_id_fk, category_id_fk, state_id_fk)
VALUES (1, 'HELLO WORLD', '1', '2', 1), (2, 'Helo Word', 2, 2, 3);

INSERT INTO comments(comments_id, comments, users_id_fk, item_id_fk)
VALUES (1, 'this is correct', 1, 1), (2, 'agree', 2, 1);