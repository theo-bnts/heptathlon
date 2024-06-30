INSERT INTO PRODUCT_CATEGORY (ID_PRODUCT_CATEGORY, NAME) VALUES
	 (1, 'Équitation'),
	 (2, 'Natation'),
	 (3, 'Course'),
	 (4, 'Fitness'),
	 (5, 'Cyclisme'),
	 (6, 'Randonnée'),
	 (7, 'Tennis'),
	 (8, 'Football'),
	 (9, 'Basketball'),
	 (10, 'Volleyball'),
	 (11, 'Handball'),
	 (12, 'Rugby'),
	 (13, 'Golf'),
	 (14, 'Pétanque');

-- Équitation
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('A1B2C3', 'Selle de cheval', 26.0, -1, 1),
    ('D4E5F6', 'Cravache', 2.0, -1, 1),
    ('G7H8I9', 'Casque d\'équitation', 4.0, -1, 1),
    ('J1K2L3', 'Bottes d\'équitation', 12.0, -1, 1),
    ('M4N5O6', 'Pantalon d\'équitation', 6.0, -1, 1),
    ('P7Q8R9', 'Gants d\'équitation', 2.0, -1, 1),
    ('S1T2U3', 'Étriers', 4.0, -1, 1),
    ('V4W5X6', 'Bridon', 5.0, -1, 1),
    ('Y7Z8A9', 'Tapis de selle', 3.0, -1, 1),
    ('B1C2D3', 'Éperons', 1.0, -1, 1),
    ('E4F5G6', 'Couverture pour cheval', 7.0, -1, 1),
    ('H7I8J9', 'Mors', 2.0, -1, 1),
    ('K1L2M3', 'Protection des membres', 3.0, -1, 1),
    ('N4O5P6', 'Chaps', 5.0, -1, 1),
    ('Q7R8S9', 'Sac de pansage', 4.0, -1, 1);

-- Natation
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('T1U2V3', 'Maillot de bain', 2.0, -1, 2),
    ('W4X5Y6', 'Lunettes de piscine', .0, -1, 2),
    ('Z7A8B9', 'Bonnet de bain', .0, -1, 2),
    ('C1D2E3', 'Palmes de natation', 3.0, -1, 2),
    ('F4G5H6', 'Tuba', 1.0, -1, 2),
    ('I7J8K9', 'Serviette de bain', 2.0, -1, 2),
    ('L1M2N3', 'Sandales de piscine', 1.0, -1, 2),
    ('O4P5Q6', 'Combinaison de natation', 8.0, -1, 2),
    ('R7S8T9', 'Planche de natation', 2.0, -1, 2),
    ('U1V2W3', 'Pince-nez', .0, -1, 2),
    ('X4Y5Z6', 'Bouchons d\'oreilles', .0, -1, 2),
    ('A7B8C9', 'Chaussons de piscine', 1.0, -1, 2),
    ('D1E2F3', 'Filet de piscine', 1.0, -1, 2),
    ('G4H5I6', 'Gilet de sauvetage', 3.0, -1, 2),
    ('J7K8L9', 'Chronomètre', 2.0, -1, 2);

-- Course
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('M1N2O3', 'Chaussures de course', 7.0, -1, 3),
    ('P4Q5R6', 'Short de course', 2.0, -1, 3),
    ('S7T8U9', 'T-shirt de course', 2.0, -1, 3),
    ('V1W2X3', 'Montre de sport', 15.0, -1, 3),
    ('Y4Z5A6', 'Bouteille d\'eau', 1.0, -1, 3),
    ('B7C8D9', 'Sac banane', 1.0, -1, 3),
    ('E1F2G3', 'Chaussettes de course', 1.0, -1, 3),
    ('H4I5J6', 'Bandeau', .0, -1, 3),
    ('K7L8M9', 'Lunettes de soleil sport', 3.0, -1, 3),
    ('N1O2P3', 'Veste de course', 6.0, -1, 3),
    ('Q4R5S6', 'Bracelet de sport', 1.0, -1, 3),
    ('T7U8V9', 'Ceinture porte-gourdes', 2.0, -1, 3),
    ('W1X2Y3', 'Gants de course', 2.0, -1, 3),
    ('Z4A5B6', 'Casquette de course', 1.0, -1, 3),
    ('C7D8E9', 'Porte-dossard', 1.0, -1, 3);

