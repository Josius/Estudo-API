INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Matriz', 'Rua Matriz', '13', 'null', '08089000');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('São Paulo', 'Rua A', '14', 'null', '08089001');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Rio de Janeiro', 'Rua B', '15', 'null', '08089002');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Belo Horizonte', 'Rua B', '15', 'null', '08089002');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Curitiba', 'Rua B', '15', 'null', '08089002');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Porto Alegre', 'Rua B', '15', 'null', '08089002');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Ponta Grossa', 'Rua B', '15', 'null', '08089002');
INSERT INTO tb_filial (nome, logradouro, numero, complemento, cep) VALUES ('Fortaleza', 'Rua B', '15', 'null', '08089002');

INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Tênis Jogging', 'Tênis de corrida', 'par');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Tênis Basquete', 'Tênis de corrida', 'par');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Bola de basquete', 'Spalding', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Bola de vôlei', 'Wilson', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Camiseta', 'Estampada', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Lápis', 'Lápis de Cor', 'caixa');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Regua', '30 cm', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Caneta Azul', 'azul', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Caneta Vermelha', 'vermelha', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Caneta Preta', 'preta', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Folha de Sulfite', 'Pacote com 500 fls', 'pacote');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Teclado', 'Teclado sem fio', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Mouse', 'Mouse sem fio', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Notebook', '1tb de HD, 16gb ram', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Memória DDR13.6', 'megaveloz', 'unidade');
INSERT INTO tb_produto (nome, descricao, unidade) VALUES ('Farofa', 'Farofa temperada 500g', 'pacote');

INSERT INTO tb_fornecedor (cnpj, nome, telefone, email, logradouro, numero, complemento, cep) VALUES ('75643289077', 'Fornecedor A', '3344-5566', 'fornecedor@fornecedor.com', 'log', '1235', 'casa b', '08079345');

INSERT INTO tb_cliente (cpf, nome, telefone, email, logradouro, numero, complemento, cep) VALUES ('44566733290', 'Cliente A', '6744-5962', 'cliente@cliente.com', 'log', '5432', 'casa cliente', '88665098');


INSERT INTO tb_usuario (email, nome, senha, perfil_id, filial_id) VALUES ('admin@admin.com', 'admin', '$2a$10$aF0w.BoJID4ZobfvNZ7.5.6NsyrS0lTH8Yj2BaR46vlAg284/R55m', 1, 1);