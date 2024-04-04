1. Télécharger [Docker Desktop](https://www.docker.com/products/docker-desktop/)
2. Installer (ne rien modifier a l'installation)
3. Redémarrer pc
4. Démarrer Docker (si pas démarré automatiquement)
5. Ouvrir un terminal a la racine du dossier
6. Exécuter la commande docker-compose up -d
7. Télécharger [DBeaver](https://dbeaver.io/download/)
8. Installer (ne rien modifier a l'installation)
9. Ouvrir DBeaver
10. Ajouter une connexion : MySQL
- Server Host: localhost
- Port: 3307
- Database: central
- Nom d'utilisateur : central
- Mot de passe : central
11. Aller dans l'onglet en haut "Propriétés du pilote" et modifier :
- allowPublicKeyRetrieval : false en TRUE