CREATE DATABASE  IF NOT EXISTS `portailetudiant` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `portailetudiant`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: portailetudiant
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `contenu` varchar(200) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  `id_user_to` int(11) NOT NULL,
  `id_user_from` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avis`
--

DROP TABLE IF EXISTS `avis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_etudiant` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  `cote` tinyint(5) NOT NULL,
  `commentaire` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avis`
--

LOCK TABLES `avis` WRITE;
/*!40000 ALTER TABLE `avis` DISABLE KEYS */;
/*!40000 ALTER TABLE `avis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_matiere` int(11) NOT NULL,
  `plage_horaire` varchar(45) NOT NULL,
  `session` varchar(45) NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  `id_prof` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours_formation`
--

DROP TABLE IF EXISTS `cours_formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cours_formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cours` int(11) NOT NULL,
  `id_formation` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours_formation`
--

LOCK TABLES `cours_formation` WRITE;
/*!40000 ALTER TABLE `cours_formation` DISABLE KEYS */;
/*!40000 ALTER TABLE `cours_formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours_groupe`
--

DROP TABLE IF EXISTS `cours_groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cours_groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cours` int(11) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours_groupe`
--

LOCK TABLES `cours_groupe` WRITE;
/*!40000 ALTER TABLE `cours_groupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `cours_groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_permanent` varchar(12) NOT NULL,
  `is_international` tinyint(1) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant`
--

LOCK TABLES `etudiant` WRITE;
/*!40000 ALTER TABLE `etudiant` DISABLE KEYS */;
/*!40000 ALTER TABLE `etudiant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant_cours`
--

DROP TABLE IF EXISTS `etudiant_cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etudiant_cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_etudiant` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `absence` int(11) NOT NULL,
  `commentaires_prof` varchar(200) DEFAULT NULL,
  `is_complete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant_cours`
--

LOCK TABLES `etudiant_cours` WRITE;
/*!40000 ALTER TABLE `etudiant_cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `etudiant_cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant_formation`
--

DROP TABLE IF EXISTS `etudiant_formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etudiant_formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_etudiant` int(11) NOT NULL,
  `id_formation` int(11) NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  `is_complete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant_formation`
--

LOCK TABLES `etudiant_formation` WRITE;
/*!40000 ALTER TABLE `etudiant_formation` DISABLE KEYS */;
/*!40000 ALTER TABLE `etudiant_formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_etudiant` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `montant` double NOT NULL,
  `type_paiement` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

LOCK TABLES `facture` WRITE;
/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `duree` int(11) NOT NULL,
  `prix` double NOT NULL,
  `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation`
--

LOCK TABLES `formation` WRITE;
/*!40000 ALTER TABLE `formation` DISABLE KEYS */;
INSERT INTO `formation` VALUES (1,'Gestion de projets informatiques T.I.','Dans la gestion des projets informatiques, les compétences techniques sont primordiales mais insuffisantes pour maîtriser les tâches liées à la planification au suivi et au contrôle de toutes les composantes d’un projet informatique. Ce programme vise à combler ces lacunes.',1140,0,'2016-07-07 00:07:09'),(2,'Intégration de sites Web','Ce programme vise à former des spécialistes de l\'intégration de sites Web. Les langages : PHP, HTML, CSS, JavaScript',915,0,'2016-07-07 00:07:09'),(3,'Intégration de systèmes d\'information','Cette formation s\'adresse aux diplômés universitaires. En plus des technologies de programmation et de réseaux, l\'étudiant sera initié à l\'analyse et à la gestion de projets. Les langages de programmation les plus répandus dans l\'industrie des TI : Java, C, C++, C#, Transact-SQL, JavaScript, HTML, HTML5, ASP.NET, UML. Les technologies de réseautique : Windows, Linux, Cisco ...  ',1845,0,'2016-07-07 00:07:09'),(4,'Réseaux, sécurité et téléphonie IP','Cette formation a pour but de former des spécialistes en réseautique : Windows, Linux, Cisco, CheckPoint, VMware, Astérisk.',1275,0,'2016-07-07 00:07:09'),(5,'Programmation et technologies internet','Cette formation a pour objectif de former des programmeurs analystes spécialisés dans les technologies les plus utilisées des applications Web. Afin d\'assurer au finissant une plus grande latitude, il s\'initiera à l\'infographie et à l\'animation. Les langages de programmation : Java, C, C++, C#, Transact-SQL, JavaScript, HTML, HTML5, ASP.NET, UML.',1305,0,'2016-07-07 00:07:09'),(6,'Programmation, réseaux et télécommunications','Les langages de programmation les plus répandus dans l\'industrie des TI : Java, C, C++, C#, Transact-SQL, JavaScript, HTML, HTML5, ASP.NET, UML. Les technologies de réseautique : Windows, Linux, Cisco ...  ',1665,0,'2016-07-07 00:07:09');
/*!40000 ALTER TABLE `formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe`
--

LOCK TABLES `groupe` WRITE;
/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matiere` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no_cours` varchar(20) NOT NULL,
  `titre` varchar(200) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `duree` int(11) NOT NULL,
  `prix` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matiere`
--

LOCK TABLES `matiere` WRITE;
/*!40000 ALTER TABLE `matiere` DISABLE KEYS */;
INSERT INTO `matiere` VALUES (1,'P85-SU','Programmation web I (HTML5)','Créer la structure de pages Web à l\'aide du langage HTML, et les bonifier grâce aux feuilles de style (CSS).',60,0),(2,'420-P89-SU','Développement d\'applications transactionnelles II (JavaScript)',' Dynamiser les pages Web grâce au JavaScript, les animer et les rendre interactives par l\'ajout de script et utiliser des librairies telles que jQuery.',90,0),(3,'p00','Algorithme et programmation structurée (Algorithmie et C)',' Apprendre les concepts, les techniques et une méthodologie de programmation structurée avec le C.',60,0),(4,'p000','Base de données (Modélisation et langage SQL)',' S\'approprier les principes de modélisation des bases de données. Maîtriser le langage de programmation de bases de données',75,0),(5,'p63','Introduction à la programmation orientée objets (C++)','Apprendre les concepts de bases de la programmation orientée objets : classes, objets, héritage, polymorphisme, etc.',75,0),(6,'p0','Programmation orientée objets I (Java)','Aborder la programmation d\'application graphique et la gestion d\'événements, threads et communication socket.',60,0),(7,'p1','Programmation orientée objets II (Java avancé)',' Approfondir la connaissance de Java et maîtriser le développement côté serveur (J2EE, JSP, Servlet). Savoir appliquer une architecture MVC.',60,0),(8,'p01','Programmation orientée objets III (Java 3)','Se familiariser avec certains framework utilisant les technologies avancées du développement côté serveur tel la persistance avec IBATIS et le développement d\'interfaces utilisateurs avec JSF.',60,0),(9,'p02','Programmation dans un environnement graphique I (C#)','Évoluer dans l\'environnement des applications Windows standards avec C# afin de se familiariser avec l\'analyse de problèmes, les concepts et les termes de la programmation par événement.',75,0),(10,'p03','Applications interactives clientes (HTML5 Canvas)',' Concevoir et développer une application dans un environnement graphique.Découvrir les nouveautés d\'HTML5 et les nouvelles API JavaScript afin de créer des composants dynamiques riches : géolocalisation, Web Socket, Canvas, Web Storage, Web Database, etc. et Introduction à XML, XPATH et XSLT.',60,0),(11,'p04','Développement d\'applications pour mobiles I','Connaître les notions fondamentales et les particularités de la programmation pour appareils mobiles en général. Apprendre à développer des applications pour le système Android, comprendre les concepts propres à cet environnement et savoir exploiter les données, les services et les périphériques des appareils mobiles.',45,0),(12,'p05','Développement d\'applications pour mobiles II',' Approfondir et explorer les fonctionnalités avancées du système Android',45,0),(13,'p06','Projet final de programmation','Se familiariser avec une méthode d\'analyse et modélisation orientée objet, connaître la notation UML et savoir appliquer ses diagrammes. Créer une application web complète qui permettra d\'intégrer l\'ensemble des concepts vus.',90,0),(14,'p07','Système d’exploitation et fonctionnement interne (Windows 7)','Installer et configurer un système d\'exploitation client (Windows 7) pour une utilisation individuelle ou en réseau local poste à poste.',45,0),(15,'p08','Linux I (Système Linux)','Installer et administrer un poste de travail utilisant le système d\'exploitation GNU/Linux.',45,0),(16,'p09','Théorie des réseaux et principes de commutation en réseau (TCP/IP)','Étudier les différentes normes, topologies et modèles de réseaux, de câblage et d\'appareils de connectique. Installer et configurer un réseau TCP/IP avec des routeurs et les services réseau : DNS, DHCP, WINS, FTP, etc.',90,0),(17,'p10','Fonctions de commutation avancées (CISCO)',' Étudier et configurer les produits Cisco. RIP, IGRP, BGP, OSPF, VLAN, STP, VTP, ISL. Design de réseaux LAN et WAN.',45,0),(18,'p11','Linux II (Serveur Linux)','Installer, configurer et administrer, sur un serveur utilisant le système d\'exploitation GNU/Linux, différents types d\'applications ou de serveurs réseau (DNS, DHCP, FTP, NFS, NIS, APACHE, SAMBA, POSTFIX, SQUID, etc.).',60,0),(19,'p12','Serveur Microsoft I (Windows 2008)','Installer, configurer et administrer des serveurs Windows 2008 dans le cadre des réseaux Microsoft.',75,0),(20,'p13','Serveur Microsoft II (Windows 2012)','Installer, configurer et administrer un serveur 2012.',60,0),(23,'p14','Messagerie (MS-Exchange Server)','Installer, configurer et administrer le serveur de messagerie Microsoft Exchange Server.',60,0),(24,'p15','Sécurité des accès aux réseaux informatiques (Check Point)','Assurer la sécurité des accès aux réseaux par Check Point (accès sécurisé de l’externe et publication sécurisée des services de l’entreprise sur Internet).',60,0),(25,'p16','Stage de fin d\'études',' Consolider les notions acquises par une application concrète des concepts et des apprentissages en situation réelle.  Pratiquer le métier en étant en contact direct avec les clients et les utilisateurs. Budgets, délais et résolution de problèmes.',270,0),(26,'p17','Utilitaires graphiques (Photoshop)','Créer des images à l\'aide d\'outils informatiques tel Photoshop. Création d\'un site web avec Photoshop. ',45,0),(27,'p18','Programmation web (PHP - AJAX)',' S\'initier à la programmation Web et au principe du protocole HTTP.',60,0),(28,'p19','Programmation web III (HTML/CSS avancées, référencement et optimisation)','Apprendre des techniques HTML5 et CSS3 avancées afin d\'optimiser la compatibilité avec les navigateurs, le temps de production et les performances des pages Web. Maîtriser les notions et les concepts de visibilité, d\'accessibilité et de performance des sites Web. Apprendre à référencer adéquatement les sites Web (SEO).',75,0),(29,'p20','Modélisation UML et projet d\'analyse','Se familiariser avec une méthode d\'analyse et modélisation orientée objet, connaître la notation UML et savoir appliquer ses diagrammes.',45,0),(30,'p21','Linux III (Sécurité Linux)','Mettre en place, sur un serveur Linux, différents mécanismes de sécurité avancés tels que Iptables, SSH, Snort, Tripwire, VPN, ainsi que l\'utilisation d\'outils (Nessus, Nmap, Hping, etc).',60,0),(31,'p22','Administration de serveur de bases de données','Implanter, configurer, sécuriser, optimiser et administrer les serveurs de bases de données de type SQL Serveur.',45,0),(32,'p23','Sécurité des communications (Check Point)','Étude du Firewall/Proxy TMG de Microsoft : cache proxy, publication sécurisée des serveurs d\'entreprise (Web, DNS, SMTP/POP3), VPN, IPSEC, SSH, SSL, TLS, PGP, etc',45,0),(33,'p24','Sécurité informatique avancée','Se familiariser avec les concepts avancés d\'intrusions, de détections, d\'audits et de gestion de crises. Aborder de façon concrète la sécurité dans la défense contre la cyber-criminalité et le cyber-terrorisme.',45,0),(34,'p25','Virtualisation et utilitaires complémentaires (Sécurité des données)','S\'initier aux outils avancés d\'administration de réseaux tels: Ghost, Hyena, Damware , Acronis. Sharepoint.  Virtualisation des serveurs d\'une entreprise et déploiement de desktops virtuels (VDM) pour les utilisateurs. ',75,0),(35,'p26','Téléphonie IP (Asterisk)','Déployer une architecture de téléphonie IP ouverte, basée sur la solution libre Asterisk.',75,0),(36,'p27','Design d\'un réseau','Analyser un réseau désuet. Évaluer les nouveaux besoins. Proposer un design pour un nouveau réseau.',45,0),(37,'p28','Implantation de réseaux','Installer, configurer, documenter et sécuriser un réseau dans un environnement où l\'on retrouve à la fois les plateformes Microsoft et Linux ainsi que les serveurs de messagerie, de bases de données, de Web sécurisé, NAT, VPN, virtualisation, Ghost,…',75,0),(38,'p26','Développement d\'applications transactionnelles III (HTML)','Créer la structure de pages Web à l\'aide du langage HTML, bonifier leur présentation grâce aux feuilles de style (CSS).',45,0),(39,'p27','Programmation dans un environnement graphique II (ASP.NET MVC 4)','Utiliser la technologie ASP.NET MVC 4, pour créer des applications intranet/internet transactionnelles basées sur l\'accès aux bases de données (EF) et intégrant les technologies WEB API, le JavaScript, le XHTML et les feuilles de style (CSS).',75,0),(40,'p28','Gestion de projets informatiques','Réaliser le déploiement d\'un système d\'information complet.',75,0),(41,'p29','Projet programmation','Créer une application web complète qui permettra d’intégrer l’ensemble des concepts vus. Le développement s’effectuera selon des règles précises de gestion de projets et devra répondre aux paramètres définis pour que l’application puisse être mise en opération.',45,0),(42,'p27','Programmation web II (JavaScript)','Animer et rendre interactives des pages WEB créées en HTML, par l\'ajout de scripts JavaScript.',90,0),(43,'p29','Projet de fin d\'études',' Apprendre à utiliser un système de gestion de contenu (CMS) comme WordPress pour concevoir et mettre à jour dynamiquement différents types d\'applications web. Créer une application web complète qui permettra d\'intégrer l\'ensemble des concepts vus.',60,0),(44,'p30','Stage de fin d\'études','Consolider les notions acquises par une application concrète des concepts et des apprentissages en situation réelle. Pratiquer le métier en étant en contact direct avec les clients et les utilisateurs. Budgets, délais et résolution de problèmes. ',525,0),(45,'p31','Stage 1 : rapport partiel',' Intégrer un milieu de travail et participer activement aux réalisations, observer le gestionnaire de projets.',270,0),(46,'p32','Stage 2 : rapport final','Poursuivre dans la même entreprise et participer plus activement au processus de gestion de projets.',270,0),(47,'p33','Introduction à la gestion de projets',' Initier aux diverses étapes de la gestion de projets T.I., définir le rôle du gestionnaire et ses responsabilités, passer du rôle d’exécutant à gestionnaire.',45,0),(48,'p34','Planification en gestion de projets T.I.',' Développer le plan de gestion de projets, définir le cadre et le contexte de gestion de projets, aller à la cueillette des fonctionnalités et des contraintes, répartir le travail (WBS).',60,0),(49,'p35','Gestion des risques','Identifier les risques, analyser les risques qualitatifs et quantitatifs, effectuer un plan des réponses aux risques.',45,0),(50,'p36','Techniques de communication',' Identifier les intervenants internes et externes, élaborer un plan de communication avec les divers intervenants, choisir et établir les canaux de communication, communication dans un contexte de rencontre d’équipe et d’affaires, rédiger des rapports.',45,0),(51,'p37','Logiciels de gestion de projets',' S’approprier les logiciels de gestion de projets tels MS Project, Gira, Scrum.',45,0),(52,'p38','Ressources humaines dans un contexte de gestion de projets T.I.','Identifier les besoins en compétences et profils, faire le choix des bonnes ressources humaines, gérer des conflits, évaluer le rendement individuel de l’équipe.',45,0),(53,'p39','Outils et techniques de gestion de projets T.I.','Se familiariser avec les divers outils et méthodologies, tels Agile, WBS, développement en cascade par prototype, Test Driven development.',45,0),(54,'p40','Méthodologie en gestion de projets',' Identifier les cycles de développement, élaborer des méthodologies de développement informatiques et de déploiement d’infrastructures technologiques.',45,0),(55,'p41','Contrôle en gestion de projets','Contrôler la gestion des délais, des coûts, de la qualité et des approvisionnements.',60,0),(56,'p42','Projet d’intégration','Procéder à toutes les étapes du projet, encadrer l’équipe et gérer les communications internes et externes.',60,0),(57,'p43','Connaissance du marché du travail','Identifier les méthodes de recherche d’emploi, produire le cv, effectuer des simulations d’entrevues et participer à la Journée Carrière.',45,0);
/*!40000 ALTER TABLE `matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_from` int(11) NOT NULL,
  `id_to` int(11) NOT NULL,
  `message` varchar(100) NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_sujet` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nom` varchar(75) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `date_naissance` datetime NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `email` varchar(75) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `NAS` varchar(9) NOT NULL,
  `photo` varchar(200) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `titre` varchar(45) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne`
--

LOCK TABLES `personne` WRITE;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` VALUES (3,'steve','abc123','Mamadou','Cecile','1982-08-23 00:00:00','5140440555','test@mail.com','25 rue cremazie','555999333',NULL,2,NULL,0);
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prof`
--

DROP TABLE IF EXISTS `prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prof` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `competence` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prof`
--

LOCK TABLES `prof` WRITE;
/*!40000 ALTER TABLE `prof` DISABLE KEYS */;
/*!40000 ALTER TABLE `prof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rendez_vous`
--

DROP TABLE IF EXISTS `rendez_vous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rendez_vous` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_etudiant` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_rendezvous` datetime DEFAULT NULL,
  `heure` time DEFAULT NULL,
  `date_demande` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `object` varchar(200) NOT NULL,
  `is_confirmed` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rendez_vous`
--

LOCK TABLES `rendez_vous` WRITE;
/*!40000 ALTER TABLE `rendez_vous` DISABLE KEYS */;
/*!40000 ALTER TABLE `rendez_vous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sujet`
--

DROP TABLE IF EXISTS `sujet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sujet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(45) NOT NULL,
  `isResolu` tinyint(1) DEFAULT NULL,
  `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sujet`
--

LOCK TABLES `sujet` WRITE;
/*!40000 ALTER TABLE `sujet` DISABLE KEYS */;
/*!40000 ALTER TABLE `sujet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-10 21:06:02
