DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    NAME VARCHAR2(20) NOT NULL,
    ID   VARCHAR2(20) PRIMARY KEY,
    PW   VARCHAR2(20) NOT NULL,
    PHONE1 VARCHAR2(10),
    PHONE2 VARCHAR2(10),
    PHONE3 VARCHAR2(10),
    GENDER VARCHAR2(10));
-- 1. ȸ�����Խ�
INSERT INTO MEMBER VALUES ('ȫ�浿', 'aaa','111','02','9999','9999','��');
COMMIT;
SELECT * FROM MEMBER;
-- 2. �α��� ��
SELECT * FROM MEMBER WHERE ID='aaa' AND PW='111';
-- 3. ȸ������ ���� ��
UPDATE MEMBER SET NAME='ȫ��', PW='aaa', PHONE1='010', PHONE2='1111', PHONE3='1111',
                GENDER='��' WHERE ID='aaa';
commit;





