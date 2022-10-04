create index IX_F61D561C on MYGDB_Course (groupId, myGradebookId);
create index IX_3AF7FF1B on MYGDB_Course (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4D1B905D on MYGDB_Course (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1E4BB176 on MYGDB_MyGradebook (groupId);
create index IX_447DEAA8 on MYGDB_MyGradebook (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CE50FB2A on MYGDB_MyGradebook (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5FF3D7A on MYGDB_Student (groupId, myGradebookId, courseId);
create index IX_5170E56F on MYGDB_Student (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6381FBB1 on MYGDB_Student (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C97E984B on MYGRADEBOOK_Course (gradebookId, groupId);
create index IX_B17916AD on MYGRADEBOOK_Course (groupId, gradebookId);
create index IX_983FE120 on MYGRADEBOOK_Course (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BC8E2FA2 on MYGRADEBOOK_Course (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9017A0EF on MYGRADEBOOK_Gradebook (groupId);
create index IX_AE65534F on MYGRADEBOOK_Gradebook (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_24786191 on MYGRADEBOOK_Gradebook (uuid_[$COLUMN_LENGTH:75$], groupId);