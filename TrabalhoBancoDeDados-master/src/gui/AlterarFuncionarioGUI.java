package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarFuncionarioGUI extends JFrame {
    private JTextField codigoFuncionarioField;
    private JTextField cargoField;
    private JTextField telefoneField;
    private JTextField cepField;
    private JTextField localField;
    private JTextField numeroField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private JButton alterarButton;
    private JButton voltarButton;

    public AlterarFuncionarioGUI() {
        setTitle("Alterar Funcionário - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(47, 47, 47)); // Fundo cinza escuro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Alterar Funcionário");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        // Campo Código do Funcionário (Somente para busca)
        JLabel codigoLabel = new JLabel("Código do Funcionário:");
        codigoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(codigoLabel, gbc);

        codigoFuncionarioField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(codigoFuncionarioField, gbc);

        // Campo Cargo
        JLabel cargoLabel = new JLabel("Novo Cargo:");
        cargoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(cargoLabel, gbc);

        cargoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(cargoField, gbc);

        // Campo Telefone
        JLabel telefoneLabel = new JLabel("Novo Telefone:");
        telefoneLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(telefoneLabel, gbc);

        telefoneField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(telefoneField, gbc);

        // Campo CEP
        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(cepLabel, gbc);

        cepField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(cepField, gbc);

        // Campo Local
        JLabel localLabel = new JLabel("Local:");
        localLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(localLabel, gbc);

        localField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(localField, gbc);

        // Campo Número
        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(numeroLabel, gbc);

        numeroField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(numeroField, gbc);

        // Campo Bairro
        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(bairroLabel, gbc);

        bairroField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(bairroField, gbc);

        // Campo Cidade
        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(cidadeLabel, gbc);

        cidadeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 8;
        add(cidadeField, gbc);

        // Campo Estado
        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(estadoLabel, gbc);

        estadoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 9;
        add(estadoField, gbc);

        // Botão Alterar
        alterarButton = new JButton("Alterar");
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        add(alterarButton, gbc);

        // Botão Voltar
        voltarButton = new JButton("Voltar");
        gbc.gridy = 11;
        add(voltarButton, gbc);

        // Ações dos botões
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder: Lógica para alterar os dados do funcionário
                JOptionPane.showMessageDialog(null, "Dados do funcionário alterados com sucesso!");
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
            new AlterarFuncionarioGUI().setVisible(true);
        });
    }
}
