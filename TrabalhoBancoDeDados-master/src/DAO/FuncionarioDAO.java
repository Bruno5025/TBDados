package DAO;

import models.Funcionario;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void adicionarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (codigo_funcionario, cargo, id_usuario) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getCodigoFuncionario());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, funcionario.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listarFuncionarios() {
        String sql = "SELECT * FROM Funcionario";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("codigo_funcionario"),
                        rs.getString("cargo"),
                        rs.getInt("id_usuario")
                );
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage());
        }

        return funcionarios;
    }

    public Funcionario buscarFuncionarioPorId(int idFuncionario) {
        String sql = "SELECT * FROM Funcionario WHERE id_funcionario = ?";
        Funcionario funcionario = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("codigo_funcionario"),
                        rs.getString("cargo"),
                        rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário: " + e.getMessage());
        }

        return funcionario;
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET codigo_funcionario = ?, cargo = ?, id_usuario = ? WHERE id_funcionario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getCodigoFuncionario());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, funcionario.getIdUsuario());
            stmt.setInt(4, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    public void excluirFuncionario(int idFuncionario) {
        String sql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir funcionário: " + e.getMessage());
        }
    }
}
