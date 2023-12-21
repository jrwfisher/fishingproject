START TRANSACTION;
DROP TABLE IF EXISTS tacklebox, region_species, region, catch, locale, app_user, species;
CREATE TABLE species (
	fish_id serial UNIQUE,
	fish_name varchar(100),
    description varchar(500),
	CONSTRAINT PK_fish_id PRIMARY KEY(fish_id)
);

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
	region_id serial UNIQUE,
	region_name varchar(50),
	CONSTRAINT PK_region_id PRIMARY KEY (region_id)
);
CREATE TABLE region_species (
	region_id int,
	fish_name varchar(100),
	CONSTRAINT FK_region_id FOREIGN KEY (region_id) REFERENCES region(region_id),
	CONSTRAINT FK_fish_name FOREIGN KEY (fish_name) REFERENCES species(fish_name)
);
CREATE TABLE tacklebox (
	lure_id serial UNIQUE,
	lure_name varchar(100),
    lure_type varchar(100),
	CONSTRAINT PK_lure_id PRIMARY KEY (lure_id)
);
CREATE TABLE user_tacklebox (
    lure_id int,
    user_id int,
    CONSTRAINT FK_lure_id FOREIGN KEY (lure_id) REFERENCES tacklebox (lure_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);
COMMIT;
