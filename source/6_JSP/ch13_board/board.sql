DROP TABLE BOARD;
CREATE TABLE BOARD (
    num    NUMBER(9) PRIMARY KEY,  -- �۹�ȣ
    writer VARCHAR2(50) NOT NULL,  -- �۾��� (�Է���,��������)
    subject VARCHAR2(50) NOT NULL, -- ������(�Է���,��������)
    content VARCHAR2(100) NOT NULL,-- ����(�Է���,��������)
    email   VARCHAR2(40),          -- �����ּ�(�Է���,��������)
    readcount NUMBER(9) NOT NULL, -- ��ȸ��
    pw        VARCHAR2(20) NOT NULL,-- ���� ���(�Է���,��������)
    ref       NUMBER(9) NOT NULL, -- �� �׷�
    re_step   NUMBER(9) NOT NULL, -- �׷쳻 ��¼���
    re_level  NUMBER(2) NOT NULL, -- �鿩���� ����
    ip        VARCHAR2(20) NOT NULL,-- IP(��������)
    rdate     DATE      NOT NULL);  -- �۾��� ����
-- ���� �� ����
SELECT COUNT(*) FROM BOARD;
-- ��ü�� ����Ʈ
SELECT * FROM BOARD ORDER BY REF DESC;
-- �۾���
SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, READCOUNT, PW, 
                        REF, RE_STEP, RE_LEVEL, IP, RDATE)
   VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 'ȫ', '����', '����',NULL,0, '11',
            (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.10', SYSDATE);
-- �۹�ȣ�� ��dto ��������
SELECT * FROM BOARD WHERE NUM=1;
-- Ư���۹�ȣ ��ȸ�� up
UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=1;

-- �� �����ϱ�
UPDATE BOARD SET WRITER='��', SUBJECT='SUBJECT', CONTENT='CONTENT',
                EMAIL='E@E', PW='11', IP='127.0.0.1'
            WHERE NUM=1;

-- Ư���ۻ���(pw���)
DELETE FROM BOARD WHERE NUM=1 AND PW='11';
delete from board;
COMMIT;
-- 4,6������ ��ȸ�� ����
UPDATE BOARD SET READCOUNT=11 WHERE NUM IN (4,6);
COMMIT;








