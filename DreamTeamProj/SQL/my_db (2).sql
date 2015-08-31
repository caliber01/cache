-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Сен 01 2015 г., 00:07
-- Версия сервера: 5.6.21
-- Версия PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `my_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `algdeps`
--

CREATE TABLE IF NOT EXISTS `algdeps` (
`dep_id` int(11) NOT NULL,
  `result_field` int(11) DEFAULT NULL,
  `formula` longtext
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `algdeps`
--

INSERT INTO `algdeps` (`dep_id`, `result_field`, `formula`) VALUES
(1, 1, 'X+Y'),
(2, 3, 'X-Y'),
(3, 2, 'X*Y');

-- --------------------------------------------------------

--
-- Структура таблицы `attribute`
--

CREATE TABLE IF NOT EXISTS `attribute` (
`attr_id` int(11) NOT NULL,
  `object_id` int(11) DEFAULT NULL,
  `Name` longtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `attribute`
--

INSERT INTO `attribute` (`attr_id`, `object_id`, `Name`) VALUES
(1, 1, 'А1О1'),
(2, 1, 'А2О1'),
(3, 2, 'А3О2'),
(4, 2, 'А4О2');

-- --------------------------------------------------------

--
-- Структура таблицы `depstosourfield`
--

CREATE TABLE IF NOT EXISTS `depstosourfield` (
  `dep_id` int(11) NOT NULL,
  `field_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `depstosourfield`
--

