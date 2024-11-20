package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarContaGUI extends JFrame {
    private JTextField numeroContaField;
    private JTextArea resultadoArea;
    private JButton consultarButton;
    private JButton voltarButton;

    public ConsultarContaGUI() {
        setTitle("Consultar Conta - Banco Malvader");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        numeroContaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        numeroContaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCentral.add(numeroContaLabel, gbc);

        numeroContaField = new JTextField(20);
        gbc.gridx = 1;
        painelCentral.add(numeroContaField, gbc);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        painelCentral.add(scrollPane, gbc);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro

        consultarButton = new JButton("Consultar");
        painelBotoes.add(consultarButton);

        voltarButton = new JButton("Voltar");
        painelBotoes.add(voltarButton);

        add(painelCentral, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroConta = numeroContaField.getText();
                if (numeroConta.isEmpty()) {
                    JOptionPane.showMessageDialog(ConsultarContaGUI.this, "Por favor, insira o número da conta.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Aqui vai a lógica para consultar os dados da conta no banco.
                String resultado = "Dados da conta: \nNúmero: " + numeroConta + "\nSaldo: R$1000.00\nTipo: Corrente\nLimite: R$500.00\nData de Vencimento: 2024-12-31";
                resultadoArea.setText(resultado);
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionarioMenuGUI().setVisible(true); // Volta para o menu do funcionário
                dispose(); // Fecha a janela atual
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConsultarContaGUI().setVisible(true));
    }
}
