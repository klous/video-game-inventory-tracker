DROP TABLE IF EXISTS platform_model_users_own;
DROP TABLE IF EXISTS games_users_own;
DROP TABLE IF EXISTS platform_game;
DROP TABLE IF EXISTS platform_model;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS game_platform;
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

CREATE TABLE platform (
	platform_id serial,
	platform_name varchar(100) NOT NULL,
	manufacturer_id int NOT NULL,
	system_nickname varchar(100),
	description varchar(300) NOT NULL,
	image_url varchar(256),

	CONSTRAINT pk_platform PRIMARY KEY (platform_id),
	CONSTRAINT fk_platform_manufacturer_id FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id)
);

CREATE TABLE platform_model (
	platform_model_id serial,
	platform_model_name varchar(100) NOT NULL,
	platform_id int NOT NULL,
	description varchar(255),
	wiki_url varchar(256)
	
	CONSTRAINT pk_platform_model PRIMARY KEY (platform_model_id),
	CONSTRAINT fk_platform_model_platform_id FOREIGN KEY (platform_id) REFERENCES platform(platform_id)
	
);



CREATE TABLE game (
	game_id serial,
	platform_id int NOT NULL,
	game_name varchar(150) NOT NULL,
	description varchar(300),
	
	CONSTRAINT pk_game PRIMARY KEY (game_id),
	CONSTRAINT fk_platform_id FOREIGN KEY(platform_id) REFERENCES game_platform(game_platform_id)

	
);

-- WHERE THE GAMES WERE PUBLISHED TO / PLATFORMS THE GAME IS AVAILABLE ON. e.g. Hades Can be played on PC or Nintendo Switch. Final Fantasy 7 Can be played on Playstation 1, PC, and was released on the Nintendo Switch too.
CREATE TABLE platform_game (
	game_id int NOT NULL,
	platform_id int NOT NULL,

	CONSTRAINT pk_platform_game PRIMARY KEY (game_id, platform_id),
	CONSTRAINT fk_platform_game_game_id FOREIGN KEY (game_id) REFERENCES game(game_id);
	CONSTRAINT fk_platform_game_platorm_id FOREIGN KEY (platform_id) REFERENCES platform(platform_id)
);


CREATE TABLE games_users_own (
	user_id int NOT NULL,
	game_id int NOT NULL,
	quantity int NOT NULL,
	physical boolean NOT NULL,

	CONSTRAINT pk_games_users_own PRIMARY KEY (user_id, game_id),
	CONSTRAINT fk_games_users_own_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT fk_games_users_own_game_id FOREIGN KEY(game_id) REFERENCES game(game_id)
);

CREATE TABLE platform_model_users_own (
	user_id int NOT NULL,
	platform_model_id int NOT NULL,
	quantity int NOT NULL,

	CONSTRAINT pk_platform_model_own PRIMARY KEY (user_id, platform_model_id),
	CONSTRAINT fk_platform_model_own_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_platform_model_own_platform_model_id FOREIGN KEY (platform_model_id) REFERENCES platform_model(platform_model_id)
);

