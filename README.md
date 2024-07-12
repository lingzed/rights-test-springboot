# rights-test-springboot

# 数据sql
goods表：
```sql
create table goods
(
    id    int unsigned auto_increment comment 'id'
        primary key,
    name  varchar(50) not null comment '商品名称',
    price double      not null comment '价格'
)
    comment '商品表';

INSERT INTO test.goods (id, name, price) VALUES (1, '手机', 3000);
INSERT INTO test.goods (id, name, price) VALUES (2, '电脑', 7500);
INSERT INTO test.goods (id, name, price) VALUES (3, '显卡', 6000);
INSERT INTO test.goods (id, name, price) VALUES (4, '显示器', 2000);
INSERT INTO test.goods (id, name, price) VALUES (5, '鼠标', 150);
INSERT INTO test.goods (id, name, price) VALUES (6, '键盘', 1000);
INSERT INTO test.goods (id, name, price) VALUES (7, 'cpu', 4000);
INSERT INTO test.goods (id, name, price) VALUES (8, 'ssd', 1000.5);
```
