/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/11/17 10:24:18                          */
/*==============================================================*/


drop index INDEX_UNIQUE_AUTHORITY_AUTHORITYNAME on authority;

drop table if exists authority;

drop table if exists authority_group;

drop table if exists note;

drop table if exists note_tag;

drop index INDEX_UNIQUE_TAGS_TAGNAME on tags;

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
   id                   bigint(11) not null auto_increment comment '����',
   authority_code       varchar(20) not null comment 'Ȩ�޴���',
   authority_name       varchar(30) comment 'Ȩ����',
   is_group             tinyint(1) not null default 0 comment '�Ƿ�ΪȨ����:
            0--��Ȩ����
            1--Ȩ����',
   comment              varchar(100) comment '˵��',
   primary key (id)
);

alter table authority comment 'Ȩ�޺�Ȩ�����';

/*==============================================================*/
/* Index: INDEX_UNIQUE_AUTHORITY_AUTHORITYNAME                  */
/*==============================================================*/
create unique index INDEX_UNIQUE_AUTHORITY_AUTHORITYNAME on authority
(
   authority_name
);

/*==============================================================*/
/* Table: authority_group                                       */
/*==============================================================*/
create table authority_group
(
   group_id             bigint(11) not null comment 'Ȩ�����ID',
   authority_id         bigint(11) not null comment 'Ȩ��ID',
   primary key (group_id, authority_id)
);

alter table authority_group comment 'Ȩ���� �� Ȩ�޵Ĺ�ϵ��';

/*==============================================================*/
/* Table: note                                                  */
/*==============================================================*/
create table note
(
   id                   bigint(11) not null auto_increment comment '����',
   note_name            varchar(30) not null comment '�ʼ�����ʼ�Ŀ¼��',
   is_dir               tinyint(1) not null default 0 comment '�Ƿ�Ϊ�ʼ�Ŀ¼:
            0--��Ŀ¼
            1--Ŀ¼',
   parent_id            bigint(11) comment '��Ŀ¼, Ϊnullʱ��ǰ�ʼ��ڸ�Ŀ¼',
   file_key             varchar(50) comment '�ʼǶ�Ӧ���ļ�',
   create_timestamp     timestamp comment '����ʱ��',
   last_modify_timestamp timestamp comment '��һ���޸ĵ�ʱ��',
   primary key (id)
);

alter table note comment '�ʼǺͱʼ�Ŀ¼��';

/*==============================================================*/
/* Table: note_tag                                              */
/*==============================================================*/
create table note_tag
(
   note_id              bigint(11) not null comment '�ʼ�ID',
   tag_id               bigint(11) not null comment '��ǩID',
   primary key (note_id, tag_id)
);

alter table note_tag comment '�ʼǺͱ�ǩ��ϵ��';

/*==============================================================*/
/* Table: tags                                                  */
/*==============================================================*/
create table tags
(
   id                   bigint(11) not null auto_increment,
   tag_name             varchar(30) not null,
   create_timestamp     timestamp comment '����ʱ��',
   primary key (id)
);

alter table tags comment '�ʼǱ�ǩ';

/*==============================================================*/
/* Index: INDEX_UNIQUE_TAGS_TAGNAME                             */
/*==============================================================*/
create unique index INDEX_UNIQUE_TAGS_TAGNAME on tags
(
   tag_name
);

/*==============================================================*/
/* Table: user_authority                                        */
/*==============================================================*/
create table user_authority
(
   user_id              bigint(11) not null comment '�û�ID',
   authority_id         bigint(11) not null comment 'Ȩ��ID����Ȩ����ID',
   primary key (user_id, authority_id)
);

alter table user_authority comment '�û�Ȩ�ޱ�';

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   id                   bigint(11) not null auto_increment comment 'id����',
   username             varchar(30) not null comment '�û���',
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

alter table note_tag add constraint FK_Reference_5 foreign key (note_id)
      references note (id) on delete cascade on update cascade;

alter table note_tag add constraint FK_Reference_6 foreign key (tag_id)
      references tags (id) on delete cascade on update cascade;

alter table user_authority add constraint FK_Reference_3 foreign key (user_id)
      references users (id) on delete cascade on update cascade;

alter table user_authority add constraint FK_Reference_4 foreign key (authority_id)
      references authority (id) on delete cascade on update cascade;

