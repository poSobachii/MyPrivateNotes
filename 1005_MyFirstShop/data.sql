create database if not exists smartdogshop;

use smartdogshop;

drop table if exists WARES;


create table wares (
    id int auto_increment primary key,
    waretype varchar(15),
    warename varchar(50),
    imgcode varchar(20),
    price float,
    qty int,
    info text
);


insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'red shirt', '1', 11.99, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'blue shirt', '2', 13.99, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'white shirt', '3', 15.99, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'green shirt', '4', 14.75, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'yellow shirt', '5', 13.90, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'black shirt', '6', 15.99, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'brownee shirt', '7', 15.50, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt', 'magenta shirt', '8', 12.30, 10 , 'some text' );
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt2', 'ADIDAS shirt', '100', 11.99, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt2', 'DOG shirt', '200', 13.99, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt2', 'ESPORTS shirt', '300', 15.99, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt2', 'NIKE shirt', '400', 14.99, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt2', 'HUAWEI shirt', '500', 13.99, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('shirt2', 'PUMA shirt', '600', 15.99, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('cups', 'CHICKEN cup','501', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('cups', 'DOG cup','502', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('cups', 'CAT cup','503', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('cups', 'HORSE cup','504', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('cups', 'BIRD cup','505', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('balloons', 'RED ballon','1501', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('balloons', 'BLUE ballon','1502', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('balloons', 'GREEN ballon','1503', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('balloons', 'ORANGE ballon','1504', 11.70, 10, 'some extra info');
insert into wares (waretype, warename, imgcode, price, qty, info) values ('balloons', 'LIME ballon','1505', 11.70, 10, 'some extra info');
