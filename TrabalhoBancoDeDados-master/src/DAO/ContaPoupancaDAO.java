package DAO;

import models.ContaPoupanca;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaPoupancaDAO {

    public void adicionarContaPoupanca(ContaPoupanca contaPoupanca) {
        String sql = "INSERT INTO ContaPoupanca (taxa_rendimento, id_conta) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, contaPoupanca.getTaxaRendimento());
            stmt.setInt(2, contaPoupanca.getIdConta());

            stmt.executeUpdate();
            System.out.println("Conta Poupança adicionada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar Conta Poupança: ", e);
        }
    }

    public List<ContaPoupanca> listarContasPoupancas() {
        String sql = "SELECT * FROM ContaPoupanca";
        List<ContaPoupanca> contasPoupanca = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ContaPoupanca conta = new ContaPoupanca(
                        rs.getInt("id_conta_poupanca"),
                        rs.getDouble("taxa_rendimento"),
                        rs.getInt("id_conta")
                );
                contasPoupanca.add(conta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Contas Poupança: ", e);
        }
        return contasPoupanca;
    }

    public void atualizarContaPoupanca(ContaPoupanca contaPoupanca) {
        String sql = "UPDATE ContaPoupanca SET taxa_rendimento = ? WHERE id_conta_poupanca = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, contaPoupanca.getTaxaRendimento());
            stmt.setInt(2, contaPoupanca.getIdContaPoupanca());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Conta Poupança: ", e);
        }
    }

    public void excluirContaPoupanca(int id) {
        String sql = "DELETE FROM ContaPoupanca WHERE id_conta_poupanca = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Conta Poupança: ", e);
        }
    }
}
