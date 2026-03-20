CREATE TABLE `brand`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `logo` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `dealership`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `logo`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `car`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `model`      varchar(255) NOT NULL,
    `brand_id`      int DEFAULT NULL,
    `price`      float DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `car_dealership`
(
    `car_id`  int DEFAULT NULL,
    `dealership_id` int DEFAULT NULL
);

INSERT INTO `dealership`(`id`, `name`, `logo`)
VALUES ('1', 'https://www.vcentrum.pl/wp-content/uploads/2021/09/vcentrum-logo.png',
        'vcentrum');
INSERT INTO `dealership`(`id`, `name`, `logo`)
VALUES ('2', 'https://eurocar.pl/wp-content/uploads/2023/08/logo-euro-car.png', 'eurocar');
INSERT INTO `dealership`(`id`, `name`, `logo`)
VALUES ('3', 'https://1000logos.net/wp-content/uploads/2021/09/CarMax-Logo-500x281.png', 'carmax');

INSERT INTO `brand`(`id`, `name`, `logo`)
VALUES ('1', 'Toyota', 'https://brand.toyota.com/content/dam/brandhub/guidelines/logo/four-column/BHUB_Logo_LogoFamily_01.svg');
INSERT INTO `brand`(`id`, `name`, `logo`)
VALUES ('2', 'Ford', 'https://www.citypng.com/public/uploads/preview/ford-logo-emblem-hd-png-70175169471401511cpxj0ogw.png');
INSERT INTO `brand`(`id`, `name`, `logo`)
VALUES ('3', 'Porsche', 'https://1000logos.net/wp-content/uploads/2018/02/Porsche-Logo-500x281.png');

INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('1', 'yarris','1', '130000');
INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('2', 'rav4','1', '133200');
INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('3', 'chr','1', '13000');
INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('4', 'raptor','2', '132000');
INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('5', 'mondeo','2', '30000');
INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('6', 'cortina','2', '57400');
INSERT INTO `car`(`id`, `model`,`brand_id`, `price`)
VALUES ('7', 'taycan','3', '1300000');

INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('1', '1');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('1', '3');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('2', '3');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('3', '1');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('3', '2');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('4', '1');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('4', '3');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('5', '2');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('5', '3');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('6', '1');
INSERT INTO `car_dealership`(`car_id`, `dealership_id`)
VALUES ('7', '2');














CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




