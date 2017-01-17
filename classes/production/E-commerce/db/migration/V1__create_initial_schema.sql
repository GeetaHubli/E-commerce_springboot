CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(10) NOT NULL DEFAULT 0,
  `name` varchar(100) NOT NULL,
  `stocknumber` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT '5',
  `noofreviews` int(11) DEFAULT '0',
  `listprice` double NOT NULL DEFAULT '1',
  `percentagediscount` double DEFAULT NULL,
  `actualprice` double NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `restricted` tinyint(4) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `stocknumber_UNIQUE` (`stocknumber`)
)
