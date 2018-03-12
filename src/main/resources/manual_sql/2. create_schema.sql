--Must connect to Tournament_Data before running this!

--Users
CREATE USER app_user WITH
  LOGIN
  NOSUPERUSER
  NOCREATEDB
  NOCREATEROLE
  INHERIT
  NOREPLICATION
  CONNECTION LIMIT -1
  PASSWORD 'Welcome1';

--Table
CREATE TABLE tournaments (
  id BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(20) NOT NULL,
  type VARCHAR(20) NOT NULL,
  winner BIGINT,
  start_date DATE NOT NULL,
  matches_remaining INT NOT NULL,
  end_date DATE,
  created_player BIGINT NOT NULL
);


CREATE TABLE players (
  id BIGINT PRIMARY KEY NOT NULL,
  email VARCHAR(200) NOT NULL UNIQUE,
  password VARCHAR(20) NOT NULL,
  username VARCHAR(20) NOT NULL UNIQUE,
  avatar_file_path VARCHAR(100)
);

CREATE TABLE matches (
  id BIGINT PRIMARY KEY NOT NULL,
  tournament_id BIGINT NOT NULL,
  home_player BIGINT NOT NULL,
  away_player BIGINT NOT NULL,
  status VARCHAR(20) NOT NULL,
  winner BIGINT
);

--FKs
--Tournaments
ALTER TABLE public.tournaments
  ADD CONSTRAINT "WINNER_FK_CONSTRAINT" FOREIGN KEY (winner)
REFERENCES public.players (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
  NOT VALID;
CREATE INDEX "fki_WINNER_FK_CONSTRAINT"
  ON public.tournaments(winner);

ALTER TABLE public.tournaments
  ADD CONSTRAINT "CREATED_PLAYER_FK_CONSTRAINT" FOREIGN KEY (created_player)
REFERENCES public.players (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
  NOT VALID;
CREATE INDEX "fki_CREATED_PLAYER_FK_CONSTRAINT"
  ON public.tournaments(created_player);

--Matches
ALTER TABLE public.matches
  ADD CONSTRAINT "FK_HOME_PLAYER_CONSTRAINT" FOREIGN KEY (home_player)
REFERENCES public.players (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
  NOT VALID;
CREATE INDEX "fki_FK_HOME_PLAYER_CONSTRAINT"
  ON public.matches(home_player);

ALTER TABLE public.matches
  ADD CONSTRAINT "FK_AWAY_PLAYER_CONSTRAINT" FOREIGN KEY (away_player)
REFERENCES public.players (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
  NOT VALID;
CREATE INDEX "fki_FK_AWAY_PLAYER_CONSTRAINT"
  ON public.matches(away_player);

ALTER TABLE public.matches
  ADD CONSTRAINT "FK_TOURNAMENT_ID_CONSTRAINT" FOREIGN KEY (tournament_id)
REFERENCES public.tournaments (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE CASCADE
  NOT VALID;
CREATE INDEX "fki_FK_TOURNAMENT_ID_CONSTRAINT"
  ON public.matches(tournament_id);

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO app_user;

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO app_user;