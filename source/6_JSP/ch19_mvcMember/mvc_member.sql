DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    mId VARCHAR2(30) PRIMARY KEY,
    mPw VARCHAR2(30) NOT NULL,
    mName VARCHAR2(30) NOT NULL,
    mEmail VARCHAR2(30),
    mPhoto VARCHAR2(30) DEFAULT 'NOIMG.JPG',
    mBirth DATE,
    mAddress VARCHAR2(300),
    mRdate DATE DEFAULT SYSDATE );
-- mId confirm
SELECT * FROM MVC_MEMBER WHERE MID='aaa';
-- join
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('aaa','111','hong',null, 'NOIMG.JPG', 
        TO_DATE('19900101','YYYYMMDD'), 'SEOUL');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('bbb','111','park',null, 'NOIMG.JPG', 
        '1990-01-01', 'SEOUL');
SELECT * FROM MVC_MEMBER;
-- login
SELECT * FROM MVC_MEMBER WHERE MID='aaa'; -- id wrong /pw wrong
SELECT * FROM MVC_MEMBER WHERE MID='aaa' AND MPW='111'; -- id or pw wrong
-- mId�� dto�� ��������
SELECT * FROM MVC_MEMBER WHERE MID='aaa';
-- modify info
UPDATE MVC_MEMBER SET MPW='111',
                    MNAME = 'HONG GIL',
                    MEMAIL = 'H@TJ.COM',
                    MPHOTO = 'NOIMG.JPG',
                    MBIRTH = NULL,
                    MADDRESS = 'INCHON'
            WHERE MID = 'aaa';
-- ������ ȸ����� ��������
SELECT COUNT(*)  FROM MVC_MEMBER;
-- startRow~endRow���� list
SELECT * FROM MVC_MEMBER ORDER BY MID; -- 1�ܰ�
SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MID) A; -- 2�ܰ�

SELECT * 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MID) A)
    WHERE RN BETWEEN 1 AND 9; -- 3�ܰ