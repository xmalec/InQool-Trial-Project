INSERT INTO `courtsurface` (`id`,`name`, `pricePerMinute`) VALUES (1,'grass', '1.25');
INSERT INTO `courtsurface` (`id`,`name`, `pricePerMinute`) VALUES (2,'clay', '1');
INSERT INTO `courtsurface` (`id`,`name`, `pricePerMinute`) VALUES (3,'Artificial grass', '2');
INSERT INTO `court` (`id`,`courtSurface_id`, `courtNumber`) VALUES (1,'1', '1');
INSERT INTO `court` (`id`,`courtSurface_id`, `courtNumber`) VALUES (2,'1', '2');
INSERT INTO `court` (`id`,`courtSurface_id`, `courtNumber`) VALUES (3,'2', '3');
INSERT INTO `court` (`id`,`courtSurface_id`, `courtNumber`) VALUES (4,'3', '4');
INSERT INTO `client` (`id`, `name`, `phoneNumber`) VALUES ('1', 'Vladimír Čech', '775445665');
INSERT INTO `client` (`id`, `name`, `phoneNumber`) VALUES ('2', 'Zuzana Tichá', '775447221');
INSERT INTO `reservation` (`gameType`, `client_id`, `court_id`, `fromTime`, `price`, `toTime`) VALUES ('0', 1, 4, '2020-10-5 12:00', '120', '2020-10-5 13:00');


