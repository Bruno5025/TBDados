package gui;

import javax.swing.*;
import java.awt.*;

public class ClienteMenuGUI extends JFrame {

    public ClienteMenuGUI() {
        setTitle("Menu do Cliente - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        painelPrincipal.setLayout(new BorderLayout());
        add(painelPrincipal, BorderLayout.CENTER);

        // Título
        JLabel tituloLabel = new JLabel("Menu do Cliente", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        painelBotoes.setLayout(new GridLayout(3, 2, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botões do menu
        JButton consultarSaldoButton = new JButton("Consultar Saldo");
        JButton depositarButton = new JButton("Depositar");
        JButton sacarButton = new JButton("Sacar");
        JButton consultarExtratoButton = new JButton("Consultar Extrato");
        JButton consultarLimiteButton = new JButton("Consultar Limite");
        JButton voltarButton = new JButton("Voltar");

        // Estilo dos botões
        JButton[] botoes = {consultarSaldoButton, depositarButton, sacarButton, consultarExtratoButton, consultarLimiteButton, voltarButton};
        for (JButton botao : botoes) {
            botao.setBackground(Color.LIGHT_GRAY);
            botao.setFont(new Font("Arial", Font.PLAIN, 16));
        }

        // Adicionando os botões ao painel
        painelBotoes.add(consultarSaldoButton);
        painelBotoes.add(depositarButton);
        painelBotoes.add(sacarButton);
        painelBotoes.add(consultarExtratoButton);
        painelBotoes.add(consultarLimiteButton);
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        // Ações dos botões
        consultarSaldoButton.addActionListener(e -> {
            new ConsultaSaldoGUI().setVisible(true);
            dispose();
        });

        depositarButton.addActionListener(e -> {
            new DepositoGUI().setVisible(true);
            dispose();
        });

        sacarButton.addActionListener(e -> {
            new SaqueGUI().setVisible(true);
            dispose();
        });

        consultarExtratoButton.addActionListener(e -> {
            new ExtratoGUI().setVisible(true);
            dispose();
        });

        consultarLimiteButton.addActionListener(e -> {
            new ConsultarLimiteGUI().setVisible(true);
            dispose();
        });

        voltarButton.addActionListener(e -> {
            new LoginGUI().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteMenuGUI menu = new ClienteMenuGUI();
            menu.setVisible(true);
        });
    }
}
