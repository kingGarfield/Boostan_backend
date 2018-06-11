# test data

ALTER TABLE course CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE semester CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE student CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
ALTER TABLE available_courses CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;


insert into course VALUES (0,"مبانی کامپیوتر","1","اصلی",3);
insert into course VALUES (1,"کارگاه کامپیوتر","1","پایه",1);
insert into course VALUES (2,"فیزیک 1","1","پایه",3);
insert into course VALUES (3,"تاریخ اسلام","1","اختصاصی",2);
insert into course VALUES (4,"زبان فارسی","1","عمومی",2);
insert into course VALUES (5,"زبان خارجه","1","عمومی",3);
insert into course VALUES (6,"ریاضی عمومی 1","1","پایه",3);

# student data
INSERT INTO student VALUES (0,"سعادت آباد","1997-04-14 00:00:00","baghinajead@gmail.com","نمی دانم.","امیر حسسین","باقی نژاد",
                                "123121235","123456","+989120002280","2018-00-00 00:00:00","9421983");

INSERT INTO student VALUES (1,"خاک سفید","1997-04-14 00:00:00","dehghani@gmail.com","حسن","سجاد","دهقانی",
                                "123121235","123456","+989120002280","2018-00-00 00:00:00","9333333");

INSERT INTO student VALUES (2,"صادقیه","1997-04-14 00:00:00","seyed.ali.hejazi.35@gmail.com","جعفر","سید علی","حجازی",
                                "123121235","123456","+989120002280","2018-00-00 00:00:00","9444444");

INSERT INTO student VALUES (3,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","احمدی"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","knowitall");




INSERT INTO semester VALUES (0,0,3,941,18.5,"قبول شده");

INSERT INTO semester VALUES (0,1,3,941,20,"قبول شده");

INSERT INTO semester VALUES (0,2,3,941,19.5,"قبول شده");


# #####

INSERT INTO semester VALUES (1,0,3,941,20,"قبول شده");

INSERT INTO semester VALUES (1,1,3,941,20,"قبول شده");

INSERT INTO semester VALUES (1,2,3,941,20,"قبول شده");

# #####

INSERT INTO semester VALUES (2,0,3,941,18.25,"قبول شده");

INSERT INTO semester VALUES (2,1,3,941,19.25,"قبول شده");

INSERT INTO semester VALUES (2,2,3,941,20,"قبول شده");

# #####

INSERT INTO semester VALUES (3,0,3,941,20,"قبول شده");

INSERT INTO semester VALUES (3,1,3,941,18,"قبول شده");

INSERT INTO semester VALUES (3,2,3,941,20,"قبول شده");

# #####

INSERT INTO semester VALUES (4,0,3,941,19.5,"قبول شده");

INSERT INTO semester VALUES (4,1,3,941,15,"قبول شده");

INSERT INTO semester VALUES (4,2,3,941,19.5,"قبول شده");

# #####

INSERT INTO semester VALUES (5,0,3,941,16.3,"قبول شده");

INSERT INTO semester VALUES (5,1,3,941,16.3,"قبول شده");

INSERT INTO semester VALUES (5,2,3,941,17.3,"قبول شده");

# #####

INSERT INTO semester VALUES (6,0,3,941,18,"قبول شده");

INSERT INTO semester VALUES (6,1,3,941,19.5,"قبول شده");

INSERT INTO semester VALUES (6,2,3,941,19,"قبول شده");
