-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-05-2025 a las 22:57:48
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ada`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestos`
--

CREATE TABLE `puestos` (
  `id` int(11) NOT NULL,
  `nombre_puesto` varchar(255) NOT NULL,
  `nombre_persona` varchar(255) NOT NULL,
  `nivel_jerarquico` int(11) NOT NULL,
  `puesto_superior_id` int(11) DEFAULT NULL,
  `posicion_x` double DEFAULT 0,
  `posicion_y` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `puestos`
--

INSERT INTO `puestos` (`id`, `nombre_puesto`, `nombre_persona`, `nivel_jerarquico`, `puesto_superior_id`, `posicion_x`, `posicion_y`) VALUES
(1, 'Dirección General', 'Juan Pérez García', 1, NULL, 0, 0),
(2, 'Coordinación Técnica', 'María González López', 2, 1, 0, 0),
(3, 'Dirección Corporativa de Operaciones', 'Carlos Rodríguez Martín', 2, 1, 0, 0),
(4, 'Dirección Corporativa de Comercialización', 'Ana Fernández Silva', 2, 1, 0, 0),
(5, 'Dirección Corporativa de Administración y Finanzas', 'Luis Sánchez Torres', 2, 1, 0, 0),
(6, 'Dirección Corporativa Jurídica y de Seguridad', 'Carmen Morales Vega', 2, 1, 0, 0),
(7, 'Oficina de Representación', 'Roberto Jiménez Cruz', 2, 1, 0, 0),
(8, 'Subdirección Corporativa de Control Financiero', 'Miguel Herrera Ruiz', 3, 5, 0, 0),
(9, 'Subdirección Corporativa de Recursos Humanos', 'Isabel Castro Méndez', 3, 5, 0, 0),
(10, 'Subdirección Corporativa Jurídica y de Seguridad', 'Fernando Ortega Díaz', 3, 6, 0, 0),
(11, 'Subdirección de la Oficina de Representación', 'Patricia Ramos Flores', 3, 7, 0, 0),
(12, 'Subdirección Corporativa de Producción', 'Eduardo Vargas Peña', 3, 3, 0, 0),
(13, 'Subdirección Corporativa de Programación y Control', 'Sofía Mendoza Aguilar', 3, 3, 0, 0),
(14, 'Subdirección de Museo Numismático Nacional', 'Diego Romero Santos', 3, 3, 0, 0),
(15, 'Subdirección Corporativa de Recursos Materiales', 'Alejandra Guerrero Luna', 3, 5, 0, 0),
(16, 'Gerencia de Acuñación Moneda de Curso Legal', 'Raúl Navarro Campos', 4, 12, 0, 0),
(17, 'Gerencia Fabricación de Troqueles y Herramentales', 'Beatriz Moreno Ríos', 4, 12, 0, 0),
(18, 'Gerencia de Metales Finos', 'Jorge Castillo Herrera', 4, 12, 0, 0),
(19, 'Gerencia de Mantenimiento', 'Lucía Delgado Vázquez', 4, 12, 0, 0),
(20, 'Gerencia de Control de Calidad', 'Roberto Garzia Juarez', 4, 13, 0, 0),
(21, 'Gerencia de Ingeniería', 'Andrés Peña Gutiérrez', 4, 12, 0, 0),
(22, 'Gerencia de Mercadotecnia y Comunicación', 'Claudia Reyes Morales', 4, 4, 0, 0),
(23, 'Gerencia de Ventas Directas', 'Sergio Muñoz Contreras', 4, 4, 0, 0),
(24, 'Gerencia de Ventas Institucionales', 'Mónica Espinoza Ramírez', 4, 4, 0, 0),
(25, 'Gerencia de Contabilidad', 'Pablo Aguilar Torres', 4, 8, 0, 0),
(26, 'Gerencia de Tesorería', 'Valeria Núñez Rivera', 4, 8, 0, 0),
(27, 'Gerencia de Presupuestos e Informes', 'Mauricio León Blanco', 4, 8, 0, 0),
(28, 'Gerencia de Personal', 'Gabriela Paredes Mejía', 4, 9, 0, 0),
(29, 'Gerencia de Relaciones Industriales', 'Arturo Salinas Ochoa', 4, 9, 0, 0),
(30, 'Gerencia de Adquisiciones y Obra Pública', 'Lorena Campos Durán', 4, 15, 0, 0),
(31, 'Gerencia de Almacenes y Servicios Grales.', 'Héctor Cordero Valle', 4, 15, 0, 0),
(32, 'Gerencia de lo Consultivo', 'Cristina Vera Palacios', 4, 10, 0, 0),
(33, 'Gerencia de Seguridad', 'Ricardo Medina Fuentes', 4, 10, 0, 0),
(34, 'Gerencia de Gestión Banco de México', 'Daniela Rojas Soto', 4, 10, 0, 0),
(35, 'Gerencia de lo Contencioso', 'Francisco Ibarra Molina', 4, 10, 0, 0),
(36, 'Gerencia 1 de la Oficina de Representación', 'Natalia Silva Acosta', 4, 11, 0, 0),
(37, 'Gerencia 2 de la Oficina de Representación', 'Tomás Guerrero Paz', 4, 11, 0, 0),
(38, 'Gerencia de Informática', 'Iván Morales Jiménez', 4, 1, 0, 0),
(39, 'Gerencia de Diseño, Escultura y Grabado', 'Marina Sandoval Cruz', 4, 1, 0, 0),
(40, 'Gerencia de Planeación', 'Octavio Herrera Luna', 4, 1, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `puesto_superior_id` (`puesto_superior_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD CONSTRAINT `puestos_ibfk_1` FOREIGN KEY (`puesto_superior_id`) REFERENCES `puestos` (`id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
