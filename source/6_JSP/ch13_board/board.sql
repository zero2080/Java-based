DROP TABLE BOARD;
CREATE TABLE BOARD (
    num    NUMBER(9) PRIMARY KEY,  -- 글번호
    writer VARCHAR2(50) NOT NULL,  -- 글쓴이 (입력폼,수정가능)
    subject VARCHAR2(50) NOT NULL, -- 글제목(입력폼,수정가능)
    content VARCHAR2(100) NOT NULL,-- 본문(입력폼,수정가능)
    email   VARCHAR2(40),          -- 메일주소(입력폼,수정가능)
    readcount NUMBER(9) NOT NULL, -- 조회수
    pw        VARCHAR2(20) NOT NULL,-- 삭제 비번(입력폼,수정가능)
    ref       NUMBER(9) NOT NULL, -- 글 그룹
    re_step   NUMBER(9) NOT NULL, -- 그룹내 출력순서
    re_level  NUMBER(2) NOT NULL, -- 들여쓰기 정도
    ip        VARCHAR2(20) NOT NULL,-- IP(수정가능)
    rdate     DATE      NOT NULL);  -- 글쓰기 시점
-- 현재 글 갯수
SELECT COUNT(*) FROM BOARD;
-- 전체글 리스트
SELECT * FROM BOARD ORDER BY REF DESC;
-- 글쓰기
SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, READCOUNT, PW, 
                        REF, RE_STEP, RE_LEVEL, IP, RDATE)
   VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '홍', '제목', '본문',NULL,0, '11',
            (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.10', SYSDATE);
-- 글번호로 글dto 가져오기
SELECT * FROM BOARD WHERE NUM=1;
-- 특정글번호 조회수 up
UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=1;

-- 글 수정하기
UPDATE BOARD SET WRITER='김', SUBJECT='SUBJECT', CONTENT='CONTENT',
                EMAIL='E@E', PW='11', IP='127.0.0.1'
            WHERE NUM=1;

-- 특정글삭제(pw고려)
DELETE FROM BOARD WHERE NUM=1 AND PW='11';
delete from board;
COMMIT;
-- 4,6번글의 조회수 조작
UPDATE BOARD SET READCOUNT=11 WHERE NUM IN (4,6);
COMMIT;








