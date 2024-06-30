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
    ('A1B2C3', 'Selle de cheval', 260.0, 10, 1),
    ('D4E5F6', 'Cravache', 25.0, 50, 1),
    ('G7H8I9', 'Casque d\'équitation', 40.0, 20, 1),
    ('J1K2L3', 'Bottes d\'équitation', 120.0, 15, 1),
    ('M4N5O6', 'Pantalon d\'équitation', 60.0, 30, 1),
    ('P7Q8R9', 'Gants d\'équitation', 20.0, 40, 1),
    ('S1T2U3', 'Étriers', 45.0, 25, 1),
    ('V4W5X6', 'Bridon', 50.0, 10, 1),
    ('Y7Z8A9', 'Tapis de selle', 30.0, 50, 1),
    ('B1C2D3', 'Éperons', 15.0, 40, 1),
    ('E4F5G6', 'Couverture pour cheval', 70.0, 15, 1),
    ('H7I8J9', 'Mors', 25.0, 30, 1),
    ('K1L2M3', 'Protection des membres', 35.0, 20, 1),
    ('N4O5P6', 'Chaps', 55.0, 10, 1),
    ('Q7R8S9', 'Sac de pansage', 40.0, 25, 1);

-- Natation
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('T1U2V3', 'Maillot de bain', 20.0, 100, 2),
    ('W4X5Y6', 'Lunettes de piscine', 9.0, 200, 2),
    ('Z7A8B9', 'Bonnet de bain', 9.0, 150, 2),
    ('C1D2E3', 'Palmes de natation', 35.0, 50, 2),
    ('F4G5H6', 'Tuba', 15.0, 75, 2),
    ('I7J8K9', 'Serviette de bain', 20.0, 100, 2),
    ('L1M2N3', 'Sandales de piscine', 15.0, 80, 2),
    ('O4P5Q6', 'Combinaison de natation', 80.0, 20, 2),
    ('R7S8T9', 'Planche de natation', 25.0, 50, 2),
    ('U1V2W3', 'Pince-nez', 5.0, 100, 2),
    ('X4Y5Z6', 'Bouchons d\'oreilles', 7.0, 150, 2),
    ('A7B8C9', 'Chaussons de piscine', 18.0, 70, 2),
    ('D1E2F3', 'Filet de piscine', 12.0, 40, 2),
    ('G4H5I6', 'Gilet de sauvetage', 30.0, 25, 2),
    ('J7K8L9', 'Chronomètre', 25.0, 30, 2);

-- Course
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('M1N2O3', 'Chaussures de course', 70.0, 100, 3),
    ('P4Q5R6', 'Short de course', 25.0, 150, 3),
    ('S7T8U9', 'T-shirt de course', 20.0, 200, 3),
    ('V1W2X3', 'Montre de sport', 150.0, 30, 3),
    ('Y4Z5A6', 'Bouteille d\'eau', 10.0, 300, 3),
    ('B7C8D9', 'Sac banane', 15.0, 100, 3),
    ('E1F2G3', 'Chaussettes de course', 10.0, 200, 3),
    ('H4I5J6', 'Bandeau', 8.0, 150, 3),
    ('K7L8M9', 'Lunettes de soleil sport', 30.0, 50, 3),
    ('N1O2P3', 'Veste de course', 60.0, 40, 3),
    ('Q4R5S6', 'Bracelet de sport', 12.0, 100, 3),
    ('T7U8V9', 'Ceinture porte-gourdes', 25.0, 50, 3),
    ('W1X2Y3', 'Gants de course', 20.0, 70, 3),
    ('Z4A5B6', 'Casquette de course', 15.0, 100, 3),
    ('C7D8E9', 'Porte-dossard', 10.0, 150, 3);

-- Fitness
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('F1G2H3', 'Tapis de yoga', 30.0, 75, 4),
    ('I4J5K6', 'Haltères', 25.0, 100, 4),
    ('L7M8N9', 'Corde à sauter', 10.0, 200, 4),
    ('O1P2Q3', 'Ballon de gym', 20.0, 50, 4),
    ('R4S5T6', 'Bande élastique', 15.0, 150, 4),
    ('U7V8W9', 'Rouleau de massage', 25.0, 50, 4),
    ('X1Y2Z3', 'Step de fitness', 45.0, 40, 4),
    ('A4B5C6', 'Kettlebell', 35.0, 70, 4),
    ('D7E8F9', 'T-shirt de fitness', 20.0, 150, 4),
    ('G1H2I3', 'Short de fitness', 25.0, 100, 4),
    ('J4K5L6', 'Chaussures de fitness', 60.0, 50, 4),
    ('M7N8O9', 'Gants de fitness', 15.0, 75, 4),
    ('P1Q2R3', 'Bouteille shaker', 12.0, 200, 4),
    ('S4T5U6', 'Sac de sport', 35.0, 60, 4),
    ('V7W8X9', 'Serviette de sport', 10.0, 100, 4);

