-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 16 mai 2023 à 08:49
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Pokemon2`
--

-- --------------------------------------------------------

--
-- Structure de la table `mochila`
--

CREATE TABLE `mochila` (
  `ID_Trainer` int(2) DEFAULT NULL,
  `ID_Objeto` int(2) DEFAULT NULL,
  `Cant_Objetos` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `movement`
--

CREATE TABLE `movement` (
  `ID_Movement` int(2) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Mvmnt_Learn_Level` int(3) DEFAULT NULL,
  `Power` int(3) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Upgrade_Attack` int(2) DEFAULT NULL,
  `Upgrade_Special_Attack` int(2) DEFAULT NULL,
  `Upgrade_Defense` int(2) DEFAULT NULL,
  `Upgrade_Special_Defense` int(2) DEFAULT NULL,
  `State_to_Apply` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `movement`
--

INSERT INTO `movement` (`ID_Movement`, `Name`, `Mvmnt_Learn_Level`, `Power`, `Type`, `Upgrade_Attack`, `Upgrade_Special_Attack`, `Upgrade_Defense`, `Upgrade_Special_Defense`, `State_to_Apply`) VALUES
(1, 'Trueno', 4, 110, 'ELECTRIC', NULL, NULL, NULL, NULL, NULL),
(2, 'Danza espada', 7, NULL, NULL, 40, 0, 0, 0, NULL),
(3, 'Rayo Confuso', 10, NULL, NULL, NULL, NULL, NULL, NULL, 'PARALYSED'),
(4, 'Niebla aromática', 13, NULL, NULL, 40, 0, 0, 0, NULL),
(5, 'Aguijón Letal', 16, 50, 'BUG', NULL, NULL, NULL, NULL, NULL),
(6, 'Refuerzo', 19, NULL, NULL, 0, 0, 0, 0, NULL),
(7, 'Impresionar', 22, 30, 'GHOST', NULL, NULL, NULL, NULL, NULL),
(8, 'Hilo venenoso', 25, NULL, NULL, NULL, NULL, NULL, NULL, 'POISONED'),
(9, 'Danza dragón', 28, NULL, NULL, 40, 0, 0, 0, NULL),
(10, 'Ventisca', 31, NULL, NULL, NULL, NULL, NULL, NULL, 'FROZEN'),
(11, 'Hipnosis', 34, NULL, NULL, NULL, NULL, NULL, NULL, 'ASLEEP'),
(12, 'Fuerza bruta', 37, 120, 'FIGHTING', NULL, NULL, NULL, NULL, NULL),
(13, 'Barrera', 40, NULL, NULL, 0, 0, 40, 0, NULL),
(14, 'Infierno', 43, NULL, NULL, NULL, NULL, NULL, NULL, 'BURNED'),
(15, 'Rayo Solar', 46, 120, 'GRASS', NULL, NULL, NULL, NULL, NULL),
(16, 'Protección', 49, NULL, NULL, 0, 0, 0, 0, NULL),
(17, 'Canto mortal', 52, NULL, NULL, NULL, NULL, NULL, NULL, 'FROZEN'),
(18, 'Motivación', 55, NULL, NULL, 40, 40, 0, 40, NULL),
(19, 'Cola Dragón', 58, 60, 'DRAGON', NULL, NULL, NULL, NULL, NULL),
(20, 'Lanzallamas', 61, 95, 'FIRE', NULL, NULL, NULL, NULL, NULL),
(21, 'Cola Férrea', 64, NULL, NULL, 0, 40, 0, 0, NULL),
(22, 'Acupresión', 67, NULL, NULL, 0, 0, 40, 0, NULL),
(23, 'Tóxico', 70, NULL, NULL, NULL, NULL, NULL, NULL, 'POISONED'),
(24, 'Ascuas', 73, NULL, NULL, NULL, NULL, NULL, NULL, 'BURNED'),
(25, 'Chuzos', 76, 85, 'ICE', NULL, NULL, NULL, NULL, NULL),
(26, 'Rayo Hielo', 79, NULL, NULL, NULL, NULL, NULL, NULL, 'FROZEN'),
(27, 'Hidrobomba', 82, 110, 'WATER', NULL, NULL, NULL, NULL, NULL),
(28, 'Polución', 85, NULL, NULL, NULL, NULL, NULL, NULL, 'BURNED'),
(29, 'Amnesia', 88, NULL, NULL, 40, 0, 0, 40, NULL),
(30, 'Lanzarrocas', 91, 50, 'ROCK', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `objeto`
--

CREATE TABLE `objeto` (
  `ID_Objeto` int(3) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `ID_Trainer` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `objeto`
--

INSERT INTO `objeto` (`ID_Objeto`, `Name`, `ID_Trainer`) VALUES
(1, 'Pesa', NULL),
(2, 'Pluma', NULL),
(3, 'Chaleco', NULL),
(4, 'Baston', NULL),
(5, 'Pilas', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `pokedex`
--

CREATE TABLE `pokedex` (
  `Name` varchar(20) DEFAULT NULL,
  `ID_Pokedex` int(3) NOT NULL,
  `Image` varchar(50) DEFAULT NULL,
  `Image_Back` varchar(20) DEFAULT NULL,
  `HP` int(3) DEFAULT NULL,
  `Level` int(3) DEFAULT NULL,
  `AttackPower` int(3) DEFAULT NULL,
  `SpecialAttack` int(3) DEFAULT NULL,
  `Defense` int(3) DEFAULT NULL,
  `SpecialDefense` int(3) DEFAULT NULL,
  `Speed` int(3) DEFAULT NULL,
  `Stamina` int(3) DEFAULT NULL,
  `Type1` varchar(15) DEFAULT NULL,
  `Type2` varchar(15) DEFAULT NULL,
  `State` varchar(15) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `experience` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pokedex`
