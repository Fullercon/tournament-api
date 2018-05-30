--This wouldnt be run in production, just for populating our postgres local instances with data!
INSERT INTO players (id, email, password, username, avatar_file_path) VALUES (1,'player1@hotmail.com', 'password', 'player1', 'C://picture.jpg');
INSERT INTO players (id, email, password, username, avatar_file_path) VALUES (2,'player2@hotmail.com', 'password', 'player2', 'C://picture2.jpg');
INSERT INTO players (id, email, password, username, avatar_file_path) VALUES (3,'player3@hotmail.com', 'password', 'player3', 'C://picture3.jpg');
INSERT INTO players (id, email, password, username, avatar_file_path)  VALUES (4,'player4@hotmail.com', 'password', 'player4', 'C://picture4.jpg');

INSERT INTO tournaments (id, name, type, matches_remaining, winner, start_date, end_date, created_player) VALUES (1, 'The Best CUP EVER', 'Round Robin', 12, null, 1, '2018-02-10', '2018-05-31', 1);

INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (1, 1, 1, 2, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (2, 1, 1, 3, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (3, 1, 1, 4, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (4, 1, 2, 1, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (5, 1, 2, 3, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (6, 1, 2, 4, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (7, 1, 3, 1, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (8, 1, 3, 2, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (9, 1, 3, 4, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (10, 1, 4, 1, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (11, 1, 4, 2, 'UNDECIDED', 0);
INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (12, 1, 4, 3, 'UNDECIDED', 0);
