-- initialDB.sql
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    mId VARCHAR2(20) PRIMARY KEY, -- ���̵�
    mPw VARCHAR2(20) NOT NULL, -- ���
    mName VARCHAR2(50) NOT NULL, -- �̸�
    mMail VARCHAR2(50) NOT NULL, -- �����ּ�
    mAddr VARCHAR2(200), --  �ּ�
    mPost VARCHAR2(10)); --  �����ȣ
INSERT INTO MEMBER VALUES
    ('aaa','111','ȫ�浿','hybrid190501@gmail.com', '����� ���α�','01234');
SELECT * FROM MEMBER;
DROP TABLE BOOK CASCADE CONSTRAINTS;
CREATE TABLE BOOK(
    bNUM NUMBER(4) PRIMARY KEY, -- å��ȣ(�������̿�)
    bTITLE VARCHAR2(200) NOT NULL, -- å�̸�
    bWRITER VARCHAR2(50) NOT NULL, -- ����
    bRDATE DATE DEFAULT SYSDATE,   -- ������
    bIMG1 VARCHAR2(100) DEFAULT 'noimg.jpg', -- å�̹���1
    bIMG2 VARCHAR2(100) DEFAULT 'noimg.jpg', -- å�̹���2
    bINFO VARCHAR2(2000));  -- å����
DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ;
INSERT INTO BOOK VALUES
(BOOK_SEQ.NEXTVAL, 'JSP','�ֹ���', '19-01-01', 'noimg.jpg','noimg.jpg','���� ������ å�̴�');
COMMIT;
