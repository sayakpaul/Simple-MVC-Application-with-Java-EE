create table Product (productId number primary key, productName varchar(20) not null,quantity number not null, 
price number(10,2),status varchar(20));

insert into Product values (1, 'Toys',10,100.2,'New');

insert into Product values (2, 'Shoes',10,500.2,'New');

insert into Product values (3, 'Bats',10,100.2,'Active');

insert into Product values (4, 'Sports',10,10.2,'Active');

insert into Product values (5, 'Rackets',10,100.2,'Inactive');

insert into Product values (1, 'Guns',10,521.2,'Inactive');

select * from Product;