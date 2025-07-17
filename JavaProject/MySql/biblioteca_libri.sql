-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `libri`
--

DROP TABLE IF EXISTS `libri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libri` (
  `ISBN` bigint unsigned NOT NULL,
  `Titolo` varchar(50) NOT NULL,
  `Autore` varchar(50) NOT NULL,
  `AnnoPubblicazione` int unsigned NOT NULL,
  `Genere` varchar(50) NOT NULL,
  `Descrizione` blob NOT NULL,
  `NumeroCopie` int unsigned NOT NULL,
  PRIMARY KEY (`ISBN`),
  UNIQUE KEY `TITOLO_UNIQUE` (`Titolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libri`
--

LOCK TABLES `libri` WRITE;
/*!40000 ALTER TABLE `libri` DISABLE KEYS */;
INSERT INTO `libri` VALUES (9780061120084,'Il Grande Gatsby','F. Scott Fitzgerald',1925,'Classici',_binary 'La storia tragica di Jay Gatsby e il suo amore per Daisy Buchanan.',1),(9780743273565,'Il Codice Da Vinci','Dan Brown',2003,'Thriller',_binary 'Un professore di simbologia indaga su un omicidio al Louvre, scoprendo antichi segreti.',0),(9781408855931,'Harry Potter e la Pietra Filosofale','J.K. Rowling',1997,'Fantasy',_binary 'Le avventure di un giovane orfano che scopre di essere un mago e inizia la sua istruzione a Hogwarts.',1),(9788804674996,'Il Nome della Rosa','Umberto Eco',1980,'Romanzo Storico',_binary 'Un giallo medievale ambientato in un monastero benedettino.',2),(9788806239124,'Sapiens: Da animali a dèi','Yuval Noah Harari',2011,'Saggistica',_binary 'Una breve storia dell\'umanità che esplora come Homo Sapiens è arrivato a dominare il mondo.',1);
/*!40000 ALTER TABLE `libri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-15 22:01:39
