create table custom_users (
  username varchar(256),
  password varchar(256),
  enabled boolean
);
create table custom_authorities (
  username varchar(256),
  authority varchar(256)
);