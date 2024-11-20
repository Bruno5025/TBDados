package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarContaGUI extends JFrame {
    private JTextField numeroContaField;
    private JTextField limiteField;
    private JTextField dataVencimentoField;
    private JButton alterarButton;
    private JButton voltarButton;

    public AlterarContaGUI() {
        setTitle("Alterar Conta - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(47, 47, 47)); // Fundo cinza escuro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Alterar Conta");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        // Campo Número da Conta
        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        numeroContaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(numeroContaLabel, gbc);

        numeroContaField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(numeroContaField, gbc);

        // Campo Limite
        JLabel limiteLabel = new JLabel("Novo Limite:");
        limiteLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(limiteLabel, gbc);

        limiteField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(limiteField, gbc);

        // Campo Data de Vencimento
        JLabel dataVencimentoLabel = new JLabel("Nova Data de Vencimento:");
        dataVencimentoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dataVencimentoLabel, gbc);

        dataVencimentoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(dataVencimentoField, gbc);

        // Botão Alterar
        alterarButton = new JButton("Alterar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(alterarButton, gbc);

        // Botão Voltar
        voltarButton = new JButton("Voltar");
        gbc.gridy = 5;
        add(voltarButton, gbc);

        // Ações dos botões
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder: Lógica para alterar os dados da conta
                JOptionPane.showMessageDialog(null, "Dados da conta alterados com sucesso!");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionarioMenuGUI().setVisible(true); // Volta para o menu do funcionário
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlterarContaGUI().setVisible(true);
        });
    }
}
