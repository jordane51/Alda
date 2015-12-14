CREATE TABLE `alda`.`User` (
  `id` INT NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `dateInscription` DATE NOT NULL,
  PRIMARY KEY (`id`));