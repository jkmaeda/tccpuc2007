USE  TccPuc2007 

CREATE TABLE Estabelecimento (
	estabelecimentoID int IDENTITY(1,1) NOT NULL,
	nome varchar(50) NOT NULL,
	PRIMARY KEY (estabelecimentoID)
)

CREATE TABLE Cardapio (
	cardapioID int IDENTITY(1,1) NOT NULL,
	estabelecimentoID int NOT NULL,
	PRIMARY KEY (cardapioID),
	FOREIGN KEY (estabelecimentoID) REFERENCES Estabelecimento(estabelecimentoID) ON DELETE CASCADE	
) 

CREATE TABLE ItemCardapio (
	itemCardapioID int IDENTITY(1,1) NOT NULL,
	preco numeric(10, 2) NOT NULL,
	nome varchar(50) NOT NULL,
	descricao text NULL,
	cardapioID int NOT NULL,
	PRIMARY KEY (itemCardapioID),
	FOREIGN KEY (cardapioID) REFERENCES Cardapio(cardapioID) ON DELETE CASCADE
)

CREATE TABLE TipoFuncionario (
	tipoFuncionarioID int IDENTITY(1,1) NOT NULL,
	descricao varchar(50) NOT NULL,
	PRIMARY KEY (tipoFuncionarioID)
)

CREATE TABLE Funcionario (
	funcionarioID int IDENTITY(1,1) NOT NULL,
	nome varchar(50) NOT NULL,
	tipoFuncionarioID int NOT NULL,
	estabelecimentoID int NOT NULL,
	PRIMARY KEY (funcionarioID),
	FOREIGN KEY (tipoFuncionarioID) REFERENCES TipoFuncionario(tipoFuncionarioID) ON DELETE CASCADE,
	FOREIGN KEY (estabelecimentoID) REFERENCES Estabelecimento(estabelecimentoID) ON DELETE CASCADE
)

CREATE TABLE Conta (
	contaID int IDENTITY(1,1) NOT NULL,
	observacao text NULL,
	PRIMARY KEY (contaID)
)

CREATE TABLE  Pedido (
	pedidoID int IDENTITY(1,1) NOT NULL,
	contaID int NOT NULL,
	PRIMARY KEY (pedidoID),
	FOREIGN KEY (contaID) REFERENCES Conta(contaID) ON DELETE CASCADE
)

CREATE TABLE ItemPedido (
	itemPedidoID int IDENTITY(1,1) NOT NULL,
	quantidade int NOT NULL,
	itemCardapioID int NOT NULL,
	pedidoID int NOT NULL,
	PRIMARY KEY (itemPedidoID),
	FOREIGN KEY (itemCardapioID) REFERENCES ItemCardapio(itemCardapioID) ON DELETE CASCADE,
	FOREIGN KEY (pedidoID) REFERENCES Pedido(pedidoID) ON DELETE CASCADE
)

CREATE TABLE Cliente (
	clienteID int IDENTITY(1,1) NOT NULL,
	contaID int NULL,
	identificacao image NULL,
	foto image NULL,
	nome varchar(50) NULL,
	cpf varchar(11) NULL,
	estabelecimentoID int NULL,
	PRIMARY KEY (clienteID),
	FOREIGN KEY (contaID) REFERENCES Conta(contaID) ON DELETE CASCADE,
	FOREIGN KEY (estabelecimentoID) REFERENCES Estabelecimento(estabelecimentoID) ON DELETE CASCADE
)