package DAO;

import models.Cliente;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void adicionarCliente(Cliente cliente) {
        // Verifica se o id_usuario existe na tabela Usuario
        if (!usuarioExiste(cliente.getIdUsuario())) {
            throw new RuntimeException("Usuário não encontrado, id_usuario: " + cliente.getIdUsuario());
        }

        String sql = "INSERT INTO Cliente (id_usuario) VALUES (?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cliente.getIdUsuario());
            stmt.executeUpdate();
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar cliente: " + e.getMessage(), e);
        }
    }

    // Verifica se o usuário existe antes de adicionar um cliente
    private boolean usuarioExiste(int idUsuario) {
        String sql = "SELECT COUNT(*) FROM Usuario WHERE id_usuario = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se o id_usuario existir
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar existência do usuário: " + e.getMessage(), e);
        }
        return false;
    }

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getInt("id_usuario")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public Cliente buscarClientePorId(int idCliente) {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        Cliente cliente = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
        }
        return cliente;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET id_usuario = ? WHERE id_cliente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getIdUsuario());
            stmt.setInt(2, cliente.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void excluirCliente(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente: " + e.getMessage());
        }
    }
}