INSERT INTO `depstosourfield` (`dep_id`, `field_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `diagram`
--

CREATE TABLE IF NOT EXISTS `diagram` (
`diagram_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `Type` longtext COLLATE utf8_general_mysql500_ci,
  `JSON` longtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `diagram`
--

INSERT INTO `diagram` (`diagram_id`, `project_id`, `Type`, `JSON`) VALUES
(1, 0, 'ER', 'dsjhsdjfh'),
(2, 0, 'UC', 'DFSFS'),
(3, 0, 'OR', 'cx');

-- --------------------------------------------------------

--
-- Структура таблицы `document`
--

CREATE TABLE IF NOT EXISTS `document` (
`docment_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `Title` longtext COLLATE utf8_general_mysql500_ci,
  `Path` longtext COLLATE utf8_general_mysql500_ci,
  `ParentalProject` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `filter`
--

CREATE TABLE IF NOT EXISTS `filter` (
  `filter_id` int(11) DEFAULT NULL,
  `object_id` int(11) DEFAULT NULL,
  `attribute_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `filter`
--

INSERT INTO `filter` (`filter_id`, `object_id`, `attribute_id`) VALUES
(1, 3, 1),
(1, 1, 2),
(1, 1, 3),
(1, 2, 2),
(1, 1, 4),
(2, 1, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `group`
--

CREATE TABLE IF NOT EXISTS `group` (
`group_Id` int(11) NOT NULL,
  `Name` longtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `group`
--

INSERT INTO `group` (`group_Id`, `Name`) VALUES
(3, 'ПИ-13-1');

-- --------------------------------------------------------

--
-- Структура таблицы `object`
--

CREATE TABLE IF NOT EXISTS `object` (
`object_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `objectName` longtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `object`
--

INSERT INTO `object` (`object_id`, `project_id`, `objectName`) VALUES
(1, 0, 'МойОбъект'),
(2, 0, 'ВторойОбъект'),
(3, 0, 'ТретийОбъект');

-- --------------------------------------------------------

--
-- Структура таблицы `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `project_id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `Title` longtext COLLATE utf8_general_mysql500_ci,
  `IsReady` smallint(6) DEFAULT NULL,
  `IsSent` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `project`
--

INSERT INTO `project` (`project_id`, `student_id`, `Title`, `IsReady`, `IsSent`) VALUES
(0, 3, 'МойПроект', 0, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `report`
--

CREATE TABLE IF NOT EXISTS `report` (
`report_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `name` longtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `report`
--

INSERT INTO `report` (`report_id`, `project_id`, `name`) VALUES
(1, 0, 'Отчет1'),
(2, 0, 'Отчет2'),
(3, 0, 'Отчет3');

-- --------------------------------------------------------

--
-- Структура таблицы `reporttoobject`
--

CREATE TABLE IF NOT EXISTS `reporttoobject` (
  `object_id` int(11) DEFAULT NULL,
  `report_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `reporttoobject`
--

INSERT INTO `reporttoobject` (`object_id`, `report_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `search`
--

CREATE TABLE IF NOT EXISTS `search` (
  `search_id` int(11) DEFAULT NULL,
  `object_id` int(11) DEFAULT NULL,
  `attribute_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `search`
--

INSERT INTO `search` (`search_id`, `object_id`, `attribute_id`) VALUES
(1, 3, 1),
(1, 1, 2),
(1, 1, 3),
(1, 2, 2),
(1, 1, 4),
(2, 1, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `sort`
--

CREATE TABLE IF NOT EXISTS `sort` (
  `sort_id` int(11) DEFAULT NULL,
  `object_id` int(11) DEFAULT NULL,
  `attribute_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `sort`
--

INSERT INTO `sort` (`sort_id`, `object_id`, `attribute_id`) VALUES
(1, 3, 1),
(1, 1, 2),
(1, 1, 3),
(1, 2, 2),
(1, 1, 4),
(2, 1, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `sourcefield`
--

CREATE TABLE IF NOT EXISTS `sourcefield` (
`field_id` int(11) NOT NULL,
  `varName` longtext,
  `object_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `sourcefield`
--

INSERT INTO `sourcefield` (`field_id`, `varName`, `object_id`) VALUES
(1, 'X', 1),
(2, 'Y', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `statistic`
--

CREATE TABLE IF NOT EXISTS `statistic` (
`statistic_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `name` varchar(256) COLLATE utf8_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `statistic`
--

INSERT INTO `statistic` (`statistic_id`, `project_id`, `name`) VALUES
(1, 0, 'С1П0'),
(2, 0, 'С2П0');

-- --------------------------------------------------------

--
-- Структура таблицы `stattoobj`
--

CREATE TABLE IF NOT EXISTS `stattoobj` (
  `statistic_id` int(11) DEFAULT NULL,
  `object_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `stattoobj`
--

INSERT INTO `stattoobj` (`statistic_id`, `object_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `student`
--

CREATE TABLE IF NOT EXISTS `student` (
`student_id` int(11) NOT NULL,
  `group_Id` int(11) DEFAULT NULL,
  `Email` longtext COLLATE utf8_general_mysql500_ci,
  `Password` longtext COLLATE utf8_general_mysql500_ci,
  `FullName` longtext COLLATE utf8_general_mysql500_ci,
  `Abbr` longtext COLLATE utf8_general_mysql500_ci
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Дамп данных таблицы `student`
--

INSERT INTO `student` (`student_id`, `group_Id`, `Email`, `Password`, `FullName`, `Abbr`) VALUES
(3, 3, 'didevgen', '123', 'Ковалев', 'Ков');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `algdeps`
--
ALTER TABLE `algdeps`
 ADD PRIMARY KEY (`dep_id`), ADD KEY `mykey_idx` (`result_field`);

--
-- Индексы таблицы `attribute`
--
ALTER TABLE `attribute`
 ADD PRIMARY KEY (`attr_id`), ADD KEY `FK_ATTRIBUT_REFERENCE_OBJECT` (`object_id`);

--
-- Индексы таблицы `depstosourfield`
--
ALTER TABLE `depstosourfield`
 ADD KEY `dfsfsd_idx` (`field_id`), ADD KEY `cxxcv_idx` (`dep_id`);

--
-- Индексы таблицы `diagram`
--
ALTER TABLE `diagram`
 ADD PRIMARY KEY (`diagram_id`), ADD KEY `FK_DIAGRAM_REFERENCE_PROJECT` (`project_id`);

--
-- Индексы таблицы `document`
--
ALTER TABLE `document`
 ADD PRIMARY KEY (`docment_id`), ADD KEY `FK_DOCUMENT_REFERENCE_PROJECT` (`project_id`);

--
-- Индексы таблицы `filter`
--
ALTER TABLE `filter`
 ADD KEY `dsf_idx` (`attribute_id`), ADD KEY `cxv_idx` (`object_id`);

--
-- Индексы таблицы `group`
--
ALTER TABLE `group`
 ADD PRIMARY KEY (`group_Id`);

--
-- Индексы таблицы `object`
--
ALTER TABLE `object`
 ADD PRIMARY KEY (`object_id`), ADD KEY `FK_OBJECT_REFERENCE_PROJECT` (`project_id`);

--
-- Индексы таблицы `project`
--
ALTER TABLE `project`
 ADD PRIMARY KEY (`project_id`), ADD KEY `FK_PROJECT_REFERENCE_STUDENT` (`student_id`);

--
-- Индексы таблицы `report`
--
ALTER TABLE `report`
 ADD PRIMARY KEY (`report_id`), ADD KEY `FK_REPORT_REFERENCE_PROJECT` (`project_id`);

--
-- Индексы таблицы `reporttoobject`
--
ALTER TABLE `reporttoobject`
 ADD KEY `FK_REPORTTO_REFERENCE_OBJECT` (`object_id`), ADD KEY `FK_REPORTTO_REFERENCE_REPORT` (`report_id`);

--
-- Индексы таблицы `search`
--
ALTER TABLE `search`
 ADD KEY `fk1_idx` (`attribute_id`), ADD KEY `fk2_idx` (`object_id`);

--
-- Индексы таблицы `sort`
--
ALTER TABLE `sort`
 ADD KEY `fk1_idx` (`attribute_id`), ADD KEY `fk2_idx` (`object_id`);

--
-- Индексы таблицы `sourcefield`
--
ALTER TABLE `sourcefield`
 ADD PRIMARY KEY (`field_id`), ADD KEY `mkey_idx` (`object_id`);

--
-- Индексы таблицы `statistic`
--
ALTER TABLE `statistic`
 ADD PRIMARY KEY (`statistic_id`), ADD KEY `FK_STATISTI_REFERENCE_PROJECT` (`project_id`);

--
-- Индексы таблицы `stattoobj`
--
ALTER TABLE `stattoobj`
 ADD KEY `FK_STATTOOB_REFERENCE_STATISTI` (`statistic_id`), ADD KEY `FK_STATTOOB_REFERENCE_OBJECT` (`object_id`);

--
-- Индексы таблицы `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`student_id`), ADD KEY `FK_STUDENT_REFERENCE_GROUP` (`group_Id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `algdeps`
--
ALTER TABLE `algdeps`
MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `attribute`
--
ALTER TABLE `attribute`
MODIFY `attr_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `diagram`
--
ALTER TABLE `diagram`
MODIFY `diagram_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `document`
--
ALTER TABLE `document`
MODIFY `docment_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `group`
--
ALTER TABLE `group`
MODIFY `group_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `object`
--
ALTER TABLE `object`
MODIFY `object_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `report`
--
ALTER TABLE `report`
MODIFY `report_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `sourcefield`
--
ALTER TABLE `sourcefield`
MODIFY `field_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `statistic`
--
ALTER TABLE `statistic`
MODIFY `statistic_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `student`
--
ALTER TABLE `student`
MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `algdeps`
--
ALTER TABLE `algdeps`
ADD CONSTRAINT `mykey` FOREIGN KEY (`result_field`) REFERENCES `object` (`object_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `attribute`
--
ALTER TABLE `attribute`
ADD CONSTRAINT `FK_ATTRIBUT_REFERENCE_OBJECT` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `depstosourfield`
--
ALTER TABLE `depstosourfield`
ADD CONSTRAINT `cxxcv` FOREIGN KEY (`dep_id`) REFERENCES `algdeps` (`dep_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `dfsfsd` FOREIGN KEY (`field_id`) REFERENCES `sourcefield` (`field_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `diagram`
--
ALTER TABLE `diagram`
ADD CONSTRAINT `FK_DIAGRAM_REFERENCE_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `document`
--
ALTER TABLE `document`
ADD CONSTRAINT `FK_DOCUMENT_REFERENCE_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `filter`
--
ALTER TABLE `filter`
ADD CONSTRAINT `cxv` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `dsf` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `object`
--
ALTER TABLE `object`
ADD CONSTRAINT `FK_OBJECT_REFERENCE_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `project`
--
ALTER TABLE `project`
ADD CONSTRAINT `FK_PROJECT_REFERENCE_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `report`
--
ALTER TABLE `report`
ADD CONSTRAINT `FK_REPORT_REFERENCE_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `reporttoobject`
--
ALTER TABLE `reporttoobject`
ADD CONSTRAINT `FK_REPORTTO_REFERENCE_OBJECT` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_REPORTTO_REFERENCE_REPORT` FOREIGN KEY (`report_id`) REFERENCES `report` (`report_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `search`
--
ALTER TABLE `search`
ADD CONSTRAINT `fk1` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk2` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `sort`
--
ALTER TABLE `sort`
ADD CONSTRAINT `fk12` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk22` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `sourcefield`
--
ALTER TABLE `sourcefield`
ADD CONSTRAINT `mkey` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `statistic`
--
ALTER TABLE `statistic`
ADD CONSTRAINT `FK_STATISTI_REFERENCE_PROJECT` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `stattoobj`
--
ALTER TABLE `stattoobj`
ADD CONSTRAINT `FK_STATTOOB_REFERENCE_OBJECT` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_STATTOOB_REFERENCE_STATISTI` FOREIGN KEY (`statistic_id`) REFERENCES `statistic` (`statistic_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `student`
--
ALTER TABLE `student`
ADD CONSTRAINT `FK_STUDENT_REFERENCE_GROUP` FOREIGN KEY (`group_Id`) REFERENCES `group` (`group_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;