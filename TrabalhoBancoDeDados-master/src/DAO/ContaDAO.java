package DAO;

import models.Conta;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void adicionarConta(Conta conta) {
        String sql = "INSERT INTO conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNumeroConta());
            stmt.setString(2, conta.getAgencia());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getTipoConta());
            stmt.setInt(5, conta.getIdCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar conta: ", e);
        }
    }

    public List<Conta> listarContas() {
        String sql = "SELECT * FROM conta";
        List<Conta> contas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("id_conta"),
                        rs.getString("numero_conta"),
                        rs.getString("agencia"),
                        rs.getDouble("saldo"),
                        rs.getString("tipo_conta"),
                        rs.getInt("id_cliente")
                );
                contas.add(conta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar contas: ", e);
        }
        return contas;
    }

    public Conta buscarContaPorId(int idConta) {
        String sql = "SELECT * FROM conta WHERE id_conta = ?";
        Conta conta = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                conta = new Conta(
                        rs.getInt("id_conta"),
                        rs.getString("numero_conta"),
                        rs.getString("agencia"),
                        rs.getDouble("saldo"),
                        rs.getString("tipo_conta"),
                        rs.getInt("id_cliente")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar conta: ", e);
        }

        return conta;
    }

    public void atualizarConta(Conta conta) {
        String sql = "UPDATE conta SET numero_conta = ?, agencia = ?, saldo = ?, tipo_conta = ?, id_cliente = ? WHERE id_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNumeroConta());
            stmt.setString(2, conta.getAgencia());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getTipoConta());
            stmt.setInt(5, conta.getIdCliente());
            stmt.setInt(6, conta.getIdConta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar conta: ", e);
        }
    }

    public void excluirConta(int idConta) {
        String sql = "DELETE FROM conta WHERE id_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idConta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir conta: ", e);
        }
    }
}
