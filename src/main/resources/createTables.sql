-- roles: table
CREATE TABLE `roles`
(
    `id`   bigint NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- users: table
CREATE TABLE `users`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `age`      int          DEFAULT NULL,
    `email`    varchar(255) DEFAULT NULL,
    `lastname` varchar(255) DEFAULT NULL,
    `name`     varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- users_roles: table
CREATE TABLE `users_roles`
(
    `user_id`  bigint NOT NULL,
    `roles_id` bigint NOT NULL,
    PRIMARY KEY (`user_id`, `roles_id`),
    KEY        `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
    CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




INSERT INTO users (id, age, email, lastname, name, password) VALUES (1, 13, 'admin@mail.ru', 'admin', 'admin', '$2a$10$sr2Va4eallh62z/dHqiN5.Sf5GvC6SkfDFJ2HfDjp6Ba7NM7ZywDG');
INSERT INTO users (id, age, email, lastname, name, password) VALUES (2, 33, 'user@mail', 'user', 'user', '$2a$10$zFZngUaZD3KVVwBDQ33yUOmheojS81dbSOSOFrocdP8nlD35WyIay');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);