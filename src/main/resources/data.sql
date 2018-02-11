--  CREATE TABLE player (
--    id BIGINT PRIMARY KEY NOT NULL,
--    email VARCHAR(200),
--    password VARCHAR(20),
--    username VARCHAR(20),
--    avatar_file_path VARCHAR(100)
--  );
--
--  CREATE TABLE match (
--    id BIGINT PRIMARY KEY NOT NULL,
--    tournament_id BIGINT NOT NULL,
--    home_player BIGINT NOT NULL,
--    away_player BIGINT NOT NULL,
--    status VARCHAR(20),
--    winner BIGINT NOT NULL
--  );
--
--
--  CREATE TABLE tournament (
--    id BIGINT PRIMARY KEY NOT NULL,
--    name VARCHAR(20),
--    type VARCHAR(20),
--    players BIGINT[],
--    matches BIGINT[],
--    winner BIGINT NOT NULL,
--    start_date DATE,
--    end_date DATE,
--    created_user BIGINT NOT NULL
--  );
--
 INSERT INTO player (id, email, password, username, avatar_file_path) VALUES (1,'player1@hotmail.com', 'password', 'player1', 'C://picture.jpg');
 INSERT INTO player (id, email, password, username, avatar_file_path) VALUES (2,'player2@hotmail.com', 'password', 'player2', 'C://picture2.jpg');
 INSERT INTO player (id, email, password, username, avatar_file_path) VALUES (3,'player3@hotmail.com', 'password', 'player3', 'C://picture3.jpg');
 INSERT INTO player (id, email, password, username, avatar_file_path)  VALUES (4,'player4@hotmail.com', 'password', 'player4', 'C://picture4.jpg');
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (1, 1, 1, 2, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (2, 1, 1, 3, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (3, 1, 1, 4, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (4, 1, 2, 1, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (5, 1, 2, 3, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (6, 1, 2, 4, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (7, 1, 3, 1, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (8, 1, 3, 2, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (9, 1, 3, 4, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (10, 1, 4, 1, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (11, 1, 4, 2, 'Undecided', 0);
 INSERT INTO match (id, tournament_id, home_player, away_player, status, winner) VALUES (12, 1, 5, 3, 'Undecided', 0);
 INSERT INTO tournament (id, name, type, matches_remaining, winner, start_date, end_date, created_player) VALUES (1, 'The Best CUP EVER', 'Round Robin', 12, 0, '2018-02-10', '2018-05-31', 1);
