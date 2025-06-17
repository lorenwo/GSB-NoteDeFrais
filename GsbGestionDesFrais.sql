-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mer. 28 mai 2025 à 10:33
-- Version du serveur : 8.0.39-0ubuntu0.22.04.1
-- Version de PHP : 8.1.2-1ubuntu2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `GsbGestionDesFrais`
--

-- --------------------------------------------------------

--
-- Structure de la table `etat`
--

CREATE TABLE `etat` (
  `id_etat` bigint NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fiche_frais`
--

CREATE TABLE `fiche_frais` (
  `date_modif` date DEFAULT NULL,
  `montant_valide` double NOT NULL,
  `nb_justificatifs` int NOT NULL,
  `id_fiche_frais` bigint NOT NULL,
  `visiteur_id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `frais_forfait`
--

CREATE TABLE `frais_forfait` (
  `date` date NOT NULL,
  `kilometres` int DEFAULT NULL,
  `montant` double NOT NULL,
  `id_frais_forfait` bigint NOT NULL,
  `visiteur_id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type_frais` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `frais_forfait`
--

INSERT INTO `frais_forfait` (`date`, `kilometres`, `montant`, `id_frais_forfait`, `visiteur_id`, `description`, `type_frais`) VALUES
('2025-03-30', NULL, 20, 39, 1, '1', 'Repas midi'),
('2025-03-27', NULL, 120, 40, 1, '1', 'Relais étape'),
('2025-04-04', NULL, 80, 41, 1, '1', 'Nuitée'),
('2025-04-26', 2222222, 444444.4, 44, 1, 'aoa', 'Relais étape'),
('2025-04-10', NULL, 20, 45, 1, 'test 1', 'Repas midi'),
('2025-04-17', 12, 6, 47, 1, 'll', 'Kilométrage'),
('2025-04-18', NULL, 20, 48, 2, 'aaa', 'Repas midi'),
('2025-04-17', NULL, 20, 49, 1, 'modif', 'Repas midi'),
('2025-04-25', NULL, 80, 50, 1, 'test 1111', 'Nuitée'),
('2025-04-17', NULL, 99, 51, 1, 'facheux', 'Relais étape'),
('2025-04-26', 100, 20, 52, 1, 'kilometre', 'Kilométrage'),
('2025-04-10', NULL, 100, 54, 1, 'aaa', 'Nuitée'),
('2025-04-11', 20000, 4000, 55, 1, 'a', 'Kilométrage'),
('2025-04-09', 1000, 200, 56, 1, 'aaa', 'Kilométrage'),
('2025-04-04', NULL, 2, 57, 1, 'aaa', 'Repas midi'),
('2025-04-10', NULL, 24, 58, 1, 'aaa', 'Repas midi');

-- --------------------------------------------------------

--
-- Structure de la table `frais_hors_forfait`
--

CREATE TABLE `frais_hors_forfait` (
  `id` bigint NOT NULL,
  `date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `montant` double NOT NULL,
  `type_frais` varchar(255) NOT NULL,
  `visiteur_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `frais_hors_forfait`
--

INSERT INTO `frais_hors_forfait` (`id`, `date`, `description`, `montant`, `type_frais`, `visiteur_id`) VALUES
(2, '2025-04-17', 'aaa', 58, 'Repas midi', 1),
(4, '2025-04-23', 'aaaa', 27, 'Repas midi', 1),
(5, '2025-04-17', 'a', 300, 'Repas midi', 1);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_frais_forfait`
--

CREATE TABLE `ligne_frais_forfait` (
  `mois` date DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `id` bigint NOT NULL,
  `id_frais_forfait` bigint DEFAULT NULL,
  `visiteur_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_frais_hors_forfait`
--

CREATE TABLE `ligne_frais_hors_forfait` (
  `date` date DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `id_ligne_frais_hors_forfait` bigint NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

CREATE TABLE `visiteur` (
  `id` bigint NOT NULL,
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`id`, `login`, `mdp`) VALUES
(1, 'test', 'test'),
(2, 'kelian', 'goat'),
(3, 'Jack', 'test'),
(4, 'Joe', 'test'),
(6, 'keliane', '26079e41910bcde04be636fbeecc9045379882b5ad3fe7f70b762436c6d98055'),
(7, 'kilian', 'c61fdf555c7b1d09103b24840781bd212195c80ffa22cba5ac8062620b6f4ebf');

--
-- Déclencheurs `visiteur`
--
DELIMITER $$
CREATE TRIGGER `hash_mdp_before_insert` BEFORE INSERT ON `visiteur` FOR EACH ROW BEGIN
  SET NEW.mdp = SHA2(NEW.mdp, 256);
END
$$
DELIMITER ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etat`
--
ALTER TABLE `etat`
  ADD PRIMARY KEY (`id_etat`);

--
-- Index pour la table `fiche_frais`
--
ALTER TABLE `fiche_frais`
  ADD PRIMARY KEY (`id_fiche_frais`),
  ADD KEY `FK5e9hr76y22g1ptlhsgjceybv4` (`visiteur_id`);

--
-- Index pour la table `frais_forfait`
--
ALTER TABLE `frais_forfait`
  ADD PRIMARY KEY (`id_frais_forfait`),
  ADD KEY `FKqu5x2lmyqtbe00l4lbal2kgm0` (`visiteur_id`);

--
-- Index pour la table `frais_hors_forfait`
--
ALTER TABLE `frais_hors_forfait`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8ryjda36a4lg0tipi6lqxa38g` (`visiteur_id`);

--
-- Index pour la table `ligne_frais_forfait`
--
ALTER TABLE `ligne_frais_forfait`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf493ucudh2ccot91vypgo24kp` (`id_frais_forfait`),
  ADD KEY `FKlgk7s60dt92td3t0qq66qkdya` (`visiteur_id`);

--
-- Index pour la table `ligne_frais_hors_forfait`
--
ALTER TABLE `ligne_frais_hors_forfait`
  ADD PRIMARY KEY (`id_ligne_frais_hors_forfait`);

--
-- Index pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK548kmjx78maeewbn2y0jlc7gx` (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `etat`
--
ALTER TABLE `etat`
  MODIFY `id_etat` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `fiche_frais`
--
ALTER TABLE `fiche_frais`
  MODIFY `id_fiche_frais` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `frais_forfait`
--
ALTER TABLE `frais_forfait`
  MODIFY `id_frais_forfait` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT pour la table `frais_hors_forfait`
--
ALTER TABLE `frais_hors_forfait`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `ligne_frais_forfait`
--
ALTER TABLE `ligne_frais_forfait`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_frais_hors_forfait`
--
ALTER TABLE `ligne_frais_hors_forfait`
  MODIFY `id_ligne_frais_hors_forfait` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `visiteur`
--
ALTER TABLE `visiteur`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `fiche_frais`
--
ALTER TABLE `fiche_frais`
  ADD CONSTRAINT `FK5e9hr76y22g1ptlhsgjceybv4` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`);

--
-- Contraintes pour la table `frais_forfait`
--
ALTER TABLE `frais_forfait`
  ADD CONSTRAINT `FKqu5x2lmyqtbe00l4lbal2kgm0` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`);

--
-- Contraintes pour la table `frais_hors_forfait`
--
ALTER TABLE `frais_hors_forfait`
  ADD CONSTRAINT `FK8ryjda36a4lg0tipi6lqxa38g` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`);

--
-- Contraintes pour la table `ligne_frais_forfait`
--
ALTER TABLE `ligne_frais_forfait`
  ADD CONSTRAINT `FKf493ucudh2ccot91vypgo24kp` FOREIGN KEY (`id_frais_forfait`) REFERENCES `frais_forfait` (`id_frais_forfait`),
  ADD CONSTRAINT `FKlgk7s60dt92td3t0qq66qkdya` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
