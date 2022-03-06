INSERT INTO users
    (username, email)
    VALUES
    ('testuser', 'test@example.com');

INSERT INTO manufacturer
    (manufacturer_name)
    VALUES
    ('Nintendo'),
    ('Sony'),
    ('Microsoft'),
    ('Sega'),
    ('Valve')
;



INSERT INTO platform
    (platform_name, manufacturer_id, description, system_nickname)
    VALUES
    ('Peronsal Computer Gaming', 3, 'PC Gaming on Windows Based Machines', 'PC Gaming'),
    ('Nintendo Entertainment System', 1, 'Originial NES released in the 80s', 'NES'),
    ('Super Nintendo Entertainment System', 1, 'Sequel to the NES, released in the early 90s, controller added shoulder buttons and two other buttons to original NES', 'SNES'),
    ('Playstation', 2, 'Original gray playstation, used discs for games instead of cartridges', 'PS1'),
    ('Playstation 2', 2, 'Successor to the popular PlayStation - featured dual shock (stick) controllers as standard', 'PS2'),
    ('Nintendo 64', 1, 'First truly 3D game system from Nintendo', 'N64'),
    ('Nintendo Switch', 1, 'Switch between playing on a TV and a handheld console. Supports Physical Switch Cartridges and Digital games. Also pull out the JoyCon controllers that snap into the device to use as a pair or split to use with another person', 'Switch') 
;

INSERT INTO platform_model
(platform_model_name, platform_id, description, wiki_url)
VALUES
('NES Control Deck', 2, 'Original front loading NES for North American Markets with hinged door and VCR-like mechanism', 'https://en.wikipedia.org/wiki/Nintendo_Entertainment_System' ),
('NES-101', 2, 'New Style NES, top loading NES', 'https://en.wikipedia.org/wiki/New-Style_NES'),
('Playstation model SCPH-1001', 4, 'Original North America Playstation with Analog Video and audio outputs built-in', 'https://en.wikipedia.org/wiki/PlayStation_models'),
('Playstation model SCPH-5501', 4, 'Playstation with Analog outputs removed built-in', 'https://en.wikipedia.org/wiki/PlayStation_models'),
('Playstation model SCPH-9001', 4, 'Playstation with Analog outputs and serial ports removed built-in', 'https://en.wikipedia.org/wiki/PlayStation_models'),
('PS One', 3, 'Smaller, redesigned version of the original Playstation', 'https://en.wikipedia.org/wiki/PlayStation_models#PS_One'),
('Playstation 2 model SCPH-3000x', 5, 'Original model released in North America, with "fat design" case', 'https://en.wikipedia.org/wiki/PlayStation_2_models'),
('Playstation 2 Slim SCPH-700xx', 5, 'Slimmed down model released in North America, with "slim design" case', 'https://en.wikipedia.org/wiki/PlayStation_2_models'),
('Nintendo Switch Original Model HAC-001', 7, 'Original Released of the Nintendo Switch with 6.2 inch LCD screen', 'https://en.wikipedia.org/wiki/Nintendo_Switch#Hardware'  ),
('Nintendo Switch Original Model HAC-001(-01)', 7, 'Slighly newer Tegra X1+ System on Chip for better battery life.', 'https://en.wikipedia.org/wiki/Nintendo_Switch#Hardware' ),
('Nintendo Switch Lite', 7, 'Handheld Only version of the Switch that integrates the Joy Cons into the Main body', 'https://en.wikipedia.org/wiki/Nintendo_Switch_Lite'),
('Nintendo Switch OLED', 7, 'Much improved OLED screen that was also larger at 7 inches', 'https://en.wikipedia.org/wiki/Nintendo_Switch#Hardware'),
('Nintendo 64 NA', 6, 'Original Top Loading N64 with 4 controller ports and the first controller stick on a Nintendo device and 10 buttons', 'https://en.wikipedia.org/wiki/Nintendo_64')
;

INSERT INTO game 
(game_name, description)
VALUES
('Super Mario Bros', 'The classic Super Mario Bros game, start at level 1-1 and see how far you can get!'),
('Super Mario Bros 3', 'A re-thought Mario Bros game where you could get and store power ups and had an map that you would travel around in between levels'),
('Mario Kart', 'The original Mario Kart that you could play solo or split screen against a friend in race or battle mode'),
('Gran Turismo', 'For the time, a pretty deep and complex racing simulation game'),
('Final Fantasy 7', 'One of the most loved games and has been remade and re-released even on other consoles'),
('Goldeneye', 'This game really popularized multiplayer First Person Shooters on the console, you could play with 4 local players'),
('Age of Empires 2', 'World Conquering Simulation'),
('Hades', 'Roguelike action-adventure game where Zagreus tries to escape the underworld, over and over'),
('Ocarina of Time', 'The first truly 3D Zelda game, including a memorable horse you could ride on and a the Ocarina instrument you could play')
;


INSERT INTO
platform_game
(game_id, platform_id)
VALUES
(1, 1),
(2, 1),
(2, 7),
(3, 4),
(5, 4),
(5, 1),
(5, 7),
(6, 6),
(7, 1),
(8, 1),
(8, 1),
(8, 7),
(9, 6)
;


INSERT INTO games_users_own
(user_id, game_id, platform_id, quantity, physical)
VALUES
(1, 1, 2, 1, true),
(1, 2, 2, 1, true),
(1, 2, 7, 1, false),
(1, 3, 3, 1, true),
(1, 3, 7, 1, false),
(1, 5, 4, 1, true),
(1, 5, 7, 1, false),
(1, 7, 1, 1, true),
(1, 8, 1, 1, false),
(1, 8, 7, 1, false)
;

INSERT INTO platform_model_users_own
(user_id, platform_model_id, quantity)
VALUES
(1, 2, 1),
(1, 4, 1),
(1, 7, 1),
(1, 9, 1),
(1, 13, 1)
;






