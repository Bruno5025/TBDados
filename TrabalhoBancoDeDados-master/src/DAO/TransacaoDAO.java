package DAO;

import models.Transacao;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    public void adicionarTransacao(Transacao transacao) {
        String sql = "INSERT INTO transacao (tipo_transacao, valor, data_hora, id_conta) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, transacao.getTipoTransacao());
            statement.setDouble(2, transacao.getValor());
            statement.setTimestamp(3, Timestamp.valueOf(transacao.getDataHora()));
            statement.setInt(4, transacao.getIdConta());

            statement.executeUpdate();
            System.out.println("Transação adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar transação: " + e.getMessage());
        }
    }

    public Transacao buscarTransacaoPorId(int id) {
        String sql = "SELECT * FROM transacao WHERE id_transacao = ?";
        Transacao transacao = null;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                transacao = new Transacao(
                        resultSet.getInt("id_transacao"),
                        resultSet.getString("tipo_transacao"),
                        resultSet.getDouble("valor"),
                        resultSet.getTimestamp("data_hora").toLocalDateTime(),
                        resultSet.getInt("id_conta")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar transação: " + e.getMessage());
        }

        return transacao;
    }

    public List<Transacao> listarTransacoes() {
        String sql = "SELECT * FROM transacao";
        List<Transacao> transacoes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Transacao transacao = new Transacao(
                        resultSet.getInt("id_transacao"),
                        resultSet.getString("tipo_transacao"),
                        resultSet.getDouble("valor"),
                        resultSet.getTimestamp("data_hora").toLocalDateTime(),
                        resultSet.getInt("id_conta")
                );
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar transações: " + e.getMessage());
        }

        return transacoes;
    }

    public void atualizarTransacao(Transacao transacao) {
        String sql = "UPDATE transacao SET tipo_transacao = ?, valor = ?, data_hora = ?, id_conta = ? WHERE id_transacao = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, transacao.getTipoTransacao());
            statement.setDouble(2, transacao.getValor());
            statement.setTimestamp(3, Timestamp.valueOf(transacao.getDataHora()));
            statement.setInt(4, transacao.getIdConta());
            statement.setInt(5, transacao.getId());

            statement.executeUpdate();
            System.out.println("Transação atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar transação: " + e.getMessage());
        }
    }

    public void excluirTransacao(int id) {
        String sql = "DELETE FROM transacao WHERE id_transacao = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println("Transação excluída com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir transação: " + e.getMessage());
        }
    }
}
