package gui;

import javax.swing.*;
import java.awt.*;

public class ExtratoGUI extends JFrame {
    private JTextField cpfField;
    private JTextArea extratoArea;
    private JButton gerarExtratoButton, exportarButton, voltarButton;

    public ExtratoGUI() {
        setTitle("Extrato - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        painelPrincipal.setLayout(new BorderLayout());
        add(painelPrincipal, BorderLayout.CENTER);

        // Título
        JLabel tituloLabel = new JLabel("Extrato", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        // Painel de campos e botões
        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(new Color(47, 47, 47));
        painelCentral.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // CPF
        JLabel cpfLabel = new JLabel("CPF do Cliente:");
        cpfLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cpfLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCentral.add(cpfLabel, gbc);

        cpfField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelCentral.add(cpfField, gbc);

        // Área de texto para extrato
        extratoArea = new JTextArea(10, 30);
        extratoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(extratoArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        painelCentral.add(scrollPane, gbc);

        // Painel para botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(47, 47, 47));
        painelBotoes.setLayout(new FlowLayout());

        gerarExtratoButton = new JButton("Gerar Extrato");
        gerarExtratoButton.setBackground(Color.LIGHT_GRAY);
        gerarExtratoButton.setFont(new Font("Arial", Font.PLAIN, 14));
        painelBotoes.add(gerarExtratoButton);

        exportarButton = new JButton("Exportar para Excel");
        exportarButton.setBackground(Color.LIGHT_GRAY);
        exportarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        painelBotoes.add(exportarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.setBackground(Color.LIGHT_GRAY);
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        painelBotoes.add(voltarButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        painelCentral.add(painelBotoes, gbc);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Ações dos botões
        gerarExtratoButton.addActionListener(e -> {
            String cpf = cpfField.getText();
            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, informe o CPF.");
                return;
            }

            // TODO: Lógica para buscar extrato no banco de dados
            extratoArea.setText("Extrato gerado para o CPF: " + cpf + "\n...");
            JOptionPane.showMessageDialog(this, "Extrato gerado com sucesso!");
        });

        exportarButton.addActionListener(e -> {
            // TODO: Lógica para exportar extrato para Excel
            JOptionPane.showMessageDialog(this, "Extrato exportado para Excel com sucesso!");
        });

        voltarButton.addActionListener(e -> {
            new ClienteMenuGUI().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExtratoGUI extratoGUI = new ExtratoGUI();
            extratoGUI.setVisible(true);
        });
    }
}
