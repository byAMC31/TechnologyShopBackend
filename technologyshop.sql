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
CREATE SCHEMA IF NOT EXISTS `tecnologyshop` DEFAULT CHARACTER SET utf8mb3 ;
USE `tecnologyshop` ;

-- -----------------------------------------------------
-- Table `tecnologyshop`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`compras` (
  `id_compra` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_compra`),
  UNIQUE INDEX `id_compra_UNIQUE` (`id_compra` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `tecnologyshop`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`productos` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `imagen`  VARCHAR(500) NOT NULL,
  `precio` DECIMAL(6,2) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE INDEX `id_producto_UNIQUE` (`id_producto` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

ALTER TABLE `productos` MODIFY COLUMN `imagen` TEXT NOT NULL;
ALTER TABLE `productos` MODIFY COLUMN `precio` FLOAT(8,2) NOT NULL;
-- -----------------------------------------------------
-- Table `tecnologyshop`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tecnologyshop`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `contraseña` VARCHAR(60) NOT NULL,
  `tipo` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Mouse Gamer Logitech Óptico', 'Mouse ergonómico con sensor óptico avanzado, diseñado para gamers que buscan precisión y comodidad en largas sesiones de juego. Compatible con PC y Mac.', 'https://www.cyberpuerta.mx/img/product/XL/CP-LOGITECH-910-006137-b23958.jpg', '1599.99', 'periféricos');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Logitech Teclado Gamer G Pro', 'Teclado mecánico compacto con switches de alta precisión. Incluye iluminación RGB personalizable y diseño portátil ideal para torneos.', 'https://www.cyberpuerta.mx/img/product/XL/CP-LOGITECH-920-009388-2.jpg', '2800.00', 'periféricos');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Monitor Gamer ASUS TUF Gaming VG27AQL1A', 'Monitor de 27 pulgadas con resolución QHD, 170Hz de refresco y tecnología G-SYNC para una experiencia de juego fluida y sin interrupciones.', 'https://www.cyberpuerta.mx/img/product/XL/CP-AOC-24G4E-9c171e.png', '7499.00', 'periféricos');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Tarjeta Gráfica NVIDIA GeForce RTX 3060', 'Gráfica de alto rendimiento con tecnología de trazado de rayos en tiempo real y memoria GDDR6 de 12GB, perfecta para gaming y creación de contenido.', 'https://www.cyberpuerta.mx/img/product/XL/CP-ASUS-90YV06N2-M0NA00-2.jpg', '10299.99', 'componentes');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Procesador Intel Core i7-12700K', 'Procesador de 12 núcleos y 20 hilos con velocidades de hasta 5.0 GHz, ideal para gaming, productividad y multitarea intensiva.', 'https://m.media-amazon.com/images/I/51AqEkc2BuL.__AC_SX300_SY300_QL70_ML2_.jpg', '8899.00', 'componentes');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('SSD Kingston NV1 1TB M.2 NVMe', 'Unidad de almacenamiento ultrarrápida con interfaz NVMe. Ofrece velocidades de lectura y escritura ideales para gaming y trabajo profesional.', 'https://http2.mlstatic.com/D_NQ_NP_886276-MLA79769239420_102024-O.webp', '1349.00', 'componentes');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Memoria RAM Corsair Vengeance LPX 16GB (2x8GB) DDR4', 'Kit de memoria RAM DDR4 de alto rendimiento con disipador de calor de perfil bajo. Ideal para overclocking y compatibilidad con sistemas compactos.','https://m.media-amazon.com/images/I/61wCOVcyvFL._AC_SY450_.jpg', '1599.00', 'componentes');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Fuente de Poder EVGA 600W 80 Plus White', 'Fuente de poder confiable con certificación 80 Plus White, que garantiza eficiencia energética y protección para tu sistema.', 'https://m.media-amazon.com/images/I/61JIZLFj3eL._AC_SY450_.jpg', '899.00', 'componentes');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Gabinete Gamer NZXT H510', 'Gabinete compacto con diseño minimalista, panel lateral de vidrio templado y excelente gestión de cables para un montaje limpio.', 'https://m.media-amazon.com/images/I/71eyFRpHS3L._AC_SY450_.jpg', '1799.00', 'ensambladas');
INSERT INTO `productos` (`nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES ('Audífonos Gamer HyperX Cloud II', 'Audífonos de alta fidelidad con sonido envolvente 7.1, almohadillas de espuma viscoelástica y micrófono desmontable para comunicación clara.', 'https://m.media-amazon.com/images/I/71pz2njkNRL.__AC_SX300_SY300_QL70_ML2_.jpg', '1899.00', 'periféricos');


INSERT INTO `usuarios` (`nombre`, `telefono`, `email`, `contraseña`, `tipo`) VALUES ('Erick Dominguez', '5576704979', 'erick_dominguez_santiago@outlook.es', 'FF3]FR77QGa', 'cliente');
INSERT INTO `usuarios` (`nombre`, `telefono`, `email`, `contraseña`, `tipo`) VALUES ('Mario Quiroga', '5549248532', 'marioeduardoquirogaber@gmail.com', '5>9}ZenoiYf1', 'administrador');
INSERT INTO `usuarios` (`nombre`, `telefono`, `email`, `contraseña`, `tipo`) VALUES ('Adrian Martinez', '9514998080', 'adrianmtzcl@gmail.com', 'G9G=vg49C[5!', 'cliente');
INSERT INTO `usuarios` (`nombre`, `telefono`, `email`, `contraseña`, `tipo`) VALUES ('Rodrigo Vera', '5518994781', 'rodverru@gmail.com', '9Jz/4!r-l3>;', 'cliente');
INSERT INTO `usuarios` (`nombre`, `telefono`, `email`, `contraseña`, `tipo`) VALUES ('Emanuel Elizalde', '5512664803', 'je.elizalde09@gmail.com', '3}t78!y4tUg1', 'cliente');