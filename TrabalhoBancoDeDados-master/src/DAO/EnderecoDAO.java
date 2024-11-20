package DAO;

import models.Endereco;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public void adicionarEndereco(Endereco endereco) {
        String sql = "INSERT INTO endereco (cep, local, numero_casa, bairro, cidade, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getLocal());
            stmt.setInt(3, endereco.getNumeroCasa());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setInt(7, endereco.getIdUsuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar endereço: " + e.getMessage(), e);
        }
    }

    public Endereco buscarEnderecoPorId(int idEndereco) {
        String sql = "SELECT * FROM endereco WHERE id_endereco = ?";
        Endereco endereco = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEndereco);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                endereco = new Endereco(
                        rs.getInt("id_endereco"),
                        rs.getString("cep"),
                        rs.getString("local"),
                        rs.getInt("numero_casa"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar endereço: " + e.getMessage(), e);
        }
        return endereco;
    }

    public List<Endereco> listarEnderecos() {
        String sql = "SELECT * FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Endereco endereco = new Endereco(
                        rs.getInt("id_endereco"),
                        rs.getString("cep"),
                        rs.getString("local"),
                        rs.getInt("numero_casa"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getInt("id_usuario")
                );
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar endereços: " + e.getMessage(), e);
        }
        return enderecos;
    }

    public void atualizarEndereco(Endereco endereco) {
        String sql = "UPDATE endereco SET cep = ?, local = ?, numero_casa = ?, bairro = ?, cidade = ?, estado = ?, id_usuario = ? WHERE id_endereco = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getLocal());
            stmt.setInt(3, endereco.getNumeroCasa());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setInt(7, endereco.getIdUsuario());
            stmt.setInt(8, endereco.getIdEndereco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar endereço: " + e.getMessage(), e);
        }
    }

    public void deletarEndereco(int idEndereco) {
        String sql = "DELETE FROM endereco WHERE id_endereco = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEndereco);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar endereço: " + e.getMessage(), e);
        }
    }
}
