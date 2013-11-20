insert into users values(1, 'xjd', 'xjd@163.com', 'password', 0, 0, 0, null, null, null, null, null);

insert into authority values(1, 'read', 'read read', 0, null);
insert into authority values(2, 'write', 'write', 0, null);

insert into user_authority values(1, 1);
insert into user_authority values(1, 2);