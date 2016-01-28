CREATE TABLE `alda`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(200) NOT NULL,
  `address` VARCHAR(200) NULL,
  `number` VARCHAR(45) NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL,
  `dateInscription` DATE NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `alda`.`Listing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` INT NOT NULL,
  `surface` INT NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NULL,
  `email` VARCHAR(200) NULL,
  `number` VARCHAR(45) NULL,
  `dateCreation` DATE NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`));