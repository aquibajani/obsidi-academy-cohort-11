-- CREATE DATABASE

CREATE DATABASE "feedApp"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- User Table

-- Create the "User" table
CREATE TABLE "User"(
  "userId" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "firstName" VARCHAR(100) NOT NULL,
  "lastName" VARCHAR(100) NOT NULL,
  "username" VARCHAR(25) NOT NULL,
  "phone" VARCHAR(10) NOT NULL,
  "emailId" VARCHAR(100) NOT NULL,
  "password" VARCHAR(25) NOT NULL,
  "emailVerified" BOOLEAN NOT NULL,
  "createdOn" TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY("userId"),
  CONSTRAINT "User_emailId_key" UNIQUE("emailId"),
  CONSTRAINT "User_username_key" UNIQUE("username")
);


-- Insert a new row into the "User" table
INSERT INTO "User"("firstName", "lastName", "username", "phone", "emailId", "password", "emailVerified", "createdOn")
VALUES('Jessie', 'Doe', 'jessiedoe', '+1-555-1234', 'jessiedoe@example.com', 'password123', true, CURRENT_TIMESTAMP)

-- Select all rows from the "User" table
SELECT * FROM "User";

-- Insert multiple users with a single insert statement using a VALUES list
INSERT INTO "User"("firstName", "lastName", "username", "phone", "emailId", "password", "emailVerified", "createdOn")
VALUES
	('Amy', 'Lee', 'amylee', '+1-555-9012', 'amylee@example.com', 'password789', true, NOW()),
	('Tom', 'Jones', 'tomjones', '+1-555-3456', 'tomjones@example.com', 'passwordabc', false, NOW()),
  ('Diana', 'Hill', 'dianahill', '+1-632-3456', 'dianahill@example.com', 'password123', false, NOW());

-- Select all rows from the "User" table where the value of the "emailVerified" column is true
SELECT * FROM "User" WHERE "emailVerified"=true;

-- Insert a few more users into the "User" table, (at least four more)
INSERT INTO "User"("firstName", "lastName", "username", "phone", "emailId", "password", "emailVerified", "createdOn")
VALUES
	('Johnny', 'Doe', 'johnnydoe', '+1-555-9011', 'johnnydoe@example.com', 'password789', true, NOW()),
	('Timmy', 'Tim', 'timmytim', '+1-555-3453', 'timmytim@example.com', 'passwordabc', false, NOW()),
    ('Mabel', 'Hill', 'mabelhill', '+1-632-3455', 'mabelhill@example.com', 'password123', true, NOW()),
	('Moana', 'Sail', 'moanasail', '+1-632-3458', 'moanasail@example.com', 'password123', false, NOW());

-- Update user with username "tomjones"
UPDATE "User" SET "username"='randyjones' WHERE "username"='tomjones';

-- Select user with username "tomjones"
SELECT * FROM "User" WHERE "username"='tomjones';

-- Delete user with username "randyjones"
DELETE FROM "User" WHERE "username"='randyjones';

-- Select all rows from the "User" table
SELECT * FROM "User";
