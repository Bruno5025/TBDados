package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.ConnectionFactory;

public class RelatorioGUI extends JFrame {
    private JTextField tipoRelatorioField;
    private JTextArea resultadoArea;
    private JButton gerarButton;
    private JButton voltarButton;

    public RelatorioGUI() {
        setTitle("Gerar Relatório - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(new Color(47, 47, 47));

        // Painel superior
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.setBackground(new Color(47, 47, 47));

        JLabel tipoRelatorioLabel = new JLabel("Tipo de Relatório:");
        tipoRelatorioLabel.setForeground(Color.WHITE);
        painelSuperior.add(tipoRelatorioLabel);

        tipoRelatorioField = new JTextField(20);
        painelSuperior.add(tipoRelatorioField);

        gerarButton = new JButton("Gerar Relatório");
        painelSuperior.add(gerarButton);

        painel.add(painelSuperior, BorderLayout.NORTH);

        // Área de resultado
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setBackground(Color.DARK_GRAY);
        resultadoArea.setForeground(Color.WHITE);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        painel.add(scrollPane, BorderLayout.CENTER);

        // Painel inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(new Color(47, 47, 47));
        voltarButton = new JButton("Voltar");
        painelInferior.add(voltarButton);
        painel.add(painelInferior, BorderLayout.SOUTH);

        // Ação do botão Gerar
        gerarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarRelatorio();
            }
        });

        // Ação do botão Voltar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioMenuGUI().setVisible(true); // Ajuste conforme necessário
            }
        });

        add(painel);
    }

    private void gerarRelatorio() {
        String tipoRelatorio = tipoRelatorioField.getText().trim();

        if (tipoRelatorio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o tipo de relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "SELECT tipo_relatorio, data_geracao, conteudo FROM Relatorio WHERE tipo_relatorio = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, tipoRelatorio);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                StringBuilder resultado = new StringBuilder();
                resultado.append("Tipo: ").append(resultSet.getString("tipo_relatorio")).append("\n");
                resultado.append("Data de Geração: ").append(resultSet.getTimestamp("data_geracao")).append("\n");
                resultado.append("Conteúdo: ").append(resultSet.getString("conteudo")).append("\n");
                resultadoArea.setText(resultado.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum relatório encontrado para o tipo especificado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                resultadoArea.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RelatorioGUI().setVisible(true);
        });
    }
}
