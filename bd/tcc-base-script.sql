USE [master]
GO
/****** Object:  Database [TccPuc2007]    Script Date: 09/22/2007 16:20:18 ******/
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'TccPuc2007')
BEGIN
CREATE DATABASE [TccPuc2007] ON  PRIMARY 
( NAME = N'TccPuc2007', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\TccPuc2007.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TccPuc2007_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\TccPuc2007_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 COLLATE SQL_Latin1_General_CP1_CI_AS
END
GO
EXEC dbo.sp_dbcmptlevel @dbname=N'TccPuc2007', @new_cmptlevel=90
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TccPuc2007].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TccPuc2007] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [TccPuc2007] SET ANSI_NULLS OFF
GO
ALTER DATABASE [TccPuc2007] SET ANSI_PADDING OFF
GO
ALTER DATABASE [TccPuc2007] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [TccPuc2007] SET ARITHABORT OFF
GO
ALTER DATABASE [TccPuc2007] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [TccPuc2007] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [TccPuc2007] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [TccPuc2007] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [TccPuc2007] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [TccPuc2007] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [TccPuc2007] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [TccPuc2007] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [TccPuc2007] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [TccPuc2007] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [TccPuc2007] SET  ENABLE_BROKER
GO
ALTER DATABASE [TccPuc2007] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [TccPuc2007] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [TccPuc2007] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [TccPuc2007] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [TccPuc2007] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [TccPuc2007] SET  READ_WRITE
GO
ALTER DATABASE [TccPuc2007] SET RECOVERY SIMPLE
GO
ALTER DATABASE [TccPuc2007] SET  MULTI_USER
GO
ALTER DATABASE [TccPuc2007] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [TccPuc2007] SET DB_CHAINING OFF
GO
USE [TccPuc2007]
GO
/****** Object:  ForeignKey [FK_ItemPedido_ItemCardapio]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPedido_ItemCardapio]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPedido]'))
ALTER TABLE [dbo].[ItemPedido] DROP CONSTRAINT [FK_ItemPedido_ItemCardapio]
GO
/****** Object:  ForeignKey [FK_ItemPedido_Pedido]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPedido_Pedido]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPedido]'))
ALTER TABLE [dbo].[ItemPedido] DROP CONSTRAINT [FK_ItemPedido_Pedido]
GO
/****** Object:  ForeignKey [FK_Cliente_Cliente]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Cliente]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente] DROP CONSTRAINT [FK_Cliente_Cliente]
GO
/****** Object:  ForeignKey [FK_Cliente_Conta]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Conta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente] DROP CONSTRAINT [FK_Cliente_Conta]
GO
/****** Object:  ForeignKey [FK_Cliente_Estabelecimento]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Estabelecimento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente] DROP CONSTRAINT [FK_Cliente_Estabelecimento]
GO
/****** Object:  ForeignKey [FK_Cliente_Identificacao]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Identificacao]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente] DROP CONSTRAINT [FK_Cliente_Identificacao]
GO
/****** Object:  ForeignKey [FK_Cliente_TipoCliente]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_TipoCliente]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente] DROP CONSTRAINT [FK_Cliente_TipoCliente]
GO
/****** Object:  ForeignKey [FK_Identificacao_TipoIdentificacao]    Script Date: 09/22/2007 16:20:21 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Identificacao_TipoIdentificacao]') AND parent_object_id = OBJECT_ID(N'[dbo].[Identificacao]'))
ALTER TABLE [dbo].[Identificacao] DROP CONSTRAINT [FK_Identificacao_TipoIdentificacao]
GO
/****** Object:  ForeignKey [FK_ItemCardapio_Cardapio]    Script Date: 09/22/2007 16:20:21 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemCardapio_Cardapio]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemCardapio]'))
ALTER TABLE [dbo].[ItemCardapio] DROP CONSTRAINT [FK_ItemCardapio_Cardapio]
GO
/****** Object:  ForeignKey [FK_Funcionario_Estabelecimento]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Funcionario_Estabelecimento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Funcionario]'))
ALTER TABLE [dbo].[Funcionario] DROP CONSTRAINT [FK_Funcionario_Estabelecimento]
GO
/****** Object:  ForeignKey [FK_Funcionario_TipoFuncionario]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Funcionario_TipoFuncionario]') AND parent_object_id = OBJECT_ID(N'[dbo].[Funcionario]'))
ALTER TABLE [dbo].[Funcionario] DROP CONSTRAINT [FK_Funcionario_TipoFuncionario]
GO
/****** Object:  ForeignKey [FK_Pedido_Conta]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Pedido_Conta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Pedido]'))
ALTER TABLE [dbo].[Pedido] DROP CONSTRAINT [FK_Pedido_Conta]
GO
/****** Object:  ForeignKey [FK_Cardapio_Estabelecimento]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cardapio_Estabelecimento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cardapio]'))
ALTER TABLE [dbo].[Cardapio] DROP CONSTRAINT [FK_Cardapio_Estabelecimento]
GO
/****** Object:  Table [dbo].[ItemPedido]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemPedido]') AND type in (N'U'))
DROP TABLE [dbo].[ItemPedido]
GO
/****** Object:  Table [dbo].[Funcionario]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Funcionario]') AND type in (N'U'))
DROP TABLE [dbo].[Funcionario]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 09/22/2007 16:20:20 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cliente]') AND type in (N'U'))
DROP TABLE [dbo].[Cliente]
GO
/****** Object:  Table [dbo].[Conta]    Script Date: 09/22/2007 16:20:19 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Conta]') AND type in (N'U'))
DROP TABLE [dbo].[Conta]
GO
/****** Object:  Table [dbo].[Pedido]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Pedido]') AND type in (N'U'))
DROP TABLE [dbo].[Pedido]
GO
/****** Object:  Table [dbo].[ItemCardapio]    Script Date: 09/22/2007 16:20:21 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemCardapio]') AND type in (N'U'))
DROP TABLE [dbo].[ItemCardapio]
GO
/****** Object:  Table [dbo].[TipoFuncionario]    Script Date: 09/22/2007 16:20:19 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoFuncionario]') AND type in (N'U'))
DROP TABLE [dbo].[TipoFuncionario]
GO
/****** Object:  Table [dbo].[Estabelecimento]    Script Date: 09/22/2007 16:20:19 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Estabelecimento]') AND type in (N'U'))
DROP TABLE [dbo].[Estabelecimento]
GO
/****** Object:  Table [dbo].[TipoCliente]    Script Date: 09/22/2007 16:20:19 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoCliente]') AND type in (N'U'))
DROP TABLE [dbo].[TipoCliente]
GO
/****** Object:  Table [dbo].[Identificacao]    Script Date: 09/22/2007 16:20:21 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Identificacao]') AND type in (N'U'))
DROP TABLE [dbo].[Identificacao]
GO
/****** Object:  Table [dbo].[TipoIdentificacao]    Script Date: 09/22/2007 16:20:18 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoIdentificacao]') AND type in (N'U'))
DROP TABLE [dbo].[TipoIdentificacao]
GO
/****** Object:  Table [dbo].[Cardapio]    Script Date: 09/22/2007 16:20:22 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cardapio]') AND type in (N'U'))
DROP TABLE [dbo].[Cardapio]
GO
USE [master]
GO
/****** Object:  Login [NT AUTHORITY\SYSTEM]    Script Date: 09/22/2007 16:20:18 ******/
IF  EXISTS (SELECT * FROM sys.server_principals WHERE name = N'NT AUTHORITY\SYSTEM')
DROP LOGIN [NT AUTHORITY\SYSTEM]
GO
/****** Object:  Login [STEIGERT\SQLServer2005MSSQLUser$STEIGERT$SQLEXPRESS]    Script Date: 09/22/2007 16:20:18 ******/
IF  EXISTS (SELECT * FROM sys.server_principals WHERE name = N'STEIGERT\SQLServer2005MSSQLUser$STEIGERT$SQLEXPRESS')
DROP LOGIN [STEIGERT\SQLServer2005MSSQLUser$STEIGERT$SQLEXPRESS]
GO
/****** Object:  Login [BUILTIN\Users]    Script Date: 09/22/2007 16:20:18 ******/
IF  EXISTS (SELECT * FROM sys.server_principals WHERE name = N'BUILTIN\Users')
DROP LOGIN [BUILTIN\Users]
GO
/****** Object:  Login [BUILTIN\Administrators]    Script Date: 09/22/2007 16:20:18 ******/
IF  EXISTS (SELECT * FROM sys.server_principals WHERE name = N'BUILTIN\Administrators')
DROP LOGIN [BUILTIN\Administrators]
GO
/****** Object:  Login [NT AUTHORITY\SYSTEM]    Script Date: 09/22/2007 16:20:18 ******/
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = N'NT AUTHORITY\SYSTEM')
CREATE LOGIN [NT AUTHORITY\SYSTEM] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [STEIGERT\SQLServer2005MSSQLUser$STEIGERT$SQLEXPRESS]    Script Date: 09/22/2007 16:20:18 ******/
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = N'STEIGERT\SQLServer2005MSSQLUser$STEIGERT$SQLEXPRESS')
CREATE LOGIN [STEIGERT\SQLServer2005MSSQLUser$STEIGERT$SQLEXPRESS] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [BUILTIN\Users]    Script Date: 09/22/2007 16:20:18 ******/
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = N'BUILTIN\Users')
CREATE LOGIN [BUILTIN\Users] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
/****** Object:  Login [BUILTIN\Administrators]    Script Date: 09/22/2007 16:20:18 ******/
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = N'BUILTIN\Administrators')
CREATE LOGIN [BUILTIN\Administrators] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english]
GO
USE [TccPuc2007]
GO
/****** Object:  Table [dbo].[TipoIdentificacao]    Script Date: 09/22/2007 16:20:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoIdentificacao]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[TipoIdentificacao](
	[tipoIdentificacaoID] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK_TipoIdentificacao] PRIMARY KEY CLUSTERED 
(
	[tipoIdentificacaoID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TipoCliente]    Script Date: 09/22/2007 16:20:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoCliente]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[TipoCliente](
	[tipoClienteID] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK_TipoCliente] PRIMARY KEY CLUSTERED 
(
	[tipoClienteID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TipoFuncionario]    Script Date: 09/22/2007 16:20:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoFuncionario]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[TipoFuncionario](
	[tipoFuncionarioID] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK_TipoFuncionario] PRIMARY KEY CLUSTERED 
(
	[tipoFuncionarioID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Conta]    Script Date: 09/22/2007 16:20:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Conta]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Conta](
	[contaID] [int] IDENTITY(1,1) NOT NULL,
	[observacao] [text] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK_Conta] PRIMARY KEY CLUSTERED 
(
	[contaID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Estabelecimento]    Script Date: 09/22/2007 16:20:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Estabelecimento]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Estabelecimento](
	[estabelecimentoID] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK_Estabelecimento] PRIMARY KEY CLUSTERED 
(
	[estabelecimentoID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemPedido]    Script Date: 09/22/2007 16:20:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemPedido]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemPedido](
	[itemPedidoID] [int] IDENTITY(1,1) NOT NULL,
	[quantidade] [int] NOT NULL,
	[itemCardapioID] [int] NOT NULL,
	[pedidoID] [int] NOT NULL,
 CONSTRAINT [PK_ItemPedido] PRIMARY KEY CLUSTERED 
(
	[itemPedidoID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 09/22/2007 16:20:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cliente]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Cliente](
	[clienteID] [int] IDENTITY(1,1) NOT NULL,
	[contaID] [int] NOT NULL,
	[identificacaoID] [int] NOT NULL,
	[nome] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[estabelecimentoID] [int] NOT NULL,
	[clienteMesaID] [int] NULL,
	[tipoClienteID] [int] NOT NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[clienteID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Identificacao]    Script Date: 09/22/2007 16:20:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Identificacao]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Identificacao](
	[identificacaoID] [int] IDENTITY(1,1) NOT NULL,
	[numeroMesa] [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[info] [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[tipoIdentificacaoID] [int] NOT NULL,
 CONSTRAINT [PK_Identificacao] PRIMARY KEY CLUSTERED 
(
	[identificacaoID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[ItemCardapio]    Script Date: 09/22/2007 16:20:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemCardapio]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemCardapio](
	[itemCardapioID] [int] IDENTITY(1,1) NOT NULL,
	[preco] [numeric](10, 2) NOT NULL,
	[nome] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[descricao] [text] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[cardapioID] [int] NOT NULL,
 CONSTRAINT [PK_ItemCardapio] PRIMARY KEY CLUSTERED 
(
	[itemCardapioID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Funcionario]    Script Date: 09/22/2007 16:20:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Funcionario]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Funcionario](
	[funcionarioID] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[tipoFuncionarioID] [int] NOT NULL,
	[estabelecimentoID] [int] NOT NULL,
 CONSTRAINT [PK_Funcionario] PRIMARY KEY CLUSTERED 
(
	[funcionarioID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Pedido]    Script Date: 09/22/2007 16:20:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Pedido]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Pedido](
	[pedidoID] [int] IDENTITY(1,1) NOT NULL,
	[contaID] [int] NOT NULL,
 CONSTRAINT [PK_Pedido] PRIMARY KEY CLUSTERED 
(
	[pedidoID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Cardapio]    Script Date: 09/22/2007 16:20:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cardapio]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Cardapio](
	[cardapioID] [int] IDENTITY(1,1) NOT NULL,
	[estabelecimentoID] [int] NOT NULL,
 CONSTRAINT [PK_Cardapio] PRIMARY KEY CLUSTERED 
(
	[cardapioID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  ForeignKey [FK_ItemPedido_ItemCardapio]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPedido_ItemCardapio]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPedido]'))
ALTER TABLE [dbo].[ItemPedido]  WITH CHECK ADD  CONSTRAINT [FK_ItemPedido_ItemCardapio] FOREIGN KEY([itemCardapioID])
REFERENCES [dbo].[ItemCardapio] ([itemCardapioID])
GO
ALTER TABLE [dbo].[ItemPedido] CHECK CONSTRAINT [FK_ItemPedido_ItemCardapio]
GO
/****** Object:  ForeignKey [FK_ItemPedido_Pedido]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPedido_Pedido]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPedido]'))
ALTER TABLE [dbo].[ItemPedido]  WITH CHECK ADD  CONSTRAINT [FK_ItemPedido_Pedido] FOREIGN KEY([pedidoID])
REFERENCES [dbo].[Pedido] ([pedidoID])
GO
ALTER TABLE [dbo].[ItemPedido] CHECK CONSTRAINT [FK_ItemPedido_Pedido]
GO
/****** Object:  ForeignKey [FK_Cliente_Cliente]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Cliente]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_Cliente] FOREIGN KEY([clienteMesaID])
REFERENCES [dbo].[Cliente] ([clienteID])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_Cliente]
GO
/****** Object:  ForeignKey [FK_Cliente_Conta]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Conta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_Conta] FOREIGN KEY([contaID])
REFERENCES [dbo].[Conta] ([contaID])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_Conta]
GO
/****** Object:  ForeignKey [FK_Cliente_Estabelecimento]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Estabelecimento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_Estabelecimento] FOREIGN KEY([estabelecimentoID])
REFERENCES [dbo].[Estabelecimento] ([estabelecimentoID])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_Estabelecimento]
GO
/****** Object:  ForeignKey [FK_Cliente_Identificacao]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_Identificacao]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_Identificacao] FOREIGN KEY([identificacaoID])
REFERENCES [dbo].[Identificacao] ([identificacaoID])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_Identificacao]
GO
/****** Object:  ForeignKey [FK_Cliente_TipoCliente]    Script Date: 09/22/2007 16:20:20 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_TipoCliente]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_TipoCliente] FOREIGN KEY([tipoClienteID])
REFERENCES [dbo].[TipoCliente] ([tipoClienteID])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_TipoCliente]
GO
/****** Object:  ForeignKey [FK_Identificacao_TipoIdentificacao]    Script Date: 09/22/2007 16:20:21 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Identificacao_TipoIdentificacao]') AND parent_object_id = OBJECT_ID(N'[dbo].[Identificacao]'))
ALTER TABLE [dbo].[Identificacao]  WITH CHECK ADD  CONSTRAINT [FK_Identificacao_TipoIdentificacao] FOREIGN KEY([tipoIdentificacaoID])
REFERENCES [dbo].[TipoIdentificacao] ([tipoIdentificacaoID])
GO
ALTER TABLE [dbo].[Identificacao] CHECK CONSTRAINT [FK_Identificacao_TipoIdentificacao]
GO
/****** Object:  ForeignKey [FK_ItemCardapio_Cardapio]    Script Date: 09/22/2007 16:20:21 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemCardapio_Cardapio]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemCardapio]'))
ALTER TABLE [dbo].[ItemCardapio]  WITH CHECK ADD  CONSTRAINT [FK_ItemCardapio_Cardapio] FOREIGN KEY([cardapioID])
REFERENCES [dbo].[Cardapio] ([cardapioID])
GO
ALTER TABLE [dbo].[ItemCardapio] CHECK CONSTRAINT [FK_ItemCardapio_Cardapio]
GO
/****** Object:  ForeignKey [FK_Funcionario_Estabelecimento]    Script Date: 09/22/2007 16:20:22 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Funcionario_Estabelecimento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Funcionario]'))
ALTER TABLE [dbo].[Funcionario]  WITH CHECK ADD  CONSTRAINT [FK_Funcionario_Estabelecimento] FOREIGN KEY([estabelecimentoID])
REFERENCES [dbo].[Estabelecimento] ([estabelecimentoID])
GO
ALTER TABLE [dbo].[Funcionario] CHECK CONSTRAINT [FK_Funcionario_Estabelecimento]
GO
/****** Object:  ForeignKey [FK_Funcionario_TipoFuncionario]    Script Date: 09/22/2007 16:20:22 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Funcionario_TipoFuncionario]') AND parent_object_id = OBJECT_ID(N'[dbo].[Funcionario]'))
ALTER TABLE [dbo].[Funcionario]  WITH CHECK ADD  CONSTRAINT [FK_Funcionario_TipoFuncionario] FOREIGN KEY([tipoFuncionarioID])
REFERENCES [dbo].[TipoFuncionario] ([tipoFuncionarioID])
GO
ALTER TABLE [dbo].[Funcionario] CHECK CONSTRAINT [FK_Funcionario_TipoFuncionario]
GO
/****** Object:  ForeignKey [FK_Pedido_Conta]    Script Date: 09/22/2007 16:20:22 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Pedido_Conta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Pedido]'))
ALTER TABLE [dbo].[Pedido]  WITH CHECK ADD  CONSTRAINT [FK_Pedido_Conta] FOREIGN KEY([contaID])
REFERENCES [dbo].[Conta] ([contaID])
GO
ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [FK_Pedido_Conta]
GO
/****** Object:  ForeignKey [FK_Cardapio_Estabelecimento]    Script Date: 09/22/2007 16:20:22 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cardapio_Estabelecimento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cardapio]'))
ALTER TABLE [dbo].[Cardapio]  WITH CHECK ADD  CONSTRAINT [FK_Cardapio_Estabelecimento] FOREIGN KEY([estabelecimentoID])
REFERENCES [dbo].[Estabelecimento] ([estabelecimentoID])
GO
ALTER TABLE [dbo].[Cardapio] CHECK CONSTRAINT [FK_Cardapio_Estabelecimento]
GO
