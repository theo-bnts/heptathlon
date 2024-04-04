INSERT INTO harmonia.PHYSICAL_ACTIVITY_TYPE (NAME, KILOCALORIES_SPENT_HOURLY) VALUES
	('MARCHE', 308),
	('JOGGING', 576),
	('VTT', 612),
	('FOOTBALL', 504),
	('TENNIS', 504),
	('ÉQUITATION', 140),
	('BASKETBALL', 576),
	('JUDO', 720),
	('HANDBALL', 864),
	('GOLF', 324),
	('NATATION', 567),
	('CANOË KAYAK', 360),
	('RUGBY', 576);

INSERT INTO harmonia.PHONE (NAME, `NUMBER`) VALUES
	('URGENCES', '112'),
	('PRÉVENTION SUICIDE', '3114'),
	('DROGUES INFO SERVICES', '0 800 23 13 13'),
	('ALCOOL INFO SERVICES', '09 80 98 09 30'),
	('TABAC INFO SERVICES', '39 89'),
	('JOUEURS INFO SERVICES', '09 74 75 13 13');

INSERT INTO harmonia.MOOD_TYPE (NAME, IMPACT) VALUES
	('TRÈS NÉGATIVE', 1),
	('NÉGATIVE', 2),
	('NORMALE', 3),
	('POSITIVE', 4),
	('TRÈS POSITIVE', 5);

INSERT INTO harmonia.CATEGORY (NAME, ICON_NAME, ID_CATEGORY_1) VALUES
	('ALIMENTATION', 'alimentation.png', NULL),
	('MENTAL', 'mood.png', NULL),
	('PHYSIQUE', 'physical.png', NULL),
	('MÉDITATION', 'guru.png', 2),
	('RESPIRATION', 'breath.png', 2),
	('MASSAGES', 'massage.png', 2),
	('ÉTIREMENTS', 'stretching.png', 2),
	('CARDIO', 'heart.png', 3),
	('MUSCULATION', 'arm.png', 3),
	('TORSE', 'abs.png', 9),
	('DOS', 'back.png', 9),
	('BRAS', 'arm.png', 9),
	('JAMBES', 'leg.png', 9);

INSERT INTO harmonia.VIDEO_TYPE (NAME) VALUES
	('CONSEIL'),
	('EXERCICE');

