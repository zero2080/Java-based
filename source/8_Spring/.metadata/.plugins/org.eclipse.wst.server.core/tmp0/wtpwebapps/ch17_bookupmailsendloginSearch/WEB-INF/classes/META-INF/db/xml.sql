-- Memeber.xml�� id=getMember
SELECT * FROM MEMBER WHERE MID='aaa';
-- Member.xml�� id=joinMember
INSERT INTO MEMBER VALUES
    ('bbb','111','ȫ�浿','uxui.userid@gmail.com',
    '����� ���α�','01234');
-- Member.xml�� id=modifyMember
UPDATE MEMBER SET
    MPW='111',
    MNAME='���浿',
    MMAIL='uxui@h.com',
    MADDR='����� ��걸',
    MPOST='01234'
    WHERE MID='aaa';
-- Member.xml�� idConfirm
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';
commit;
-- Book.xml�� id=bookListAll
SELECT * FROM BOOK order by brdate desc;
-- Book.xml�� id=bookListPaging
SELECT * FROM (SELECT ROWNUM RN, A.*
FROM (SELECT * FROM BOOK order by btitle) A)
WHERE RN BETWEEN 1 AND 33;
-- Book.xml�� id=getBook
SELECT * FROM BOOK WHERE BNUM=21;
-- Book.xml�� id=registerBook
INSERT INTO BOOK VALUES
(BOOK_SEQ.NEXTVAL, 'JSP','�ֹ���',SYSDATE,
    'noimg.jpg','noimg.jpg','���� JSP å�̴�');
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BIMG2, BINFO) VALUES
(BOOK_SEQ.NEXTVAL, 'JSP','�ֹ���',SYSDATE,
    'noimg.jpg','���� JSP å�̴�');    
-- Book.xml�� id=modifyBook
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='��',
    brdate=sysdate,
    bimg1='noimg.jpg',
    bimg2='noimg.jpg',
    binfo='���� å'
    WHERE BNUM=2;
-- Book.xml�� id=cntBook
SELECT COUNT(*) FROM BOOK;
select count(*) from book where bwriter like '%'||'��'||'%';
COMMIT;