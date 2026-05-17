CREATE DATABASE statlineguessr;
CREATE USER statline_user WITH PASSWORD 'statline_pass';
GRANT ALL PRIVILEGES ON DATABASE statlineguessr TO statline_user;

\c statlineguessr;

CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        sport VARCHAR(50) NOT NULL,
                        team VARCHAR(50),
                        position VARCHAR(50)
);

CREATE TABLE statline (
                          id SERIAL PRIMARY KEY,
                          player_id INT REFERENCES player(id) ON DELETE CASCADE,
                          game_date DATE NOT NULL,
                          points INT,
                          assists INT,
                          rebounds INT,
                          steals INT,
                          blocks INT,
                          minutes_played DECIMAL(4,1),
                          UNIQUE (player_id, game_date) -- no duplicate statlines for same player & date
);

CREATE TABLE guess (
                       id SERIAL PRIMARY KEY,
                       statline_id INT REFERENCES statline(id) ON DELETE CASCADE,
                       guess_points INT,
                       guess_assists INT,
                       guess_rebounds INT,
                       guessed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

