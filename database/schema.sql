BEGIN TRANSACTION
DROP TABLE IF EXISTS 
DROP TABLE IF EXISTS 
DROP TABLE IF EXISTS 
DROP TABLE IF EXISTS 
DROP TABLE IF EXISTS 

CREATE TABLE users (
	user_id serial,
	name varchar(100) NOT NULL,
	email varchar(120) NOT NULL,

	CONSTRAINT pk_users PRIMARY KEY (user_id)
);

CREATE TABLE game_system (
	game_system_id serial,
	system_name varchar(100) NOT NULL,
	description varchar(300) NOT NULL,
	image_url varchar(256),

	CONSTRAINT pk_game_system PRIMARY KEY (game_system_id)
);

CREATE TABLE manufacturer (
	manufacturer_id serial,
	manufacturer_name varchar(200) NOT NULL,
	
	CONSTRAINT pk_manufacturer PRIMARY KEY (manufacturer_id)
);

CREATE TABLE system_variant (
	system_variant_id serial,
	game_system int NOT NULL,
	system_variant_name varchar(100) NOT NULL,
	manufacturer_id int NOT NULL,
	
	CONSTRAINT pk_system_variant PRIMARY KEY(system_variant_id),
	CONSTRAINT fk_system_variant FOREIGN KEY(manufacturer_id) REFERENCES manufacturer(manufacturer_id)
);

CREATE TABLE game (
	game_id serial,
	game_system_id int NOT NULL,
	game_name varchar(150) NOT NULL,
	description varchar(300),
	physical boolean NOT NULL
	
	CONSTRAINT pk_game PRIMARY KEY(game_id),
	CONSTRAINT fk_game_game_system FOREIGN KEY(game_system_id) REFERENCES game_system(game_system_id)

	
);

CREATE TABLE system_variant_own (
	user_id int NOT NULL,
	system_variant_id int NOT NULL
	quantity int NOT NULL

	CONSTRAINT pk_system_variant_own PRIMARY KEY(user_id, system_variant_id),
	CONSTRAINT fk_system_variant_own FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk_system_variant_own FOREIGN KEY(system_variant_id) REFERENCES system_variant(system_variant_id)
);


COMMIT TRANSACTION;
