drop database if exists notes_database;
drop table if exists notes;
drop table if exists users;

create database notes_database;

create table users
(
  id       serial primary key,
  username char(255) not null unique,
  password char(255)
);

create table notes
(
  id           serial primary key,
  user_id      integer,
  note_message char(500),
  foreign key (user_id) references users (id) on delete cascade
);