-- Cyclisme
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('Y1Z2A3', 'Vélo de route', 500.0, 20, 5),
    ('B4C5D6', 'Casque de vélo', 50.0, 100, 5),
    ('E7F8G9', 'Gants de cyclisme', 15.0, 200, 5),
    ('H1I2J3', 'Maillot de cyclisme', 35.0, 150, 5),
    ('K4L5M6', 'Pompe à vélo', 20.0, 75, 5),
    ('N7O8P9', 'Porte-bidon', 10.0, 100, 5),
    ('Q1R2S3', 'Lunettes de cyclisme', 25.0, 80, 5),
    ('T4U5V6', 'Chaussures de cyclisme', 90.0, 50, 5),
    ('W7X8Y9', 'Selle de vélo', 40.0, 60, 5),
    ('Z1A2B3', 'Antivol de vélo', 25.0, 150, 5),
    ('C4D5E6', 'Lumières de vélo', 30.0, 200, 5),
    ('F7G8H9', 'Compteur de vélo', 45.0, 40, 5),
    ('I1J2K3', 'Bidon', 12.0, 100, 5),
    ('L4M5N6', 'Sacoche de selle', 20.0, 50, 5),
    ('O7P8Q9', 'Gilet de sécurité', 15.0, 100, 5);

-- Randonnée
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('R1S2T3', 'Chaussures de randonnée', 80.0, 50, 6),
    ('U4V5W6', 'Sac à dos', 60.0, 75, 6),
    ('X7Y8Z9', 'Bâtons de marche', 30.0, 100, 6),
    ('A1B2C3', 'Tente de randonnée', 120.0, 20, 6),
    ('D4E5F6', 'Sac de couchage', 50.0, 40, 6),
    ('G7H8I9', 'Lampe frontale', 25.0, 150, 6),
    ('J1K2L3', 'Gourde', 15.0, 100, 6),
    ('M4N5O6', 'Veste de randonnée', 90.0, 30, 6),
    ('P7Q8R9', 'Pantalon de randonnée', 50.0, 60, 6),
    ('S1T2U3', 'Chapeau de randonnée', 20.0, 80, 6),
    ('V4W5X6', 'Boussole', 10.0, 120, 6),
    ('Y7Z8A9', 'Montre altimètre', 150.0, 20, 6),
    ('B1C2D3', 'Tapis de sol', 30.0, 50, 6),
    ('E4F5G6', 'Réchaud portable', 40.0, 25, 6),
    ('H7I8J9', 'Kit de premiers secours', 20.0, 100, 6);

-- Tennis
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('K1L2M3', 'Raquette de tennis', 70.0, 100, 7),
    ('N4O5P6', 'Balles de tennis', 10.0, 300, 7),
    ('Q7R8S9', 'Chaussures de tennis', 60.0, 50, 7),
    ('T1U2V3', 'Filet de tennis', 150.0, 10, 7),
    ('W4X5Y6', 'Sac de tennis', 40.0, 30, 7),
    ('Z7A8B9', 'Short de tennis', 25.0, 100, 7),
    ('C1D2E3', 'T-shirt de tennis', 30.0, 150, 7),
    ('F4G5H6', 'Casquette de tennis', 15.0, 80, 7),
    ('I7J8K9', 'Serre-poignet', 10.0, 200, 7),
    ('L1M2N3', 'Bandana', 12.0, 100, 7),
    ('O4P5Q6', 'Grips de raquette', 8.0, 300, 7),
    ('R7S8T9', 'Bande de protection pour raquette', 5.0, 150, 7),
    ('U1V2W3', 'Anti-vibrateur', 7.0, 200, 7),
    ('X4Y5Z6', 'Chaussettes de tennis', 10.0, 120, 7),
    ('A7B8C9', 'Veste de tennis', 50.0, 40, 7);

