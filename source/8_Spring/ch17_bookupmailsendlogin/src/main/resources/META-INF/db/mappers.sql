-- �� �� �� Member.xml �� �� ��
-- Member.xml�� idConfirm (id�ߺ�üũ)
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';

-- Member.xml�� id=joinMember(ȸ������)
INSERT INTO MEMBER VALUES
    ('bbb','111','ȫ�浿','hybrid190501@gmail.com',
    '����� ���α�','01234');
    
-- Memeber.xml�� id=getMember(mid�� ȸ������ ��������)
SELECT * FROM MEMBER WHERE MID='aaa';

-- Member.xml�� id=modifyMember(ȸ�����������ϱ�)
UPDATE MEMBER SET
    MPW='111',
    MNAME='���浿',
    MMAIL='hybrid@tj.com',
    MADDR='����� ��걸',
    MPOST='01234'
    WHERE MID='aaa';
commit;
-- �� �� �� Book.xml �� �� ��
-- Book.xml�� id=bookListAll (�Ż������� ��� å ����Ʈ)
SELECT * FROM BOOK order by brdate DESC;
-- Book.xml�� id=bookListPaging(å���� ������� top-N����)
SELECT * FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM BOOK order by btitle) A)
    WHERE RN BETWEEN 1 AND 3;
-- Book.xml�� id=getBook(å��ȣ�� å���� ��������)
SELECT * FROM BOOK WHERE BNUM=1;
-- Book.xml�� id=registerBook(å���)
INSERT INTO BOOK VALUES
    (BOOK_SEQ.NEXTVAL, 'Java','���浿',SYSDATE,
                'noimg.jpg','noimg.jpg','���� JSP å�̴�');
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BIMG1, BINFO) VALUES
    (BOOK_SEQ.NEXTVAL, 'html','�ֹ���',SYSDATE,
    'noimg.jpg','���� JSP å�̴�');   
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BIMG2, BINFO) VALUES
    (BOOK_SEQ.NEXTVAL, 'JavaScript','�ֹ���',SYSDATE,
    'noimg.jpg','���� JSP å�̴�');    
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BINFO) VALUES
    (BOOK_SEQ.NEXTVAL, 'python','ȫ�浿',SYSDATE,'���� JSP å�̴�');
-- Book.xml�� id=modifyBook(å��������)
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='��',
    brdate=sysdate,
    bimg1='noimg.jpg',
    bimg2='noimg.jpg',
    binfo='���� å'
    WHERE BNUM=2;
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='��',
    brdate=sysdate,
    bimg1='noimg.jpg',
    binfo='���� å'
    WHERE BNUM=2;
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='��',
    brdate=sysdate,
    bimg2='noimg.jpg',
    binfo='���� å'
    WHERE BNUM=2;
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='��',
    brdate=sysdate,
    binfo='���� å'
    WHERE BNUM=2;
-- Book.xml�� id=cntBook(��ϵ� å����)
SELECT COUNT(*) FROM BOOK;
COMMIT;