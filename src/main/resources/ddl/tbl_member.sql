

-- 회원 관리 테이블
CREATE TABLE tbl_member (
    account VARCHAR2(50),
    password VARCHAR2(150) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) NOT NULL UNIQUE,
    auth VARCHAR2(20) DEFAULT 'COMMON',
    reg_date DATE DEFAULT SYSDATE,
    CONSTRAINT pk_member PRIMARY KEY (account)
);

ALTER TABLE tbl_board ADD account VARCHAR2(50) NOT NULL;
ALTER TABLE tbl_reply ADD account VARCHAR2(50) NOT NULL;



SELECT * FROM tbl_member;







