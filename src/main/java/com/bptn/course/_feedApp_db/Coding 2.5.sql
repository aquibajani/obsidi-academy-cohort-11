-- Retrieve All User IDs: Select all unique userId values from the "User" table
SELECT DISTINCT "userId" FROM "User";

-- Profiles in Canada: Select headline, city, and country for profiles located in 'Canada'
SELECT "headline", "city", "country" FROM "Profile" WHERE "country"='Canada';

-- INNER JOIN User and Profile to display firstName, lastName, and headline
SELECT
	"u"."firstName",
	"u"."lastName",
	"p"."headline"
FROM
	"User" AS "u"
	INNER JOIN "Profile" AS "p" ON "u"."userId" = "p"."userId";
	
-- Users Without Profiles (Outer Join): LEFT JOIN to include all users, ORDER BY headline
SELECT
	"User".*,
	"Profile"."headline"
FROM
	"User"
	LEFT JOIN "Profile" ON "User"."userId" = "Profile"."userId"
ORDER BY
	"Profile"."headline";

-- GROUP BY emailVerified status and COUNT the number of users in each group
SELECT
	"emailVerified",
	COUNT(*) AS "userCount"
FROM
	"User"
GROUP BY
	"emailVerified";

-- Use UNION to combine userId from all profiles AND users in Canada
SELECT "userId" FROM "User"

UNION

SELECT "userId" FROM "Profile"
WHERE "country"='Canada';


-- Which ACID property is ensured by the UNIQUE constraint on username?
Consistency

-- Write a TRIGGER function named log_profile_update BEFORE UPDATE on the Profile table
CREATE OR REPLACE FUNCTION LOG_PROFILE_UPDATE () RETURNS TRIGGER AS $$
	BEGIN
		RAISE NOTICE 'Profile with ID % is being updated at %', OLD."profileId", CURRENT_TIMESTAMP;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER LOG_PROFILE_UPDATE BEFORE
UPDATE ON "Profile" FOR EACH ROW
EXECUTE FUNCTION LOG_PROFILE_UPDATE ();

UPDATE "Profile"
SET "headline"='Wonderful Amy!'
WHERE "profileId"=1;
















