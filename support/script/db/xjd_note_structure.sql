/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/2/15 12:06:42                           */
/*==============================================================*/


drop index INDEX_UNIQUE_AUTHORITY_CODE on authority;

drop index INDEX_UNIQUE_AUTHORITY_AUTHORITYNAME on authority;

drop table if exists authority;

drop table if exists authority_group;

drop index Index_1 on id_mngr;

drop table if exists id_mngr;

drop table if exists note;

drop table if exists note_tag;

drop index INDEX_UNIQUE_TAGS_TAGNAME_USERNAME on tags;

drop table if exists tags;

drop table if exists user_authority;

drop index INDEX_UNIQUE_USERS_EMAIL on users;

drop index INDEX_UNIQUE_USERS_USERNAME on users;

drop table if exists users;

/*==============================================================*/
/* Table: authority                                             */
/*==============================================================*/
create table authority
(
   id                   bigint(11) not null auto_increment comment '主键',
   authority_code       varchar(20) not null comment '权限代码',
   authority_name       varchar(30) comment '权限名',
   is_group             tinyint(1) not null default 0 comment '是否为权限组:
            0--非权限组
            1--权限组',
   comment              varchar(100) comment '说明',
   primary key (id)
);

alter table authority comment '权限和权限组表';

/*==============================================================*/
/* Index: INDEX_UNIQUE_AUTHORITY_AUTHORITYNAME                  */
/*==============================================================*/
create unique index INDEX_UNIQUE_AUTHORITY_AUTHORITYNAME on authority
(
   authority_name
);

/*==============================================================*/
/* Index: INDEX_UNIQUE_AUTHORITY_CODE                           */
/*==============================================================*/
create index INDEX_UNIQUE_AUTHORITY_CODE on authority
(
   authority_code
);

/*==============================================================*/
/* Table: authority_group                                       */
/*==============================================================*/
create table authority_group
(
   group_id             bigint(11) not null comment '权限组的ID',
   authority_id         bigint(11) not null comment '权限ID',
   primary key (group_id, authority_id)
);

alter table authority_group comment '权限组 与 权限的关系表';

/*==============================================================*/
/* Table: id_mngr                                               */
/*==============================================================*/
create table id_mngr
(
   id                   bigint(11) not null auto_increment,
   name                 varchar(40) not null,
   mid                  bigint(11) not null default 1,
   primary key (id)
);

alter table id_mngr comment 'id manager';

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create unique index Index_1 on id_mngr
(
   name
);

/*==============================================================*/
/* Table: note                                                  */
/*==============================================================*/
create table note
(
   id                   bigint(11) not null auto_increment comment '主键',
   note_name            varchar(30) not null comment '笔记名或笔记目录名',
   is_dir               tinyint(1) not null default 0 comment '是否为笔记目录:
            0--非目录
            1--目录',
   parent_id            bigint(11) comment '父目录, 为null时表当前笔记在根目录',
   file_key             varchar(50) comment '笔记对应的文件',
   create_timestamp     timestamp comment '创建时间',
   last_modify_timestamp timestamp comment '上一次修改的时间',
   user_id              bigint(11) not null,
   deleted              tinyint(1) not null default 0 comment '是否删除状态',
   primary key (id)
);

alter table note comment '笔记和笔记目录表';

/*==============================================================*/
/* Table: note_tag                                              */
/*==============================================================*/
create table note_tag
(
   note_id              bigint(11) not null comment '笔记ID',
   tag_id               bigint(11) not null comment '标签ID',
   primary key (note_id, tag_id)
);

alter table note_tag comment '笔记和标签关系表';

/*==============================================================*/
/* Table: tags                                                  */
/*==============================================================*/
create table tags
(
   id                   bigint(11) not null auto_increment,
   tag_name             varchar(30) not null,
   create_timestamp     timestamp comment '创建时间',
   user_id              bigint(11),
   primary key (id)
);

alter table tags comment '笔记标签';

/*==============================================================*/
/* Index: INDEX_UNIQUE_TAGS_TAGNAME_USERNAME                    */
/*==============================================================*/
create unique index INDEX_UNIQUE_TAGS_TAGNAME_USERNAME on tags
(
   tag_name,
   user_id
);

/*==============================================================*/
/* Table: user_authority                                        */
/*==============================================================*/
create table user_authority
(
   user_id              bigint(11) not null comment '用户ID',
   authority_id         bigint(11) not null comment '权限ID或者权限组ID',
   primary key (user_id, authority_id)
);

alter table user_authority comment '用户权限表';

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   id                   bigint(11) not null auto_increment comment 'id主键',
   username             varchar(30) not null comment '用户名',
   email                varchar(30) not null comment '电子邮件',
   password             varchar(50) not null comment '加密后的密码',
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
/* Index: INDEX_UNIQUE_USERS_USERNAME                           */
/*==============================================================*/
create unique index INDEX_UNIQUE_USERS_USERNAME on users
(
   username
);

/*==============================================================*/
/* Index: INDEX_UNIQUE_USERS_EMAIL                              */
/*==============================================================*/
create unique index INDEX_UNIQUE_USERS_EMAIL on users
(
   email
);

alter table authority_group add constraint FK_Reference_1 foreign key (group_id)
      references authority (id) on delete cascade on update cascade;

alter table authority_group add constraint FK_Reference_2 foreign key (authority_id)
      references authority (id) on delete cascade on update cascade;

alter table note add constraint FK_FK_NOTE_USERID foreign key (user_id)
      references users (id) on delete restrict on update restrict;

alter table note_tag add constraint FK_Reference_5 foreign key (note_id)
      references note (id) on delete cascade on update cascade;

alter table note_tag add constraint FK_Reference_6 foreign key (tag_id)
      references tags (id) on delete cascade on update cascade;

alter table tags add constraint FK_FK_TAGS_USERID foreign key (user_id)
      references users (id) on delete restrict on update restrict;

alter table user_authority add constraint FK_Reference_3 foreign key (user_id)
      references users (id) on delete cascade on update cascade;

alter table user_authority add constraint FK_Reference_4 foreign key (authority_id)
      references authority (id) on delete cascade on update cascade;