-- Football
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('D1E2F3', 'Ballon de football', 20.0, 200, 8),
    ('G4H5I6', 'Chaussures de football', 80.0, 50, 8),
    ('J7K8L9', 'Maillot de football', 50.0, 100, 8),
    ('M1N2O3', 'Protège-tibias', 15.0, 150, 8),
    ('P4Q5R6', 'Filet de but', 100.0, 10, 8),
    ('S7T8U9', 'Gants de gardien', 30.0, 75, 8),
    ('V1W2X3', 'Short de football', 25.0, 120, 8),
    ('Y4Z5A6', 'Chaussettes de football', 12.0, 150, 8),
    ('B7C8D9', 'Sac de sport', 35.0, 60, 8),
    ('E1F2G3', 'Échelle de vitesse', 20.0, 30, 8),
    ('H4I5J6', 'Cônes d\'entraînement', 15.0, 100, 8),
    ('K7L8M9', 'Veste de survêtement', 40.0, 50, 8),
    ('N1O2P3', 'Bandeau de sueur', 10.0, 200, 8),
    ('Q4R5S6', 'Sifflet d\'arbitre', 5.0, 300, 8),
    ('T7U8V9', 'Tableau tactique', 25.0, 20, 8);

-- Basketball
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('W1X2Y3', 'Ballon de basketball', 25.0, 150, 9),
    ('Z4A5B6', 'Chaussures de basketball', 90.0, 50, 9),
    ('C7D8E9', 'Maillot de basketball', 45.0, 75, 9),
    ('F1G2H3', 'Panier de basketball', 200.0, 10, 9),
    ('I4J5K6', 'Protège-poignets', 10.0, 200, 9),
    ('L7M8N9', 'Chaussettes de basketball', 15.0, 150, 9),
    ('O1P2Q3', 'Short de basketball', 30.0, 100, 9),
    ('R4S5T6', 'T-shirt de basketball', 35.0, 120, 9),
    ('U7V8W9', 'Sac de sport', 40.0, 60, 9),
    ('X1Y2Z3', 'Genouillères', 20.0, 80, 9),
    ('A4B5C6', 'Gants de compression', 15.0, 100, 9),
    ('D7E8F9', 'Sweat à capuche', 50.0, 40, 9),
    ('G1H2I3', 'Bandana', 12.0, 200, 9),
    ('J4K5L6', 'Brassard de sport', 8.0, 300, 9),
    ('M7N8O9', 'Tableau de score', 100.0, 15, 9);

-- Volleyball
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('P1Q2R3', 'Ballon de volleyball', 20.0, 100, 10),
    ('S4T5U6', 'Chaussures de volleyball', 70.0, 50, 10),
    ('V7W8X9', 'Genouillères', 15.0, 150, 10),
    ('Y1Z2A3', 'Filet de volleyball', 100.0, 10, 10),
    ('B4C5D6', 'Short de volleyball', 25.0, 75, 10),
    ('E7F8G9', 'T-shirt de volleyball', 30.0, 80, 10),
    ('H1I2J3', 'Chaussettes de volleyball', 12.0, 120, 10),
    ('K4L5M6', 'Sac de sport', 35.0, 60, 10),
    ('N7O8P9', 'Protège-chevilles', 20.0, 90, 10),
    ('Q1R2S3', 'Bandeau de sueur', 10.0, 200, 10),
    ('T4U5V6', 'Serviette de sport', 15.0, 100, 10),
    ('W7X8Y9', 'Veste de survêtement', 45.0, 40, 10),
    ('Z1A2B3', 'Sifflet d\'arbitre', 5.0, 300, 10),
    ('C4D5E6', 'Coudières', 18.0, 120, 10),
    ('F7G8H9', 'Ballon de beach-volley', 25.0, 70, 10);

