-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2018 at 02:23 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pjar`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--

CREATE TABLE `absensi` (
  `id` int(11) NOT NULL,
  `id_praktikan` int(11) NOT NULL,
  `praktikum` varchar(50) NOT NULL,
  `minggu1` enum('0','1') NOT NULL DEFAULT '0',
  `minggu2` enum('0','1') NOT NULL DEFAULT '0',
  `minggu3` enum('0','1') NOT NULL DEFAULT '0',
  `minggu4` enum('0','1') NOT NULL DEFAULT '0',
  `minggu5` enum('0','1') NOT NULL DEFAULT '0',
  `minggu6` enum('0','1') NOT NULL DEFAULT '0',
  `minggu7` enum('0','1') NOT NULL DEFAULT '0',
  `minggu8` enum('0','1') NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `asisten`
--

CREATE TABLE `asisten` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asisten`
--

INSERT INTO `asisten` (`id`, `nama`, `username`, `password`, `telepon`) VALUES
(1, 'Indra Suryaatmaja', 'indraarianggi', '1234', '085879690290'),
(2, 'Thomi Alghani', 'thomial', '1234', '081290870770'),
(3, 'Kartiko Pramudito', 'kartikopr', '1234', '087890834990'),
(4, 'Akmal Alfarisi', 'akmalfarisi', '1234', '081294595985');

-- --------------------------------------------------------

--
-- Table structure for table `matprak`
--

CREATE TABLE `matprak` (
  `id` int(11) NOT NULL,
  `praktikum` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matprak`
--

INSERT INTO `matprak` (`id`, `praktikum`) VALUES
(1, 'FPGA'),
(2, 'JKD'),
(3, 'JKL'),
(4, 'MCS');

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `id` int(11) NOT NULL,
  `id_praktikan` int(11) NOT NULL,
  `praktikum` varchar(50) NOT NULL,
  `nilai1` int(11) NOT NULL,
  `nilai2` int(11) NOT NULL,
  `nilai3` int(11) NOT NULL,
  `nilai4` int(11) NOT NULL,
  `nilai5` int(11) NOT NULL,
  `nilai6` int(11) NOT NULL,
  `nilai7` int(11) NOT NULL,
  `nilai8` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `praktikan`
--

CREATE TABLE `praktikan` (
  `id` int(11) NOT NULL,
  `npm` varchar(8) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `praktikan`
--

INSERT INTO `praktikan` (`id`, `npm`, `nama`, `kelas`, `telepon`) VALUES
(1, '55414290', 'Indra Arianggi', '4IA01', '085879690290'),
(2, '55278372', 'Thomi Alghani', '4IA01', '085672672662'),
(3, '55829283', 'Kartiko Pramudito', '4IA02', '087987656787'),
(4, '55646589', 'Akmal Alfarisi', '4IA03', '081898787767');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `asisten`
--
ALTER TABLE `asisten`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `matprak`
--
ALTER TABLE `matprak`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `praktikan`
--
ALTER TABLE `praktikan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absensi`
--
ALTER TABLE `absensi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `asisten`
--
ALTER TABLE `asisten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `matprak`
--
ALTER TABLE `matprak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `nilai`
--
ALTER TABLE `nilai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `praktikan`
--
ALTER TABLE `praktikan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
