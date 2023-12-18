BEGIN TRANSACTION;

INSERT INTO species (fish_name)
VALUES ('Speckled Trout'), ('Redfish'), ('Snook'), ('Cobia'), ('Tarpon'), ('Swordfish'),
       ('Flounder'), ('Gag Grouper'), ('Bluefish'), ('Black Drum'), ('Mahi-mahi'),
       ('Tripletail'), ('Bonefish'), ('Red Snapper'), ('Lane Snapper'), ('Mangrove Snapper'),
       ('Red Grouper'), ('Spanish Mackerel'), ('Kingfish'), ('Amberjack'), ('Jack Crevalle'),
       ('Roosterfish'), ('Hogfish'), ('Sheepshead'), ('Bonnethead Shark'), ('Blacktip Shark'),
       ('Grunt');
INSERT INTO region (region_name)
VALUES ('Gulf of Mexico'), ('America, Atlantic'), ('America, Pacific'), ('Caribbean');


COMMIT TRANSACTION;