package DAO;

import models.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainDAOTest {
    public static void main(String[] args) {
        try {
            System.out.println("=== Testando Conexões com DAOs ===");

            // Teste UsuarioDAO (adicionar usuário)
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            String cpfCliente = "12345678901";
            Usuario usuarioCliente = new Usuario("João Silva", cpfCliente, Date.valueOf("1990-05-15"), "123456789", "CLIENTE", "senha123");

            // Verificar se o CPF já existe
            if (!usuarioDAO.cpfExistente(cpfCliente)) {
                usuarioDAO.adicionarUsuario(usuarioCliente);
                System.out.println("Usuário Cliente adicionado com sucesso!");
            } else {
                System.out.println("CPF já cadastrado: " + cpfCliente);
                return; // Interrompe o teste se o CPF já estiver cadastrado
            }

            // Teste ClienteDAO (adicionar cliente)
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = new Cliente(usuarioCliente.getIdUsuario());
            clienteDAO.adicionarCliente(cliente);
            System.out.println("Cliente adicionado com sucesso!");

            // Teste FuncionarioDAO (adicionar funcionário)
            Usuario usuarioFuncionario = new Usuario("Maria Oliveira", "98765432100", Date.valueOf("1985-08-20"), "987654321", "FUNCIONARIO", "senha456");
            if (!usuarioDAO.cpfExistente(usuarioFuncionario.getCpf())) {
                usuarioDAO.adicionarUsuario(usuarioFuncionario); // Adicionar usuário
                System.out.println("Usuário Funcionario adicionado com sucesso!");
            } else {
                System.out.println("CPF já cadastrado: " + usuarioFuncionario.getCpf());
                return; // Interrompe o teste se o CPF já estiver cadastrado
            }

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Funcionario funcionario = new Funcionario("FUNC001", "Gerente", usuarioFuncionario.getIdUsuario());
            funcionarioDAO.adicionarFuncionario(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");

            // Teste RelatorioDAO (adicionar relatório)
            RelatorioDAO relatorioDAO = new RelatorioDAO();
            Relatorio relatorio = new Relatorio("Relatório Geral", LocalDateTime.now(), "Movimentações financeiras detalhadas", funcionario.getIdFuncionario());
            relatorioDAO.adicionarRelatorio(relatorio);
            System.out.println("Relatório gerado com sucesso!");

            // Teste ContaDAO (adicionar conta)
            ContaDAO contaDAO = new ContaDAO();
            Conta conta = new Conta("123456", "001", 1000.00, "POUPANCA", cliente.getIdUsuario());
            contaDAO.adicionarConta(conta);
            System.out.println("Conta Poupança adicionada com sucesso!");

            // Teste ContaCorrenteDAO (adicionar conta corrente)
            ContaCorrenteDAO contaCorrenteDAO = new ContaCorrenteDAO();
            ContaCorrente contaCorrente = new ContaCorrente(2000.00, LocalDate.parse("2024-12-31"), conta.getIdConta());
            contaCorrenteDAO.adicionarContaCorrente(contaCorrente);
            System.out.println("Conta Corrente adicionada com sucesso!");

            // Teste ContaPoupancaDAO (adicionar conta poupança)
            ContaPoupancaDAO contaPoupancaDAO = new ContaPoupancaDAO();
            ContaPoupanca contaPoupanca = new ContaPoupanca(0.5, conta.getIdConta());
            contaPoupancaDAO.adicionarContaPoupanca(contaPoupanca);
            System.out.println("Conta Poupança adicionada com sucesso!");

            // Teste TransacaoDAO (adicionar transação)
            TransacaoDAO transacaoDAO = new TransacaoDAO();
            Transacao transacao = new Transacao("DEPOSITO", 500.00, conta.getIdConta());
            transacaoDAO.adicionarTransacao(transacao);
            System.out.println("Transação realizada com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro durante os testes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
