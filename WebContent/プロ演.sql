-- �����f�[�^�x�[�X�̍폜
DROP DATABASE IF EXISTS emp_sys_db;

-- �f�[�^�x�[�X�̍쐬
CREATE DATABASE emp_sys_db;

-- �f�[�^�x�[�X�̑I��
USE emp_sys_db;

-- ���[�U�}�X�^�e�[�u���̍쐬
create table if not exists emp_sys_db.m_user (
	user_id		VARCHAR(24) primary key NOT NULL,
	password	VARCHAR(32) NOT NULL,
	update_date	TIMESTAMP NOT NULL
	) engine=InnoDB;

-- �����}�X�^�e�[�u���̍쐬
create table if not exists emp_sys_db.m_section (
	section_code		VARCHAR(2) primary key NOT NULL,
	section_name		VARCHAR(24) NOT NULL,
	update_date		TIMESTAMP NOT NULL
	) engine=InnoDB;


-- �]�ƈ��}�X�^�e�[�u���̍쐬
create table if not exists emp_sys_db.m_employee (
	emp_code		VARCHAR(4) primary key NOT NULL,
	l_name			VARCHAR(16) NOT NULL,
	f_name			VARCHAR(16) NOT NULL,
	l_kana_name		VARCHAR(24),
	f_kana_name		VARCHAR(24),
	sex				TINYINT(1),
	birth_day		DATE,
	section_code	VARCHAR(2),
	emp_date		DATE,
	update_date		TIMESTAMP NOT NULL,
	foreign key(section_code) references m_section(section_code)
) engine=InnoDB;


-- ���[�U�T���v���f�[�^
INSERT INTO m_user (user_id, password, update_date) 
VALUES ('1001', 'embex', '2017-01-01 12:30:00');

-- �����T���v���f�[�^
INSERT INTO m_section (section_code, section_name, update_date) 
VALUES ('1', '�G���y�b�N�X', '2017-01-01 12:30:00');

-- �]�ƈ��T���v���f�[�^
INSERT INTO m_employee (emp_code, l_name, f_name,l_kana_name,f_kana_name,sex,birth_day,section_code,emp_date,update_date) 
VALUES ('1111', 'akira','funakoshi', '������','�ӂȂ���',1,'2017-01-01','1','2017-01-01','2017-01-01 12:30:00');
