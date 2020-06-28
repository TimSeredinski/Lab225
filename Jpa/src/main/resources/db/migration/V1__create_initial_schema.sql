create type public.features AS enum ('POOL', 'BAR', 'GYM');
create type public.tour_type AS enum ('SIGHTSEEING', 'SHORE_EXCURSION', 'ADVEMTURE_OR_SPORTING');
create table user_account(id serial  not null primary key, login varchar(50) not null unique, password varchar(50) not null);
create table country(id serial not null primary key, name varchar(50) not null);
create table hotel(id serial not null primary key, name varchar(50) not null, stars integer, website text, lalitude numeric(30,0), longitude numeric(30,0), features features[]);
create table tour(id serial not null primary key, photo text, date date, duration integer, description text, cost integer, tour_type tour_type, hotel_id integer, country_id integer);
create table review(id serial not null primary key, date date, text text, user_id integer, tour_id integer);
create table user_tour(user_id integer, tour_id integer);