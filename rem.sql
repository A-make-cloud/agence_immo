-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 20 fév. 2022 à 20:46
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `rem`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` int(11) NOT NULL,
  `nom` varchar(55) DEFAULT NULL,
  `adresse` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id`, `nom`, `adresse`) VALUES
(1, 'Dupres', '10 rue de paris 75001 Paris'),
(2, 'Immo Louvre ', '15 rue du Louvre 75002 Paris'),
(3, 'Smart Immo', '5 rue ferre 93100 Montreuil'),
(5, 'immo paris', 'test test'),
(6, 'Immo ville', '1 rue du pres 75002 Paris'),
(7, 'Mon Agence Immo', '5 rue du commerce 75015 Paris'),
(8, '', ''),
(10, 'IMMO Discount', '76 rue Jaures 75019 Paris'),
(11, 'Immo im', '23 rue im 75006 Paris'),
(12, '21', 'VINGTet une'),
(13, 'IMMO foret', '12 rue du bois 92100  Boulogne'),
(14, 'testestestestetesteste', 'idem'),
(15, 'immobilier de Paris', '1 place de la Gare 75009 Paris'),
(16, 'Nivero', 'Damien'),
(17, 'Levin', 'Nicole'),
(18, 'Jervo', 'Remi'),
(19, 'tttttttttt', 'tttttttttttt'),
(20, 'jjjjjjjjjjjj', 'jjjjjjjjjjj'),
(21, 'KKKKKKKKKK', 'KKKKKKKKK'),
(22, 'vvvvvvvvv', 'vvvvvvv'),
(23, 'vvvvvvvvvvvvvvvvvv', 'vvvvvvvvvvvv'),
(24, 'XXXXXXXXXXXX', 'XXXXXXXXXX'),
(25, 'HHHHHHHH', 'HHHHHHHH'),
(26, 'IMMO rural', 'IMMO rural'),
(27, 'Immo test', '1 rue du marché 75009 Paris'),
(28, 'test', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `type` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `type`) VALUES
(1, 'Maison'),
(2, 'Appartement'),
(3, 'Studio'),
(4, 'Garage'),
(5, 'Box'),
(6, 'Entrepot'),
(8, 'Grenier'),
(9, 'Loft'),
(10, 'T2'),
(11, 'T3'),
(12, 'F1'),
(13, 'Parking'),
(14, 'Local'),
(15, 'Immeuble');

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `id` int(11) NOT NULL,
  `numero` int(20) NOT NULL,
  `dateC` date DEFAULT NULL,
  `id_Locataire` int(11) NOT NULL,
  `id_Proprietaire` int(11) NOT NULL,
  `id_Agence` int(11) NOT NULL,
  `id_Logement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`id`, `numero`, `dateC`, `id_Locataire`, `id_Proprietaire`, `id_Agence`, `id_Logement`) VALUES
(2, 12233, '2020-07-15', 1, 1, 1, 1),
(6, 4441, '2019-10-12', 1, 2, 1, 4),
(7, 55522, '2018-11-30', 1, 1, 1, 1),
(9, 33322, '2011-10-02', 2, 2, 5, 3),
(10, 899997, '2014-04-03', 2, 3, 2, 3),
(11, 333344, '2013-04-15', 4, 3, 2, 1),
(12, 777722, '2022-02-09', 2, 3, 1, 2),
(13, 8888833, '2018-09-26', 2, 3, 5, 6),
(14, 99922, '2017-02-24', 2, 2, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `nom` varchar(55) DEFAULT NULL,
  `prenom` varchar(55) NOT NULL,
  `dateE` date DEFAULT NULL,
  `id_Agence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `dateE`, `id_Agence`) VALUES
(1, 'Fer', 'Nico', '2022-02-10', 3),
(2, 'Prea', 'Ari', '2019-10-16', 3),
(3, 'Renault', 'Paul', '2010-05-20', 2),
(4, 'Nivero', 'Damien', '2017-09-30', 3),
(5, 'Lev', 'Nic', '2017-03-12', 5),
(6, 'Jer', 'Remon', '2016-09-11', 2),
(7, 'Jubert', 'swen', '2020-06-09', 2),
(8, 'Hamon', 'Elise', '2009-07-23', 3),
(9, 'Dup', 'Jea', '2010-11-20', 5),
(10, 'Talber', 'Jacques', '2013-12-20', 3);

-- --------------------------------------------------------

--
-- Structure de la table `litige`
--

