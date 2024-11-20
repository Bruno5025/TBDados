package gui;

import javax.swing.*;
import java.awt.*;

public class ConsultarLimiteGUI extends JFrame {
    private JTextField cpfField;
    private JLabel limiteLabel;
    private JButton consultarButton, voltarButton;

    public ConsultarLimiteGUI() {
        setTitle("Consultar Limite - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        painelPrincipal.setLayout(new BorderLayout());
        add(painelPrincipal, BorderLayout.CENTER);

        // Título
        JLabel tituloLabel = new JLabel("Consultar Limite", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        // Painel central para os campos
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

        // Limite
        limiteLabel = new JLabel("Limite: ---");
        limiteLabel.setFont(new Font("Arial", Font.BOLD, 16));
        limiteLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelCentral.add(limiteLabel, gbc);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(47, 47, 47));
        painelBotoes.setLayout(new FlowLayout());

        consultarButton = new JButton("Consultar Limite");
        consultarButton.setBackground(Color.LIGHT_GRAY);
        consultarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        painelBotoes.add(consultarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.setBackground(Color.LIGHT_GRAY);
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        consultarButton.addActionListener(e -> {
            String cpf = cpfField.getText();
            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, informe o CPF.");
                return;
            }

            // TODO: Lógica para buscar limite no banco de dados
            limiteLabel.setText("Limite: R$ 1.000,00"); // Simulando valor
            JOptionPane.showMessageDialog(this, "Consulta realizada com sucesso!");
        });

        voltarButton.addActionListener(e -> {
            new ClienteMenuGUI().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultarLimiteGUI consultarLimiteGUI = new ConsultarLimiteGUI();
            consultarLimiteGUI.setVisible(true);
        });
    }
}
