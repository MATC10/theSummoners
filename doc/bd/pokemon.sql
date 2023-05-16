-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2023 a las 11:17:10
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
  `ID_Pokemon` int(11) NOT NULL,
  `ID_Pokedex` int(3) DEFAULT NULL,
  `ID_Trainer` int(2) DEFAULT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `NickName` varchar(20) DEFAULT NULL,
  `HP` int(3) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
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
  `Experience` int(3) DEFAULT NULL,
  `objeto` varchar(255) DEFAULT NULL,
  `equipoOpc` int(11) DEFAULT 2
) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`ID_Pokemon`),
  ADD KEY `ID_POKEDEX_Pokedex_FK` (`ID_Pokedex`),
  ADD KEY `ID_TRAINER_Trainer_FK` (`ID_Trainer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