-- Fitness
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('F1G2H3', 'Tapis de yoga', 3.0, -1, 4),
    ('I4J5K6', 'Haltères', 2.0, -1, 4),
    ('L7M8N9', 'Corde à sauter', 1.0, -1, 4),
    ('O1P2Q3', 'Ballon de gym', 2.0, -1, 4),
    ('R4S5T6', 'Bande élastique', 1.0, -1, 4),
    ('U7V8W9', 'Rouleau de massage', 2.0, -1, 4),
    ('X1Y2Z3', 'Step de fitness', 4.0, -1, 4),
    ('A4B5C6', 'Kettlebell', 3.0, -1, 4),
    ('D7E8F9', 'T-shirt de fitness', 2.0, -1, 4),
    ('G1H2I3', 'Short de fitness', 2.0, -1, 4),
    ('J4K5L6', 'Chaussures de fitness', 6.0, -1, 4),
    ('M7N8O9', 'Gants de fitness', 1.0, -1, 4),
    ('P1Q2R3', 'Bouteille shaker', 1.0, -1, 4),
    ('S4T5U6', 'Sac de sport', 3.0, -1, 4),
    ('V7W8X9', 'Serviette de sport', 1.0, -1, 4);

-- Cyclisme
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('Y1Z2A3', 'Vélo de route', 50.0, -1, 5),
    ('B4C5D6', 'Casque de vélo', 5.0, -1, 5),
    ('E7F8G9', 'Gants de cyclisme', 1.0, -1, 5),
    ('H1I2J3', 'Maillot de cyclisme', 3.0, -1, 5),
    ('K4L5M6', 'Pompe à vélo', 2.0, -1, 5),
    ('N7O8P9', 'Porte-bidon', 1.0, -1, 5),
    ('Q1R2S3', 'Lunettes de cyclisme', 2.0, -1, 5),
    ('T4U5V6', 'Chaussures de cyclisme', 9.0, -1, 5),
    ('W7X8Y9', 'Selle de vélo', 4.0, -1, 5),
    ('Z1A2B3', 'Antivol de vélo', 2.0, -1, 5),
    ('C4D5E6', 'Lumières de vélo', 3.0, -1, 5),
    ('F7G8H9', 'Compteur de vélo', 4.0, -1, 5),
    ('I1J2K3', 'Bidon', 1.0, -1, 5),
    ('L4M5N6', 'Sacoche de selle', 2.0, -1, 5),
    ('O7P8Q9', 'Gilet de sécurité', 1.0, -1, 5);

-- Randonnée
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('R1S2T3', 'Chaussures de randonnée', 8.0, -1, 6),
    ('U4V5W6', 'Sac à dos', 6.0, -1, 6),
    ('X7Y8Z9', 'Bâtons de marche', 3.0, -1, 6),
    ('A1B2C3', 'Tente de randonnée', 12.0, -1, 6),
    ('D4E5F6', 'Sac de couchage', 5.0, -1, 6),
    ('G7H8I9', 'Lampe frontale', 2.0, -1, 6),
    ('J1K2L3', 'Gourde', 1.0, -1, 6),
    ('M4N5O6', 'Veste de randonnée', 9.0, -1, 6),
    ('P7Q8R9', 'Pantalon de randonnée', 5.0, -1, 6),
    ('S1T2U3', 'Chapeau de randonnée', 2.0, -1, 6),
    ('V4W5X6', 'Boussole', 1.0, -1, 6),
    ('Y7Z8A9', 'Montre altimètre', 15.0, -1, 6),
    ('B1C2D3', 'Tapis de sol', 3.0, -1, 6),
    ('E4F5G6', 'Réchaud portable', 4.0, -1, 6),
    ('H7I8J9', 'Kit de premiers secours', 2.0, -1, 6);

-- Tennis
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('K1L2M3', 'Raquette de tennis', 7.0, -1, 7),
    ('N4O5P6', 'Balles de tennis', 1.0, -1, 7),
    ('Q7R8S9', 'Chaussures de tennis', 6.0, -1, 7),
    ('T1U2V3', 'Filet de tennis', 15.0, -1, 7),
    ('W4X5Y6', 'Sac de tennis', 4.0, -1, 7),
    ('Z7A8B9', 'Short de tennis', 2.0, -1, 7),
    ('C1D2E3', 'T-shirt de tennis', 3.0, -1, 7),
    ('F4G5H6', 'Casquette de tennis', 1.0, -1, 7),
    ('I7J8K9', 'Serre-poignet', 1.0, -1, 7),
    ('L1M2N3', 'Bandana', 1.0, -1, 7),
    ('O4P5Q6', 'Grips de raquette', .0, -1, 7),
    ('R7S8T9', 'Bande de protection pour raquette', .0, -1, 7),
    ('U1V2W3', 'Anti-vibrateur', .0, -1, 7),
    ('X4Y5Z6', 'Chaussettes de tennis', 1.0, -1, 7),
    ('A7B8C9', 'Veste de tennis', 5.0, -1, 7);

