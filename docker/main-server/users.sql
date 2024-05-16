CREATE USER 'main_server'@'%' IDENTIFIED BY 'main_server';
GRANT SELECT, INSERT, UPDATE, DELETE ON main_server.* TO 'main_server'@'%';
