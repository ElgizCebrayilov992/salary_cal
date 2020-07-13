/*
MySQL Backup
Database: salary_calculation
Backup Time: 2020-07-13 14:15:50
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `salary_calculation`.`about_employee`;
DROP TABLE IF EXISTS `salary_calculation`.`daily_salary`;
DROP TABLE IF EXISTS `salary_calculation`.`monthly_salary`;
DROP TABLE IF EXISTS `salary_calculation`.`position`;
DROP TABLE IF EXISTS `salary_calculation`.`tax_cal`;
CREATE TABLE `about_employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `identity_fin` varchar(255) DEFAULT NULL,
  `identity_seria` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `salary` double(100,0) DEFAULT NULL,
  `salary_day` varchar(255) DEFAULT NULL,
  `num_of_day` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `position_id` (`position_id`),
  CONSTRAINT `about_employee_ibfk_1` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `daily_salary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employe_id` int DEFAULT NULL,
  `bonus` double DEFAULT NULL,
  `advance` double DEFAULT NULL,
  `penalty` double DEFAULT NULL,
  `taken_daily_salary` double DEFAULT NULL,
  `daily_salary` double DEFAULT NULL,
  `about_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `about_id` (`employe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `monthly_salary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employe_id` int DEFAULT NULL,
  `total_bonus` double DEFAULT NULL,
  `total_advance` double DEFAULT NULL,
  `total_penalty` double DEFAULT NULL,
  `total_taken_daily_salary` double DEFAULT NULL,
  `employee_debit` double DEFAULT NULL,
  `company_debit` double DEFAULT NULL,
  `about_date` date DEFAULT NULL,
  `net_salary` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employe_id` (`employe_id`),
  CONSTRAINT `monthly_salary_ibfk_1` FOREIGN KEY (`employe_id`) REFERENCES `about_employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `tax_cal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gv_200` double DEFAULT NULL,
  `ssh_200_gore` double DEFAULT NULL,
  `ssh_200dan_yuxari` double DEFAULT NULL,
  `ish_200_gore` double DEFAULT NULL,
  `itsh_200` double DEFAULT NULL,
  `gv_8000` double DEFAULT NULL,
  `ssh_8000in200` double DEFAULT NULL,
  `ssh_8000qalani` double DEFAULT NULL,
  `ish_8000` double DEFAULT NULL,
  `itsh_8000_gore` double DEFAULT NULL,
  `itsh_8000_elave` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `salary_calculation`.`about_employee` WRITE;
DELETE FROM `salary_calculation`.`about_employee`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `salary_calculation`.`daily_salary` WRITE;
DELETE FROM `salary_calculation`.`daily_salary`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `salary_calculation`.`monthly_salary` WRITE;
DELETE FROM `salary_calculation`.`monthly_salary`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `salary_calculation`.`position` WRITE;
DELETE FROM `salary_calculation`.`position`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `salary_calculation`.`tax_cal` WRITE;
DELETE FROM `salary_calculation`.`tax_cal`;
INSERT INTO `salary_calculation`.`tax_cal` (`id`,`name`,`gv_200`,`ssh_200_gore`,`ssh_200dan_yuxari`,`ish_200_gore`,`itsh_200`,`gv_8000`,`ssh_8000in200`,`ssh_8000qalani`,`ish_8000`,`itsh_8000_gore`,`itsh_8000_elave`) VALUES (1, 'qnss', 0, 3, 10, 0.5, 1, 14, 3, 10, 0.5, 1, 0.5);
UNLOCK TABLES;
COMMIT;