-- Handball
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('I1J2K3', 'Ballon de handball', 30.0, 100, 11),
    ('L4M5N6', 'Chaussures de handball', 80.0, 50, 11),
    ('O7P8Q9', 'Maillot de handball', 40.0, 75, 11),
    ('R1S2T3', 'Protège-dents', 10.0, 200, 11),
    ('U4V5W6', 'Sifflet', 5.0, 300, 11),
    ('X7Y8Z9', 'Genouillères', 20.0, 100, 11),
    ('A1B2C3', 'Chaussettes de handball', 12.0, 150, 11),
    ('D4E5F6', 'Short de handball', 25.0, 120, 11),
    ('G7H8I9', 'Gants de handball', 15.0, 80, 11),
    ('J1K2L3', 'Veste de survêtement', 45.0, 40, 11),
    ('M4N5O6', 'Bandeau de sueur', 10.0, 200, 11),
    ('P7Q8R9', 'Sac de sport', 35.0, 60, 11),
    ('S1T2U3', 'Coudières', 18.0, 120, 11),
    ('V4W5X6', 'Sweat à capuche', 50.0, 40, 11),
    ('Y7Z8A9', 'Bandana', 12.0, 100, 11);

-- Rugby
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('B1C2D3', 'Ballon de rugby', 35.0, 100, 12),
    ('E4F5G6', 'Chaussures de rugby', 90.0, 50, 12),
    ('H7I8J9', 'Maillot de rugby', 50.0, 75, 12),
    ('K1L2M3', 'Casque de rugby', 60.0, 30, 12),
    ('N4O5P6', 'Protège-tibias', 15.0, 150, 12),
    ('Q7R8S9', 'Gants de rugby', 20.0, 80, 12),
    ('T1U2V3', 'Short de rugby', 30.0, 100, 12),
    ('W4X5Y6', 'Chaussettes de rugby', 15.0, 120, 12),
    ('Z7A8B9', 'Veste de survêtement', 45.0, 40, 12),
    ('C1D2E3', 'Bandeau de sueur', 10.0, 200, 12),
    ('F4G5H6', 'Sac de sport', 35.0, 60, 12),
    ('I7J8K9', 'Protège-dents', 10.0, 200, 12),
    ('L1M2N3', 'Coudières', 18.0, 120, 12),
    ('O4P5Q6', 'Sweat à capuche', 50.0, 40, 12),
    ('R7S8T9', 'Bandana', 12.0, 100, 12);

-- Golf
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('U1V2W3', 'Club de golf', 120.0, 50, 13),
    ('X4Y5Z6', 'Balles de golf', 25.0, 200, 13),
    ('A7B8C9', 'Gants de golf', 15.0, 150, 13),
    ('D1E2F3', 'Sac de golf', 80.0, 30, 13),
    ('G4H5I6', 'Tee de golf', 5.0, 300, 13),
    ('J7K8L9', 'Veste de golf', 60.0, 40, 13),
    ('M1N2O3', 'Casquette de golf', 20.0, 100, 13),
    ('P4Q5R6', 'Polo de golf', 40.0, 80, 13),
    ('S7T8U9', 'Chaussettes de golf', 12.0, 150, 13),
    ('V1W2X3', 'Couvre-clubs', 30.0, 60, 13),
    ('Y4Z5A6', 'Serviette de golf', 15.0, 120, 13),
    ('B7C8D9', 'Outil de réparation de divot', 10.0, 200, 13),
    ('E1F2G3', 'Marqueur de balle', 5.0, 300, 13),
    ('H4I5J6', 'Chariot de golf', 100.0, 20, 13),
    ('K7L8M9', 'Parapluie de golf', 25.0, 50, 13);

-- Pétanque
INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES
    ('N1O2P3', 'Boules de pétanque', 50.0, 100, 14),
    ('Q4R5S6', 'Cochonnet', 3.0, 300, 14),
    ('T7U8V9', 'Sac de pétanque', 20.0, 75, 14),
    ('W1X2Y3', 'Marqueur de score', 10.0, 200, 14),
    ('Z4A5B6', 'Râteau de terrain', 25.0, 50, 14),
    ('C7D8E9', 'Cible de pétanque', 15.0, 100, 14),
    ('F1G2H3', 'Chapeau de pétanque', 20.0, 50, 14),
    ('I4J5K6', 'Serviette de pétanque', 10.0, 100, 14),
    ('L7M8N9', 'Veste de pétanque', 35.0, 40, 14),
    ('O1P2Q3', 'Casquette de pétanque', 15.0, 60, 14),
    ('R4S5T6', 'Gants de pétanque', 12.0, 80, 14),
    ('U7V8W9', 'Bandeau de sueur', 5.0, 150, 14),
    ('X1Y2Z3', 'Protège-boules', 10.0, 100, 14),
    ('A4B5C6', 'Cible en bois', 15.0, 70, 14),
    ('D7E8F9', 'Sweat à capuche', 40.0, 30, 14);
