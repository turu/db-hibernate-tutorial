create sequence hibernate_sequence;
grant all on hibernate_sequence to bazy;
alter sequence hibernate_sequence increment by 1000;