package DAO;

import models.Usuario;
import utils.ConnectionFactory;
import java.sql.*;

public class UsuarioDAO {

    // Método para verificar se o CPF já existe
    public boolean cpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM Usuario WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar CPF: " + e.getMessage());
        }
        return false;
    }

    // Método para adicionar o usuário
    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setDate(3, usuario.getDataNascimento());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getTipoUsuario());
            stmt.setString(6, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar usuário: " + e.getMessage());
        }
    }
}
