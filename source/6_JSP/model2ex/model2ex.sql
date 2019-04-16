DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD(
    fId NUMBER(6) PRIMARY KEY,
    mId VARCHAR2(30) REFERENCES MVC_MEMBER(MID),
    fTitle VARCHAR2(100) NOT NULL,
    fContent VARCHAR2(1000),
    fileName VARCHAR2(30),
    fDate    DATE DEFAULT SYSDATE,
    fHit     NUMBER(6) DEFAULT 0,
    fGroup   NUMBER(6) NOT NULL,
    fStep    NUMBER(3) NOT NULL,
    fIndent  NUMBER(3) NOT NULL,
    fIp      VARCHAR2(20) NOT NULL);

-- ���̵�����(����)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, null,'title','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.10.151');
SELECT * FROM FILEBOARD;
-- ���̵�����(���� 1���ۿ� ���� ù��° �亯��)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb','reply','content', null,
        1, 1, 1, '192.168.10.151');
select * from fileboard order by fgroup desc, fstep;
-- ���̵����� (���� 1���ۿ� ���� �ι�° �亯��)
--    �亯�� �߰��� STEP a ����
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb','reply','content', null,
        1, 1, 1, '192.168.10.151');
COMMIT;
-- �۸��(startRow���� endRow����)
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID ORDER BY FGROUP DESC, FSTEP;
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID 
                ORDER BY FGROUP DESC, FSTEP) A)
    WHERE RN BETWEEN 1 AND 300;
-- �۰���
SELECT COUNT(*) FROM FILEBOARD;
-- �۾���(����)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','title','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.10.151');
-- FHit �ϳ� �ø���(1���� ��ȸ�� �ϳ� �ø���)
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=1;
-- bId�� �� dto����
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE M.MID=F.MID AND FID=1;
-- �� �����ϱ�(FId, FTitle, FContent, FILENAME,  FIp, FDATE)
UPDATE FILEBOARD SET FTITLE = '����',
                    FCONTENT = '����',
                    FILENAME = NULL,
                    FIP = '192.168.151.10',
                    FDATE = SYSDATE
            WHERE FID = 1;
-- �� �����ϱ�(bId�� �����ϱ�)
DELETE FROM FILEBOARD WHERE FID=6;
--    �亯�� �߰��� STEP a ����
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
-- �亯�� ����
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb','reply','content', null,
        1, 1, 1, '192.168.10.151');
commit;
----------------------------------------------------------------------
--                          admin table                             --
----------------------------------------------------------------------
DROP TABLE ADMIN;
CREATE TABLE ADMIN(
    aId VARCHAR2(30) PRIMARY KEY,
    aPw VARCHAR2(30) NOT NULL,
    aName VARCHAR2(30) NOT NULL);
-- dummy data
INSERT INTO ADMIN VALUES ('admin','111','�����');
-- admin loginCheck
SELECT * FROM ADMIN WHERE AID='admin' AND APW='111';
-- admin aid�� dto ��������
SELECT * FROM ADMIN WHERE AID='admin';
COMMIT;








