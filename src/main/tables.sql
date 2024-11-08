CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    name       varchar(35)  NOT NULL UNIQUE,
    surname    varchar(20)  NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE CHECK (email LIKE '_%@_%.%'),
    birthday   date         NOT NULL,
    created_by int,
    created_at timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    last_login timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    password   varchar(30)  NOT NULL,
    updated_by int,
    bio        varchar(255)
);

CREATE TABLE post
(
    id         SERIAL PRIMARY KEY,
    user_id    int          NOT NULL,
    title      varchar(200) NOT NULL,
    view       int          DEFAULT 0,
    created_at timestamp(3) DEFAULT CURRENT_TIMESTAMP,
    created_by int          NOT NULL,
    updated_at timestamp(3) DEFAULT CURRENT_TIMESTAMP,
    updated_by int,
    post_like  int          DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE comment
(
    id           SERIAL PRIMARY KEY,
    post_id      int          NOT NULL,
    user_id      int          NOT NULL,
    content      varchar(250) NOT NULL,
    created_at   timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    created_by   int          NOT NULL,
    comment_like int          DEFAULT 0,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE post_like
(
    id         SERIAL PRIMARY KEY,
    user_id    int NOT NULL,
    post_id    int NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE
);
CREATE TABLE comment_like
(
    id         SERIAL PRIMARY KEY,
    user_id    int NOT NULL,
    comment_id int NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (comment_id) REFERENCES comment (id) ON DELETE CASCADE
);
INSERT INTO users
VALUES ('Anna', 'Illi', 'anli@example.com', '1999-11-12', 1, '2020-11-01 18:11:10', '2021-11-01 12:59:59',
        'password12345', 1, 'Developer'),
       ('Ali', 'Aliyev', 'aaliyev.@example.com', '1995-07-22', 2, '2023-11-11 03:24:26', '2023-11-01 09:22:09',
        'password121212', 2, 'Senior');
INSERT INTO post
VALUES (1, 1, 'Java', 100, '2024-11-11 12:32:29', 1, '2024-11-12 01:02:03', 1, 10),
       (2, 2, 'Traveling', 250, '2024-11-11 12:33:40', 1, '2023- 12:13:15', 1, 5);
INSERT INTO comment
VALUES (1, 1, 'Great post on Java!', '2024-11-11 12:45:00', 1, 3),
       (2, 2, 'I love traveling too!', '2024-11-11 12:50:00', 2, 5);
INSERT INTO post_like (user_id, post_id, created_at)
VALUES (1, 1, '2022-09-04 21:44:31'),
       (2, 1, '2024-03-10 19:33:22'),
       (1, 2, '2023-01-12 18:57:10');
INSERT INTO comment_like (user_id, comment_id, created_at)
VALUES (1, 1, '2022-01-10 22:58:19'),
       (2, 1, '2023-02-30 17:51:10'),
       (1, 2, '2024-12-12 13:22:09'),
       (2, 2, '2023-03-01 13:11:44');