-- Football
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('D1E2F3', 'Ballon de football', 2.0, -1, 8),
    ('G4H5I6', 'Chaussures de football', 8.0, -1, 8),
    ('J7K8L9', 'Maillot de football', 5.0, -1, 8),
    ('M1N2O3', 'Protège-tibias', 1.0, -1, 8),
    ('P4Q5R6', 'Filet de but', 10.0, -1, 8),
    ('S7T8U9', 'Gants de gardien', 3.0, -1, 8),
    ('V1W2X3', 'Short de football', 2.0, -1, 8),
    ('Y4Z5A6', 'Chaussettes de football', 1.0, -1, 8),
    ('B7C8D9', 'Sac de sport', 3.0, -1, 8),
    ('E1F2G3', 'Échelle de vitesse', 2.0, -1, 8),
    ('H4I5J6', 'Cônes d\'entraînement', 1.0, -1, 8),
    ('K7L8M9', 'Veste de survêtement', 4.0, -1, 8),
    ('N1O2P3', 'Bandeau de sueur', 1.0, -1, 8),
    ('Q4R5S6', 'Sifflet d\'arbitre', .0, -1, 8),
    ('T7U8V9', 'Tableau tactique', 2.0, -1, 8);

-- Basketball
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('W1X2Y3', 'Ballon de basketball', 2.0, -1, 9),
    ('Z4A5B6', 'Chaussures de basketball', 9.0, -1, 9),
    ('C7D8E9', 'Maillot de basketball', 4.0, -1, 9),
    ('F1G2H3', 'Panier de basketball', 20.0, -1, 9),
    ('I4J5K6', 'Protège-poignets', 1.0, -1, 9),
    ('L7M8N9', 'Chaussettes de basketball', 1.0, -1, 9),
    ('O1P2Q3', 'Short de basketball', 3.0, -1, 9),
    ('R4S5T6', 'T-shirt de basketball', 3.0, -1, 9),
    ('U7V8W9', 'Sac de sport', 4.0, -1, 9),
    ('X1Y2Z3', 'Genouillères', 2.0, -1, 9),
    ('A4B5C6', 'Gants de compression', 1.0, -1, 9),
    ('D7E8F9', 'Sweat à capuche', 5.0, -1, 9),
    ('G1H2I3', 'Bandana', 1.0, -1, 9),
    ('J4K5L6', 'Brassard de sport', .0, -1, 9),
    ('M7N8O9', 'Tableau de score', 10.0, -1, 9);

-- Volleyball
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('P1Q2R3', 'Ballon de volleyball', 2.0, -1, 10),
    ('S4T5U6', 'Chaussures de volleyball', 7.0, -1, 10),
    ('V7W8X9', 'Genouillères', 1.0, -1, 10),
    ('Y1Z2A3', 'Filet de volleyball', 10.0, -1, 10),
    ('B4C5D6', 'Short de volleyball', 2.0, -1, 10),
    ('E7F8G9', 'T-shirt de volleyball', 3.0, -1, 10),
    ('H1I2J3', 'Chaussettes de volleyball', 1.0, -1, 10),
    ('K4L5M6', 'Sac de sport', 3.0, -1, 10),
    ('N7O8P9', 'Protège-chevilles', 2.0, -1, 10),
    ('Q1R2S3', 'Bandeau de sueur', 1.0, -1, 10),
    ('T4U5V6', 'Serviette de sport', 1.0, -1, 10),
    ('W7X8Y9', 'Veste de survêtement', 4.0, -1, 10),
    ('Z1A2B3', 'Sifflet d\'arbitre', .0, -1, 10),
    ('C4D5E6', 'Coudières', 1.0, -1, 10),
    ('F7G8H9', 'Ballon de beach-volley', 2.0, -1, 10);