--

INSERT INTO `pokedex` (`Name`, `ID_Pokedex`, `Image`, `Image_Back`, `HP`, `Level`, `AttackPower`, `SpecialAttack`, `Defense`, `SpecialDefense`, `Speed`, `Stamina`, `Type1`, `Type2`, `State`, `Sex`, `experience`) VALUES
('Bulbasaur', 1, 'doc/images/Bulbasaur.png', 'doc/images/spritesba', 145, 1, 49, 65, 49, 65, 45, 150, 'GRASS', 'POISON', 'ALIVE', 'M', 0),
('Ivysaur', 2, 'doc/images/Ivysaur.png', 'doc/images/spritesba', 145, 1, 39, 55, 42, 55, 45, 153, 'GRASS', 'POISON', 'ALIVE', 'M', 0),
('Venusaur', 3, 'doc/images/Venusaur.png', 'doc/images/spritesba', 180, 1, 83, 100, 83, 100, 80, 150, 'GRASS', 'POISON', 'ALIVE', 'F', 0),
('Charmander', 4, 'doc/images/Charmander.png', 'doc/images/spritesba', 139, 1, 52, 60, 43, 50, 65, 150, 'FIRE', 'NOTHING', 'ALIVE', 'F', 0),
('Charmaleon', 5, 'doc/images/Charmaleon.png', 'doc/images/spritesba', 150, 1, 65, 75, 32, 45, 48, 160, 'FIRE', 'NOTHING', 'ALIVE', 'M', 0),
('Charizard', 6, 'doc/images/Charizard.png', 'doc/images/spritesba', 160, 1, 75, 85, 42, 55, 80, 170, 'FIRE', 'FLYING', 'ALIVE', 'F', 0),
('Squirtle', 7, 'doc/images/Squirtle.png', 'doc/images/spritesba', 144, 1, 48, 50, 65, 64, 43, 150, 'WATER', 'NOTHING', 'ALIVE', 'F', 0),
('Wartortle', 8, 'doc/images/Wartortle.png', 'doc/images/spritesba', 140, 1, 45, 55, 32, 45, 58, 140, 'WATER', 'NOTHING', 'ALIVE', 'F', 0),
('Blastoise', 9, 'doc/images/Blastoise.png', 'doc/images/spritesba', 150, 1, 55, 65, 42, 55, 68, 150, 'WATER', 'NOTHING', 'ALIVE', 'M', 0),
('Caterpie', 10, 'doc/images/Caterpie.png', 'doc/images/spritesba', 100, 1, 25, 35, 22, 35, 38, 90, 'BUG', 'NOTHING', 'ALIVE', 'F', 0),
('Metapod', 11, 'doc/images/Metapod.png', 'doc/images/spritesba', 120, 1, 35, 45, 32, 45, 48, 100, 'BUG', 'NOTHING', 'ALIVE', 'M', 0),
('Butterfree', 12, 'doc/images/Butterfree.png', 'doc/images/spritesba', 125, 1, 20, 40, 25, 40, 40, 110, 'BUG', 'FLYING', 'ALIVE', 'F', 0),
('Weedle', 13, 'doc/images/Weedle.png', 'doc/images/spritesba', 130, 1, 20, 40, 25, 40, 40, 110, 'BUG', 'FLYING', 'ALIVE', 'F', 0),
('Kakuna', 14, 'doc/images/Kakuna.png', 'doc/images/spritesba', 150, 1, 40, 60, 50, 60, 50, 160, 'BUG', 'POISON', 'ALIVE', 'M', 0),
('Beedrill', 15, 'doc/images/Beedrill.png', 'doc/images/spritesba', 160, 1, 50, 70, 60, 70, 60, 170, 'BUG', 'POISON', 'ALIVE', 'M', 0),
('Pidgey', 16, 'doc/images/Pidgey.png', 'doc/images/spritesba', 130, 1, 30, 40, 45, 55, 55, 120, 'NORMAL', 'FLYING', 'ALIVE', 'F', 0),
('Pidgeotto', 17, 'doc/images/Pidgeotto.png', 'doc/images/spritesba', 140, 1, 40, 50, 55, 65, 65, 130, 'NORMAL', 'FLYING', 'ALIVE', 'M', 0),
('Pidgeot', 18, 'doc/images/Pidgeot.png', 'doc/images/spritesba', 150, 1, 50, 60, 65, 75, 75, 140, 'NORMAL', 'FLYING', 'ALIVE', 'M', 0),
('Rattata', 19, 'doc/images/Rattata.png', 'doc/images/spritesba', 100, 1, 30, 40, 35, 45, 45, 100, 'NORMAL', 'NOTHING', 'ALIVE', 'F', 0),
('Raticate', 20, 'doc/images/Raticate.png', 'doc/images/spritesba', 110, 1, 50, 60, 55, 65, 65, 120, 'NORMAL', 'NOTHING', 'ALIVE', 'F', 0),
('Spearow', 21, 'doc/images/Spearow.png', 'doc/images/spritesba', 100, 1, 30, 40, 35, 45, 45, 10, 'NORMAL', 'FLYING', 'ALIVE', 'M', 0),
('Fearow', 22, 'doc/images/Fearow.png', 'doc/images/spritesba', 120, 1, 60, 80, 70, 80, 90, 150, 'NORMAL', 'NOTHING', 'ALIVE', 'M', 0),
('Ekans', 23, 'doc/images/Ekans.png', 'doc/images/spritesba', 90, 1, 30, 40, 30, 40, 50, 100, 'POISON', 'NOTHING', 'ALIVE', 'M', 0),
('Arbok', 24, 'doc/images/Arbok.png', 'doc/images/spritesba', 110, 1, 50, 60, 50, 60, 70, 130, 'POISON', 'NOTHING', 'ALIVE', 'F', 0),
('Pikachu', 25, 'doc/images/Pikachu.png', 'doc/images/spritesba', 135, 1, 55, 50, 40, 50, 90, 150, 'ELECTRIC', 'NOTHING', 'ALIVE', 'F', 0),
('Raichu', 26, 'doc/images/Raichu.png', 'doc/images/spritesba', 130, 1, 70, 80, 60, 70, 90, 130, 'ELECTRIC', 'NOTHING', 'ALIVE', 'M', 0),
('Mankey', 56, 'doc/images/Mankey.png', 'doc/images/spritesba', 120, 1, 55, 65, 55, 65, 75, 150, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Primeape', 57, 'doc/images/Primeape.png', 'doc/images/spritesba', 130, 1, 65, 75, 65, 85, 80, 160, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Abra', 63, 'doc/images/Abra.png', 'doc/images/spritesba', 100, 1, 35, 45, 25, 35, 45, 100, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Kadabra', 64, 'doc/images/Kadabra.png', 'doc/images/spritesba', 110, 1, 45, 55, 35, 45, 55, 120, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Alakazam', 65, 'doc/images/Alakazam.png', 'doc/images/spritesba', 120, 1, 65, 75, 55, 65, 75, 150, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Machop', 66, 'doc/images/Machop.png', 'doc/images/spritesba', 100, 1, 30, 40, 30, 40, 50, 130, 'FIGHTING', 'NOTHING', 'ALIVE', 'M', 0),
('Machoke', 67, 'doc/images/Machoke.png', 'doc/images/spritesba', 120, 1, 50, 60, 40, 55, 60, 150, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Machamp', 68, 'doc/images/Machamp.png', 'doc/images/spritesba', 130, 1, 60, 70, 50, 65, 70, 170, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Chansey', 113, 'doc/images/Chansey.png', 'doc/images/spritesba', 100, 1, 30, 40, 30, 65, 70, 100, 'NORMAL', 'NOTHING', 'ALIVE', 'F', 0),
('Tangela', 114, 'doc/images/Tangela.png', 'doc/images/spritesba', 110, 1, 30, 40, 30, 65, 70, 100, 'GRASS', 'NOTHING', 'ALIVE', 'M', 0),
('Jynx', 124, 'doc/images/Jynx.png', 'doc/images/spritesba', 120, 1, 35, 45, 35, 70, 75, 110, 'ICE', 'PSYCHIC', 'ALIVE', 'F', 0),
('Magikarp', 129, 'doc/images/Magikarp.png', 'doc/images/spritesba', 100, 1, 30, 40, 30, 40, 50, 90, 'WATER', 'NOTHING', 'ALIVE', 'M', 0),
('Gyarados', 130, 'doc/images/Gyarados.png', 'doc/images/spritesba', 120, 1, 65, 85, 65, 90, 100, 140, 'WATER', 'FLYING', 'ALIVE', 'M', 0),
('Lapras', 131, 'doc/images/Lapras.png', 'doc/images/spritesba', 130, 1, 65, 85, 75, 80, 65, 140, 'WATER', 'ICE', 'ALIVE', 'F', 0),
('Aerodactyl', 142, 'doc/images/Aerodactyl.png', 'doc/images/spritesba', 140, 1, 75, 95, 85, 90, 85, 150, 'ROCK', 'FLYING', 'ALIVE', 'F', 0),
('Snorlax', 143, 'doc/images/Snorlax.png', 'doc/images/spritesba', 200, 1, 75, 85, 95, 100, 105, 170, 'NORMAL', 'NOTHING', 'ALIVE', 'M', 0),
('Articuno', 144, 'doc/images/Articuno.png', 'doc/images/spritesba', 150, 1, 95, 105, 80, 90, 105, 140, 'ICE', 'FLYING', 'ALIVE', 'M', 0),
('Zapdos', 145, 'doc/images/Zapdos.png', 'doc/images/spritesba', 150, 1, 95, 105, 80, 90, 105, 140, 'ELECTRIC', 'FLYING', 'ALIVE', 'M', 0),
('Moltres', 146, 'doc/images/Moltres.png', 'doc/images/spritesba', 140, 1, 100, 105, 80, 90, 105, 160, 'FIRE', 'FLYING', 'ALIVE', 'M', 0),
('Dratini', 147, 'doc/images/Dratini.png', 'doc/images/spritesba', 100, 1, 35, 45, 40, 50, 92, 90, 'DRAGON', 'NOTHING', 'ALIVE', 'F', 0),
('Dragonair', 148, 'doc/images/Dragonair.png', 'doc/images/spritesba', 120, 1, 65, 75, 70, 80, 112, 130, 'DRAGON', 'NOTHING', 'ALIVE', 'F', 0),
('Dragonite', 149, 'doc/images/Dragonite.png', 'doc/images/spritesba', 140, 1, 85, 95, 90, 100, 132, 150, 'DRAGON', 'FLYING', 'ALIVE', 'F', 0),
('Mewtwo', 150, 'doc/images/Mewtwo.png', 'doc/images/spritesba', 150, 1, 95, 105, 100, 110, 142, 160, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Mew', 151, 'doc/images/Mew.png', 'doc/images/spritesba', 100, 1, 55, 65, 50, 60, 82, 110, 'PSYCHIC', 'NOTHING', 'ALIVE', 'F', 0);

-- --------------------------------------------------------

--
-- Structure de la table `pokemon`
--

CREATE TABLE `pokemon` (
  `ID_Pokemon` int(3) NOT NULL,
  `ID_Pokedex` int(3) DEFAULT NULL,
  `ID_Objeto` int(3) DEFAULT NULL,
  `ID_Trainer` int(2) DEFAULT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `NickName` varchar(20) DEFAULT NULL,
  `HP` int(3) DEFAULT NULL,
  `Levl` int(3) DEFAULT NULL,
  `Attack_Power` int(3) DEFAULT NULL,
  `Fertility` int(1) DEFAULT NULL,
  `Special_Attack` int(3) DEFAULT NULL,
  `Special_Defense` int(3) DEFAULT NULL,
  `Defense` int(3) DEFAULT NULL,
  `Speed` int(3) DEFAULT NULL,
  `Stamina` int(3) DEFAULT NULL,
  `Type_1` varchar(20) DEFAULT NULL,
  `Type_2` varchar(20) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `Experience` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `pokemonmovement`
--

CREATE TABLE `pokemonmovement` (
  `ID_Pokemon` int(3) DEFAULT NULL,
  `ID_Movement` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `trainer`
--

CREATE TABLE `trainer` (
  `ID_Trainer` int(2) NOT NULL,
  `Name` varchar(25) DEFAULT NULL,
  `Passwrd` varchar(15) DEFAULT NULL,
  `Pokedollar` int(5) DEFAULT NULL,
  `Pokeball` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `mochila`
--
ALTER TABLE `mochila`
  ADD KEY `ID_Objeto` (`ID_Objeto`),
  ADD KEY `ID_Trainer` (`ID_Trainer`);

--
-- Index pour la table `movement`
--
ALTER TABLE `movement`
  ADD PRIMARY KEY (`ID_Movement`);

--
-- Index pour la table `objeto`
--
ALTER TABLE `objeto`
  ADD PRIMARY KEY (`ID_Objeto`),
  ADD KEY `tr_ID_Trainer_fk` (`ID_Trainer`);

--
-- Index pour la table `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`ID_Pokedex`);

--
-- Index pour la table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`ID_Pokemon`),
  ADD KEY `ID_POKEDEX_Pokedex_FK` (`ID_Pokedex`),
  ADD KEY `ID_OBJETO_Objeto_FK` (`ID_Objeto`),
  ADD KEY `ID_TRAINER_Trainer_FK` (`ID_Trainer`);

--
-- Index pour la table `pokemonmovement`
--
ALTER TABLE `pokemonmovement`
  ADD KEY `ID_Movement` (`ID_Movement`),
  ADD KEY `ID_Pokemon` (`ID_Pokemon`);

--
-- Index pour la table `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`ID_Trainer`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `objeto`
--
ALTER TABLE `objeto`
  ADD CONSTRAINT `tr_ID_Trainer_fk` FOREIGN KEY (`ID_Trainer`) REFERENCES `trainer` (`ID_Trainer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
