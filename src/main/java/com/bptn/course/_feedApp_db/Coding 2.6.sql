-- Select DISTINCT content and the user's firstName, JOINING User and Feed
SELECT DISTINCT
	"Feed"."content",
	"User"."firstName"
FROM
	"Feed"
	JOIN "User" ON "User"."userId" = "Feed"."userId";

-- Select feedId, username, and createdOn, ORDERING BY createdOn DESC and LIMIT 5
SELECT
	"User"."username",
	"Feed"."feedId",
	"Feed"."createdOn"
FROM
	"Feed"
	JOIN "User" ON "User"."userId" = "Feed"."userId"
ORDER BY
	"Feed"."createdOn" DESC
LIMIT 5;


-- Select feedId and content where content contains the word 'post' (using LIKE)
SELECT
	"feedId",
	"content"
FROM
	"Feed"
WHERE
	"content" LIKE '%post%';

-- GROUP BY username and COUNT the total number of posts, ORDER BY post count descending
SELECT
	"User"."username",
	COUNT("Feed"."feedId") AS "totalPosts"
FROM
	"User"
	JOIN "Feed" ON "User"."userId" = "Feed"."userId"
GROUP BY
	"User"."username"
ORDER BY
	"totalPosts" DESC

	
-- Find usernames with exactly one post using GROUP BY and HAVING
SELECT
	"User"."username"
FROM
	"User"
	JOIN "Feed" ON "User"."userId" = "Feed"."userId"
GROUP BY
	"User"."username"
HAVING
	COUNT("Feed"."feedId") = 1;

	
-- Combine all feedId from Feed and userId from User into one result set using UNION ALL
SELECT "feedId" AS "id" FROM "Feed" 
UNION ALL
SELECT "userId" AS "id" FROM "User"
	

-- Which ACID property guarantees all-or-nothing submission of a post?	
Atomicity
	
-- Write a TRIGGER named prevent_short_post BEFORE INSERT on the Feed table
CREATE OR REPLACE FUNCTION PREVENT_SHORT_POST () RETURNS TRIGGER AS $$
	BEGIN
		IF LENGTH(TRIM(NEW."content"))<5 THEN
			RAISE EXCEPTION 'Post Content is too short (must be more than 5 characters)';
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER PREVENT_SHORT_POST BEFORE INSERT ON "Feed" FOR EACH ROW
EXECUTE FUNCTION PREVENT_SHORT_POST ();










