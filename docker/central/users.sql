CREATE USER 'harmonia'@'%' IDENTIFIED BY 'harmonia';
GRANT SELECT, INSERT, UPDATE, DELETE ON harmonia.* TO 'harmonia'@'%';
