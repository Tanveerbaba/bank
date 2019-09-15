CREATE TABLE bank (
id INT PRIMARY KEY NOT NULL,
name TEXT
);

CREATE TABLE bank_branches (
id INT PRIMARY KEY NOT NULL,
ifsc TEXT NOT NULL,
branch TEXT,
address TEXT,
city TEXT,
district TEXT,
state TEXT,
bank_name TEXT,
bank_id INT REFERENCES bank(id)
);

