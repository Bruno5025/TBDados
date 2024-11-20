package gui;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton acessarFuncionarioButton;
    private JButton acessarClienteButton;

    public LoginGUI() {
        setTitle("Banco Malvader - Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500); // Mantém o tamanho da janela
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel esquerdo para a imagem e logo
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setBackground(new Color(47, 47, 47)); // Tom de cinza escuro
        painelEsquerdo.setLayout(new BorderLayout());
        painelEsquerdo.setPreferredSize(new Dimension(400, getHeight()));

        // Carregar e redimensionar a imagem do Darth Vader
        ImageIcon darthIcon = new ImageIcon("src/images/Darth.png");
        Image darthImage = darthIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        darthIcon = new ImageIcon(darthImage);
        JLabel darthLabel = new JLabel(darthIcon);
        darthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        painelEsquerdo.add(darthLabel, BorderLayout.CENTER);

        // Carregar e redimensionar o logo "Banco Malvader"
        ImageIcon logoIcon = new ImageIcon("src/images/logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        painelEsquerdo.add(logoLabel, BorderLayout.SOUTH);

        add(painelEsquerdo, BorderLayout.WEST);

        // Painel direito para os campos de login
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new GridBagLayout());
        painelDireito.setBackground(Color.WHITE); // Fundo branco

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel tituloLabel = new JLabel("Bem-vindo ao Banco Malvader");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelDireito.add(tituloLabel, gbc);

        // Campo Usuário
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        painelDireito.add(usuarioLabel, gbc);

        usuarioField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painelDireito.add(usuarioField, gbc);

        // Campo Senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        painelDireito.add(senhaLabel, gbc);

        senhaField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        painelDireito.add(senhaField, gbc);

        // Botão Acessar como Funcionário
        acessarFuncionarioButton = new JButton("Acessar como Funcionário");
        acessarFuncionarioButton.setPreferredSize(new Dimension(220, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelDireito.add(acessarFuncionarioButton, gbc);

        // Botão Acessar como Cliente
        acessarClienteButton = new JButton("Acessar como Cliente");
        acessarClienteButton.setPreferredSize(new Dimension(220, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        painelDireito.add(acessarClienteButton, gbc);

        add(painelDireito, BorderLayout.CENTER);

        // Ações dos botões
        acessarFuncionarioButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Acesso como Funcionário");
            new FuncionarioMenuGUI().setVisible(true);
            dispose();
        });

        acessarClienteButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Acesso como Cliente");
            new ClienteMenuGUI().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
        });
    }
}
