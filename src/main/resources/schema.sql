DROP TABLE IF EXISTS `order`;
create table `order`
(
    id               bigint auto_increment primary key,
    product          varchar(255) not null,
    quantity         int          not null,
    customer_name    varchar(255) not null,
    customer_address varchar(255) not null,
    status           varchar(20)  not null
);