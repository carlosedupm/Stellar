set foreign_key_checks = 0;

delete from produto;
alter table produto auto_increment = 1;

set foreign_key_checks = 1;

insert into stellar.produto (id, nome, descricao, preco, ativo) values (1,'Leite','Leite integral', 10,1);