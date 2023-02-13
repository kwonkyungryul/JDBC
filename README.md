# JDBC를 이용한 자바 dbapp

## 데이터베이스 테이블

```sql
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