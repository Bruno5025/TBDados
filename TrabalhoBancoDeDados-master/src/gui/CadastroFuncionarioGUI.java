package gui;

import javax.swing.*;
import java.awt.*;

public class CadastroFuncionarioGUI extends JFrame {
    private JTextField codigoField, nomeField, cargoField, cpfField, telefoneField, dataNascimentoField;
    private JTextField cepField, localField, numeroField, bairroField, cidadeField, estadoField;
    private JButton cadastrarButton, voltarButton;

    public CadastroFuncionarioGUI() {
        setTitle("Cadastro de Funcionários - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600); // Aumentado para ajustar os campos
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(47, 47, 47)); // Fundo cinza escuro
        painelPrincipal.setLayout(new BorderLayout());
        add(painelPrincipal, BorderLayout.CENTER);

        // Título
        JLabel tituloLabel = new JLabel("Cadastro de Funcionários", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE);
        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);

        // Painel de campos
        JPanel painelCampos = new JPanel();
        painelCampos.setBackground(new Color(47, 47, 47));
        painelCampos.setLayout(new GridLayout(12, 2, 10, 10)); // Ajustado para 2 colunas
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adicionando labels e campos
        painelCampos.add(createLabel("Código do Funcionário:"));
        codigoField = new JTextField();
        painelCampos.add(codigoField);

        painelCampos.add(createLabel("Nome:"));
        nomeField = new JTextField();
        painelCampos.add(nomeField);

        painelCampos.add(createLabel("Cargo:"));
        cargoField = new JTextField();
        painelCampos.add(cargoField);

        painelCampos.add(createLabel("CPF:"));
        cpfField = new JTextField();
        painelCampos.add(cpfField);

        painelCampos.add(createLabel("Data de Nascimento (dd/mm/aaaa):"));
        dataNascimentoField = new JTextField();
        painelCampos.add(dataNascimentoField);

        painelCampos.add(createLabel("Telefone:"));
        telefoneField = new JTextField();
        painelCampos.add(telefoneField);

        painelCampos.add(createLabel("CEP:"));
        cepField = new JTextField();
        painelCampos.add(cepField);

        painelCampos.add(createLabel("Local:"));
        localField = new JTextField();
        painelCampos.add(localField);

        painelCampos.add(createLabel("Número:"));
        numeroField = new JTextField();
        painelCampos.add(numeroField);

        painelCampos.add(createLabel("Bairro:"));
        bairroField = new JTextField();
        painelCampos.add(bairroField);

        painelCampos.add(createLabel("Cidade:"));
        cidadeField = new JTextField();
        painelCampos.add(cidadeField);

        painelCampos.add(createLabel("Estado (UF):"));
        estadoField = new JTextField();
        painelCampos.add(estadoField);

        painelPrincipal.add(painelCampos, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(47, 47, 47));
        painelBotoes.setLayout(new FlowLayout());

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(Color.LIGHT_GRAY);
        cadastrarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        painelBotoes.add(cadastrarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.setBackground(Color.LIGHT_GRAY);
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        painelBotoes.add(voltarButton);

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        cadastrarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            // TODO: Adicionar lógica para salvar os dados no banco
        });

        voltarButton.addActionListener(e -> {
            new FuncionarioMenuGUI().setVisible(true);
            dispose();
        });
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.RIGHT);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroFuncionarioGUI cadastroFuncionario = new CadastroFuncionarioGUI();
            cadastroFuncionario.setVisible(true);
        });
    }
}
