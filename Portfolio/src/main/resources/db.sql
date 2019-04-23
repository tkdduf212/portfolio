--------------------------------------------멤버
create table project_member(
	p_id varchar2(10 char) primary key,
	p_pw varchar2(20 char) not null,
	p_name  varchar2(5 char) not null,
	p_birth varchar2(20 char) not null,
	--p_birth date not null,
	p_gender number(1) not null,
	p_adds varchar2(40 char) not null,
	p_img varchar2(30 char) not null,
	p_id_hint varchar2(30 char) not null,
	p_pw_hint varchar2(30 char) not null
);

insert into PROJECT_MEMBER values ('1','1','1','1',1,'1*1*1','non_img.png','1','1');
select * from PROject_MEMBER;
drop table project_member cascade constraint purge;

delete from pro_member where p_id = 11 and p_id=22;

update project_MEMBER set p_birth = '2019.1.1' where p_birth='19/01/01'
-------------------------------------------------------------------게시판
create table PROJECT_sns(
	ps_no number(5) primary key,
	ps_owner varchar2(10 char) not null, 
	ps_txt varchar2(350 char) not null,  
	ps_date date not null,				 
	ps_color char(7 char) not null,
	ps_img varchar2(150 char) not null
);
create sequence PROJECT_sns_seq;
insert into PROJECT_SNS values(PROJECT_sns_seq.nextval, '1','1', sysdate ,'1','1');
drop table PROJECT_sns cascade constraint purge;
DROP SEQUENCE PROJECT_sns_SEQ;
select * from PROJECT_SNS;
--------------------------------------------------------------
create table PROJECT_sns_reply(
	psr_no number(6) primary key, 
	psr_ps_no number(5) not null, 
	psr_owner varchar2(10 char) not null,	
	psr_txt varchar2(120 char) not null,
	psr_date date not null,
	constraint sns_reply_delete 
		foreign key(psr_ps_no) references PROJECT_sns(ps_no)
		on delete cascade
);
drop table PROJECT_sns_reply cascade constraint purge;
drop sequence PROJECT_sns_reply_seq;
create sequence PROJECT_sns_reply_seq;
select * from PROJECT_SNS_REPLY;
select * from PROJECT_sns_reply where psr_ps_no = #{ps_no} order by psr_date;

