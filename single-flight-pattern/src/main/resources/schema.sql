CREATE TABLE IF NOT EXISTS MESSAGE (
    id int8 PRIMARY KEY,-- snowflake id
    channel_id serial not null,
    user_id serial not null,
    content varchar(512) not null
);