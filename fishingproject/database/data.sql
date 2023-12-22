BEGIN TRANSACTION;

INSERT INTO species (fish_name)
VALUES ('Speckled Trout'), ('Redfish'), ('Snook'), ('Cobia'), ('Tarpon'), ('Swordfish'),
       ('Flounder'), ('Gag Grouper'), ('Bluefish'), ('Black Drum'), ('Mahi-mahi'),
       ('Tripletail'), ('Bonefish'), ('Red Snapper'), ('Lane Snapper'), ('Mangrove Snapper'),
       ('Red Grouper'), ('Spanish Mackerel'), ('Kingfish'), ('Amberjack'), ('Jack Crevalle'),
       ('Roosterfish'), ('Hogfish'), ('Sheepshead'), ('Bonnethead Shark'), ('Blacktip Shark'),
       ('Grunt');
INSERT INTO region (region_name)
VALUES ('Gulf of Mexico'), ('America, Atlantic');

INSERT INTO tacklebox  (lure_name, lure_type)
VALUES ('MirrOlure', 'Hard Plastic'), ('Gulp Shrimp', 'Soft Plastic'), ('Bucktail Jig', 'Jig'),
       ('Shrimp', 'Live Bait'), ('Pinfish', 'Live Bait'), ('Mullet', 'Live Bait'), ('Crab', 'Live Bait');

INSERT INTO region_species (region_name, fish_name)
VALUES ('Gulf of Mexico', 'Speckled Trout'), ('Gulf of Mexico', 'Redfish'), ('Gulf of Mexico', 'Snook'),
       ('Gulf of Mexico', 'Cobia'), ('Gulf of Mexico', 'Tarpon'), ('Gulf of Mexico', 'Swordfish'),
       ('Gulf of Mexico', 'Flounder'), ('Gulf of Mexico', 'Gag Grouper'), ('Gulf of Mexico', 'Bluefish'),
       ('Gulf of Mexico', 'Black Drum'), ('Gulf of Mexico', 'Mahi-mahi'), ('Gulf of Mexico', 'Tripletail'),
       ('Gulf of Mexico', 'Bonefish'), ('Gulf of Mexico', 'Red Snapper'), ('Gulf of Mexico', 'Lane Snapper'),
       ('Gulf of Mexico', 'Mangrove Snapper'), ('Gulf of Mexico', 'Red Grouper'), ('Gulf of Mexico', 'Spanish Mackerel'),
       ('Gulf of Mexico', 'Kingfish'), ('Gulf of Mexico', 'Amberjack'), ('Gulf of Mexico', 'Jack Crevalle'),
       ('Gulf of Mexico', 'Roosterfish'), ('Gulf of Mexico', 'Hogfish'), ('Gulf of Mexico', 'Sheepshead'),
       ('Gulf of Mexico', 'Bonnethead Shark'), ('Gulf of Mexico', 'Blacktip Shark'), ('Gulf of Mexico', 'Grunt'),
       ('America, Atlantic', 'Speckled Trout'), ('America, Atlantic', 'Redfish'), ('America, Atlantic', 'Snook'),
       ('America, Atlantic', 'Cobia'), ('America, Atlantic', 'Tarpon'), ('America, Atlantic', 'Swordfish'),
       ('America, Atlantic', 'Flounder'), ('America, Atlantic', 'Gag Grouper'), ('America, Atlantic', 'Bluefish'),
       ('America, Atlantic', 'Black Drum'), ('America, Atlantic', 'Mahi-mahi'), ('America, Atlantic', 'Tripletail'),
       ('America, Atlantic', 'Bonefish'), ('America, Atlantic', 'Red Snapper'), ('America, Atlantic', 'Lane Snapper'),
       ('America, Atlantic', 'Mangrove Snapper'), ('America, Atlantic', 'Red Grouper'), ('America, Atlantic', 'Spanish Mackerel'),
       ('America, Atlantic', 'Kingfish'), ('America, Atlantic', 'Amberjack'), ('America, Atlantic', 'Jack Crevalle'),
       ('America, Atlantic', 'Roosterfish'), ('America, Atlantic', 'Hogfish'), ('America, Atlantic', 'Sheepshead'),
       ('America, Atlantic', 'Bonnethead Shark'), ('America, Atlantic', 'Blacktip Shark'), ('America, Atlantic', 'Grunt');




COMMIT TRANSACTION;