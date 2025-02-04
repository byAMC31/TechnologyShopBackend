-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tecnologyshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tecnologyshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tecnologyshop` DEFAULT CHARACTER SET utf8 ;
USE `tecnologyshop` ;

-- -----------------------------------------------------
-- Table `tecnologyshop`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `contraseña` VARCHAR(60) NOT NULL,
  `tipo` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tecnologyshop`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`productos` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `imagen` VARCHAR(30) NOT NULL,
  `precio` FLOAT(7,2) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE INDEX `id_producto_UNIQUE` (`id_producto` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tecnologyshop`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`compras` (
  `id_compra` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_compra`),
  UNIQUE INDEX `id_compra_UNIQUE` (`id_compra` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tecnologyshop`.`detalle_de_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`detalle_de_compra`
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
