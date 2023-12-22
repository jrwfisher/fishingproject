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

INSERT INTO region_species (region_id, fish_id)
VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10), (1, 11), (1, 12),
       (1, 13), (1, 14), (1, 15), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20), (1, 21), (1, 22), (1, 23),
       (1, 24), (1, 25), (1, 26), (1, 27), (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8),
       (2, 9), (2, 10), (2, 11), (2, 12), (2, 13), (2, 14), (2, 15), (2, 16), (2, 17), (2, 18), (2, 19),
       (2, 20), (2, 21), (2, 22), (2, 23), (2, 24), (2, 25), (2, 26), (2, 27);




COMMIT TRANSACTION;