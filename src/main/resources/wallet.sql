-- Table structure for table 'account'
-- Use the default Engine INNODB 
CREATE TABLE IF NOT EXISTS account (
	id INT NOT NULL AUTO_INCREMENT COMMENT 'unique ID for each account',
	account_name varchar(20) NOT NULL COMMENT 'the account name' ,
	fullname varchar(255) NOT NULL COMMENT 'fullname of the account owner',
	PRIMARY KEY (id),
	INDEX (id)
);

-- Some test data
INSERT INTO account(account_name,fullname)
VALUES	('user1', 'Juan'),
	('user2', 'Pedro'),
 	('user3', 'Pablo');
