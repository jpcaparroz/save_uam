CREATE TABLE IF NOT EXISTS `user`
(
    `id`    BIGINT AUTO_INCREMENT,
    `email` VARCHAR(255) NOT NULL UNIQUE,
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

ALTER TABLE `movies`
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user (id);