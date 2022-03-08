--Games in DB on Nintendo Switch 

SELECT game_name, game.description, platform_name
FROM game
INNER JOIN platform_game on platform_game.game_id = game.game_id
INNER JOIN platform on platform.platform_id = platform_game.platform_id
WHERE platform_name = 'Nintendo Switch';


--Games on Switch owned by user named testser
SELECT game_name, game.description, platform_name
FROM game
INNER JOIN platform_game on platform_game.game_id = game.game_id
INNER JOIN platform on platform.platform_id = platform_game.platform_id
INNER JOIN games_users_own on games_users_own.game_id = game.game_id
INNER JOIN users on users.user_id = games_users_own.user_id
WHERE username = 'user1';

--Find all games on a platform
SELECT game_name, game.game_id, game.description
FROM game
INNER JOIN platform_game on platform_game.game_id = game.game_id
INNER JOIN platform on platform.platform_id = platform_game.platform_id
WHERE platform_game.platform_id = 4;

-- do a search for a game
SELECT game_name, game.game_id, platform_name, platform.platform_id
FROM game
INNER JOIN platform_game on platform_game.game_id = game.game_id
INNER JOIN platform on platform.platform_id = platform_game.platform_id
WHERE game_name ILIKE 'gran%';


--Delete a game
DELETE FROM games_users_own
WHERE game_id = 4;
DELETE FROM platform_game
WHERE game_id = 4;
DELETE FROM game
WHERE game_id = 4;
