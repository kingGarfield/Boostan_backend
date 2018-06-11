# test data

ALTER TABLE course CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE semester CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE student CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;

insert into course VALUES (0,"ریاضی عمومی 1","اختصاصی",3);
insert into course VALUES (1,"ریاضی عمومی 2","اختصاصی",3);
insert into course VALUES (2,"فیزیک 2","اختصاصی",3);
insert into course VALUES (3,"فیزیک 1","اختصاصی",3);
insert into course VALUES (4,"مبانی برنامه نویسی","اختصاصی",3);

INSERT INTO student VALUES (1,"سعادت آباد","1997-04-14 00:00:00","baghinajead@gmail.com","نمی دانم.","امیر حسسین","باقی نژاد",
                                "123121235","123456","+989120002280","2018-00-00 00:00:00","9421983");

INSERT INTO student VALUES (2,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","احمدی"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","knowitall");

INSERT INTO student VALUES (3,"صادقیه","1997-04-14 00:00:00","seyed.ali.hejazi.35@gmail.com","جعفر","سید علی","حجازی",
                                "123121235","123456","+989120002280","2018-00-00 00:00:00","9422743");


INSERT INTO semester VALUES (4,1,2,941,12,"قبول شده");

INSERT INTO semester VALUES (3,1,2,941,12,"قبول شده");

INSERT INTO semester VALUES (0,1,2,941,12,"قبول شده");