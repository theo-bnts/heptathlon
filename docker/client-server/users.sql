CREATE USER 'client_server'@'%' IDENTIFIED BY 'client_server';
GRANT SELECT, INSERT, UPDATE, DELETE ON client_server.* TO 'client_server'@'%';
