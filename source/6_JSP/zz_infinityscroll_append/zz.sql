CREATE TABLE zz(
    no number(3) primary key,
    name varchar2(30) not null,
    tel varchar2(30) not null,
    addr varchar2(300) );
DROP SEQUENCE ZZ_SEQ;
CREATE SEQUENCE ZZ_SEQ NOCACHE;
INSERT INTO ZZ VALUES (ZZ_SEQ.NEXTVAL, 'È«2','010-9999-9991','Á¾·Î2');
select * from zz order by no;
select * from
    (select ROWNUM RN, A.* FROM (select * from zz order by no) A)
    WHERE RN BETWEEN 5 AND 8;
    
SELECT COUNT(*) FROM ZZ;
commit;