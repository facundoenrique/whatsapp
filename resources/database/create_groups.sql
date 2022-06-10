CREATE DATABASE groups;

CREATE TABLE messages(
     id serial NOT NULL,
     group_id serial NOT NULL,
     text varchar(256),
     active bool NOT NULL DEFAULT TRUE,
     read_for_user_id text,
     dateSend timestamptz(0),
     date_created timestamptz(0) NOT NULL DEFAULT now(),
     date_modified timestamptz(0),

    CONSTRAINT messages_pk PRIMARY KEY (id)
);

CREATE TABLE users(
      id serial NOT NULL,
      name varchar(256),
      phone varchar(20) NOT NULL,
      date_created timestamptz(0) NOT NULL DEFAULT now(),

    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE groups(
   id serial NOT NULL,
   groups_id serial NOT NULL,
   name varchar(256),
   date_created timestamptz(0) NOT NULL DEFAULT now(),
   date_modified timestamptz(0),

    CONSTRAINT groups_pk PRIMARY KEY (id)
);

CREATE TABLE group_users(
    group_id serial NOT NULL,
    user_id serial NOT NULL,
    date_created timestamptz(0) NOT NULL DEFAULT now(),

    CONSTRAINT gu_group_fk FOREIGN KEY (group_id) REFERENCES groups (id),
    CONSTRAINT gu_user_fk FOREIGN KEY (user_id) REFERENCES users (id)
);
