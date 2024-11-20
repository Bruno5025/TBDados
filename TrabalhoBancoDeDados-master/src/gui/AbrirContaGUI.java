package gui;

import utils.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbrirContaGUI extends JFrame {
    private JTextField numeroContaField;
    private JTextField agenciaField;
    private JTextField saldoField;
    private JComboBox<String> tipoContaComboBox;
    private JTextField limiteField;
    private JTextField rendimentoField;
    private JTextField idClienteField;
    private JButton abrirContaButton;
    private JButton voltarButton;

    public AbrirContaGUI() {
        setTitle("Banco Malvader - Abrir Conta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(47, 47, 47)); // Fundo cinza escuro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel tituloLabel = new JLabel("Abrir Conta");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(tituloLabel, gbc);

        // Número da Conta
        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        numeroContaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(numeroContaLabel, gbc);

        numeroContaField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(numeroContaField, gbc);

        // Agência
        JLabel agenciaLabel = new JLabel("Agência:");
        agenciaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(agenciaLabel, gbc);

        agenciaField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(agenciaField, gbc);

        // Saldo Inicial
        JLabel saldoLabel = new JLabel("Saldo Inicial:");
        saldoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(saldoLabel, gbc);

        saldoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(saldoField, gbc);

        // Tipo de Conta
        JLabel tipoContaLabel = new JLabel("Tipo de Conta:");
        tipoContaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(tipoContaLabel, gbc);

        tipoContaComboBox = new JComboBox<>(new String[]{"POUPANCA", "CORRENTE"});
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(tipoContaComboBox, gbc);

        // Limite (apenas para Corrente)
        JLabel limiteLabel = new JLabel("Limite:");
        limiteLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(limiteLabel, gbc);

        limiteField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(limiteField, gbc);

        // Rendimento (apenas para Poupança)
        JLabel rendimentoLabel = new JLabel("Rendimento:");
        rendimentoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(rendimentoLabel, gbc);

        rendimentoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(rendimentoField, gbc);

        // ID do Cliente
        JLabel idClienteLabel = new JLabel("ID do Cliente:");
        idClienteLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(idClienteLabel, gbc);

        idClienteField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(idClienteField, gbc);

        // Botão Abrir Conta
        abrirContaButton = new JButton("Abrir Conta");
        abrirContaButton.setBackground(new Color(100, 149, 237));
        abrirContaButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        add(abrirContaButton, gbc);

        // Botão Voltar
        voltarButton = new JButton("Voltar");
        voltarButton.setBackground(new Color(100, 149, 237));
        voltarButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 8;
        add(voltarButton, gbc);

        // Ações dos botões
        abrirContaButton.addActionListener(e -> abrirConta());
        voltarButton.addActionListener(e -> {
            new FuncionarioMenuGUI().setVisible(true); // Retorna ao menu do funcionário
            dispose();
        });

        // Ajusta campos com base no tipo de conta selecionado
        tipoContaComboBox.addActionListener(e -> ajustarCamposPorTipoDeConta());
        ajustarCamposPorTipoDeConta(); // Configuração inicial
    }

    private void ajustarCamposPorTipoDeConta() {
        String tipoConta = (String) tipoContaComboBox.getSelectedItem();
        if ("CORRENTE".equals(tipoConta)) {
            limiteField.setEnabled(true);
            rendimentoField.setEnabled(false);
            rendimentoField.setText("");
        } else if ("POUPANCA".equals(tipoConta)) {
            rendimentoField.setEnabled(true);
            limiteField.setEnabled(false);
            limiteField.setText("");
        }
    }

    private void abrirConta() {
        String numeroConta = numeroContaField.getText();
        String agencia = agenciaField.getText();
        String saldo = saldoField.getText();
        String tipoConta = (String) tipoContaComboBox.getSelectedItem();
        String limite = limiteField.getText();
        String rendimento = rendimentoField.getText();
        String idCliente = idClienteField.getText();

        if (numeroConta.isEmpty() || agencia.isEmpty() || saldo.isEmpty() || idCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.");
            return;
        }

        String insertConta = "INSERT INTO Conta (numero_conta, agencia, saldo, tipo_conta, id_cliente) VALUES (?, ?, ?, ?, ?)";
        String insertContaCorrente = "INSERT INTO ContaCorrente (limite, id_conta) VALUES (?, LAST_INSERT_ID())";
        String insertContaPoupanca = "INSERT INTO ContaPoupanca (taxa_rendimento, id_conta) VALUES (?, LAST_INSERT_ID())";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement contaStmt = connection.prepareStatement(insertConta);
            contaStmt.setString(1, numeroConta);
            contaStmt.setString(2, agencia);
            contaStmt.setDouble(3, Double.parseDouble(saldo));
            contaStmt.setString(4, tipoConta);
            contaStmt.setInt(5, Integer.parseInt(idCliente));
            contaStmt.executeUpdate();

            if ("CORRENTE".equals(tipoConta)) {
                PreparedStatement correnteStmt = connection.prepareStatement(insertContaCorrente);
                correnteStmt.setDouble(1, Double.parseDouble(limite));
                correnteStmt.executeUpdate();
            } else if ("POUPANCA".equals(tipoConta)) {
                PreparedStatement poupancaStmt = connection.prepareStatement(insertContaPoupanca);
                poupancaStmt.setDouble(1, Double.parseDouble(rendimento));
                poupancaStmt.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao criar conta: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AbrirContaGUI abrirContaGUI = new AbrirContaGUI();
            abrirContaGUI.setVisible(true);
        });
    }
}
