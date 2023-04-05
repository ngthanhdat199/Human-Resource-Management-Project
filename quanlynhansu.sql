-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2022 at 07:14 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlynhansu`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietktkl`
--

CREATE TABLE `chitietktkl` (
  `MaKTKL` varchar(255) NOT NULL,
  `MaNV` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietktkl`
--

INSERT INTO `chitietktkl` (`MaKTKL`, `MaNV`) VALUES
('KT01', '001'),
('KT02', '001'),
('KT02', '002'),
('KT03', '001');

-- --------------------------------------------------------

--
-- Table structure for table `chitietluong`
--

CREATE TABLE `chitietluong` (
  `MaLuong` varchar(255) NOT NULL,
  `MaNV` varchar(255) NOT NULL,
  `ThuongPhat` double NOT NULL DEFAULT 0,
  `HeSoLuong` double NOT NULL,
  `NgayLapBang` date NOT NULL,
  `NgaySuaDoi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietluong`
--

INSERT INTO `chitietluong` (`MaLuong`, `MaNV`, `ThuongPhat`, `HeSoLuong`, `NgayLapBang`, `NgaySuaDoi`) VALUES
('Luong01', '001', 20000, 1.5, '2022-04-01', '2022-04-01'),
('Luong01', '001', 50000, 1.5, '2022-05-21', '2022-05-21'),
('Luong01', '002', -50000, 1.5, '2022-05-21', '2022-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `MaCV` varchar(255) NOT NULL,
  `TenCV` varchar(255) DEFAULT NULL,
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hesoluong`
--

CREATE TABLE `hesoluong` (
  `MaHSL` varchar(255) NOT NULL,
  `HeSoLuong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `khenthuongkyluat`
--

CREATE TABLE `khenthuongkyluat` (
  `MaKTKL` varchar(255) NOT NULL,
  `SoTien` double DEFAULT NULL,
  `NgayQuyetDinh` date DEFAULT NULL,
  `LoaiQuyetDinh` varchar(255) DEFAULT NULL,
  `NoiDung` varchar(255) DEFAULT NULL,
  `NgaySuaDoi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khenthuongkyluat`
--

INSERT INTO `khenthuongkyluat` (`MaKTKL`, `SoTien`, `NgayQuyetDinh`, `LoaiQuyetDinh`, `NoiDung`, `NgaySuaDoi`) VALUES
('KT01', 100000, '2022-05-21', 'Thưởng', 'Giỏi', '2022-05-21'),
('KT02', -50000, '2022-05-21', 'Phạt', 'Trễ', '2022-05-21'),
('KT03', 20000, '2022-04-01', 'Thưởng', 'Thưởng tết', '2022-04-01');

-- --------------------------------------------------------

--
-- Table structure for table `luong`
--

CREATE TABLE `luong` (
  `MaLuong` varchar(255) NOT NULL,
  `LuongCB` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `luong`
--

INSERT INTO `luong` (`MaLuong`, `LuongCB`) VALUES
('Luong01', 5000000),
('Luong02', 4500000);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(255) NOT NULL,
  `HinhNV` varchar(255) DEFAULT NULL,
  `TenNV` varchar(255) DEFAULT NULL,
  `NgaySinh` varchar(255) DEFAULT NULL,
  `GioiTinh` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `SoCMND` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `MaPB` varchar(255) DEFAULT NULL,
  `MaCV` varchar(255) DEFAULT NULL,
  `MaTDHV` varchar(255) DEFAULT NULL,
  `MaHSL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HinhNV`, `TenNV`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SoCMND`, `SoDienThoai`, `Email`, `MaPB`, `MaCV`, `MaTDHV`, `MaHSL`) VALUES
('001', 'a', 'Hung', '2003-04-13', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('002', 'b', 'Hung', '2003-04-14', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('003', 'a', 'Hung', '2003-04-15', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('004', 'a', 'Hung', '2003-04-16', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('005', 'a', 'Hung', '2003-04-17', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('006', 'b', 'Hung', '2003-04-18', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('007', 'a', 'Hung', '2003-04-19', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('008', 'a', 'Hung', '2003-04-20', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('009', 'a', 'Hung', '2003-04-21', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('010', 'b', 'Hung', '2003-04-22', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('011', 'a', 'Hung', '2003-04-23', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('012', 'a', 'Hung', '2003-04-24', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('013', 'a', 'Hung', '2003-04-25', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('014', 'b', 'Hung', '2003-04-26', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('015', 'a', 'Hung', '2003-04-27', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('016', 'a', 'Hung', '2003-04-28', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('017', 'a', 'Hung', '2003-04-29', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('018', 'b', 'Hung', '2003-04-30', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('019', 'a', 'Hung', '2003-04-13', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('020', 'a', 'Hung', '2003-04-14', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('021', 'a', 'Hung', '2003-04-15', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('022', 'b', 'Hung', '2003-04-16', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('023', 'a', 'Hung', '2003-04-17', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('024', 'a', 'Hung', '2003-04-18', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('025', 'a', 'Hung', '2003-04-19', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('026', 'b', 'Hung', '2003-04-20', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('027', 'a', 'Hung', '2003-04-21', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('028', 'a', 'Hung', '2003-04-22', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('029', 'a', 'Hung', '2003-04-23', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('030', 'b', 'Hung', '2003-04-24', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('031', 'a', 'Hung', '2003-04-25', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('032', 'a', 'Hung', '2003-04-26', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('033', 'a', 'Hung', '2003-04-13', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('034', 'b', 'Hung', '2003-04-14', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('035', 'a', 'Hung', '2003-04-15', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('036', 'a', 'Hung', '2003-04-16', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('037', 'a', 'Hung', '2003-04-17', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('038', 'b', 'Hung', '2003-04-18', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('039', 'a', 'Hung', '2003-04-19', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('040', 'a', 'Hung', '2003-04-20', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('041', 'a', 'Hung', '2003-04-21', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('042', 'b', 'Hung', '2003-04-22', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('043', 'a', 'Hung', '2003-04-23', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('044', 'a', 'Hung', '2003-04-24', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL),
('045', 'a', 'Hung', '2003-04-25', 'Nam', 'Quan6', '125', '06423', 'aaa', NULL, NULL, NULL, NULL),
('046', 'b', 'Hung', '2003-04-21', 'Nữ', 'Quan1', '025', '0245', 'bbb', NULL, NULL, NULL, NULL),
('047', 'a', 'Hung', '2003-04-22', 'Nam', 'Quan8', '420', '0576', 'bbb', NULL, NULL, NULL, NULL),
('048', 'a', 'Hung', '2003-04-23', 'Nữ', 'Quan7', '147', '06474', 'bbb', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `phongban`
--

CREATE TABLE `phongban` (
  `MaPB` varchar(255) NOT NULL,
  `TenPB` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `trinhdohv`
--

CREATE TABLE `trinhdohv` (
  `MaTDHV` varchar(255) NOT NULL,
  `TenTDHV` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietktkl`
--
ALTER TABLE `chitietktkl`
  ADD PRIMARY KEY (`MaKTKL`,`MaNV`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `chitietluong`
--
ALTER TABLE `chitietluong`
  ADD PRIMARY KEY (`MaLuong`,`MaNV`,`NgayLapBang`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`MaCV`);

--
-- Indexes for table `hesoluong`
--
ALTER TABLE `hesoluong`
  ADD PRIMARY KEY (`MaHSL`);

--
-- Indexes for table `khenthuongkyluat`
--
ALTER TABLE `khenthuongkyluat`
  ADD PRIMARY KEY (`MaKTKL`);

--
-- Indexes for table `luong`
--
ALTER TABLE `luong`
  ADD PRIMARY KEY (`MaLuong`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `MaCV` (`MaCV`),
  ADD KEY `MaPB` (`MaPB`),
  ADD KEY `MaTDHV` (`MaTDHV`),
  ADD KEY `MaHSL` (`MaHSL`);

--
-- Indexes for table `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`MaPB`);

--
-- Indexes for table `trinhdohv`
--
ALTER TABLE `trinhdohv`
  ADD PRIMARY KEY (`MaTDHV`),
  ADD UNIQUE KEY `TenTDHV` (`TenTDHV`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietktkl`
--
ALTER TABLE `chitietktkl`
  ADD CONSTRAINT `chitietktkl_ibfk_1` FOREIGN KEY (`MaKTKL`) REFERENCES `khenthuongkyluat` (`MaKTKL`),
  ADD CONSTRAINT `chitietktkl_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Constraints for table `chitietluong`
--
ALTER TABLE `chitietluong`
  ADD CONSTRAINT `chitietluong_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `chitietluong_ibfk_2` FOREIGN KEY (`MaLuong`) REFERENCES `luong` (`MaLuong`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`MaCV`) REFERENCES `chucvu` (`MaCV`),
  ADD CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`MaPB`) REFERENCES `phongban` (`MaPB`),
  ADD CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`MaTDHV`) REFERENCES `trinhdohv` (`MaTDHV`),
  ADD CONSTRAINT `nhanvien_ibfk_4` FOREIGN KEY (`MaHSL`) REFERENCES `hesoluong` (`MaHSL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
