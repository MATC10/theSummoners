-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2023 a las 16:49:50
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
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `ID_Pokemon` int(20) NOT NULL,
  `ID_Pokedex` int(3) DEFAULT NULL,
  `ID_Trainer` int(2) DEFAULT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `NickName` varchar(20) DEFAULT NULL,
  `HP` int(3) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  `AttackPower` int(11) DEFAULT NULL,
  `Fertility` int(1) DEFAULT NULL,
  `SpecialAttack` int(11) DEFAULT NULL,
  `SpecialDefense` int(11) DEFAULT NULL,
  `Defense` int(3) DEFAULT NULL,
  `Speed` int(3) DEFAULT NULL,
  `Stamina` int(3) DEFAULT NULL,
  `Type1` varchar(255) DEFAULT NULL,
  `Type2` varchar(255) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `Experience` int(3) DEFAULT NULL,
  `objeto` varchar(255) DEFAULT NULL,
  `equipoOpc` int(11) DEFAULT 2,
  `Image` varchar(255) DEFAULT NULL,
  `Image_Back` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokemon`
--

INSERT INTO `pokemon` (`ID_Pokemon`, `ID_Pokedex`, `ID_Trainer`, `Name`, `NickName`, `HP`, `Level`, `AttackPower`, `Fertility`, `SpecialAttack`, `SpecialDefense`, `Defense`, `Speed`, `Stamina`, `Type1`, `Type2`, `State`, `Sex`, `Experience`, `objeto`, `equipoOpc`, `Image`, `Image_Back`) VALUES
(10, 1, 1, 'Bulbasaur', NULL, 145, 1, 49, 5, 65, 65, 49, 45, 150, 'GRASS', 'POISON', 'ALIVE', 'M', 0, NULL, 1, 'doc/images/Bulbasaur.png', 'doc/images/spritesback/3a-b__001__xy.gif'),
(11, 1, 1, 'Bulbasaur', NULL, 145, 1, 49, 5, 65, 65, 49, 45, 150, 'GRASS', 'POISON', 'ALIVE', 'M', 0, NULL, 1, 'doc/images/Bulbasaur.png', 'doc/images/spritesback/3a-b__001__xy.gif');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`ID_Pokemon`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `ID_Pokemon` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
