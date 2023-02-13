``` MYSQL
CREATE DATABASE metadb;

use metadb;

CREATE TABLE product(
	id int auto_increment primary key,
    name varchar(50),
    price int,
    qty int,
    created_at timestamp
);
```