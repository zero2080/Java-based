DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ NOCACHE;
CREATE TABLE FRIEND(
    no NUMBER PRIMARY KEY,
    name VARCHAR2(30) NOT NULL,
    phone VARCHAR2(20) NOT NULL);
-- 친구추가
INSERT INTO FRIEND VALUES (FRIEND_SEQ.NEXTVAL, '홍길동','010-9999-9999');
COMMIT;
-- 친구리스트 (모든 친구들 리스트)
SELECT * FROM FRIEND;
-- 친구검색 (이름과 전화번호 조건에 맞는 친구들 리스트)
SELECT * FROM FRIEND 
    WHERE NAME LIKE '%'||''||'%' AND PHONE LIKE '%'||''||'%';
















