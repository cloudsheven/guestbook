create index IX_450644F1 on GBT_GuestbookT (groupId, status);
create index IX_E74FE265 on GBT_GuestbookT (status);
create index IX_F99112B3 on GBT_GuestbookT (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4594A9F5 on GBT_GuestbookT (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_70DB453 on GBT_GuestbookTEntry (groupId, guestbookTId, status);
create index IX_64960AF1 on GBT_GuestbookTEntry (groupId, status);
create index IX_3FC95C65 on GBT_GuestbookTEntry (status);
create index IX_CBFA0CB3 on GBT_GuestbookTEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B1F423F5 on GBT_GuestbookTEntry (uuid_[$COLUMN_LENGTH:75$], groupId);