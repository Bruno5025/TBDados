package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.ConnectionFactory;

public class DepositoGUI extends JFrame {
    private JTextField numeroContaField;
    private JTextField valorField;
    private JButton depositarButton;
    private JButton voltarButton;

    public DepositoGUI() {
        setTitle("Banco Malvader - Depósito");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(new Color(47, 47, 47));
        JLabel tituloLabel = new JLabel("Depósito");
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloPanel.add(tituloLabel);
        add(tituloPanel, BorderLayout.NORTH);

        // Painel central
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

        JLabel valorLabel = new JLabel("Valor do Depósito:");
        valorLabel.setForeground(Color.WHITE);
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formularioPanel.add(valorLabel, gbc);

        valorField = new JTextField(20);
        gbc.gridx = 1;
        formularioPanel.add(valorField, gbc);

        add(formularioPanel, BorderLayout.CENTER);

        // Painel inferior
        JPanel botoesPanel = new JPanel();
        botoesPanel.setBackground(Color.DARK_GRAY);

        depositarButton = new JButton("Depositar");
        depositarButton.setPreferredSize(new Dimension(120, 30));
        botoesPanel.add(depositarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.setPreferredSize(new Dimension(120, 30));
        botoesPanel.add(voltarButton);

        add(botoesPanel, BorderLayout.SOUTH);

        // Ação do botão Depositar
        depositarButton.addActionListener(e -> realizarDeposito());

        // Ação do botão Voltar
        voltarButton.addActionListener(e -> {
            new ClienteMenuGUI().setVisible(true);
            dispose();
        });
    }

    private void realizarDeposito() {
        String numeroConta = numeroContaField.getText();
        String valorTexto = valorField.getText();

        if (numeroConta.isEmpty() || valorTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double valor = Double.parseDouble(valorTexto);
            String sql = "UPDATE Conta SET saldo = saldo + ? WHERE numero_conta = ?";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setDouble(1, valor);
                stmt.setString(2, numeroConta);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao realizar depósito: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DepositoGUI gui = new DepositoGUI();
            gui.setVisible(true);
        });
    }
}
