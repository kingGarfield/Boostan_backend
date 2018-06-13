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

INSERT INTO student VALUES (3,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","ملک"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","106");

INSERT INTO student VALUES (4,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","رودکی"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","100");

INSERT INTO student VALUES (5,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","مقیمی"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","101");

INSERT INTO student VALUES (6,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","صمدبور"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","102");

INSERT INTO student VALUES (7,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","ایزدی"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","103");

INSERT INTO student VALUES (8,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","منوچهری"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","104");

INSERT INTO student VALUES (9,"سید خندان","0000-00-00 00:00:00","ali@ahamadi.sh","اصغر","علی","کبیری"
  ,"000000000","123456","+9891111111","0000-00-00 00:00:00","105");


INSERT INTO semester VALUES (0,0,4,941,18.5,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (0,1,4,941,20,"قبول شده","اعلام شده");

INSERT INTO semester VALUES (0,2,4,941,19.5,"اعلام شده","قبول شده");


# #####

INSERT INTO semester VALUES (1,0,5,941,20,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (1,1,5,941,20,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (1,2,5,941,20,"اعلام شده","قبول شده");

# #####

INSERT INTO semester VALUES (2,0,6,941,18.25,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (2,1,6,941,19.25,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (2,2,6,941,20,"اعلام شده","قبول شده");

# #####

INSERT INTO semester VALUES (3,0,7,941,20,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (3,1,7,941,18,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (3,2,7,941,20,"اعلام شده","قبول شده");

# #####

INSERT INTO semester VALUES (4,0,8,941,19.5,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (4,1,8,941,15,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (4,2,8,941,19.5,"اعلام شده","قبول شده");

# #####

INSERT INTO semester VALUES (5,0,9,941,16.3,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (5,1,9,941,16.3,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (5,2,9,941,17.3,"اعلام شده","قبول شده");

# #####

INSERT INTO semester VALUES (6,0,3,941,18,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (6,1,3,941,19.5,"اعلام شده","قبول شده");

INSERT INTO semester VALUES (6,2,3,941,19,"اعلام شده","قبول شده");
