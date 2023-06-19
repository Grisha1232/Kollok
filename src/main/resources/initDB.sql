CREATE TABLE IF NOT EXISTS user_activity (
                                          id INT PRIMARY KEY,
                                          activity_kind VARCHAR(100) NOT NULL,
                                          seconds INT NOT NULL,
                                          kalories INT NOT NULL,
                                          user_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_meals (
                                             id INT PRIMARY KEY,
                                             name VARCHAR(100) NOT NULL,
                                             gramms INT NOT NULL,
                                             kalories INT NOT NULL,
                                             user_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_sleep (
                                          id INT PRIMARY KEY,
                                          seconds INT NOT NULL,
                                          user_id INT NOT NULL
);