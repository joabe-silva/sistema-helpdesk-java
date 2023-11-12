-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Nov-2023 às 00:39
-- Versão do servidor: 10.4.28-MariaDB
-- versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `helpdesk`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `def_nivel_prioridade`
--

CREATE TABLE `def_nivel_prioridade` (
  `ID` int(11) NOT NULL,
  `DESCRICAO` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `def_nivel_prioridade`
--

INSERT INTO `def_nivel_prioridade` (`ID`, `DESCRICAO`) VALUES
(1, 'ALTO'),
(2, 'MEDIO'),
(3, 'BAIXO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `def_situacao`
--

CREATE TABLE `def_situacao` (
  `ID` int(11) NOT NULL,
  `DESCRICAO` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `def_situacao`
--

INSERT INTO `def_situacao` (`ID`, `DESCRICAO`) VALUES
(1, 'PENDENTE'),
(2, 'EM ANALISE'),
(3, 'AGUARDANDO RETORNO'),
(4, 'CONCLUIDO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticket`
--

CREATE TABLE `ticket` (
  `ID` int(11) NOT NULL,
  `ID_TECNICO` int(11) DEFAULT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `ID_NIVEL` int(11) DEFAULT NULL,
  `ID_SITUACAO` int(11) DEFAULT NULL,
  `DATA_ABERTURA` datetime DEFAULT current_timestamp(),
  `DATA_FECHAMENTO` datetime DEFAULT NULL,
  `TITULO` varchar(45) NOT NULL,
  `DESCRICAO` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `ticket`
--

INSERT INTO `ticket` (`ID`, `ID_TECNICO`, `ID_CLIENTE`, `ID_NIVEL`, `ID_SITUACAO`, `DATA_ABERTURA`, `DATA_FECHAMENTO`, `TITULO`, `DESCRICAO`) VALUES
(1, 1, 2, 3, 1, '2023-11-05 23:37:45', NULL, 'IMPRESSORA MANCHANDO IMPRESSÕES', 'IMPRESSORA DO SETOR COMERCIAL DESDE SEXTA FEIRA ESTÁ MANCHANDO AS IMPRESSÕES.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticket_comentario`
--

CREATE TABLE `ticket_comentario` (
  `ID` int(11) NOT NULL,
  `ID_TICKET` int(11) DEFAULT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `DATA_COMENTARIO` datetime DEFAULT current_timestamp(),
  `DESCRICAO` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL,
  `USUARIO` varchar(40) NOT NULL,
  `SENHA` varchar(60) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `PERFIL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`ID`, `USUARIO`, `SENHA`, `NOME`, `PERFIL`) VALUES
(1, 'JOABE', '123456', 'JOABE SILVA', 1),
(2, 'IVAN', '123456', 'IVANILSON', 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `def_nivel_prioridade`
--
ALTER TABLE `def_nivel_prioridade`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `def_situacao`
--
ALTER TABLE `def_situacao`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_TECNICO` (`ID_TECNICO`),
  ADD KEY `ID_CLIENTE` (`ID_CLIENTE`),
  ADD KEY `ID_NIVEL` (`ID_NIVEL`),
  ADD KEY `ID_SITUACAO` (`ID_SITUACAO`);

--
-- Índices para tabela `ticket_comentario`
--
ALTER TABLE `ticket_comentario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_TICKET` (`ID_TICKET`),
  ADD KEY `ID_USUARIO` (`ID_USUARIO`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `def_nivel_prioridade`
--
ALTER TABLE `def_nivel_prioridade`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `def_situacao`
--
ALTER TABLE `def_situacao`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `ticket_comentario`
--
ALTER TABLE `ticket_comentario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`ID_TECNICO`) REFERENCES `usuario` (`ID`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `usuario` (`ID`),
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`ID_NIVEL`) REFERENCES `def_nivel_prioridade` (`ID`),
  ADD CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`ID_SITUACAO`) REFERENCES `def_situacao` (`ID`);

--
-- Limitadores para a tabela `ticket_comentario`
--
ALTER TABLE `ticket_comentario`
  ADD CONSTRAINT `ticket_comentario_ibfk_1` FOREIGN KEY (`ID_TICKET`) REFERENCES `ticket` (`ID`),
  ADD CONSTRAINT `ticket_comentario_ibfk_2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
