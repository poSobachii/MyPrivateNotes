create table items_all
(
    id          MEDIUMINT NOT NULL AUTO_INCREMENT,
    itemName    varchar(100),
    itemtype_id integer(10),
    qty         integer(10),
    price       integer(10),
    description varchar(500),
    is_favorite integer(1) DEFAULT 0 NOT NULL,
    primary key (id),
    unique (id)
);

create table item_types
(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    type_name varchar(255),
    material varchar(255),
    description varchar(255),
    primary key (id),
    unique (id)
);

create table orders
(
    order_id bigint(30) NOT NULL,
    primary key (order_id),
    email varchar(50),
    address nvarchar(100),
    phone varchar(20),
    order_status varchar(20),
    user_info nvarchar(2000),
    admin_info nvarchar(2000),
    unique (order_id)
);

create table order_wares
(
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    order_id bigint(30),
    item_id int(100),
    primary key (id),
    unique (id)
);
