CREATE USER 'magasin'@'%' IDENTIFIED BY 'magasin';
GRANT SELECT, INSERT, UPDATE, DELETE ON magasin.* TO 'magasin'@'%';
