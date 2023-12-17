START TRANSACTION;
DROP TABLE IF EXISTS tacklebox, region_species, region, catch, locale, app_user, species;
CREATE TABLE species (
	fish_id serial,
	fish_name varchar(100),
	CONSTRAINT PK_fish_id PRIMARY KEY(fish_id)
);
INSERT INTO species (fish_name)
VALUES ('Speckled Trout'), ('Redfish'), ('Snook'), ('Cobia'), ('Tarpon'), ('Swordfish'),
	   ('Flounder'), ('Gag Grouper'), ('Bluefish'), ('Black Drum'), ('Mahi-mahi'),
	   ('Tripletail'), ('Bonefish'), ('Red Snapper'), ('Lane Snapper'), ('Mangrove Snapper'),
	   ('Red Grouper'), ('Spanish Mackerel'), ('Kingfish'), ('Amberjack'), ('Jack Crevalle'),
	   ('Roosterfish'), ('Hogfish'), ('Sheepshead'), ('Bonnethead Shark'), ('Blacktip Shark'),
	   ('Grunt');
CREATE TABLE app_user (
	user_id serial,
	username varchar(50),
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_user_id PRIMARY KEY (user_id)
);  
CREATE TABLE locale (
	locale_id serial,
	locale_name varchar(100),
	description varchar(100),
	CONSTRAINT PK_locale_id PRIMARY KEY (locale_id)
);
CREATE TABLE catch (
	catch_id serial,
	fish_id int,
	fish_length int,
	fish_weight int,
	catch_date date,
	user_id int,
	locale_id int,
	CONSTRAINT PK_catch_id PRIMARY KEY (catch_id),
	CONSTRAINT FK_locale_id FOREIGN KEY (locale_id) REFERENCES locale(locale_id),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES app_user(user_id),
	CONSTRAINT FK_fish_id FOREIGN KEY (fish_id) REFERENCES species(fish_id)
);
CREATE TABLE region (
	region_id serial,
	region_name varchar(50),
	CONSTRAINT PK_region_id PRIMARY KEY (region_id)
);
CREATE TABLE region_species (
	region_id int,
	species_id int,
	CONSTRAINT FK_region_id FOREIGN KEY (region_id) REFERENCES region(region_id),
	CONSTRAINT FK_species_id FOREIGN KEY (species_id) REFERENCES species(fish_id)
);
CREATE TABLE tacklebox (
	lure_id serial,
	user_id int,
	lure_name varchar(100),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES app_user(user_id),
	CONSTRAINT PK_lure_id PRIMARY KEY (lure_id)
);
COMMIT;
