CREATE DATABASE  IF NOT EXISTS `vademecum` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vademecum`;
-- MySQL dump 10.13  Distrib 5.7.12, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: vademecum
-- ------------------------------------------------------
-- Server version	5.7.15-0ubuntu0.16.04.1

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
-- Table structure for table `ANAG_IMPIANTI`
--

DROP TABLE IF EXISTS `ANAG_IMPIANTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ANAG_IMPIANTI` (
  `ID_IMPIANTO` int(11) NOT NULL,
  `DES_IMPIANTO` varchar(100) NOT NULL,
  `IND_IMPIANTO` varchar(100) DEFAULT NULL,
  `AMNT_STANZE` int(11) DEFAULT NULL,
  `AMNT_PORTE` int(11) DEFAULT NULL,
  `AMNT_FINESTRE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_IMPIANTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANAG_IMPIANTI`
--

LOCK TABLES `ANAG_IMPIANTI` WRITE;
/*!40000 ALTER TABLE `ANAG_IMPIANTI` DISABLE KEYS */;
INSERT INTO `ANAG_IMPIANTI` VALUES (23,'STABLIMENTO','VIA UGO 1',3,3,8),(27,'UFFICIO','VIA CAMPI',4,4,2);
/*!40000 ALTER TABLE `ANAG_IMPIANTI` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-30 19:12:36
