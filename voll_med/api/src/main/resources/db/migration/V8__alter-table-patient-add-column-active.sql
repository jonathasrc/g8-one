alter table patient add active tinyint;

update medical set active = 1;
