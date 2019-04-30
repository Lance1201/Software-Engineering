-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2019 at 06:37 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `softwareengine`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `u_id` int(3) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `fullname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`u_id`, `username`, `password`, `fullname`) VALUES
(1, 'marcus', '1234', 'Marcus Wong'),
(2, 'Lance', '12345', 'Lance Vance'),
(3, 'Lance2', '88888888', 'Lance Vance II'),
(4, 'Lance3', '11111111', 'Hi Hi'),
(5, 'shyamyn', 'happy123', 'shyamala'),
(6, 'Hello', '11111111', 'Hello World'),
(7, 'testing123', '11111111', 'Adam Jones'),
(8, 'norman123', '12345678', 'marcus wong');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `n_id` int(3) NOT NULL,
  `u_id` int(3) NOT NULL,
  `n_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`n_id`, `u_id`, `n_name`) VALUES
(1, 6, 'Do Assignment start now. 01:18:00'),
(2, 6, 'Do homework start now. 01:19:00'),
(3, 2, 'fdfsfsfs start now. 10:30:00'),
(4, 2, 'Assignment Besiifia start now. 11:30:00'),
(5, 2, 'Assignment awrweqe start now. 11:30:00'),
(6, 6, 'sadasdad start now. 14:00:00'),
(7, 6, 'dasdad start now. 15:00:00'),
(8, 8, 'sadasdasdasd start now. 13:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `s_id` int(3) NOT NULL,
  `u_id` int(3) NOT NULL,
  `s_name` varchar(20) NOT NULL,
  `s_date` date NOT NULL,
  `s_starttime` time NOT NULL,
  `s_endtime` time NOT NULL,
  `s_desc` varchar(50) DEFAULT 'no description',
  `share_id` int(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`s_id`, `u_id`, `s_name`, `s_date`, `s_starttime`, `s_endtime`, `s_desc`, `share_id`) VALUES
(1, 2, 'SE Meeting', '2019-03-30', '08:00:00', '18:00:00', 'do some meeting', 0),
(4, 2, 'SE meeting 2', '2019-04-02', '06:00:00', '17:00:00', '2nd meeting', 0),
(5, 2, 'SE meeting 3', '2019-04-03', '10:00:00', '13:00:00', 'se meeting 3', 0),
(12, 2, 'Testing', '2019-03-21', '17:00:00', '18:00:00', 'no description', 0),
(13, 2, 'Testing sql', '2019-03-12', '15:00:00', '17:00:00', 'testing comment', 0),
(15, 2, 'asfasdf', '2019-03-04', '01:30:00', '03:00:00', 'afasdfsda', 0),
(17, 2, 'Testing again', '2019-03-05', '00:00:00', '03:00:00', 'testing again', 0),
(18, 1, 'Marcus First Meeting', '2019-03-04', '01:00:00', '03:30:00', 'adasdasd', 0),
(19, 5, 'class', '2019-04-01', '09:00:00', '12:00:00', 'Class', 0),
(21, 1, 'SE Meeting', '2019-03-30', '08:00:00', '18:00:00', 'do some meeting', 2),
(22, 1, 'SE meeting 2', '2019-04-02', '06:00:00', '17:00:00', '2nd meeting', 2),
(23, 1, 'asfasdf', '2019-03-04', '01:30:00', '03:00:00', 'afasdfsda', 2),
(24, 2, 'Doing Assignment', '2019-04-21', '15:30:00', '20:30:00', 'Rushing Software Engineering Assignment', 0),
(25, 2, 'Eating Breakfast', '2019-04-21', '09:00:00', '10:30:00', 'Good Food', 0),
(26, 2, 'Today ', '2019-04-22', '05:30:00', '06:30:00', 'testa', 0),
(27, 2, 'Tiday 2', '2019-04-22', '19:00:00', '21:00:00', 'test', 0),
(28, 2, 'today3', '2019-04-22', '01:30:00', '09:30:00', 'what', 0),
(29, 1, 'today3', '2019-04-22', '01:30:00', '09:30:00', 'what', 2),
(30, 6, 'Tester', '2019-04-27', '00:32:00', '02:00:00', 'testing', 0),
(31, 6, 'Do Assignment', '2019-04-27', '01:18:00', '02:00:00', 'testing', 0),
(43, 6, 'Do homework', '2019-04-27', '01:19:00', '01:00:00', 'fsdfaffasfasfsad', 0),
(44, 2, 'fdfsfsfs', '2019-04-29', '10:30:00', '19:00:00', 'safassaf', 0),
(47, 7, 'Breakfast', '2019-04-30', '08:00:00', '09:00:00', 'Eating breakfast with family ', 0),
(48, 7, 'SE Class', '2019-04-30', '09:00:00', '12:00:00', 'Software Engineering Class in R103 ', 0),
(49, 7, 'Lunch', '2019-04-30', '12:00:00', '13:00:00', 'Lunch in canteen', 0),
(50, 7, 'Social Class', '2019-04-30', '13:00:00', '16:00:00', 'Class in 4th floor', 0),
(51, 7, 'Movie ', '2019-04-30', '17:00:00', '19:00:00', 'Movie with friends in Gurney', 0),
(52, 7, 'Dinner', '2019-04-30', '19:00:00', '20:00:00', 'Dinner with family', 0),
(53, 7, 'Doing Assignment', '2019-04-30', '20:00:00', '22:30:00', 'Doing the SE Assignment', 0),
(57, 6, 'ddSDAF', '2019-04-30', '12:00:00', '21:30:00', 'DASDASDA', 0),
(58, 6, 'dsadasdasda', '2019-04-30', '13:00:00', '21:00:00', 'sdsadasdad', 0),
(59, 6, 'sadasdad', '2019-04-30', '14:00:00', '19:00:00', 'sadasdada', 0),
(60, 6, 'dasdad', '2019-04-30', '15:00:00', '17:00:00', 'adsadasdas', 0),
(61, 8, 'PResentation', '2019-04-30', '10:00:00', '11:00:00', 'testingadasd', 0),
(62, 8, 'sadasdasdasd', '2019-04-30', '13:00:00', '17:30:00', 'testingadasd', 0),
(63, 2, 'PResentation', '2019-04-30', '10:00:00', '11:00:00', 'testingadasd', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`n_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `u_id` (`u_id`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `u_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `n_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `s_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `login` (`u_id`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `login` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
