CREATE TABLE `alda`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NULL,
  `number` VARCHAR(255) NULL,
  `firstName` VARCHAR(255) NULL,
  `lastName` VARCHAR(255) NULL,
  `password` VARCHAR(255) NOT NULL,
  `birthday` DATE NULL,
  `dateInscription` DATE NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `alda`.`Listing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` INT NOT NULL,
  `surface` INT NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `number` VARCHAR(255) NULL,
  `dateCreation` DATE NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`));