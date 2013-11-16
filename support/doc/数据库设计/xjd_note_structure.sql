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
   id                   bigint(11) not null auto_increment comment '����id',
   name                 varchar(20) not null comment 'ʵ����',
   comment              varchar(50) comment '˵��',
   primary key (id)
);

alter table auth_entity comment 'Ȩ��ʵ��';

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
   id                   bigint(11) not null auto_increment comment 'id����',
   name                 varchar(20) not null comment 'Ȩ�޴���',
   comment              varchar(50) comment '˵��',
   primary key (id)
);

alter table authority comment 'Ȩ�ޱ�';

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
   group_id             bigint(11) not null comment '��ID',
   authority_id         bigint(11) not null comment 'Ȩ��ID',
   entity_id            bigint(11) not null comment 'ʵ��ID',
   primary key (group_id, authority_id, entity_id)
);

/*==============================================================*/
/* Table: groups                                                */
/*==============================================================*/
create table groups
(
   id                   bigint(11) not null auto_increment comment 'id����',
   name                 varchar(20) not null comment '����',
   comment              varchar(50) comment '˵��',
   primary key (id)
);

alter table groups comment '�û���';

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
   user_id              bigint(11) not null comment '�û�ID',
   authority_id         bigint(11) not null comment 'Ȩ��ID',
   entity_id            bigint(11) not null comment 'ʵ��ID',
   primary key (user_id, authority_id, entity_id)
);

/*==============================================================*/
/* Table: user_group                                            */
/*==============================================================*/
create table user_group
(
   user_id              bigint(11) not null comment '�û�ID',
   group_id             bigint(11) not null comment '��ID',
   primary key (user_id, group_id)
);

alter table user_group comment '�û�����Ĺ�ϵ��';

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   id                   bigint(11) not null auto_increment comment 'id����',
   name                 varchar(30) not null comment '�û���',
   email                varchar(30) not null comment '�����ʼ�',
   password             varchar(40) not null comment '���ܺ������',
   enabled              tinyint(1) not null default 0 comment '����״̬:
            1--����״̬
            0--�Ǽ���״̬',
   locked               tinyint(1) not null default 0 comment '����״̬:
            1--����״̬
            0--������״̬',
   pwd_error_times      numeric(3) not null default 0 comment '����һ�ε�¼��Ŀǰ��������������',
   last_login_timestamp timestamp comment '��һ�ε�¼��ʱ��',
   last_login_ip        varchar(23) comment '��һ�ε�¼��IP',
   last_modify_timestamp timestamp not null comment '��һ���û��޸�ʱ��',
   create_timestamp     timestamp not null comment '���ݴ���ʱ��',
   reset_pwd_token      varchar(30) comment '�����������������',
   primary key (id)
);

alter table users comment '�û���';

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

