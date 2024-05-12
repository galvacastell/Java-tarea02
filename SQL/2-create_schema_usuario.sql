-- table usuario
create table if not exists usuario(
    id serial primary key,
    nombre varchar(32) not null,
    usua varchar(20) not null,
    pass varchar(20)
    );

create index id_usuario
    on usuario("id");

-- table documentos
create table if not exists documento(
    id serial primary key,
    id_user bigint,
    tipo int,
    numero varchar(32) not null,
    constraint fk_usuario
    foreign key(id_user)
    references usuario(id)
    on delete cascade
    );

insert into usuario(nombre,usua,pass) values('Gian ALva','galva','123456');
insert into usuario(nombre,usua,pass) values('Gian ALva02','galva02','123456');
insert into usuario(nombre,usua,pass) values('Gian ALva03','galva03','123456');
insert into documento(id_user,tipo,numero) values(1,1,'45209789');
insert into documento(id_user,tipo,numero) values(1,3,'C45209789L');
