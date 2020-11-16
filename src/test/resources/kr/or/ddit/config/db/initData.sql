
SELECT *
FROM NOT_EXISTS_IN_PRD;


TRUNCATE TABLE attachment;
TRUNCATE TABLE board;
TRUNCATE TABLE board_gubun;
TRUNCATE TABLE reply;
TRUNCATE TABLE users;


Insert into ATTACHMENT (ATCH_SQ,ATCH_FILENAME,BOARD_SQ) values (1,'brown.png',5);
Insert into ATTACHMENT (ATCH_SQ,ATCH_FILENAME,BOARD_SQ) values (2,'cony.png',5);

Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (1,'자유게시판 첫번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','brown',null,1,1);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (2,'자유게시판 두번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n','brown',null,1,2);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (3,'자유게시판 세번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','cony',null,1,3);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (4,'자유게시판 네번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n','sally',null,1,4);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (5,'자유게시판 다섯번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','moon',null,1,5);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (6,'자유게시판 여섯번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','brown',1,1,1);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (7,'자유게시판 일곱번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','moon',2,1,2);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (8,'자유게시판 여덟번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n','brown',3,1,3);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (9,'자유게시판 아홉번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','brown',3,1,3);
Insert into BOARD (BOARD_SQ,BOARD_TITLE,BOARD_DATE,BOARD_YN,USERID,BOARD_P_SQ,GUBUN_SQ,GROUP_NO) values (10,'자유게시판 열번째 글제목입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y','brown',9,1,3);

Insert into BOARD_GUBUN (GUBUN_SQ,GUBUN_NM,GUBUN_YN) values (1,'자유게시판','y');
Insert into BOARD_GUBUN (GUBUN_SQ,GUBUN_NM,GUBUN_YN) values (2,'Q&A게시판','n');
Insert into BOARD_GUBUN (GUBUN_SQ,GUBUN_NM,GUBUN_YN) values (3,'공지게시판','n');

Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (1,'다섯번째글 첫번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n',5,'brown');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (2,'다섯번째글 두번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y',5,'sally');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (3,'다섯번째글 세번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n',5,'sally');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (4,'다섯번째글 네번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y',5,'moon');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (5,'다섯번째글 다섯번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n',5,'brown');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (6,'여덟번째글 첫번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'n',8,'brown');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (7,'여덟번째글 두번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y',8,'brown');
Insert into REPLY (REPLY_SQ,REPLY_CONTENT,REPLY_DATE,REPLY_YN,BOARD_SQ,USERID) values (8,'여덟번째글 세번째 댓글입니다.',to_date('2020-10-26','YYYY-MM-DD'),'y',8,'brown');

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('0019-01-28','YYYY-MM-DD'),'곰',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('0019-01-28','YYYY-MM-DD'),'토끼',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('0019-01-28','YYYY-MM-DD'),'병아리',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('0019-01-28','YYYY-MM-DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',null,'달',null,null,null,null,null);


COMMIT;