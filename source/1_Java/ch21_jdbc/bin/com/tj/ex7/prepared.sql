INSERT INTO DEPT VALUES (50, 'IT','JONGRO');
commit;

SELECT * FROM DEPT;
-- ����ڿ��� ������ �μ���ȣ?
-- �Է��� �μ���ȣ�� �ִ��� ����
SELECT * FROM DEPT WHERE DEPTNO=10;
-- 1. �μ���ȣ�� �ִ� ��� : �Ʒ��� ���� ����(dname, loc ���� �� ����)
UPDATE DEPT SET DNAME='XX', LOC='YY'
    WHERE DEPTNO=50;
-- 2. �μ���ȣ�� ���� ��� : �μ���ȣ ���ٰ� ���
