package DAO;

import models.Relatorio;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO {

    public void adicionarRelatorio(Relatorio relatorio) {
        String sql = "INSERT INTO relatorio (tipo_relatorio, data_geracao, conteudo, id_funcionario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, relatorio.getTipoRelatorio());
            stmt.setTimestamp(2, Timestamp.valueOf(relatorio.getDataGeracao()));
            stmt.setString(3, relatorio.getConteudo());
            stmt.setInt(4, relatorio.getIdFuncionario());

            stmt.executeUpdate();
            System.out.println("Relatório gerado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar relatório: ", e);
        }
    }

    public List<Relatorio> listarRelatorios() {
        String sql = "SELECT * FROM relatorio";
        List<Relatorio> relatorios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Relatorio relatorio = new Relatorio(
                        rs.getInt("id_relatorio"),
                        rs.getString("tipo_relatorio"),
                        rs.getTimestamp("data_geracao").toLocalDateTime(),
                        rs.getString("conteudo"),
                        rs.getInt("id_funcionario")
                );
                relatorios.add(relatorio);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar relatórios: ", e);
        }
        return relatorios;
    }

    public Relatorio buscarRelatorioPorId(int id) {
        String sql = "SELECT * FROM relatorio WHERE id_relatorio = ?";
        Relatorio relatorio = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                relatorio = new Relatorio(
                        rs.getInt("id_relatorio"),
                        rs.getString("tipo_relatorio"),
                        rs.getTimestamp("data_geracao").toLocalDateTime(),
                        rs.getString("conteudo"),
                        rs.getInt("id_funcionario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar relatório: ", e);
        }

        return relatorio;
    }
}
