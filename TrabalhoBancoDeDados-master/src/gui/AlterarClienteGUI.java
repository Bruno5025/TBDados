package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarClienteGUI extends JFrame {
    private JTextField cpfField;
    private JTextField telefoneField;
    private JTextField cepField;
    private JTextField localField;
    private JTextField numeroField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private JButton alterarButton;
    private JButton voltarButton;

    public AlterarClienteGUI() {
        setTitle("Alterar Cliente - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(47, 47, 47));

        // Painel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(47, 47, 47));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel titleLabel = new JLabel("Alterar Cliente");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        // CPF do Cliente
        JLabel cpfLabel = new JLabel("CPF do Cliente:");
        cpfLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(cpfLabel, gbc);

        cpfField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(cpfField, gbc);

        // Telefone
        JLabel telefoneLabel = new JLabel("Novo Telefone:");
        telefoneLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(telefoneLabel, gbc);

        telefoneField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(telefoneField, gbc);

        // CEP
        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(cepLabel, gbc);

        cepField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(cepField, gbc);

        // Local
        JLabel localLabel = new JLabel("Local:");
        localLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(localLabel, gbc);

        localField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(localField, gbc);

        // Número
        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(numeroLabel, gbc);

        numeroField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(numeroField, gbc);

        // Bairro
        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(bairroLabel, gbc);

        bairroField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        mainPanel.add(bairroField, gbc);

        // Cidade
        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(cidadeLabel, gbc);

        cidadeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        mainPanel.add(cidadeField, gbc);

        // Estado
        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(estadoLabel, gbc);

        estadoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 8;
        mainPanel.add(estadoField, gbc);

        // Botão Alterar
        alterarButton = new JButton("Alterar");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        mainPanel.add(alterarButton, gbc);

        // Botão Voltar
        voltarButton = new JButton("Voltar");
        gbc.gridy = 10;
        mainPanel.add(voltarButton, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Ações dos botões
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso!");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionarioMenuGUI().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlterarClienteGUI().setVisible(true);
        });
    }
}