CREATE TABLE `litige` (
  `id` int(11) NOT NULL,
  `motif` varchar(55) DEFAULT NULL,
  `numero` int(20) DEFAULT NULL,
  `dateL` date DEFAULT NULL,
  `id_Locataire` int(11) DEFAULT NULL,
  `id_Contrat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `litige`
--

INSERT INTO `litige` (`id`, `motif`, `numero`, `dateL`, `id_Locataire`, `id_Contrat`) VALUES
(1, 'bris de glace', 11234, '2020-10-20', 3, 6),
(2, 'Humidite', 11333, '2019-01-13', 1, 2),
(3, 'Tapage Nocturne', 333223, '2015-06-21', 1, 2),
(4, 'Boiserie gondolée', 44433, '2008-08-18', 2, 7),
(5, 'Peinture décollée', 55544, '2018-03-10', 3, 7);

-- --------------------------------------------------------

--
-- Structure de la table `locataire`
--

CREATE TABLE `locataire` (
  `id` int(11) NOT NULL,
  `nom` varchar(55) DEFAULT NULL,
  `prenom` varchar(55) DEFAULT NULL,
  `date_naissance` date NOT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `locataire`
--

INSERT INTO `locataire` (`id`, `nom`, `prenom`, `date_naissance`, `age`) VALUES
(1, 'Jubert', 'Aline', '2022-02-16', 24),
(2, 'Fereau', 'Henri', '2022-02-14', 65),
(3, 'Maninier', 'Annick', '2022-02-21', 49),
(4, 'Moreau', 'Lucas', '2022-02-27', 23),
(5, 'Lison', 'Charles', '2022-02-01', 29),
(6, 'vvvvvvv', 'bbbbbbbbb', '2022-02-18', 77),
(7, 'hhhhh', 'hhhhhhhh', '2022-02-18', 11),
(8, 'ddddddd', 'dddd', '2022-02-18', 14),
(9, 'FFF', 'FFFFFFFFFFFFF', '2022-02-18', 37),
(10, 'jjjjjjjjjjjj', 'jjjjjjjjjjjj', '2022-02-19', 57),
(11, 'Dumont', 'Kelly', '2022-02-20', 34);

-- --------------------------------------------------------

--
-- Structure de la table `logement`
--

CREATE TABLE `logement` (
  `id` int(11) NOT NULL,
  `ville` varchar(55) DEFAULT NULL,
  `prix` float NOT NULL,
  `taille` int(11) NOT NULL,
  `etage` int(11) NOT NULL,
  `id_Proprietaire` int(11) NOT NULL,
  `id_Categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `logement`
--

INSERT INTO `logement` (`id`, `ville`, `prix`, `taille`, `etage`, `id_Proprietaire`, `id_Categorie`) VALUES
(1, 'Bordeaux', 1100, 35, 5, 1, 2),
(2, 'Montreuil', 1100, 150, 1, 2, 1),
(3, 'Paris', 1300, 45, 3, 1, 2),
(4, 'Paris', 150, 12, 0, 2, 4),
(5, 'Paris', 15000, 400, 2, 2, 2),
(6, 'Paris', 1600, 60, 5, 2, 2),
(7, 'Paris', 1200, 50, 4, 2, 2),
(8, 'Anthony', 4000, 200, 0, 3, 3),
(9, 'Antony', 989, 48, 2, 6, 6),
(10, 'Montrouge', 2000, 200, 0, 2, 2),
(11, 'Paris', 3000, 127, 5, 3, 3),
(12, 'Neuilly', 4500, 69, 5, 5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(55) DEFAULT NULL,
  `prenom` varchar(55) DEFAULT NULL,
  `ville` varchar(55) DEFAULT NULL,
  `dateP` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `nom`, `prenom`, `ville`, `dateP`) VALUES
(1, 'Barreu', 'Carl', 'Neuilly', '2019-03-30'),
(2, 'Gerreau', 'Alain', 'Montreuil', '2016-07-20'),
(3, 'Lebrun', 'Benoit', 'Paris', '2012-12-09'),
(4, 'Nevert', 'Roberto', 'Paris', '2022-02-09'),
(5, 'bbbb', 'bbb', 'bb', '2010-01-01'),
(6, 'Bulet', 'Annie', 'Paris', '2017-05-20'),
(7, 'TEST', 'TEST', 'TEST', '2010-04-28'),
(8, 'VVERAN', 'Wera', 'Montreuil', '2016-03-29');

-- --------------------------------------------------------

--
-- Structure de la table `reparation`
--

CREATE TABLE `reparation` (
  `id` int(11) NOT NULL,
  `type` varchar(55) NOT NULL,
  `numero` int(11) NOT NULL,
  `prix` float NOT NULL,
  `dateR` date NOT NULL,
  `id_Litige` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reparation`
--

INSERT INTO `reparation` (`id`, `type`, `numero`, `prix`, `dateR`, `id_Litige`) VALUES
(2, 'bris de glace', 111223, 670, '2020-09-29', 1),
(3, 'fuite d\'eau', 22233, 500, '2014-06-12', 3),
(5, 'Peinture', 333344, 600, '2020-07-24', 2),
(6, 'Huisserie', 444223, 1300, '2011-04-06', 4);

-- --------------------------------------------------------

--
-- Structure de la table `technicien`
--

CREATE TABLE `technicien` (
  `id` int(11) NOT NULL,
  `nom` varchar(55) DEFAULT NULL,
  `prenom` varchar(55) DEFAULT NULL,
  `specialite` varchar(55) DEFAULT NULL,
  `id_Agence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `technicien`
--

INSERT INTO `technicien` (`id`, `nom`, `prenom`, `specialite`, `id_Agence`) VALUES
(1, 'Carron', 'Anne', 'Plomberie', 1),
(2, 'Gibeau', 'Daniel', 'Peinture', 2),
(4, 'Dupond', 'Paul', 'Menage', 5),
(5, 'Oliveri', 'Nicolas', 'Menage', 3),
(6, 'Frau', 'Elodie', 'Gardiennage', 2),
(7, 'This', 'Erika', 'Plomberie', 3),
(8, 'Gereven', 'Mathieu', 'Plomberie', 2),
(9, 'test2', 'ttttt', 'tttt', 5),
(10, 'test3', 'teste', 'testes', 2),
(11, 'Feret', 'Cibil', 'peintre', 2),
(12, 'Aven', 'Cyril', 'Electricite', 3);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `identifiant` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `identifiant`, `password`) VALUES
(2, 'Manu', 'man75'),
(3, 'Titou', 'ti123'),
(4, 'jose', 'jos75'),
(5, 'lena', 'le123'),
(7, 'Paul', 'paul123'),
(8, 'Agnès', 'agn75');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `contrat_fk0` (`id_Locataire`),
  ADD KEY `contrat_fk1` (`id_Proprietaire`),
  ADD KEY `contrat_fk2` (`id_Agence`),
  ADD KEY `contrat_fk3` (`id_Logement`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employe_fk0` (`id_Agence`);

--
-- Index pour la table `litige`
--
ALTER TABLE `litige`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `locataire`
--
ALTER TABLE `locataire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `logement`
--
ALTER TABLE `logement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `logement_fk0` (`id_Proprietaire`),
  ADD KEY `logement_fk1` (`id_Categorie`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reparation`
--
ALTER TABLE `reparation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `technicien`
--
ALTER TABLE `technicien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `technicien_fk0` (`id_Agence`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `litige`
--
ALTER TABLE `litige`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `locataire`
--
ALTER TABLE `locataire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `logement`
--
ALTER TABLE `logement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `reparation`
--
ALTER TABLE `reparation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `technicien`
--
ALTER TABLE `technicien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `contrat_fk0` FOREIGN KEY (`id_Locataire`) REFERENCES `locataire` (`id`),
  ADD CONSTRAINT `contrat_fk1` FOREIGN KEY (`id_Proprietaire`) REFERENCES `proprietaire` (`id`),
  ADD CONSTRAINT `contrat_fk2` FOREIGN KEY (`id_Agence`) REFERENCES `agence` (`id`),
  ADD CONSTRAINT `contrat_fk3` FOREIGN KEY (`id_Logement`) REFERENCES `logement` (`id`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `employe_fk0` FOREIGN KEY (`id_Agence`) REFERENCES `agence` (`id`);

--
-- Contraintes pour la table `logement`
--
ALTER TABLE `logement`
  ADD CONSTRAINT `logement_fk0` FOREIGN KEY (`id_Proprietaire`) REFERENCES `proprietaire` (`id`),
  ADD CONSTRAINT `logement_fk1` FOREIGN KEY (`id_Categorie`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `technicien`
--
ALTER TABLE `technicien`
  ADD CONSTRAINT `technicien_fk0` FOREIGN KEY (`id_Agence`) REFERENCES `agence` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
