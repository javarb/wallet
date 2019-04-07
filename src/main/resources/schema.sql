-- Table structure for table 'account'
-- Use the default Engine INNODB 
CREATE TABLE IF NOT EXISTS account (
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for each account',
	account_name varchar(20) NOT NULL COMMENT 'The account name' ,
	fullname varchar(255) NOT NULL COMMENT 'Fullname of the account owner',
	PRIMARY KEY (id)
);
