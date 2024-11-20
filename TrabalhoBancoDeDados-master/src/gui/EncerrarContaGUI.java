package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.ConnectionFactory;

public class EncerrarContaGUI extends JFrame {
    private JTextField numeroContaField;
    private JButton encerrarButton;
    private JButton voltarButton;

    public EncerrarContaGUI() {
        setTitle("Encerrar Conta - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(new Color(47, 47, 47));

        // Painel central
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridBagLayout());
        painelCentral.setBackground(new Color(47, 47, 47));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        numeroContaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        painelCentral.add(numeroContaLabel, gbc);

        numeroContaField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        painelCentral.add(numeroContaField, gbc);

        painel.add(painelCentral, BorderLayout.CENTER);

        // Painel inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(new Color(47, 47, 47));
        encerrarButton = new JButton("Encerrar Conta");
        voltarButton = new JButton("Voltar");

        painelInferior.add(encerrarButton);
        painelInferior.add(voltarButton);

        painel.add(painelInferior, BorderLayout.SOUTH);

        // Ações dos botões
        encerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarConta();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioMenuGUI().setVisible(true); // Ajuste conforme necessário
            }
        });

        add(painel);
    }

    private void encerrarConta() {
        String numeroConta = numeroContaField.getText().trim();

        if (numeroConta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o número da conta!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "DELETE FROM Conta WHERE numero_conta = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, numeroConta);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Conta encerrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                numeroContaField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Conta não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao encerrar a conta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EncerrarContaGUI().setVisible(true);
        });
    }
}
