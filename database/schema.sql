DROP TABLE IF EXISTS system_variant_users_own;
DROP TABLE IF EXISTS games_users_own;
DROP TABLE IF EXISTS system_variant;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS game_system;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id serial,
	username varchar(100) NOT NULL,
	email varchar(120) NOT NULL,

	CONSTRAINT pk_users PRIMARY KEY (user_id)
);

CREATE TABLE manufacturer (
	manufacturer_id serial,
	manufacturer_name varchar(200) NOT NULL,
	
	CONSTRAINT pk_manufacturer PRIMARY KEY (manufacturer_id)
);

CREATE TABLE game_system (
	game_system_id serial,
	system_name varchar(100) NOT NULL,
	manufacturer_id int NOT NULL,
	system_nickname varchar(100),
	description varchar(300) NOT NULL,
	image_url varchar(256),

	CONSTRAINT pk_game_system PRIMARY KEY (game_system_id),
	CONSTRAINT fk_game_system_manufacturer_id FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id)
);

CREATE TABLE system_variant (
	system_variant_id serial,
	system_variant_name varchar(100) NOT NULL,
	game_system_id int NOT NULL,
	
	CONSTRAINT pk_system_variant PRIMARY KEY (system_variant_id),
	CONSTRAINT fk_system_variant_game_system_id FOREIGN KEY (game_system_id) REFERENCES game_system(game_system_id)
	
);

CREATE TABLE game (
	game_id serial,
	game_system_id int NOT NULL,
	game_name varchar(150) NOT NULL,
	description varchar(300),
	physical boolean NOT NULL,
	
	CONSTRAINT pk_game PRIMARY KEY (game_id),
	CONSTRAINT fk_game_game_system_id FOREIGN KEY(game_system_id) REFERENCES game_system(game_system_id)

	
);

CREATE TABLE games_users_own (
	user_id int NOT NULL,
	game_id int NOT NULL,
	quantity int NOT NULL,

	CONSTRAINT pk_games_users_own PRIMARY KEY (user_id, game_id),
	CONSTRAINT fk_games_users_own_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk_games_users_own_game_id FOREIGN KEY(game_id) REFERENCES game(game_id)
);

CREATE TABLE system_variant_users_own (
	user_id int NOT NULL,
	system_variant_id int NOT NULL,
	quantity int NOT NULL,

	CONSTRAINT pk_system_variant_own PRIMARY KEY (user_id, system_variant_id),
	CONSTRAINT fk_system_variant_own_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_system_variant_own_system_variant_id FOREIGN KEY (system_variant_id) REFERENCES system_variant(system_variant_id)
);

