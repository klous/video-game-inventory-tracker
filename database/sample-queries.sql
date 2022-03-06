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
WHERE platform_name = 'Nintendo Switch' AND username = 'testuser';