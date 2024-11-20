package gui;

import javax.swing.*;
import java.awt.*;

public class FuncionarioMenuGUI extends JFrame {

    public FuncionarioMenuGUI() {
        setTitle("Menu do Funcionário - Banco Malvader");
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
        JLabel tituloLabel = new JLabel("Menu do Funcionário", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        painelBotoes.setLayout(new GridLayout(0, 1, 10, 10)); // Layout com uma coluna
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botões do menu
        JButton abrirContaButton = new JButton("Abrir Conta");
        JButton encerrarContaButton = new JButton("Encerrar Conta");
        JButton consultarClienteButton = new JButton("Consultar Cliente");
        JButton consultarContaButton = new JButton("Consultar Conta");
        JButton consultarFuncionarioButton = new JButton("Consultar Funcionário");
        JButton alterarClienteButton = new JButton("Alterar Cliente");
        JButton alterarContaButton = new JButton("Alterar Conta");
        JButton alterarFuncionarioButton = new JButton("Alterar Funcionário");
        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        JButton voltarButton = new JButton("Voltar");

        // Estilo dos botões
        JButton[] botoes = {abrirContaButton, encerrarContaButton, consultarClienteButton,
                consultarContaButton, consultarFuncionarioButton, alterarClienteButton,
                alterarContaButton, alterarFuncionarioButton, gerarRelatorioButton, voltarButton};
        for (JButton botao : botoes) {
            botao.setBackground(Color.LIGHT_GRAY);
            botao.setFont(new Font("Arial", Font.PLAIN, 16));
        }

        // Adicionando os botões ao painel
        painelBotoes.add(abrirContaButton);
        painelBotoes.add(encerrarContaButton);
        painelBotoes.add(consultarClienteButton);
        painelBotoes.add(consultarContaButton);
        painelBotoes.add(consultarFuncionarioButton);
        painelBotoes.add(alterarClienteButton);
        painelBotoes.add(alterarContaButton);
        painelBotoes.add(alterarFuncionarioButton);
        painelBotoes.add(gerarRelatorioButton);
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        // Ações dos botões
        abrirContaButton.addActionListener(e -> {
            new AbrirContaGUI().setVisible(true);
            dispose();
        });

        encerrarContaButton.addActionListener(e -> {
            new EncerrarContaGUI().setVisible(true);
            dispose();
        });

        consultarClienteButton.addActionListener(e -> {
            new ConsultarClienteGUI().setVisible(true);
            dispose();
        });

        consultarContaButton.addActionListener(e -> {
            new ConsultarContaGUI().setVisible(true);
            dispose();
        });

        consultarFuncionarioButton.addActionListener(e -> {
            new ConsultarFuncionarioGUI().setVisible(true);
            dispose();
        });

        alterarClienteButton.addActionListener(e -> {
            new AlterarClienteGUI().setVisible(true);
            dispose();
        });

        alterarContaButton.addActionListener(e -> {
            new AlterarContaGUI().setVisible(true);
            dispose();
        });

        alterarFuncionarioButton.addActionListener(e -> {
            new AlterarFuncionarioGUI().setVisible(true);
            dispose();
        });

        gerarRelatorioButton.addActionListener(e -> {
            new RelatorioGUI().setVisible(true);
            dispose();
        });

        voltarButton.addActionListener(e -> {
            new LoginGUI().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FuncionarioMenuGUI menu = new FuncionarioMenuGUI();
            menu.setVisible(true);
        });
    }
}
