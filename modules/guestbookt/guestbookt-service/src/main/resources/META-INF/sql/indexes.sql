create index IX_25A8410B on GBT_GuestbookT (groupId);
create index IX_F99112B3 on GBT_GuestbookT (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4594A9F5 on GBT_GuestbookT (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_DDFE326D on GBT_GuestbookTEntry (groupId, guestbookTId);
create index IX_CBFA0CB3 on GBT_GuestbookTEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B1F423F5 on GBT_GuestbookTEntry (uuid_[$COLUMN_LENGTH:75$], groupId);