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



-- Profile Table

-- Create the "Profile" table

CREATE TABLE "Profile" (
  "profileId" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "userId" INTEGER NOT NULL,
  "headline" VARCHAR NOT NULL,
  "picture" VARCHAR NOT NULL,
  "bio" VARCHAR,
  "city" VARCHAR,
  "country" VARCHAR,
  CONSTRAINT "Profile_pkey" PRIMARY KEY ("profileId"),
  CONSTRAINT "Profile_userId_fkey" FOREIGN KEY ("userId") REFERENCES "User" ("userId")
);


-- Insert a new row into the "Profile" table
INSERT INTO "Profile" ("userId", "headline", "bio", "city", "country", "picture")
VALUES (
  2,
  'Wondergirl Amy!',
  'My name is Amy and I am a super hero.',
  'Toronto',
  'Canada',
  'https://static.vecteezy.com/system/resources/previews/005/162/430/original/cartoon-happy-superhero-girl-posing-free-vector.jpg'
);

-- Select all rows from the "Profile" table
SELECT * FROM "Profile";

-- Insert two new profiles with a single statement using a VALUES list. (use your won data)
INSERT INTO "Profile" ("userId", "headline", "bio", "city", "country", "picture")
VALUES 
  (
    1, 
    'Jessie the Explorer', 
    'Lover of mountains, coffee, and open trails.', 
    'Vancouver', 
    'Canada', 
    'https://example.com/images/jessie.jpg'
  ),
  (
    4, 
    'Diana Code Crafter', 
    'Software engineer and open-source enthusiast.', 
    'Seattle', 
    'USA', 
    'https://example.com/images/diana.jpg'
  );


-- Select all rows from the "Profile" table where the country is "Canada".
SELECT * FROM "Profile"
WHERE "country" = 'Canada';

-- Update the profile with userId = 2
UPDATE "Profile"
SET "bio" = 'I am Amy and I probably shouldn''t tell anyone I''m a super hero'
WHERE "userId" = 2;

-- Delete profile with profileId = 3
DELETE FROM "Profile"
WHERE "profileId" = 3;

-- Select all rows from the "Profile" table
SELECT * FROM "Profile";

-- Select the row from the "Profile" table with userdId = 2
SELECT * FROM "Profile"
WHERE "userId" = 2;

-- Join the "User" and "Profile" tables to get all the details for ALL users (including the ones without a profile). Hint: Use an outer join.

SELECT * FROM "User"
FULL OUTER JOIN "Profile"
ON "User"."userId" = "Profile"."userId";

-- Join the "User" and "Profile" tables to get the details of the users who have a profile.

SELECT "u"."firstName", "u"."lastName", "p"."bio" FROM "User" AS "u"
INNER JOIN "Profile" AS "p"
ON "u"."userId" = "p"."userId";

















