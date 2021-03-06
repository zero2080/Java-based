DROP TABLE MVC_BOARD;
DROP SEQUENCE MVC_BOARD_SEQ;
CREATE SEQUENCE MVC_BOARD_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999
    NOCYCLE
    NOCACHE;
CREATE TABLE MVC_BOARD(
    bId    NUMBER(6) PRIMARY KEY,
    bName  VARCHAR2(50) NOT NULL,
    bTitle VARCHAR2(100) NOT NULL,
    bContent VARCHAR2(1000),
    bDate  DATE DEFAULT SYSDATE NOT NULL,
    bHit   NUMBER(6) DEFAULT 0 NOT NULL,
    bGroup NUMBER(6) NOT NULL,
    bStep  NUMBER(3) NOT NULL,
    bIndent NUMBER(3) NOT NULL,
    bIp    VARCHAR2(20) NOT NULL
);
-- 더미데이터(원글)
INSERT INTO MVC_BOARD (bId, bName, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'HONG', 'TITLE','CONTENT',
            MVC_BOARD_SEQ.CURRVAL, 0,0, '192.168.10.151');
SELECT * FROM MVC_BOARD;
-- 더미데이터(위의 1번글에 대한 첫번째 답변글)
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'KIM','T1','C1',
            1, 1, 1, '127.0.0.1');
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP;
-- 더미데이터 (위의 1번글에 대한 두번째 답변글)
--    답변글 추가전 STEP a 수행
UPDATE MVC_BOARD SET BSTEP = BSTEP+1
    WHERE BGROUP = 1 AND BSTEP>0;
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP;
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'PARK','T2','C2',
            1, 1, 1, '192.168.10.151');
COMMIT;
-- 글목록(startRow부터 endRow까지)
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM
            (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)
    WHERE RN BETWEEN 2 AND 3;
-- 글갯수
SELECT COUNT(*) cnt FROM MVC_BOARD;
-- 글쓰기(원글)
INSERT INTO MVC_BOARD (bId, bName, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'HONG', 'TITLE','CONTENT',
            MVC_BOARD_SEQ.CURRVAL, 0,0, '192.168.10.151');
-- bHit 하나 올리기(1번글 조회수 하나 올리기)
UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID=1;
-- bId로 글 dto보기
SELECT * FROM MVC_BOARD WHERE BID=1;
-- 글 수정하기(bId, bName, bTitle, bContent, bIp, bDATE)
UPDATE MVC_BOARD 
    SET BNAME='LEE',
        BTITLE = 'TITLE2',
        BCONTENT = '본문2',
        BIP = '192.168.10.151',
        BDATE = SYSDATE
    WHERE BID=1;
-- 글 삭제하기(bId로 삭제하기)
DELETE FROM MVC_BOARD WHERE BID=3;
--    답변글 추가전 STEP a 수행
UPDATE MVC_BOARD SET BSTEP = BSTEP+1
    WHERE BGROUP = 1 AND BSTEP>0;
-- 답변글 쓰기
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'PARK','T2','C2',
            1, 1, 1, '192.168.10.151');
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP;












