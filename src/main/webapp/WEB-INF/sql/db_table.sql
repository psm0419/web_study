CREATE TABLE T_ROOM (
	room_id number primary key,
	building_number varchar2(32) not null,
	room_number number(6) not null,
	floor number(4),
	max_guest_count number(6) not null,
	view_type varchar2(8) not null
);

create sequence seq_t_room_pk
start with 1
increment by 1
nocycle;