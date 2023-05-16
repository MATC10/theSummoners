-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-05-2023 a las 23:07:13
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `thesummoners`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokedex`
--

CREATE TABLE `pokedex` (
  `Name` varchar(20) DEFAULT NULL,
  `ID_Pokedex` int(3) NOT NULL,
  `Image` varchar(50) DEFAULT NULL,
  `Image_Back` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokedex`
--

INSERT INTO `pokedex` (`Name`, `ID_Pokedex`, `Image`, `Image_Back`, `HP`, `Level`, `AttackPower`, `SpecialAttack`, `Defense`, `SpecialDefense`, `Speed`, `Stamina`, `Type1`, `Type2`, `State`, `Sex`, `experience`) VALUES
('Bulbasaur', 1, 'doc/images/Bulbasaur.png', 'doc/images/spritesback/3a-b__001__xy.gif', 145, 1, 49, 65, 49, 65, 45, 150, 'GRASS', 'POISON', 'ALIVE', 'M', 0),
('Ivysaur', 2, 'doc/images/Ivysaur.png', 'doc/images/spritesback/3a-b__002__xy.gif', 145, 1, 39, 55, 42, 55, 45, 153, 'GRASS', 'POISON', 'ALIVE', 'M', 0),
('Venusaur', 3, 'doc/images/Venusaur.png', 'doc/images/spritesback/3a-b__003__xy.gif', 180, 1, 83, 100, 83, 100, 80, 150, 'GRASS', 'POISON', 'ALIVE', 'F', 0),
('Charmander', 4, 'doc/images/Charmander.png', 'doc/images/spritesback/3a-b__004__xy.gif', 139, 1, 52, 60, 43, 50, 65, 150, 'FIRE', 'NOTHING', 'ALIVE', 'F', 0),
('Charmaleon', 5, 'doc/images/Charmaleon.png', 'doc/images/spritesback/3a-b__005__xy.gif', 150, 1, 65, 75, 32, 45, 48, 160, 'FIRE', 'NOTHING', 'ALIVE', 'M', 0),
('Charizard', 6, 'doc/images/Charizard.png', 'doc/images/spritesback/3a-b__006__xy.gif', 160, 1, 75, 85, 42, 55, 80, 170, 'FIRE', 'FLYING', 'ALIVE', 'F', 0),
('Squirtle', 7, 'doc/images/Squirtle.png', 'doc/images/spritesback/3a-b__007__xy.gif', 144, 1, 48, 50, 65, 64, 43, 150, 'WATER', 'NOTHING', 'ALIVE', 'F', 0),
('Wartortle', 8, 'doc/images/Wartortle.png', 'doc/images/spritesback/3a-b__008__xy.gif', 140, 1, 45, 55, 32, 45, 58, 140, 'WATER', 'NOTHING', 'ALIVE', 'F', 0),
('Blastoise', 9, 'doc/images/Blastoise.png', 'doc/images/spritesback/3a-b__009__xy.gif', 150, 1, 55, 65, 42, 55, 68, 150, 'WATER', 'NOTHING', 'ALIVE', 'M', 0),
('Caterpie', 10, 'doc/images/Caterpie.png', 'doc/images/spritesback/3a-b__010__xy.gif', 100, 1, 25, 35, 22, 35, 38, 90, 'BUG', 'NOTHING', 'ALIVE', 'F', 0),
('Metapod', 11, 'doc/images/Metapod.png', 'doc/images/spritesback/3a-b__011__xy.gif', 120, 1, 35, 45, 32, 45, 48, 100, 'BUG', 'NOTHING', 'ALIVE', 'M', 0),
('Butterfree', 12, 'doc/images/Butterfree.png', 'doc/images/spritesback/3a-b__012__xy.gif', 125, 1, 20, 40, 25, 40, 40, 110, 'BUG', 'FLYING', 'ALIVE', 'F', 0),
('Weedle', 13, 'doc/images/Weedle.png', 'doc/images/spritesback/3a-b__013__xy.gif', 130, 1, 20, 40, 25, 40, 40, 110, 'BUG', 'FLYING', 'ALIVE', 'F', 0),
('Kakuna', 14, 'doc/images/Kakuna.png', 'doc/images/spritesback/3a-b__014__xy.gif', 150, 1, 40, 60, 50, 60, 50, 160, 'BUG', 'POISON', 'ALIVE', 'M', 0),
('Beedrill', 15, 'doc/images/Beedrill.png', 'doc/images/spritesback/3a-b__015__xy.gif', 160, 1, 50, 70, 60, 70, 60, 170, 'BUG', 'POISON', 'ALIVE', 'M', 0),
('Pidgey', 16, 'doc/images/Pidgey.png', 'doc/images/spritesback/3a-b__016__xy.gif', 130, 1, 30, 40, 45, 55, 55, 120, 'NORMAL', 'FLYING', 'ALIVE', 'F', 0),
('Pidgeotto', 17, 'doc/images/Pidgeotto.png', 'doc/images/spritesback/3a-b__017__xy.gif', 140, 1, 40, 50, 55, 65, 65, 130, 'NORMAL', 'FLYING', 'ALIVE', 'M', 0),
('Pidgeot', 18, 'doc/images/Pidgeot.png', 'doc/images/spritesback/3a-b__018__xy.gif', 150, 1, 50, 60, 65, 75, 75, 140, 'NORMAL', 'FLYING', 'ALIVE', 'M', 0),
('Rattata', 19, 'doc/images/Rattata.png', 'doc/images/spritesback/3a-b__019__xy.gif', 100, 1, 30, 40, 35, 45, 45, 100, 'NORMAL', 'NOTHING', 'ALIVE', 'F', 0),
('Raticate', 20, 'doc/images/Raticate.png', 'doc/images/spritesback/3a-b__020__xy.gif', 110, 1, 50, 60, 55, 65, 65, 120, 'NORMAL', 'NOTHING', 'ALIVE', 'F', 0),
('Spearow', 21, 'doc/images/Spearow.png', 'doc/images/spritesback/3a-b__021__xy.gif', 100, 1, 30, 40, 35, 45, 45, 100, 'NORMAL', 'FLYING', 'ALIVE', 'M', 0),
('Fearow', 22, 'doc/images/Fearow.png', 'doc/images/spritesback/3a-b__022__xy.gif', 120, 1, 60, 80, 70, 80, 90, 150, 'NORMAL', 'NOTHING', 'ALIVE', 'M', 0),
('Ekans', 23, 'doc/images/Ekans.png', 'doc/images/spritesback/3a-b__023__xy.gif', 90, 1, 30, 40, 30, 40, 50, 100, 'POISON', 'NOTHING', 'ALIVE', 'M', 0),
('Arbok', 24, 'doc/images/Arbok.png', 'doc/images/spritesback/3a-b__024__xy.gif', 110, 1, 50, 60, 50, 60, 70, 130, 'POISON', 'NOTHING', 'ALIVE', 'F', 0),
('Pikachu', 25, 'doc/images/Pikachu.png', 'doc/images/spritesback/3a-b__025__xy.gif', 135, 1, 55, 50, 40, 50, 90, 150, 'ELECTRIC', 'NOTHING', 'ALIVE', 'F', 0),
('Raichu', 26, 'doc/images/Raichu.png', 'doc/images/spritesback/3a-b__026__xy.gif', 130, 1, 70, 80, 60, 70, 90, 130, 'ELECTRIC', 'NOTHING', 'ALIVE', 'M', 0),
('Mankey', 56, 'doc/images/Mankey.png', 'doc/images/spritesback/3a-b__056__xy.gif', 120, 1, 55, 65, 55, 65, 75, 150, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Primeape', 57, 'doc/images/Primeape.png', 'doc/images/spritesback/3a-b__057__xy.gif', 130, 1, 65, 75, 65, 85, 80, 160, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Abra', 63, 'doc/images/Abra.png', 'doc/images/spritesback/3a-b__063__xy.gif', 100, 1, 35, 45, 25, 35, 45, 100, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Kadabra', 64, 'doc/images/Kadabra.png', 'doc/images/doc/images/spritesback/3a-b__064__xy.gif', 110, 1, 45, 55, 35, 45, 55, 120, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Alakazam', 65, 'doc/images/Alakazam.png', 'doc/images/spritesback/3a-b__065__xy.gif', 120, 1, 65, 75, 55, 65, 75, 150, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Machop', 66, 'doc/images/Machop.png', 'doc/images/spritesback/3a-b__066__xy.gif', 100, 1, 30, 40, 30, 40, 50, 130, 'FIGHTING', 'NOTHING', 'ALIVE', 'M', 0),
('Machoke', 67, 'doc/images/Machoke.png', 'doc/images/spritesback/3a-b__067__xy.gif', 120, 1, 50, 60, 40, 55, 60, 150, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Machamp', 68, 'doc/images/Machamp.png', 'doc/images/spritesback/3a-b__068__xy.gif', 130, 1, 60, 70, 50, 65, 70, 170, 'FIGHTING', 'NOTHING', 'ALIVE', 'F', 0),
('Chansey', 113, 'doc/images/Chansey.png', 'doc/images/spritesback/3a-b__113__xy.gif', 100, 1, 30, 40, 30, 65, 70, 100, 'NORMAL', 'NOTHING', 'ALIVE', 'F', 0),
('Tangela', 114, 'doc/images/Tangela.png', 'doc/images/spritesback/3a-b__114__xy.gif', 110, 1, 30, 40, 30, 65, 70, 100, 'GRASS', 'NOTHING', 'ALIVE', 'M', 0),
('Jynx', 124, 'doc/images/Jynx.png', 'doc/images/spritesback/3a-b__124__xy.gif', 120, 1, 35, 45, 35, 70, 75, 110, 'ICE', 'PSYCHIC', 'ALIVE', 'F', 0),
('Magikarp', 129, 'doc/images/Magikarp.png', 'doc/images/spritesback/3a-b__129__xy.gif', 100, 1, 30, 40, 30, 40, 50, 90, 'WATER', 'NOTHING', 'ALIVE', 'M', 0),
('Gyarados', 130, 'doc/images/Gyarados.png', 'doc/images/spritesback/3a-b__130__xy.gif', 120, 1, 65, 85, 65, 90, 100, 140, 'WATER', 'FLYING', 'ALIVE', 'M', 0),
('Lapras', 131, 'doc/images/Lapras.png', 'doc/images/spritesback/3a-b__131__xy.gif', 130, 1, 65, 85, 75, 80, 65, 140, 'WATER', 'ICE', 'ALIVE', 'F', 0),
('Aerodactyl', 142, 'doc/images/Aerodactyl.png', 'doc/images/spritesback/3a-b__142__xy.gif', 140, 1, 75, 95, 85, 90, 85, 150, 'ROCK', 'FLYING', 'ALIVE', 'F', 0),
('Snorlax', 143, 'doc/images/Snorlax.png', 'doc/images/spritesback/3a-b__143__xy.gif', 200, 1, 75, 85, 95, 100, 105, 170, 'NORMAL', 'NOTHING', 'ALIVE', 'M', 0),
('Articuno', 144, 'doc/images/Articuno.png', 'doc/images/doc/images/spritesback/3a-b__144__xy.gif', 150, 1, 95, 105, 80, 90, 105, 140, 'ICE', 'FLYING', 'ALIVE', 'M', 0),
('Zapdos', 145, 'doc/images/Zapdos.png', 'doc/images/spritesback/3a-b__145__xy.gif', 150, 1, 95, 105, 80, 90, 105, 140, 'ELECTRIC', 'FLYING', 'ALIVE', 'M', 0),
('Moltres', 146, 'doc/images/Moltres.png', 'doc/images/spritesback/3a-b__146__xy.gif', 140, 1, 100, 105, 80, 90, 105, 160, 'FIRE', 'FLYING', 'ALIVE', 'M', 0),
('Dratini', 147, 'doc/images/Dratini.png', 'doc/images/spritesback/3a-b__147__xy.gif', 100, 1, 35, 45, 40, 50, 92, 90, 'DRAGON', 'NOTHING', 'ALIVE', 'F', 0),
('Dragonair', 148, 'doc/images/Dragonair.png', 'doc/images/spritesback/3a-b__148__xy.gif', 120, 1, 65, 75, 70, 80, 112, 130, 'DRAGON', 'NOTHING', 'ALIVE', 'F', 0),
('Dragonite', 149, 'doc/images/Dragonite.png', 'doc/images/spritesback/3a-b__149__xy.gif', 140, 1, 85, 95, 90, 100, 132, 150, 'DRAGON', 'FLYING', 'ALIVE', 'F', 0),
('Mewtwo', 150, 'doc/images/Mewtwo.png', 'doc/images/spritesback/3a-b__150__xy.gif', 150, 1, 95, 105, 100, 110, 142, 160, 'PSYCHIC', 'NOTHING', 'ALIVE', 'M', 0),
('Mew', 151, 'doc/images/Mew.png', 'doc/images/spritesback/3a-b__151__xy.gif', 100, 1, 55, 65, 50, 60, 82, 110, 'PSYCHIC', 'NOTHING', 'ALIVE', 'F', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`ID_Pokedex`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
