# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table director (
  id                        bigint not null,
  nome                      varchar(255),
  constraint pk_director primary key (id))
;

create sequence director_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists director;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists director_seq;

