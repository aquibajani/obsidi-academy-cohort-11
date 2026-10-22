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



-- FEED Table


-- Create the "Feed" table
CREATE TABLE "Feed" (
  "feedId" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "userId" INTEGER NOT NULL,
  "content" VARCHAR NOT NULL,
  "picture" VARCHAR NOT NULL,
  "createdOn" TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT "Feed_pkey" PRIMARY KEY ("feedId"),
  CONSTRAINT "Feed_userId_fkey" FOREIGN KEY ("userId") REFERENCES "User" ("userId")
);

-- Insert a new row into the "Feed" table.
INSERT INTO "Feed" ("userId", "content", "picture", "createdOn")
VALUES (
  2,
  'This is my first post!',
  'https://static.vecteezy.com/system/resources/previews/005/162/430/original/cartoon-happy-superhero-girl-posing-free-vector.jpg',
  CURRENT_TIMESTAMP
);

-- Insert two new rows into the "Feed" table for other users.
INSERT INTO "Feed" ("userId", "content", "picture", "createdOn")
VALUES 
  (
    5,
    'Enjoying a sunny day in the park!',
    'https://example.com/images/park.jpg',
    CURRENT_TIMESTAMP
  ),
  (
    4,
    'Just shipped a brand new feature.',
    'https://example.com/images/coding.jpg',
    CURRENT_TIMESTAMP
  );

-- Select all rows from the "Feed" table
SELECT * FROM "Feed";

-- Update the feed content for the feed with feedId = 1
UPDATE "Feed"
SET "content" = 'This is my second post!'
WHERE "feedId" = 1;

-- Delete feed with feedId = 2
DELETE FROM "Feed"
WHERE "feedId" = 2;

-- Join the "User" and "Feed" tables.
SELECT *
FROM "User"
JOIN "Feed" 
  ON "User"."userId" = "Feed"."userId";

-- Join the "User" and "Feed" tables to display the rows for username = 'amylee'
SELECT *
FROM "User"
JOIN "Feed" 
  ON "User"."userId" = "Feed"."userId"
WHERE "User"."username" = 'amylee';



-- FeedMetaData


-- Create the "FeedMetaData" table
CREATE TABLE "FeedMetaData" (
  "feedMetaDataId" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "feedId" INTEGER NOT NULL,
  "actionUserId" INTEGER NOT NULL,
  "isLike" BOOLEAN NOT NULL,
  "comment" VARCHAR,
  "createdOn" TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT "FeedMetaData_pkey" PRIMARY KEY ("feedMetaDataId"),
  CONSTRAINT "FeedMetaData_actionUserId_fkey" FOREIGN KEY ("actionUserId") REFERENCES "User" ("userId"),
  CONSTRAINT "FeedMetaData_feedId_fkey" FOREIGN KEY ("feedId") REFERENCES "Feed" ("feedId")
);

-- Insert a new row into the "FeedMetaData" table.
INSERT INTO "FeedMetaData" ("actionUserId", "feedId", "isLike", "comment", "createdOn")
VALUES (
  2,
  1,
  TRUE,
  'Thanks!',
  CURRENT_TIMESTAMP
);

-- Insert two new rows into the "FeedMetaData" table.
INSERT INTO "FeedMetaData" ("actionUserId", "feedId", "isLike", "comment", "createdOn")
VALUES 
  (
    4,
    1,
    TRUE,
    'Great post!',
    CURRENT_TIMESTAMP
  ),
  (
    4,
    5,
    FALSE,
    'Interesting perspective.',
    CURRENT_TIMESTAMP
  );

-- Select all rows from the "FeedMetaData" table.
SELECT * FROM "FeedMetaData";

-- Update the feedMetaData content for the feedMetaData with feedMetaDataId = 1
UPDATE "FeedMetaData"
SET "comment" = 'Thanks fam!'
WHERE "feedMetaDataId" = 1;

-- Delete feedMetaData with feedMetaDataId = 2
DELETE FROM "FeedMetaData"
WHERE "feedMetaDataId" = 2;

-- Select all rows from the "FeedMetaData" table.
SELECT * FROM "FeedMetaData";

-- Select feedMetaData with feedMetaDataId = 1
SELECT * FROM "FeedMetaData"
WHERE "feedMetaDataId" = 1;

-- Join the "Feed" and "FeedMetaData" tables to display a row (or rows) for feedId = 1
SELECT *
FROM "Feed"
LEFT JOIN "FeedMetaData" 
  ON "Feed"."feedId" = "FeedMetaData"."feedId"
WHERE "Feed"."feedId" = 1;

-- Join the "User", "Feed" and "FeedMetaData" tables to display a row (or rows) for userId = 2
SELECT *
FROM "User"
LEFT JOIN "Feed" 
  ON "User"."userId" = "Feed"."userId"
LEFT JOIN "FeedMetaData" 
  ON "Feed"."feedId" = "FeedMetaData"."feedId"
WHERE "User"."userId" = 2;








