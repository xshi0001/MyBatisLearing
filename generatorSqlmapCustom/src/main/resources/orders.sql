create table orders
(
    id         int auto_increment
        primary key,
    user_id    int          not null comment '下单用户id',
    number     varchar(32)  not null comment '订单号',
    createtime datetime     not null comment '创建订单时间',
    note       varchar(100) null comment '备注',
    constraint FK_orders_id
        foreign key (user_id) references user (id)
);

create index FK_orders_1
    on orders (user_id);
