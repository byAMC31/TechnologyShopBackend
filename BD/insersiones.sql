USE technologyshop;

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `imagen`, `precio`, `categoria`) VALUES
(1, 'Mouse Gamer Logitech Óptico', 'Mouse ergonómico con sensor óptico avanzado, diseñado para gamers que buscan precisión y comodidad en largas sesiones de juego. Compatible con PC y Mac.', 'https://www.cyberpuerta.mx/img/product/XL/CP-LOGITECH-910-006137-b23958.jpg', 1599.99, 'Periféricos para computadoras'),
(2, 'Logitech Teclado Gamer G Pro', 'Teclado mecánico compacto con switches de alta precisión. Incluye iluminación RGB personalizable y diseño portátil ideal para torneos.', 'https://www.cyberpuerta.mx/img/product/XL/CP-LOGITECH-920-009388-2.jpg', 2800.00, 'Periféricos para computadoras'),
(3, 'Monitor Gamer ASUS TUF Gaming VG27AQL1A', 'Monitor de 27 pulgadas con resolución QHD, 170Hz de refresco y tecnología G-SYNC para una experiencia de juego fluida y sin interrupciones.', 'https://www.cyberpuerta.mx/img/product/XL/CP-AOC-24G4E-9c171e.png', 7499.00, 'Periféricos para computadoras'),
(4, 'Tarjeta Gráfica NVIDIA GeForce RTX 3060', 'Gráfica de alto rendimiento con tecnología de trazado de rayos en tiempo real y memoria GDDR6 de 12GB, perfecta para gaming y creación de contenido.', 'https://www.cyberpuerta.mx/img/product/XL/CP-ASUS-90YV06N2-M0NA00-2.jpg', 10299.99, 'Componentes para ensamblaje'),
(5, 'Procesador Intel Core i7-12700K', 'Procesador de 12 núcleos y 20 hilos con velocidades de hasta 5.0 GHz, ideal para gaming, productividad y multitarea intensiva.', 'https://m.media-amazon.com/images/I/51AqEkc2BuL.__AC_SX300_SY300_QL70_ML2_.jpg', 8899.00, 'Componentes para ensamblaje'),
(6, 'SSD Kingston NV1 1TB M.2 NVMe', 'Unidad de almacenamiento ultrarrápida con interfaz NVMe. Ofrece velocidades de lectura y escritura ideales para gaming y trabajo profesional.', 'https://http2.mlstatic.com/D_NQ_NP_886276-MLA79769239420_102024-O.webp', 1349.00, 'Componentes para ensamblaje'),
(7, 'Memoria RAM Corsair Vengeance LPX 16GB (2x8GB) DDR4', 'Kit de memoria RAM DDR4 de alto rendimiento con disipador de calor de perfil bajo. Ideal para overclocking y compatibilidad con sistemas compactos.', 'https://m.media-amazon.com/images/I/61wCOVcyvFL._AC_SY450_.jpg', 1599.00, 'Componentes para ensamblaje'),
(8, 'Fuente de Poder EVGA 600W 80 Plus White', 'Fuente de poder confiable con certificación 80 Plus White, que garantiza eficiencia energética y protección para tu sistema.', 'https://m.media-amazon.com/images/I/61JIZLFj3eL._AC_SY450_.jpg', 899.00, 'Componentes para ensamblaje'),
(9, 'Gabinete Gamer NZXT H510', 'Gabinete compacto con diseño minimalista, panel lateral de vidrio templado y excelente gestión de cables para un montaje limpio.', 'https://m.media-amazon.com/images/I/71eyFRpHS3L._AC_SY450_.jpg', 1799.00, 'Computadoras ensambladas'),
(10, 'Audífonos Gamer HyperX Cloud II', 'Audífonos de alta fidelidad con sonido envolvente 7.1, almohadillas de espuma viscoelástica y micrófono desmontable para comunicación clara.', 'https://m.media-amazon.com/images/I/71pz2njkNRL.__AC_SX300_SY300_QL70_ML2_.jpg', 1899.00, 'Periféricos para computadoras');

INSERT INTO `usuarios` (`id`, `nombre`, `telefono`, `email`, `password`, `tipo`) VALUES
(1, 'Erick Dominguez', '5576704979', 'erick_dominguez_santiago@outlook.es', 'FF3]FR77`QGa', 'cliente'),
(2, 'Mario Quiroga', '5549248532', 'marioeduardoquirogaber@gmail.com', '5>9}ZenoiYf1', 'administrador'),
(3, 'Adrian Martinez', '9514998080', 'adrianmtzcl@gmail.com', 'G9G=vg49C[5!', 'cliente'),
(4, 'Rodrigo Vera', '5518994781', 'rodverru@gmail.com', '3}t78!y4tUg1', 'cliente'), 
(5, 'Emanuel Elizalde', '5512664803', 'je.elizalde09@gmail.com', '3}t78!y4tUg1', 'cliente');