DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ NOCACHE;
CREATE TABLE FRIEND(
    no NUMBER PRIMARY KEY,
    name VARCHAR2(30) NOT NULL,
    phone VARCHAR2(20) NOT NULL);
-- ģ���߰�
INSERT INTO FRIEND VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿','010-9999-9999');
COMMIT;
-- ģ������Ʈ (��� ģ���� ����Ʈ)
SELECT * FROM FRIEND;
-- ģ���˻� (�̸��� ��ȭ��ȣ ���ǿ� �´� ģ���� ����Ʈ)
SELECT * FROM FRIEND 
    WHERE NAME LIKE '%'||''||'%' AND PHONE LIKE '%'||''||'%';















