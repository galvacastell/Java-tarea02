-- table usuario
create table if not exists usuario(
    id_usu bigint primary key
    );

create index id_usuario
    on usuario("id_usu");

-- table cuentas
create table if not exists cuenta(
    id serial primary key,
    id_usu bigint,
    num_tarjeta varchar(20) not null,
    saldo decimal not null,
    constraint fk_usuario
    foreign key(id_usu)
    references usuario(id_usu)
    on delete cascade
    );

insert into usuario(id_usu) values(1);
insert into usuario(id_usu) values(2);
insert into cuenta(id_usu,num_tarjeta,saldo) values(1,'1245789654',150);
insert into cuenta(id_usu,num_tarjeta,saldo) values(1,'1245419654',789);

