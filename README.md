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

operation表：
```sql
create table operation
(
    id        int unsigned auto_increment comment 'id'
        primary key,
    operation varchar(20) not null comment '操作',
    constraint operation_rights_pk2
        unique (operation)
)
    comment '操作权限' row_format = DYNAMIC;

INSERT INTO test.operation (id, operation) VALUES (1, 'ADD');
INSERT INTO test.operation (id, operation) VALUES (3, 'DELETE');
INSERT INTO test.operation (id, operation) VALUES (4, 'EDIT');
INSERT INTO test.operation (id, operation) VALUES (2, 'VIEW');
```

rights表：
```sql
create table rights
(
    id        varchar(10) not null comment 'id'
        primary key,
    auth_name varchar(50) not null comment '权限名称',
    icon      varchar(50) null comment '图标',
    parent_id varchar(10) null comment '父级权限id',
    path      varchar(50) null comment '权限路径'
)
    comment '权限表' row_format = DYNAMIC;

INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('01', '用户管理', 'User', '0', '/user-manage');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('0101', '用户列表', 'User', '01', '/user-manage/users');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('02', '角色管理', 'Avatar', '0', '/role-manage');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('0201', '角色列表', 'Avatar', '02', '/role-manage/roles');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('03', '商品管理', 'Goods', '0', '/good-manage');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('0301', '商品列表', 'Goods', '03', '/good-manage/goods');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('0302', '商品种类', 'Goods', '03', '/good-manage/types');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('04', '订单管理', 'List', '0', '/order-manage');
INSERT INTO test.rights (id, auth_name, icon, parent_id, path) VALUES ('0401', '订单列表', 'List', '04', '/order-manage/order');
```

rights_operations表：
```sql
create table rights_operation
(
    id           int unsigned auto_increment comment 'id'
        primary key,
    rights_id    varchar(10)  not null comment '权限id',
    operation_id int unsigned not null comment '操作id'
)
    comment '权限操作中间表' row_format = DYNAMIC;

INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (1, '0101', 1);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (2, '0101', 2);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (3, '0101', 3);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (4, '0101', 4);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (5, '0201', 1);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (6, '0201', 2);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (7, '0201', 3);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (8, '0201', 4);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (9, '0301', 1);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (10, '0301', 2);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (11, '0301', 3);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (12, '0301', 4);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (17, '0302', 1);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (18, '0302', 2);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (19, '0302', 3);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (20, '0302', 4);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (21, '0401', 1);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (22, '0401', 2);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (23, '0401', 3);
INSERT INTO test.rights_operation (id, rights_id, operation_id) VALUES (24, '0401', 4);
```

role_rights表：
```sql
create table role_rights
(
    id        int unsigned auto_increment comment 'id'
        primary key,
    role_id   int unsigned not null comment '角色id',
    rights_id varchar(10)  not null comment '权限id'
)
    comment '角色权限对应表' row_format = DYNAMIC;

INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (1, 1, '01');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (2, 1, '0101');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (3, 1, '02');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (4, 1, '0201');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (5, 1, '03');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (6, 1, '0301');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (7, 1, '0302');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (9, 1, '04');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (10, 1, '0401');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (11, 2, '03');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (12, 2, '0301');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (13, 2, '0302');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (14, 2, '04');
INSERT INTO test.role_rights (id, role_id, rights_id) VALUES (15, 2, '0401');
```

roles表：
```sql
create table roles
(
    id   int unsigned auto_increment comment 'id'
        primary key,
    name varchar(20) not null comment '角色名',
    constraint roles_uq
        unique (name)
)
    comment '角色表' row_format = DYNAMIC;

INSERT INTO test.roles (id, name) VALUES (1, 'SYS_ADMIN');
INSERT INTO test.roles (id, name) VALUES (2, 'SYS_USER');
```

roles_rights_operation表：
```sql
create table roles_rights_operation
(
    id             int unsigned auto_increment
        primary key,
    role_rights_id int not null comment '角色-权限表id',
    operation_id   int not null comment '操作表id'
)
    comment '角色-权限-操作中间表';

INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (1, 2, 1);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (2, 2, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (3, 2, 3);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (4, 2, 4);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (5, 4, 1);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (6, 4, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (7, 4, 3);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (8, 4, 4);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (9, 6, 1);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (10, 6, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (11, 6, 3);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (12, 6, 4);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (13, 7, 1);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (14, 7, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (15, 7, 3);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (17, 10, 1);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (18, 10, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (19, 10, 3);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (20, 10, 4);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (21, 12, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (22, 13, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (23, 15, 2);
INSERT INTO test.roles_rights_operation (id, role_rights_id, operation_id) VALUES (24, 7, 4);
```

user表：
```sql
create table user
(
    id       int unsigned auto_increment comment 'id'
        primary key,
    username varchar(20)  not null comment '用户名',
    password varchar(30)  not null comment '密码',
    role_id  int unsigned not null comment '角色id',
    constraint user_uq
        unique (username)
)
    comment '用户表' row_format = DYNAMIC;

INSERT INTO test.user (id, username, password, role_id) VALUES (1, 'user', '123456', 2);
INSERT INTO test.user (id, username, password, role_id) VALUES (2, 'root', '123456', 1);
```

user_info表：
```sql
create table user_info
(
    id      int auto_increment comment 'id'
        primary key,
    name    varchar(10)  not null comment '姓名',
    address varchar(200) not null comment '地址'
)
    comment '人员信息表';

INSERT INTO test.user_info (id, name, address) VALUES (1, 'tom', '上海');
INSERT INTO test.user_info (id, name, address) VALUES (2, 'lilei', '北京');
INSERT INTO test.user_info (id, name, address) VALUES (3, 'wangmm', '南京');
INSERT INTO test.user_info (id, name, address) VALUES (4, 'alice', '深圳');
```
