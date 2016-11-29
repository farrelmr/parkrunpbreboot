--
-- PARKRUNCOURSE dataset
--
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (1, 'Inverness', 'http://www.parkrun.org.uk/inverness/', 1582);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (2, 'Aberdeen',	'http://www.parkrun.org.uk/aberdeen/', 1586);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (3, 'Dundee(Camperdown)', 'http://www.parkrun.org.uk/camperdown/', 1752);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (4, 'St Andrews', 'http://www.parkrun.org.uk/standrews/', 1669);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (5, 'Perth', 'http://www.parkrun.org.uk/perth/', 1620);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (6, 'Edinburgh', 'http://www.parkrun.org.uk/edinburgh/', 1523);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (7, 'Falkirk', 'http://www.parkrun.org.uk/falkirk/', 1612);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (8, 'Tollcross', 'http://www.parkrun.org.uk/tollcross/', 1623);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (9, 'Strathclyde', 'http://www.parkrun.org.uk/strathclyde/', 1586);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (10, 'Victoria',	'http://www.parkrun.org.uk/victoria/', 1526);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (11, 'Glasgow', 'http://www.parkrun.org.uk/glasgow/', 1585);
INSERT INTO PARKRUNCOURSE(PRCOURSE_ID, COURSENAME, URL, AVERAGETIME) VALUES (12, 'Eglington', 'http://www.parkrun.org.uk/eglinton/', 1681);
--
insert into custom_users (username, password, enabled) values ('customadmin', 'customadmin', true);
insert into custom_authorities (username, authority) values ('customadmin', 'ROLE_CUSTOM_ADMIN');
-- NoOpPasswordEncoder - pw - NoOpPasswordEncoder
insert into custom_users (username, password, enabled) values ('NoOpPasswordEncoder', 'NoOpPasswordEncoder', true);
insert into custom_authorities (username, authority) values ('NoOpPasswordEncoder', 'ROLE_CUSTOM_ADMIN');
-- StandardPasswordEncoder - pw - StandardPasswordEncoder
insert into custom_users (username, password, enabled) values ('StandardPasswordEncoder', 'c585256d114a65edf8e14e2c7ef73211a51d9a75e3717404e26e5e7a0f668e32b5bcb761e8987a31', true);
insert into custom_authorities (username, authority) values ('StandardPasswordEncoder', 'ROLE_CUSTOM_ADMIN');
-- BCryptPasswordEncoder - pw - BCryptPasswordEncoder
insert into custom_users (username, password, enabled) values ('BCryptPasswordEncoder', '$2a$10$sTEe7.f1Qo.Ma.A56ENI5ekBBW.NS5L1t.05xYaylxwj46O0cgMIm', true);
insert into custom_authorities (username, authority) values ('BCryptPasswordEncoder', 'ROLE_CUSTOM_ADMIN');
--