# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Hôte: 127.0.0.1 (MySQL 5.6.14)
# Base de données: aroundev
# Temps de génération: 2014-11-19 10:42:42 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Affichage de la table event
# ------------------------------------------------------------

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startdate` datetime NOT NULL,
  `creationdate` datetime NOT NULL,
  `owner` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;

INSERT INTO `event` (`id`, `title`, `description`, `startdate`, `creationdate`, `owner`)
VALUES
	(1,'zdzddz','zdzddzd','2014-11-07 00:00:00','2014-11-13 16:04:10',1),
	(2,'efeffe','efeffef','2014-11-08 00:00:00','2014-11-13 16:06:11',1),
	(13,'MON EVENEMEN','AAAA','2014-11-07 00:00:00','2014-11-13 20:40:44',2),
	(14,'12','12','2014-11-08 00:00:00','2014-11-13 20:51:27',2),
	(15,'3344','43333','2014-11-22 00:00:00','2014-11-14 09:02:56',1),
	(16,'teets','kjsjdjzdiz','2014-11-08 00:00:00','2014-11-14 12:42:05',1);

/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table persistent_logins
# ------------------------------------------------------------

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `series` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `last_used` tinyblob NOT NULL,
  `token` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



# Affichage de la table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `name`)
VALUES
	(1,'AUTHENTICATED'),
	(2,'ADMIN'),
	(3,'USER'),
	(4,'SUPINFONICE');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `isactive` bit(1) NOT NULL,
  `isfemale` bit(1) DEFAULT NULL,
  `lastname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `registerdate` datetime NOT NULL,
  `supinfoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `email`, `firstname`, `isactive`, `isfemale`, `lastname`, `login`, `password`, `registerdate`, `supinfoid`)
VALUES
	(1,'spywen@hotmail.fr','babin',00000001,00000000,'laurent','spywen','e73b79a0b10f8cdb6ac7dbe4c0a5e25776e1148784b86cf98f7d6719d472af69','0000-00-00 00:00:00',144763),
	(2,'k@k.com','fontaine',00000001,00000001,'camille','kmille','e73b79a0b10f8cdb6ac7dbe4c0a5e25776e1148784b86cf98f7d6719d472af69','0000-00-00 00:00:00',144763);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
	(1,1),
	(2,1),
	(1,2),
	(1,3),
	(1,4);

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
