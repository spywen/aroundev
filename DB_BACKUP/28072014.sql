-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 28 Juillet 2014 à 20:04
-- Version du serveur: 5.6.14
-- Version de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `aroundev`
--
CREATE DATABASE IF NOT EXISTS `aroundev` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `aroundev`;

-- --------------------------------------------------------

--
-- Structure de la table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `series` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `last_used` tinyblob NOT NULL,
  `token` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `persistent_logins`
--

INSERT INTO `persistent_logins` (`series`, `last_used`, `token`, `username`) VALUES
('UGkSNofjkz9Cawcd/vDPyw==', 0x323031342d30372d32382031393a35343a30332e353534, 'NIoZKjPTw7JvFcCu9tYCVQ==', 'spywen');

-- --------------------------------------------------------

--
-- Structure de la table `planning_poker_grooming`
--

DROP TABLE IF EXISTS `planning_poker_grooming`;
CREATE TABLE IF NOT EXISTS `planning_poker_grooming` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isactive` bit(1) NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `enddate` datetime DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `moderator` int(11) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q5jgi9u7ye6eixgbrni2nqxyw` (`moderator`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `planning_poker_grooming`
--

INSERT INTO `planning_poker_grooming` (`id`, `isactive`, `description`, `enddate`, `name`, `moderator`, `creationdate`) VALUES
(1, b'1', 'test', '0000-00-00 00:00:00', 'mon grooming', 1, '0000-00-00 00:00:00'),
(2, b'1', 'test', '0000-00-00 00:00:00', 'mon grooming 2', 2, '0000-00-00 00:00:00'),
(3, b'1', 'test', '0000-00-00 00:00:00', 'mon grooming 3', 1, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `planning_poker_status`
--

DROP TABLE IF EXISTS `planning_poker_status`;
CREATE TABLE IF NOT EXISTS `planning_poker_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `planning_poker_status`
--

INSERT INTO `planning_poker_status` (`id`, `code`, `description`) VALUES
(1, 'open', 'open'),
(2, 'standby', 'standby'),
(3, 'close', 'close');

-- --------------------------------------------------------

--
-- Structure de la table `planning_poker_story`
--

DROP TABLE IF EXISTS `planning_poker_story`;
CREATE TABLE IF NOT EXISTS `planning_poker_story` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creationdate` datetime DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estimation` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `grooming` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4rorlyq2b1267nydvb340g3o2` (`grooming`),
  KEY `FK_lbup8l6xt58e334xtcs7nh0r3` (`status`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Contenu de la table `planning_poker_story`
--

INSERT INTO `planning_poker_story` (`id`, `creationdate`, `description`, `estimation`, `name`, `grooming`, `status`) VALUES
(1, NULL, 'test', 2, 'my story', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `planning_poker_vote`
--

DROP TABLE IF EXISTS `planning_poker_vote`;
CREATE TABLE IF NOT EXISTS `planning_poker_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session` int(11) NOT NULL,
  `votedate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `story` int(11) NOT NULL,
  `useraroundev` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eno0j1ym80vqygy1x9quilu3c` (`story`),
  KEY `FK_rggukm7695dky5am4007k2h4t` (`useraroundev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'AUTHENTICATED'),
(2, 'ADMIN'),
(3, 'USER'),
(4, '');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `isactive` bit(1) NOT NULL,
  `isfemale` bit(1) DEFAULT NULL,
  `lastname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `registerdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `email`, `firstname`, `isactive`, `isfemale`, `lastname`, `login`, `password`, `registerdate`) VALUES
(1, 'spywen@hotmail.fr', 'babin', b'1', b'0', 'laurent', 'spywen', 'e73b79a0b10f8cdb6ac7dbe4c0a5e25776e1148784b86cf98f7d6719d472af69', '0000-00-00 00:00:00'),
(2, 'k@k.com', 'fontaine', b'1', b'1', 'camille', 'kmille', 'e73b79a0b10f8cdb6ac7dbe4c0a5e25776e1148784b86cf98f7d6719d472af69', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(1, 2),
(2, 2);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `planning_poker_grooming`
--
ALTER TABLE `planning_poker_grooming`
  ADD CONSTRAINT `FK_q5jgi9u7ye6eixgbrni2nqxyw` FOREIGN KEY (`moderator`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `planning_poker_story`
--
ALTER TABLE `planning_poker_story`
  ADD CONSTRAINT `FK_4rorlyq2b1267nydvb340g3o2` FOREIGN KEY (`grooming`) REFERENCES `planning_poker_grooming` (`id`),
  ADD CONSTRAINT `FK_lbup8l6xt58e334xtcs7nh0r3` FOREIGN KEY (`status`) REFERENCES `planning_poker_status` (`id`);

--
-- Contraintes pour la table `planning_poker_vote`
--
ALTER TABLE `planning_poker_vote`
  ADD CONSTRAINT `FK_eno0j1ym80vqygy1x9quilu3c` FOREIGN KEY (`story`) REFERENCES `planning_poker_story` (`id`),
  ADD CONSTRAINT `FK_rggukm7695dky5am4007k2h4t` FOREIGN KEY (`useraroundev`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
