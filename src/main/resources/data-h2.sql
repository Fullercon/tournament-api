 INSERT INTO players (id, email, password, username, avatar_file_path) VALUES (1,'player1@hotmail.com', 'password', 'player1', 'C://picture.jpg');
 INSERT INTO players (id, email, password, username, avatar_file_path) VALUES (2,'player2@hotmail.com', 'password', 'player2', 'C://picture2.jpg');
 INSERT INTO players (id, email, password, username, avatar_file_path) VALUES (3,'player3@hotmail.com', 'password', 'player3', 'C://picture3.jpg');
 INSERT INTO players (id, email, password, username, avatar_file_path)  VALUES (4,'player4@hotmail.com', 'password', 'player4', 'C://picture4.jpg');

 INSERT INTO tournaments (id, name, type, matches_remaining, winner, start_date, end_date, created_player) VALUES (1, 'The Best CUP EVER', 'Round Robin', 12, 0, '2018-02-10', '2018-05-31', 1);
 INSERT INTO tournaments (id, name, type, matches_remaining, winner, start_date, end_date, created_player) VALUES (2, 'The Second Best CUP EVER', 'Round Robin', 12, 0, '2018-03-10', '2018-09-30', 1);


 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (1, 1, 1, 2, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (2, 1, 1, 3, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (3, 1, 1, 4, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (4, 1, 2, 1, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (5, 1, 2, 3, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (6, 1, 2, 4, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (7, 1, 3, 1, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (8, 1, 3, 2, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (9, 1, 3, 4, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (10, 1, 4, 1, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (11, 1, 4, 2, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (12, 1, 5, 3, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (13, 2, 1, 2, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (14, 2, 1, 3, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (15, 2, 1, 4, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (16, 2, 2, 1, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (17, 2, 2, 3, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (18, 2, 2, 4, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (19, 2, 3, 1, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (20, 2, 3, 2, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (21, 2, 3, 4, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (22, 2, 4, 1, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (23, 2, 4, 2, 'Undecided', 0);
 INSERT INTO matches (id, tournament_id, home_player, away_player, status, winner) VALUES (24, 2, 5, 3, 'Undecided', 0);

