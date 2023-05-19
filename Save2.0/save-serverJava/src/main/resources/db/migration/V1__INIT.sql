CREATE TABLE IF NOT EXISTS `user`
(
    `id`    BIGINT AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL,
    `name`  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `movies`
(
    `id`     BIGINT AUTO_INCREMENT,
    `name`   VARCHAR(255),
    `year`   VARCHAR(255),
    `poster` VARCHAR(255),
    `rating` VARCHAR(255),
    `user_id` BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `user_movies`
(
    `user_id`   BIGINT NOT NULL,
    `movies_id` BIGINT NOT NULL,
    PRIMARY KEY (user_id, movies_id)
);

ALTER TABLE `movies`
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE `user_movies`
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES `user` (id);

ALTER TABLE `user_movies`
    ADD CONSTRAINT fk_movies_id FOREIGN KEY (movies_id) REFERENCES `movies` (id);