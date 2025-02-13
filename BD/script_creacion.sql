-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema technologyshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema technologyshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `technologyshop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `technologyshop` ;

-- -----------------------------------------------------
-- Table `technologyshop`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `technologyshop`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(255) NOT NULL,
  `tipo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `technologyshop`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `technologyshop`.`compras` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME(6) NOT NULL,
  `total` DOUBLE NOT NULL,
  `usuarioid` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKmporo12vxqribtvixs12kud1f` (`usuarioid` ASC) VISIBLE,
  CONSTRAINT `FKmporo12vxqribtvixs12kud1f`
    FOREIGN KEY (`usuarioid`)
    REFERENCES `technologyshop`.`usuarios` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `technologyshop`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `technologyshop`.`productos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `imagen` VARCHAR(255) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `technologyshop`.`detalle_de_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `technologyshop`.`detalle_de_compra` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `precio_unitario` DOUBLE NOT NULL,
  `compra_id` BIGINT NULL DEFAULT NULL,
  `producto_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKo7ih0kih30e4r1rbgy9k3scy1` (`compra_id` ASC) VISIBLE,
  INDEX `FK8j5e1ll7uw8g488ptif1sasgj` (`producto_id` ASC) VISIBLE,
  CONSTRAINT `FK8j5e1ll7uw8g488ptif1sasgj`
    FOREIGN KEY (`producto_id`)
    REFERENCES `technologyshop`.`productos` (`id`),
  CONSTRAINT `FKo7ih0kih30e4r1rbgy9k3scy1`
    FOREIGN KEY (`compra_id`)
    REFERENCES `technologyshop`.`compras` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