INSERT INTO harmonia.VIDEO (NAME, DESCRIPTION, URL, ID_VIDEO_TYPE, ID_CATEGORY) VALUES
	('LE NUTRI-SCORE', NULL, 'https://www.youtube.com/embed/JiWs3Ibj7b0', 1, 1),
	('10 BONNES HABITUDES À PRENDRE', NULL, 'https://www.youtube.com/embed/JM-SSmWBVpw', 1, 2),
	('DÉPISTAGE DES CANCERS DU SEIN', NULL, 'https://www.youtube.com/embed/OUbVI0460PQ', 1, 3),
	('AU SPORT !', NULL, 'https://www.youtube.com/embed/bV2nvkhGlOg', 1, 3),
	('LA PREP', NULL, 'https://www.youtube.com/embed/fxWLd2PuwEw', 1, 3),
	('STEP UPS', 'Le « step-up » cible vos muscles fessiers et les ischio-jambiers. Il est considéré comme l''un des meilleurs exercices pour le développement de jambes fortes et minces. Ce mouvement augmente également votre fréquence cardiaque, ce qui permet d''augmenter votre dépense calorique. Les « step-ups » sont un excellent moyen pour développer la force au niveau des jambes, développer la puissance explosive et améliorer la symétrie de la musculature de vos jambes. ', 'https://www.youtube.com/embed/yTRS_y4HT88', 2, 13),
	('JUMPING JACKS', 'Les «sauts à écarts» ciblent tous les groupes musculaires et améliorent la santé cardiovasculaire. Cet exercice composé travaille vos abdominaux, bras, épaules, fessiers, jambes et votre dos. Il brûle également les calories et augmente votre rythme cardiaque. Il a été démontré que les « sauts à écarts » soulagent le stress, améliorent la circulation sanguine et stimulent la condition physique. Pour brûler plus de calories, sautez plus vite. Si vous êtes un débutant, utilisez des mouvements lents et contrôlés pour éviter les blessures. Que vous souhaitiez perdre du poids, améliorer votre endurance ou développer de la masse musculaire maigre, faites régulièrement des sauts à écarts. Cet exercice est destiné à la fois au cardio et à la musculation. Il est également très efficace pour s''échauffer avant de se rendre à la salle de musculation. ', 'https://www.youtube.com/embed/doXgX5o3PDk', 2, 13),
	('HIGH KNEES RUNNING IN PLACE', 'Cet exercice combine les levés de genoux avec le mouvement typique de la course. Il s’agit d’un des mouvements les plus efficaces pour améliorer votre technique de course ainsi que votre vitesse, souplesse et équilibre. La course genoux levés augmente également votre rythme cardiaque et brûle des calories, ce qui est idéal pour ceux qui souhaitent faire fondre la graisse. C''est l''exercice parfait pour un entraînement cardio difficile qui accélérera votre fréquence cardiaque. Les principaux muscles impliqués sont les quadriceps, les mollets et les fessiers. Ce mouvement fait également participer vos abdominaux et peut vous aider à vous débarrasser des poignées d''amour. ', 'https://www.youtube.com/embed/WoQneiFP9wU', 2, 13),
	('PLANK', 'La « Planche » et toutes ses variantes sont considérés comme l’un des 5 meilleurs exercices en termes d''efficacité pour entraîner la partie centrale du buste, en particulier les abdominaux, sans surcharger la colonne vertébrale, comme cela arrive souvent dans les classiques sit up (en particulier s’ils sont réalisés avec une technique incorrecte).
La difficulté de cet exercice réside non pas tant dans le mouvement, mais à conserver la position « en ligne » pendant un certain laps de temps et dans le même temps à contracter de façon volontaires les muscles du buste (abdominaux, abdominaux obliques et lombaires). Cet exercice est un « MUST » pour tous ceux qui souhaitent améliorer leurs abdominaux en réduisant au minimum la charge sur le dos.', 'https://www.youtube.com/embed/auaPX7B2rV4', 2, 10),
	('PUSH-UPS WITH TORSO ROTATION', 'Ces flexions sont une variante plus complexe des classiques « push-up ». En plus d’entraîner intensément les pectoraux, leur bonne exécution contribue à renforcer la partie centrale du corps en travaillant également vos épaules.
Les flexions avec rotation sont particulièrement indiquées à ceux qui pratiquent des sports nécessitant de fréquentes flexions du torse, de l’équilibre et une grande stabilité dans la partie centrale du corps.
Les résultats plus évidents concernent en effet la stabilisation des épaules et le renforcement des muscles du torse. ', 'https://www.youtube.com/embed/sKZZKPIEEew', 2, 10),
	('SIDE PLANK', 'La planche est l''un des 5 meilleurs exercices pour gainer la musculature abdominale profonde, et dans le cas de la planche latérale, les obliques. De plus, elle est plus efficace que les « Sit-Up » classiques, puisqu''elle mobilise différents groupes musculaires sans mettre la pression sur les disques et les lombaires. Cet exercice est très utile au renforcement des muscles stabilisateurs du torse et si l''exercice est exécuté correctement, vous travaillez tous les groupes musculaires en synergie. Pour leur action profonde élevée, les planches latérales sont conseillées aux personnes qui souhaitent augmenter l''intensité de leur entraînement. La difficulté est de garder la position correcte et l''équilibre pendant un certain temps : par conséquent, nous conseillons cet exercice aux personnes qui possèdent déjà une bonne tonicité musculaire. Nous le déconseillons à celles qui ont des problèmes de coiffes musculaires à l''épaule, et de cervicales.', 'https://www.youtube.com/embed/cqehV0kVvjM', 2, 10),
	('TRICEP BENCH DIPS', 'Les flexions des triceps, mieux connues sous le nom de « dip » constituent un exercice bien connu et apprécié pour le travail qui est effectué sur les triceps, les pectoraux et les portions antérieures des deltoïdes. 
Cette variante des différents « dips » est particulièrement adaptée à la fois pour une séance d''entraînement en salle ou pour une séance d''entraînement à la maison, car si vous ne disposez pas d''un banc de musculation, vous pouvez utiliser n''importe quel autre type de support, comme une simple chaise.', 'https://www.youtube.com/embed/qwSoO6WEJ9g', 2, 12),
	('FORWARD LUNGES', 'Les fentes avant améliorent la force et la souplesse des jambes, tonifient vos fessiers et brûle les graisses. Ce classique exercice multi-articulaire façonnera vos jambes et permettra d’éliminer vos déséquilibres musculaires. Il cible plusieurs muscles, y compris vos quadriceps, ischio-jambiers, mollets, fessiers et abdominaux. La fente est depuis longtemps un entraînement de base en raison de ses nombreux bénéfices pour la santé. Si effectué correctement, cet exercice améliore votre équilibre et votre coordination, augmente la souplesse des fléchisseurs des hanches et permet une meilleure stabilité du tronc.', 'https://www.youtube.com/embed/Y0jGY9Eie8U', 2, 13),
	('WALL SIT', 'L’exercice assis contre le mur est l''un des meilleurs exercices pour les quadriceps. Également connu sous le nom de la chaise romaine, ce mouvement augmente la force au niveau du bas du corps et améliore votre équilibre. Les principaux muscles ciblés sont les fesses, les mollets et les quadriceps. Cet exercice est largement utilisé dans les sports nécessitant de forts quadriceps, comme le ski, les courses de bateaux, le hockey sur glace et l’escrime. Cet exercice est également populaire parmi les culturistes et les mannequins de fitness. Lorsqu’ils sont faits régulièrement, ils améliorent la force isométrique et l''endurance, façonnent vos jambes et vous rendent plus fort dans l''ensemble.', 'https://www.youtube.com/embed/y9v66nRKtJM', 2, 13),
	('ABDOMINAL CRUNCH', 'Exercices pour ventre plat: Abdominal Crunch. Le redressement assis est l’exercice le plus connu pour les abdominaux. Quand il s''agit d’obtenir une « tablette de chocolat » et de perdre la graisse abdominale, les redressements assis sont indispensables. Ce mouvement isole vos muscles du tronc, améliore votre équilibre et améliore la condition physique fonctionnelle. Il cible le droit de l''abdomen, le transverse de l''abdomen et les obliques. Les redressements assis peuvent aider à renforcer vos abdominaux, améliorer votre posture et faire fondre la graisse. Les sportifs avancés peuvent utiliser des haltères pour un entraînement plus difficile. ', 'https://www.youtube.com/embed/C0NQqI9YeyQ', 2, 10),
	('SQUAT', 'Le «squat» est un exercice à plusieurs composants qui fait participer presque tous les muscles de votre corps, surtout votre tronc, vos quadriceps, ischio-jambiers, fessiers et mollets. Considéré comme le « roi des exercices », il améliore votre équilibre et votre coordination, renforce votre tronc et vous rend plus fort dans l''ensemble. Faire des « squats » améliore la performance physique, la forme et la mobilité pour les activités quotidiennes. Ce mouvement fonctionnel est adapté pour tous les sports nécessitant de la force au bas du corps. ', 'https://www.youtube.com/embed/HFzk7HC3QM4', 2, 13),
	('PUSH-UPS', 'Les meilleurs exercices pour la poitrine: Push-Ups. La «pompe» est considérée comme l''un des meilleurs exercices pour le haut du corps. Ce mouvement multi-articulaire ne nécessite aucun équipement spécial et peut être fait n''importe où, n''importe quand. Elle cible la plupart des groupes musculaires, y compris vos muscles du dos, des épaules, du tronc, vos triceps et pectoraux. Les « pompes » sont couramment utilisées dans l''entraînement physique militaire, en musculation et lors des entraînements de Cross Fit. Si effectuées correctement, elles aident à construire une base plus solide et améliorent votre condition physique générale. ', 'https://www.youtube.com/embed/5L-HbGnh68M', 2, 10),
	('CRUNCH AVEC LES GENOUX À LA POITRINE', 'Le crunch avec les genoux à la poitrine, connu comme le double crunch, est un exercice de niveau avancé pour développer les abdominaux et stabiliser la partie lambaire. La partie « crunch inverse » de cet exercice qui implique les jambes, forme particulièrement la partie inférieure de vos abdominaux. Il ne faut pas oublier que les fléchisseurs de la hanche font partie des muscles impliqués dans cet exercice : ils sont les premiers à être activés lors du mouvement des genoux vers la poitrine. ', 'https://www.youtube.com/embed/gPJ_lSfgROM', 2, 10),
	('REDRESSEMENT AVEC LES BRAS CROISÉS', 'Le redressement avec les bras croisés sur la poitrine est une simple variante du redressement classique.
Il s''agit d''un exercice pour les débutants puisque les bras croisés sur la poitrine facilitent l''exécution du mouvement.
Si vous souhaitez muscler vos abdos de manière efficace, les tonifier et les renforcer (surtout dans la partie supérieure),c''est sans aucun doute un exercice par lequel commencer.', 'https://www.youtube.com/embed/iT5EjBwZLRM', 2, 10),
	('CONTRACTION DES ABDOS', 'Cet exercice est très efficace pour renforcer l''ensemble de l''aponévrose abdominale tout en mettant un accent particulier sur la zone supérieure du grand droit de l''abdomen (les abdos).
Le renforcement musculaire de ce type d''exercice permettra également d''augmenter la force et la capacité d’effectuer des activités aérobiques comme la natation, la course et la marche. L’exercice « Contractez vos muscles en maintenant vos jambes verticales et touchez vos chevilles » aide également à corriger la posture et à l''équilibre du corps.', 'https://www.youtube.com/embed/pAOrY9IIoMc', 2, 10),
	('CRUNCH AVEC LES MAINS REPOSÉES', 'Cet exercice pour vos abdominaux est une variante du crunch classique et est idéal pour travailler intensivement votre abdomen supérieur. 
Reposez vos mains sur vos quadriceps, le travail se concentre sur la partie supérieure droite de l''abdomen', 'https://www.youtube.com/embed/DQu6OTmNhcw', 2, 10),
	('ÉLÉVATION DES JAMBES EN 4 TEMPS', 'Cet exercice est un exercice classique pour ce qu’on appelle les « abdominaux bas». Comme toujours, nous tenons à préciser que le muscle grand droit de l''abdomen est un muscle unique et large, mais qui a des zones pouvant être stimulées et renforcées par des exercices ciblés. Le cas des abdominaux avec élévation des jambes en 4 temps est un exemple : grâce à l''élévation et l''abaissement alternatifs des jambes, le bas-ventre sera stimulé plus efficacement.', 'https://www.youtube.com/embed/FCcSgVWhmIE', 2, 10),
	('CRUNCH PAR POUSSÉE DES MAINS', 'Le crunch par poussée des mains est un exercice idéal pour former le grand droit de l''abdomen (rectus abdominis) en concentrant précisément l’effort sur l’extrémité supérieure des muscles abdominaux. Cet exercice est une variante du crunch classique : avec la poussée en avant des mains, un effort accru est demandé, ce qui sollicite ainsi les abdos (notamment leur partie supérieure) de manière plus intense et plus ciblée.', 'https://www.youtube.com/embed/TMItuHXKLx8', 2, 10),
	('ABDOMINAUX ALTERNÉS', 'Les abdominaux alternés sont l''exercice idéal pour bien sculpter l''abdomen et obtenir de supers six abdominaux. Les abdominaux alternés contribuent à renforcer et à tonifier le droit de l''abdomen et les abdominaux obliques mais encore : cet exercice procure une meilleure stabilité aux muscles du bas du dos.', 'https://www.youtube.com/embed/UuQNxjMPIfw', 2, 10),
	('FOOT 2 FOOT CRUNCH', 'Cet exercice est l''un des exercices les plus connus et les plus efficaces pour former des abdominaux obliques.
Le Foot 2 Foot Crunch est très efficace pour  la formation de la bande latérale de l''abdomen,  grâce à la tension musculaire continue et la position tendue et légèrement relevée des bras et des épaules, qui aident à équilibrer le poids et à exécuter correctement l''exercice.', 'https://www.youtube.com/embed/8FSPprNrqx4', 2, 10),
	('ÉTIREMENTS CORPS ENTIER', 'Cette séance est consacrée aux étirements, objectif : gagner en souplesse ! Elle s''adresse tout particulièrement aux personnes atteintes de lombalgies, mais peut être également suivie par tous ceux qui souhaitent travailler leur souplesse. 
Pour progresser, je vous conseille de la faire au moins 3x/semaine !', 'https://www.youtube.com/embed/twf4e-EC2e4', 2, 7),
	('SALUTATION AU SOLEIL', 'Cette séance est consacrée à un enchaînement dynamique de yoga que l''on appelle la salutation au soleil. Il se compose d''une douzaine de postures (montagne, pince-avant, dos droit, planche, cobra, chien tête en bas...) qui travaillent la mobilité de la colonne vertébrale (en flexion et en extension),ainsi que la stabilité du corps. Cet enchaînement permet de s''échauffer avant une séance d''activité physique, ou de se réveiller le matin. Il prévient également le mal de dos, de façon très efficace !
Vous découvrirez d''abord les postures une par une, puis vous apprendrez à les enchaîner en vous accompagnant de la respiration. 
Bonne séance !', 'https://www.youtube.com/embed/tL3VKssE53E', 2, 4),
	('YOGA', 'Cette séance est consacrée au relâchement des tensions, à travers des exercices de respiration, des postures d’étirements, et de la relaxation. Elle s’adresse à toutes les personnes souhaitant prendre du temps pour elles, et pour se détendre. Elle peut également être réalisée dans un objectif de récupération après un entrainement sportif.', 'https://www.youtube.com/embed/Kmt66urYVD8', 2, 4),
	('ÉTIREMENTS NUQUE', 'Cette séance est consacrée au relâchement des tensions cervicales, à travers des exercices de respiration, et des postures d’étirements. Elle s’adresse à toutes les personnes qui souffrent de douleurs ou de tensions dans le cou, et dans les épaules. Elle peut également être réalisée dans un objectif de prévention, chez les personnes stressées, ou travaillant dans des bureaux.', 'https://www.youtube.com/embed/vMEIq_QDcrg', 2, 7),
	('COHÉRENCE CARDIAQUE', 'Cette séance est consacrée à un exercice un peu particulier, à la recherche de la « cohérence cardiaque ». 
Comme nos émotions sont capables d’agir sur notre cœur et notre respiration, notre respiration et notre cœur peuvent agir sur nos émotions. Ainsi, à travers un exercice respiratoire simple (fréquence respiratoire de 6 cycles/minute, pendant 5 minutes, 3x/jour),vous allez agir sur la variabilité de votre fréquence cardiaque (VFC),et déclencher des processus physiologiques de bien-être (ex : sécrétion d’hormones anti-stress, d’hormones anti-hypertension…). Cet exercice s’apparente à une forme de méditation, et apporte de nombreux bienfaits sur la régulation des émotions (lutte contre le stress, l''anxiété),de la tension artérielle, et même sur la cognition.', 'https://www.youtube.com/embed/Sdn-QkOBCC8', 2, 5),
	('HATHA YOGA', 'Cette séance est consacrée au yoga dans sa version posturale : le Hatha Yoga. Vous y découvrirez une dizaine de posture, que vous maintiendrez durant six respirations lentes et profondes. Les postures sont présentées dans différentes versions lorsque cela est possible, pour les rendre plus accessibles. C’est une séance qui s’adresse tout particulièrement aux débutants qui voudraient s’essayer en douceur à l’art des asanas. ', 'https://www.youtube.com/embed/iwZiArDpNEo', 2, 4),
	('VINYASA YOGA', 'Cette séance est consacrée au yoga dans sa version dynamique : le Vinyasa Yoga. Elle fait notamment suite aux vidéos sur la « salutation au soleil », on vient ajouter de nouvelles postures à cet enchaînement dynamique. L’objectif est d’arriver à maîtriser les transitions entre les postures, et de s’accompagner avec la respiration.  Ne vous inquiétez pas, les postures n’ont pas besoin d’être parfaitement exécutées, c’est surtout l’intention que vous y mettez qui compte !', 'https://www.youtube.com/embed/8uU7cz9HO3c', 2, 4),
	('CARDIO DANSE', NULL, 'https://www.youtube.com/embed/rYzcaQMkkMw', 2, 8),
	('CARDIO CORDES À SAUTER', NULL, 'https://www.youtube.com/embed/cquLK8W8Re8', 2, 8),
	('CARDIO BOXE', NULL, 'https://www.youtube.com/embed/irdElQC2Heg', 2, 8);