DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    id VARCHAR2(30) PRIMARY KEY,
    pw VARCHAR2(30) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(40),
    birth DATE NOT NULL,
    rDate DATE NOT NULL,
    address VARCHAR2(255));
-- 1. 회원가입 시 쓸 id 중복체크
SELECT * FROM MEMBER WHERE ID='aaa';
-- 2. 회원 INSERT 
INSERT INTO MEMBER (ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS)
    VALUES ('aaa','111','홍긷오','hong@tj.com','1995-01-01', sysdate, '서울 종로');
INSERT INTO MEMBER 
    VALUES ('bbb','222','박길동','park@tj.com','1995-01-01', sysdate, '서울 종로');
-- 3. 로그인 체크 (ID를 먼저 확인)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 4. ID로 dto 리턴하는 함수에 쓸 것 public MemberDto getMember(String id){}
SELECT * FROM MEMBER WHERE ID='aaa';

-- 5. 회원정보 수정
UPDATE MEMBER SET PW='111', NAME='홍길동', EMAIL='h@tj.com', BIRTH='1995-01-01',
    ADDRESS='서울 용산' WHERE ID='aaa';





