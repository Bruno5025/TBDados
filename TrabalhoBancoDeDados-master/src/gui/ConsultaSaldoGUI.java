package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.ConnectionFactory;

public class ConsultaSaldoGUI extends JFrame {
    private JTextField numeroContaField;
    private JTextArea resultadoArea;
    private JButton consultarButton;
    private JButton voltarButton;

    public ConsultaSaldoGUI() {
        setTitle("Banco Malvader - Consultar Saldo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior para o título
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(new Color(47, 47, 47));
        JLabel tituloLabel = new JLabel("Consultar Saldo");
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloPanel.add(tituloLabel);
        add(tituloPanel, BorderLayout.NORTH);

        // Painel central para o formulário
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridBagLayout());
        formularioPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        numeroContaLabel.setForeground(Color.WHITE);
        numeroContaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formularioPanel.add(numeroContaLabel, gbc);

        numeroContaField = new JTextField(20);
        gbc.gridx = 1;
        formularioPanel.add(numeroContaField, gbc);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formularioPanel.add(scrollPane, gbc);

        add(formularioPanel, BorderLayout.CENTER);

        // Painel inferior para os botões
        JPanel botoesPanel = new JPanel();
        botoesPanel.setBackground(Color.DARK_GRAY);

        consultarButton = new JButton("Consultar");
        consultarButton.setPreferredSize(new Dimension(120, 30));
        botoesPanel.add(consultarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 30));
        botoesPanel.add(voltarButton);

        add(botoesPanel, BorderLayout.SOUTH);

        // Ação do botão Consultar
        consultarButton.addActionListener(e -> consultarSaldo());

        // Ação do botão Voltar
        voltarButton.addActionListener(e -> {
            new ClienteMenuGUI().setVisible(true);
            dispose();
        });
    }

    private void consultarSaldo() {
        String numeroConta = numeroContaField.getText();

        if (numeroConta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o número da conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "SELECT saldo FROM Conta WHERE numero_conta = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, numeroConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double saldo = rs.getDouble("saldo");
                resultadoArea.setText("Saldo da conta " + numeroConta + ": R$ " + saldo);
            } else {
                resultadoArea.setText("Conta não encontrada.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar saldo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultaSaldoGUI gui = new ConsultaSaldoGUI();
            gui.setVisible(true);
        });
    }
}
