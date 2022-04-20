create table if not exists `board`
(
    board_id           int auto_increment
        primary key,
    name               varchar(255)                             not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1
);

create table if not exists `card`
(
    card_id            int auto_increment
        primary key,
    name               varchar(255)                             not null,
    description        varchar(255)                             null,
    board_fk           int                                      not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1,
    constraint fk_card_board
        foreign key (board_fk) references board (board_id)
);

create table if not exists `label`
(
    label_id           int auto_increment
        primary key,
    name               varchar(255)                             not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1
);

create table if not exists `card_label`
(
    card_fk            int                                      not null,
    label_fk           int                                      not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1,
    primary key(card_fk, label_fk),
    constraint fk_card_label_card
        foreign key (card_fk) references card (card_id),
    constraint fk_card_label_label
        foreign key (label_fk) references label (label_id)
);

create table if not exists `role`
(
    role_id            int auto_increment
        primary key,
    name               varchar(255)                             not null,
    description        varchar(512)                             null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1
);

create table if not exists `role_authorization`
(
    role_fk            int                                      not null,
    authorization      varchar(64)                              not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1,
    primary key (role_fk, authorization),
    constraint fk_role_authorization_role
        foreign key (role_fk) references role (role_id)

);

create table if not exists `user`
(
    user_id            int auto_increment
        primary key,
    first_name         varchar(255)                             not null,
    last_name          varchar(255)                             not null,
    email              varchar(255)                             not null,
    password           varchar(255)                             not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1
);

create table if not exists `user_role`
(
    user_fk            int                                      not null,
    role_fk            int                                      not null,
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1,
    primary key (user_fk, role_fk),
    constraint fk_user_role_role
        foreign key (role_fk) references role (role_id),
    constraint fk_user_role_user
        foreign key (user_fk) references user (user_id)
);

INSERT IGNORE INTO user (user_id, first_name, last_name, email, password)
VALUES (1, 'David', 'Stefanovic', 'david.stefanovic0711@gmail.com', '$2a$10$DnsgP/Lr2hC1PIUY5rx5SeaKA5d5UGRBZKMKU7nLACnSr1LW6a/v6');

INSERT IGNORE INTO role (role_id, name, description)
VALUES (1, 'admin', 'Administrator');

INSERT IGNORE INTO user_role (user_fk, role_fk)
VALUES (1, 1);