insert into produto (nome, descricao, preco, quantidade, unidade) values ('Cabo', 'Cabo de cobre', 10.00, 10, 'm');
insert into produto (nome, descricao, preco, quantidade, unidade) values ('Rj-45', 'Conector RJ-45', 0.10, 10, 'un')


insert into cliente (nome, sexocliente) values ('Nicolas','MASC');
insert into cliente (nome, sexocliente) values ('Luisa','FEM');

INSERT INTO Pedido (cliente_id, pedido_data_criacao, pedido_data_finalizacao, notafiscal_id, total, status_pedido, cep, logradouro, numero, cidade, estado,bairro,complemento) VALUES (1, '2024-04-19 10:00:00', '2024-04-19 11:00:00', 123456, 50.00, 'AGUARDANDO', '09541-200', 'Rua Wenceuslau Bras', '231', 'São Caetano do Sul', 'São Paulo','Santa Paula','81B');
INSERT INTO Pedido (cliente_id, pedido_data_criacao, pedido_data_finalizacao, notafiscal_id, total, status_pedido, cep, logradouro, numero, cidade, estado,bairro,complemento) VALUES (2, '2024-04-19 12:00:00', '2024-05-19 12:00:00', 123, 70.00, 'PAGO', '09641-300', 'Rua pIRAJU', '62', 'São Caetano do Sul', 'São Paulo','Olimpico','  ');

INSERT INTO ItemPedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);