CREATE USER 'central'@'%' IDENTIFIED BY 'central';
GRANT SELECT, INSERT, UPDATE, DELETE ON central.* TO 'central'@'%';
