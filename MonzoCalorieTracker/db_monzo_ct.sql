-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_monzo_ct
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calorietracker`
--

DROP TABLE IF EXISTS `calorietracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calorietracker` (
  `codigoTracker` int(11) NOT NULL AUTO_INCREMENT,
  `budget` double NOT NULL,
  `totalCal` double NOT NULL,
  `ejercicio` double NOT NULL,
  `remaining` double NOT NULL,
  `time24h` date NOT NULL,
  `codigoP` int(11) NOT NULL,
  PRIMARY KEY (`codigoTracker`),
  KEY `codigoP` (`codigoP`),
  CONSTRAINT `calorietracker_ibfk_1` FOREIGN KEY (`codigoP`) REFERENCES `persona` (`codigoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calorietracker`
--

LOCK TABLES `calorietracker` WRITE;
/*!40000 ALTER TABLE `calorietracker` DISABLE KEYS */;
/*!40000 ALTER TABLE `calorietracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comida`
--

DROP TABLE IF EXISTS `comida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comida` (
  `codigoComida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `serving` varchar(50) NOT NULL,
  `servingSize` double NOT NULL,
  `calorias` double NOT NULL,
  `carbohidratos` double NOT NULL,
  `proteinas` double NOT NULL,
  `grasas` double NOT NULL,
  `sodio` double NOT NULL,
  `azucar` double NOT NULL,
  `codigoTracker` int(11) NOT NULL,
  PRIMARY KEY (`codigoComida`),
  KEY `codigoTracker` (`codigoTracker`),
  CONSTRAINT `comida_ibfk_1` FOREIGN KEY (`codigoTracker`) REFERENCES `calorietracker` (`codigoTracker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comida`
--

LOCK TABLES `comida` WRITE;
/*!40000 ALTER TABLE `comida` DISABLE KEYS */;
/*!40000 ALTER TABLE `comida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `codigoPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `objetivo` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `bmi` double NOT NULL,
  `bmr` double NOT NULL,
  PRIMARY KEY (`codigoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-03 21:59:12
