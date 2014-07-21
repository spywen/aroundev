-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 21 Juillet 2014 à 23:28
-- Version du serveur: 5.6.14
-- Version de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: 'aroundev'
--
CREATE DATABASE IF NOT EXISTS aroundev DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE aroundev;

-- --------------------------------------------------------

--
-- Structure de la table 'role'
--

DROP TABLE IF EXISTS role;
CREATE TABLE IF NOT EXISTS role (
  id int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table 'user'
--

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS `user` (
  id int(11) NOT NULL AUTO_INCREMENT,
  firstname varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  lastname varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  isfemale tinyint(1) NOT NULL,
  pseudo varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  email varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  role varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  registerdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  isactive tinyint(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Contenu de la table 'user'
--

INSERT INTO user (id, firstname, lastname, isfemale, pseudo, email, password, role, registerdate, isactive) VALUES
(1, 'babin', 'laurent', 0, 'spywen', 'spywen@hotmail.fr', 'cisco', 'ADMIN', '2014-07-19 16:08:43', 1),
(2, 'fontaine', 'camille', 1, 'k', 'k@k.com', 'cisco', 'ADMIN', '2014-07-21 21:12:06', 1);

-- --------------------------------------------------------

--
-- Structure de la table 'user_role'
--

DROP TABLE IF EXISTS user_role;
CREATE TABLE IF NOT EXISTS user_role (
  id int(11) NOT NULL,
  `user` int(11) NOT NULL,
  role int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
