create table MYGDB_Course (
	uuid_ VARCHAR(75) null,
	courseId LONG not null primary key,
	myGradebookId LONG,
	name VARCHAR(75) null,
	topic VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table MYGDB_MyGradebook (
	uuid_ VARCHAR(75) null,
	myGradebookId LONG not null primary key,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table MYGDB_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	birthday DATE null,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupId LONG,
	companyId LONG,
	myGradebookId LONG,
	courseId LONG,
	enrollDate DATE null
);

create table MYGRADEBOOK_Course (
	uuid_ VARCHAR(75) null,
	courseId LONG not null primary key,
	name VARCHAR(75) null,
	gradebookId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table MYGRADEBOOK_Gradebook (
	uuid_ VARCHAR(75) null,
	gradebookId LONG not null primary key,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);