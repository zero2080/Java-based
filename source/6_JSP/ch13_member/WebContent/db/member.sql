DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    id VARCHAR2(30) PRIMARY KEY,
    pw VARCHAR2(30) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(40),
    birth DATE NOT NULL,
    rDate DATE NOT NULL,
    address VARCHAR2(255));
-- 1. ȸ������ �� �� id �ߺ�üũ
SELECT * FROM MEMBER WHERE ID='aaa';
-- 2. ȸ�� INSERT 
INSERT INTO MEMBER (ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS)
    VALUES ('aaa','111','ȫ���','hong@tj.com','1995-01-01', sysdate, '���� ����');
INSERT INTO MEMBER 
    VALUES ('bbb','222','�ڱ浿','park@tj.com','1995-01-01', sysdate, '���� ����');
-- 3. �α��� üũ (ID�� ���� Ȯ��)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 4. ID�� dto �����ϴ� �Լ��� �� �� public MemberDto getMember(String id){}
SELECT * FROM MEMBER WHERE ID='aaa';

-- 5. ȸ������ ����
UPDATE MEMBER SET PW='111', NAME='ȫ�浿', EMAIL='h@tj.com', BIRTH='1995-01-01',
    ADDRESS='���� ���' WHERE ID='aaa';





