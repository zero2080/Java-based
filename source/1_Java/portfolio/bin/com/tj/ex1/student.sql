-- ���̺� DROP
DROP TABLE STUDENT;
DROP TABLE MAJOR;
-- ���̺� ����
CREATE TABLE MAJOR(
    mNO NUMBER(1,0),
    mNAME VARCHAR2(30) NOT NULL,
    PRIMARY KEY(MNO));
INSERT INTO MAJOR VALUES (1, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (2, '�濵����');
INSERT INTO MAJOR VALUES (3, '���������');
INSERT INTO MAJOR VALUES (4, '�ǿ�����');
INSERT INTO MAJOR VALUES (5, '������������');

CREATE TABLE STUDENT(
    sNO VARCHAR2(10),
    sNAME VARCHAR2(50) NOT NULL,
    mNO NUMBER(1,0),
    SCORE NUMBER(3,0) DEFAULT 0 NOT NULL,
    sEXPEL NUMBER(1,0) DEFAULT 0 NOT NULL,
    PRIMARY KEY(SNO),
    FOREIGN KEY(MNO) REFERENCES MAJOR(MNO),
    CHECK(SCORE>=0 AND SCORE<=100),
    CHECK(sEXPEL=0 OR sEXPEL=1));
-- 1. �й� �˻� (�й�, �̸�, ������(������ȣ), ����)
SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND sNO='201901';
-- 2. �̸� �˻� (�й�, �̸�, ������(������ȣ), ����)
SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND sNAME='ȫ�浿';
-- 3. ���� �˻� (�й�, �̸�, ������(������ȣ), ����)
SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND MNAME='��ǻ�Ͱ���';
-- 4. �л� �Է� (�й�, �̸�, ������, ����)
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    ('201902','ȫ���', (SELECT mNO FROM MAJOR WHERE mNAME='�濵����'),96);
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    ('201901','ȫ�浿',1,100);
SELECT * FROM STUDENT;
-- 5. �л����� (�й��� ����, �̸�, ������, ���� ����)
UPDATE STUDENT SET sNAME='ȫ���', mNO=(SELECT mNO FROM MAJOR WHERE mNAME='�濵����'),
        SCORE=99
    WHERE sNO='201901';
-- 6. �л���� (���������� �й�, �̸�, ������(������ȣ), ����)
SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=0;
-- 7. ����ó�� (�й��� ���� �� �л� ������ ó��)
UPDATE STUDENT SET sEXPEL=1 WHERE sNO='201902';
-- 8. ������ ��� (�����ڸ� �й�, �̸�, ������(������ȣ), ����, ��������)
SELECT S.*, mNAME FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=1;
--0. ������ �˻�
SELECT MNAME FROM MAJOR;
select * from student;
commit;