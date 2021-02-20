-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 20, 2021 at 05:25 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kotlin_basic`
--

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `deskripsi` varchar(10000) NOT NULL,
  `sarat` varchar(255) NOT NULL,
  `durasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id`, `nama`, `deskripsi`, `sarat`, `durasi`) VALUES
(1, 'Training Android Kotlin Basic', 'Training Android Kotlin Dasar/Android Basic Kotlin Training merupakan program belajar membuat aplikasi android dari dasar dengan menggunakan bahasa pemrograman Kotlin. Dengan kursus ini peserta akan membuat aplikasi android dengan mudah', '– Laptop baik  Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\nSoftware yang dibutuhkan  :\n* Android Studio (https://developer.android.com/studio/)\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 17:00, Setiap Senin s/d Kamis'),
(2, 'Training Android Kotlin Intermediate', 'Training Android Kotlin Lanjutan/Android Kotlin Intermediate Training merupakan program belajar membuat aplikasi android lanjutan dengan menggunakan bahasa pemrograman Kotlin. Dengan kursus ini peserta akan membuat aplikasi android dengan mudah.', '– Laptop baik  Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\nSoftware yang dibutuhkan  :\n* Android Studio (https://developer.android.com/studio/)\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 17:00, Setiap Senin s/d Kamis'),
(3, 'Training iOS Basic', 'Training iOS Dasar/iOS Basic Training merupakan program belajar membuat aplikasi iOS dari dasar. Peserta akan belajar membuat aplikasi iOS pertama mereka menggunakan Swift / XCode.', '– Memiliki Laptop Pribadi baik Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\n– Software yang dibutuhkan adalah\n* XCode\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 16:00. Terdapat 2 pilihan kelas:\n– Kelas Weekend (Sabtu dan Minggu)\n– Kelas Weekday (Senin s/d Kamis)'),
(4, 'Training Flutter Basic', 'Flutter adalah sebuah framework aplikasi mobil sumber terbuka yang diciptakan oleh Google. Flutter digunakan dalam pengembangan aplikasi untuk sistem operasi Android dan iOS, serta menjadi metode utama untuk membuat aplikasi Google Fuchsia.\n\nFlutter Basic  Training merupakan program belajar membuat aplikasi  yang bisa berjalan di aplikasi android dan ios sekaligus. Dengan kursus ini peserta akan dapat membuat aplikasi mobile dengan mudah. Training ini sangat cocok bagi pemula yang belum ada dasar programming sekalipun.', '– Laptop baik  Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\nSoftware yang dibutuhkan  :\n* Android Studio (https://developer.android.com/studio/)\n\n* Flutter\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 17:00, Setiap Senin s/d Kamis'),
(5, 'Training iOS Intermediate', 'Training iOS Lanjutan/iOS Intermediate Training merupakan program belajar membuat aplikasi iOS tingkat lanjutan. Peserta akan belajar membuat aplikasi iOS mereka menggunakan Swift / XCode.', '– Memiliki Laptop Pribadi baik Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\n– Software yang dibutuhkan adalah\n* XCode\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 16:00. Terdapat 2 pilihan kelas:\n– Kelas Weekend (Sabtu dan Minggu)\n– Kelas Weekday (Senin s/d Kamis)'),
(6, 'Training Flutter Intermediate', 'Flutter adalah sebuah framework aplikasi mobil sumber terbuka yang diciptakan oleh Google. Flutter digunakan dalam pengembangan aplikasi untuk sistem operasi Android dan iOS, serta menjadi metode utama untuk membuat aplikasi Google Fuchsia.\n\nFlutter Intermediate  Training merupakan program belajar membuat aplikasi  yang bisa berjalan di aplikasi android dan ios sekaligus. Dengan kursus ini peserta akan dapat membuat aplikasi mobile dengan mudah.', '– Laptop baik  Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\nSoftware yang dibutuhkan  :\n* Android Studio (https://developer.android.com/studio/)\n\n* Flutter\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 17:00, Setiap Senin s/d Kamis'),
(7, 'Training Android Java Intermediate', 'Training Android Java merupakan program belajar membuat aplikasi android lanjutan dengan menggunakan bahasa pemrograman Java. Dengan kursus ini peserta akan membuat aplikasi android dengan mudah.', '– Laptop baik Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\nSoftware yang dibutuhkan :\n* Android Studio (https://developer.android.com/studio/)\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 17:00, Setiap Senins/d Kamis.'),
(8, 'Training Java Apps Less Private', 'Android Java Apps Less Private Training merupakan program pelatihan pembuatan Aplikasi untuk mempermudah siswa menemukan guru private yang sesuai dengan mata pelajaran yang diinginkan, dan bisa langsung membooking guru untuk mengajar bidang yang mereka inginkan.', '– Laptop baik  Windows, Linux Ataupun Mac dengan RAM minimal 4GB.\nSoftware yang dibutuhkan  :\n* Android Studio (https://developer.android.com/studio/)\n* Big Nox App Player (https://id.bignox.com/)', '4 hari mulai jam 9:00 s/d 17:00, Setiap Senin s/d Kamis');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user_nama` varchar(255) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_hp` varchar(15) NOT NULL,
  `user_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_nama`, `user_email`, `user_hp`, `user_password`) VALUES
(1, 'Abd Wahid', 'wahid@wa.id', '087860501411', '6bf8416d67b6ecb5e9ee1a3535893965');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
