--Games in DB on Nintendo Switch 

SELECT game_name, game.description, platform_name
FROM game
INNER JOIN platform_game on platform_game.game_id = game.game_id
INNER JOIN platform on platform.platform_id = platform_game.platform_id
WHERE platform_name = 'Nintendo Switch';


--games opwned by user id = 1 -->
SELECT game_name, game.description, pg.platform_id, user_id
FROM games_users_own guo
INNER JOIN game on game.game_id = guo.game_id
INNER JOIN platform_game pg on pg.platform_id = guo.platform_id
	AND guo.game_id = pg.game_id
WHERE user_id = 1
ORDER BY game.game_id;


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
WHERE game_name ILIKE '%mario%';


--Delete a game
DELETE FROM games_users_own
WHERE game_id = 4;
DELETE FROM platform_game
WHERE game_id = 4;
DELETE FROM game
WHERE game_id = 4;


-- find platforms for a game
SELECT platform.platform_id, platform_name, platform_nickname, platform.description, image_url
FROM platform
JOIN platform_game pg ON pg.platform_id = platform.platform_id
WHERE game_id=2;
