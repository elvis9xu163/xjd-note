/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/11/15 22:37:29                          */
/*==============================================================*/


drop index UNIQUE_INDEX_AUTH_ENTITY_NAME on auth_entity;

drop table if exists auth_entity;

drop index UNIQUE_INDEX_AUTHORITY_NAME on authority;

drop table if exists authority;

drop table if exists group_authority;

drop index UNIQUE_INDEX_GROUP_NAME on groups;

drop table if exists groups;

drop table if exists user_authority;

drop table if exists user_group;

drop index UNIQUE_INDEX_USER_EMAIL on users;

drop index UNIQUE_INDEX_USER_NAME on users;

drop table if exists users;

/*==============================================================*/
/* Table: auth_entity                                           */
/*==============================================================*/
create table auth_entity
(
   id                   bigint(11) not null auto_increment comment '主键id',
   name                 varchar(20) not null comment '实体名',
   comment              varchar(50) comment '说明',
   primary key (id)
);

alter table auth_entity comment '权限实体';

/*==============================================================*/
/* Index: UNIQUE_INDEX_AUTH_ENTITY_NAME                         */
/*==============================================================*/
create index UNIQUE_INDEX_AUTH_ENTITY_NAME on auth_entity
(
   name
);

/*==============================================================*/
/* Table: authority                                             */
/*==============================================================*/
create table authority
(
   id                   bigint(11) not null auto_increment comment 'id主键',
   name                 varchar(20) not null comment '权限代码',
   comment              varchar(50) comment '说明',
   primary key (id)
);

alter table authority comment '权限表';

/*==============================================================*/
/* Index: UNIQUE_INDEX_AUTHORITY_NAME                           */
/*==============================================================*/
create unique index UNIQUE_INDEX_AUTHORITY_NAME on authority
(
   name
);

/*==============================================================*/
/* Table: group_authority                                       */
/*==============================================================*/
create table group_authority
(
   group_id             bigint(11) not null comment '组ID',
   authority_id         bigint(11) not null comment '权限ID',
   entity_id            bigint(11) not null comment '实体ID',
   primary key (group_id, authority_id, entity_id)
);

/*==============================================================*/
/* Table: groups                                                */
/*==============================================================*/
create table groups
(
   id                   bigint(11) not null auto_increment comment 'id主键',
   name                 varchar(20) not null comment '组名',
   comment              varchar(50) comment '说明',
   primary key (id)
);

alter table groups comment '用户组';

/*==============================================================*/
/* Index: UNIQUE_INDEX_GROUP_NAME                               */
/*==============================================================*/
create index UNIQUE_INDEX_GROUP_NAME on groups
(
   name
);

/*==============================================================*/
/* Table: user_authority                                        */
/*==============================================================*/
create table user_authority
(
   user_id              bigint(11) not null comment '用户ID',
   authority_id         bigint(11) not null comment '权限ID',
   entity_id            bigint(11) not null comment '实体ID',
   primary key (user_id, authority_id, entity_id)
);

/*==============================================================*/
/* Table: user_group                                            */
/*==============================================================*/
create table user_group
(
   user_id              bigint(11) not null comment '用户ID',
   group_id             bigint(11) not null comment '组ID',
   primary key (user_id, group_id)
);

alter table user_group comment '用户与组的关系表';

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   id                   bigint(11) not null auto_increment comment 'id主键',
   name                 varchar(30) not null comment '用户名',
   email                varchar(30) not null comment '电子邮件',
   password             varchar(40) not null comment '加密后的密码',
   enabled              tinyint(1) not null default 0 comment '激活状态:
            1--激活状态
            0--非激活状态',
   locked               tinyint(1) not null default 0 comment '锁定状态:
            1--锁定状态
            0--非锁定状态',
   pwd_error_times      numeric(3) not null default 0 comment '从上一次登录到目前密码输入错误次数',
   last_login_timestamp timestamp comment '上一次登录的时间',
   last_login_ip        varchar(23) comment '上一次登录的IP',
   last_modify_timestamp timestamp not null comment '上一次用户修改时间',
   create_timestamp     timestamp not null comment '数据创建时间',
   reset_pwd_token      varchar(30) comment '重置密码请求的令牌',
   primary key (id)
);

alter table users comment '用户表';

/*==============================================================*/
/* Index: UNIQUE_INDEX_USER_NAME                                */
/*==============================================================*/
create index UNIQUE_INDEX_USER_NAME on users
(
   name
);

/*==============================================================*/
/* Index: UNIQUE_INDEX_USER_EMAIL                               */
/*==============================================================*/
create index UNIQUE_INDEX_USER_EMAIL on users
(
   email
);

alter table group_authority add constraint FK_Reference_6 foreign key (group_id)
      references groups (id) on delete restrict on update cascade;

alter table group_authority add constraint FK_Reference_7 foreign key (authority_id)
      references authority (id) on delete restrict on update cascade;

alter table group_authority add constraint FK_Reference_8 foreign key (entity_id)
      references auth_entity (id) on delete restrict on update cascade;

alter table user_authority add constraint FK_Reference_3 foreign key (user_id)
      references users (id) on delete restrict on update cascade;

alter table user_authority add constraint FK_Reference_4 foreign key (authority_id)
      references authority (id) on delete restrict on update cascade;

alter table user_authority add constraint FK_Reference_5 foreign key (entity_id)
      references auth_entity (id) on delete restrict on update cascade;

alter table user_group add constraint FK_Reference_1 foreign key (user_id)
      references users (id) on delete restrict on update cascade;

alter table user_group add constraint FK_Reference_2 foreign key (group_id)
      references groups (id) on delete restrict on update cascade;