-- Handball
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('I1J2K3', 'Ballon de handball', 3.0, -1, 11),
    ('L4M5N6', 'Chaussures de handball', 8.0, -1, 11),
    ('O7P8Q9', 'Maillot de handball', 4.0, -1, 11),
    ('R1S2T3', 'Protège-dents', 1.0, -1, 11),
    ('U4V5W6', 'Sifflet', .0, -1, 11),
    ('X7Y8Z9', 'Genouillères', 2.0, -1, 11),
    ('A1B2C3', 'Chaussettes de handball', 1.0, -1, 11),
    ('D4E5F6', 'Short de handball', 2.0, -1, 11),
    ('G7H8I9', 'Gants de handball', 1.0, -1, 11),
    ('J1K2L3', 'Veste de survêtement', 4.0, -1, 11),
    ('M4N5O6', 'Bandeau de sueur', 1.0, -1, 11),
    ('P7Q8R9', 'Sac de sport', 3.0, -1, 11),
    ('S1T2U3', 'Coudières', 1.0, -1, 11),
    ('V4W5X6', 'Sweat à capuche', 5.0, -1, 11),
    ('Y7Z8A9', 'Bandana', 1.0, -1, 11);

-- Rugby
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('B1C2D3', 'Ballon de rugby', 3.0, -1, 12),
    ('E4F5G6', 'Chaussures de rugby', 9.0, -1, 12),
    ('H7I8J9', 'Maillot de rugby', 5.0, -1, 12),
    ('K1L2M3', 'Casque de rugby', 6.0, -1, 12),
    ('N4O5P6', 'Protège-tibias', 1.0, -1, 12),
    ('Q7R8S9', 'Gants de rugby', 2.0, -1, 12),
    ('T1U2V3', 'Short de rugby', 3.0, -1, 12),
    ('W4X5Y6', 'Chaussettes de rugby', 1.0, -1, 12),
    ('Z7A8B9', 'Veste de survêtement', 4.0, -1, 12),
    ('C1D2E3', 'Bandeau de sueur', 1.0, -1, 12),
    ('F4G5H6', 'Sac de sport', 3.0, -1, 12),
    ('I7J8K9', 'Protège-dents', 1.0, -1, 12),
    ('L1M2N3', 'Coudières', 1.0, -1, 12),
    ('O4P5Q6', 'Sweat à capuche', 5.0, -1, 12),
    ('R7S8T9', 'Bandana', 1.0, -1, 12);

-- Golf
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('U1V2W3', 'Club de golf', 12.0, -1, 13),
    ('X4Y5Z6', 'Balles de golf', 2.0, -1, 13),
    ('A7B8C9', 'Gants de golf', 1.0, -1, 13),
    ('D1E2F3', 'Sac de golf', 8.0, -1, 13),
    ('G4H5I6', 'Tee de golf', .0, -1, 13),
    ('J7K8L9', 'Veste de golf', 6.0, -1, 13),
    ('M1N2O3', 'Casquette de golf', 2.0, -1, 13),
    ('P4Q5R6', 'Polo de golf', 4.0, -1, 13),
    ('S7T8U9', 'Chaussettes de golf', 1.0, -1, 13),
    ('V1W2X3', 'Couvre-clubs', 3.0, -1, 13),
    ('Y4Z5A6', 'Serviette de golf', 1.0, -1, 13),
    ('B7C8D9', 'Outil de réparation de divot', 1.0, -1, 13),
    ('E1F2G3', 'Marqueur de balle', .0, -1, 13),
    ('H4I5J6', 'Chariot de golf', 10.0, -1, 13),
    ('K7L8M9', 'Parapluie de golf', 2.0, -1, 13);

-- Pétanque
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('N1O2P3', 'Boules de pétanque', 5.0, -1, 14),
    ('Q4R5S6', 'Cochonnet', .0, -1, 14),
    ('T7U8V9', 'Sac de pétanque', 2.0, -1, 14),
    ('W1X2Y3', 'Marqueur de score', 1.0, -1, 14),
    ('Z4A5B6', 'Râteau de terrain', 2.0, -1, 14),
    ('C7D8E9', 'Cible de pétanque', 1.0, -1, 14),
    ('F1G2H3', 'Chapeau de pétanque', 2.0, -1, 14),
    ('I4J5K6', 'Serviette de pétanque', 1.0, -1, 14),
    ('L7M8N9', 'Veste de pétanque', 3.0, -1, 14),
    ('O1P2Q3', 'Casquette de pétanque', 1.0, -1, 14),
    ('R4S5T6', 'Gants de pétanque', 1.0, -1, 14),
    ('U7V8W9', 'Bandeau de sueur', .0, -1, 14),
    ('X1Y2Z3', 'Protège-boules', 1.0, -1, 14),
    ('A4B5C6', 'Cible en bois', 1.0, -1, 14),
    ('D7E8F9', 'Sweat à capuche', 4.0, -1, 14);
