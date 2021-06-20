-- MySQL dump 10.13  Distrib 5.7.34, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: tennisDatabase
-- ------------------------------------------------------
-- Server version	5.7.34-0ubuntu0.18.04.1

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
-- Table structure for table `TennisAdmin`
--

DROP TABLE IF EXISTS `TennisAdmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TennisAdmin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TennisAdmin`
--

LOCK TABLES `TennisAdmin` WRITE;
/*!40000 ALTER TABLE `TennisAdmin` DISABLE KEYS */;
INSERT INTO `TennisAdmin` VALUES (1,'userName3','password3'),(2,'userName2','password2');
/*!40000 ALTER TABLE `TennisAdmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TennisCourt`
--

DROP TABLE IF EXISTS `TennisCourt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TennisCourt` (
  `courtID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`courtID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TennisCourt`
--

LOCK TABLES `TennisCourt` WRITE;
/*!40000 ALTER TABLE `TennisCourt` DISABLE KEYS */;
INSERT INTO `TennisCourt` VALUES (10,'court2'),(11,'courtName'),(12,'courtName2');
/*!40000 ALTER TABLE `TennisCourt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TennisPlayer`
--

DROP TABLE IF EXISTS `TennisPlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TennisPlayer` (
  `playerID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`playerID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TennisPlayer`
--

LOCK TABLES `TennisPlayer` WRITE;
/*!40000 ALTER TABLE `TennisPlayer` DISABLE KEYS */;
INSERT INTO `TennisPlayer` VALUES (4,'firstName1','lastName1','2018-12-10','email1',24),(5,'firstName1','lastName1','2018-12-10','email12',60);
/*!40000 ALTER TABLE `TennisPlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TennisReservation`
--

DROP TABLE IF EXISTS `TennisReservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TennisReservation` (
  `reservationID` int(11) NOT NULL AUTO_INCREMENT,
  `dateStart` datetime NOT NULL,
  `dateEnd` datetime NOT NULL,
  `courtID` int(11) DEFAULT NULL,
  `playerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservationID`),
  KEY `courtID` (`courtID`),
  KEY `playerID` (`playerID`),
  CONSTRAINT `TennisReservation_ibfk_1` FOREIGN KEY (`courtID`) REFERENCES `TennisCourt` (`courtID`),
  CONSTRAINT `TennisReservation_ibfk_2` FOREIGN KEY (`playerID`) REFERENCES `TennisPlayer` (`playerID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TennisReservation`
--

LOCK TABLES `TennisReservation` WRITE;
/*!40000 ALTER TABLE `TennisReservation` DISABLE KEYS */;
INSERT INTO `TennisReservation` VALUES (1,'2021-12-10 20:45:00','2021-12-10 21:45:00',10,4),(2,'2021-12-10 19:00:00','2021-12-10 20:00:00',10,4),(3,'2021-11-10 19:00:00','2021-11-10 20:00:00',10,4),(4,'2021-11-10 19:00:00','2021-11-10 20:00:00',10,4),(6,'2021-09-10 19:00:00','2021-09-10 21:00:00',10,4),(7,'2021-07-10 19:00:00','2021-07-10 21:00:00',10,4),(8,'2023-07-10 19:00:00','2023-07-10 21:00:00',10,4),(9,'2023-07-10 22:00:00','2023-07-10 23:00:00',10,4),(10,'2024-07-10 22:00:00','2024-07-10 23:00:00',10,4),(11,'2025-07-10 22:00:00','2025-07-10 23:00:00',10,4),(12,'2026-08-10 20:00:00','2026-08-10 21:00:00',10,4),(13,'2027-08-10 21:00:00','2027-08-10 22:00:00',10,4),(14,'2028-08-10 21:00:00','2028-08-10 22:00:00',10,4),(15,'2029-08-10 19:00:00','2029-08-10 20:00:00',10,5),(16,'2030-08-10 19:00:00','2030-08-10 20:00:00',10,5),(17,'2031-08-10 19:00:00','2031-08-10 20:00:00',10,5),(18,'2032-08-10 19:00:00','2032-08-10 20:00:00',10,5);
/*!40000 ALTER TABLE `TennisReservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-20 22:04:43
