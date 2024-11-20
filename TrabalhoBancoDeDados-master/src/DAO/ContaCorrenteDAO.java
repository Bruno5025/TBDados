package DAO;

import models.ContaCorrente;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteDAO {

    public void adicionarContaCorrente(ContaCorrente contaCorrente) {
        String sql = "INSERT INTO ContaCorrente (limite, data_vencimento, id_conta) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, contaCorrente.getLimite());
            stmt.setDate(2, Date.valueOf(contaCorrente.getDataVencimento()));
            stmt.setInt(3, contaCorrente.getIdConta());

            stmt.executeUpdate();
            System.out.println("Conta Corrente adicionada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar Conta Corrente: " + e.getMessage(), e);
        }
    }

    public List<ContaCorrente> listarContasCorrentes() {
        String sql = "SELECT * FROM ContaCorrente";
        List<ContaCorrente> contasCorrentes = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ContaCorrente contaCorrente = new ContaCorrente(
                        rs.getInt("id_conta_corrente"),
                        rs.getDouble("limite"),
                        rs.getDate("data_vencimento").toLocalDate(),
                        rs.getInt("id_conta")
                );
                contasCorrentes.add(contaCorrente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Contas Correntes: " + e.getMessage(), e);
        }
        return contasCorrentes;
    }

    public ContaCorrente buscarContaCorrentePorId(int idContaCorrente) {
        String sql = "SELECT * FROM ContaCorrente WHERE id_conta_corrente = ?";
        ContaCorrente contaCorrente = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContaCorrente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contaCorrente = new ContaCorrente(
                        rs.getInt("id_conta_corrente"),
                        rs.getDouble("limite"),
                        rs.getDate("data_vencimento").toLocalDate(),
                        rs.getInt("id_conta")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Conta Corrente: " + e.getMessage(), e);
        }
        return contaCorrente;
    }

    public void atualizarContaCorrente(ContaCorrente contaCorrente) {
        String sql = "UPDATE ContaCorrente SET limite = ?, data_vencimento = ? WHERE id_conta_corrente = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, contaCorrente.getLimite());
            stmt.setDate(2, Date.valueOf(contaCorrente.getDataVencimento()));
            stmt.setInt(3, contaCorrente.getIdContaCorrente());

            stmt.executeUpdate();
            System.out.println("Conta Corrente atualizada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Conta Corrente: " + e.getMessage(), e);
        }
    }

    public void excluirContaCorrente(int idContaCorrente) {
        String sql = "DELETE FROM ContaCorrente WHERE id_conta_corrente = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContaCorrente);

            stmt.executeUpdate();
            System.out.println("Conta Corrente excluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Conta Corrente: " + e.getMessage(), e);
        }
    }
}
