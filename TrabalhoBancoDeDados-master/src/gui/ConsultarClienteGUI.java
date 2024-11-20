package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.ConnectionFactory;

public class ConsultarClienteGUI extends JFrame {
    private JTextField cpfField;
    private JTextArea resultadoArea;
    private JButton consultarButton;
    private JButton voltarButton;

    public ConsultarClienteGUI() {
        setTitle("Consultar Cliente - Banco Malvader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(new Color(47, 47, 47));

        // Painel superior
        JPanel painelSuperior = new JPanel();
        painelSuperior.setBackground(new Color(47, 47, 47));
        painelSuperior.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel cpfLabel = new JLabel("CPF do Cliente:");
        cpfLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        painelSuperior.add(cpfLabel, gbc);

        cpfField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        painelSuperior.add(cpfField, gbc);

        painel.add(painelSuperior, BorderLayout.NORTH);

        // Área de resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        painel.add(scrollPane, BorderLayout.CENTER);

        // Painel inferior
        JPanel painelInferior = new JPanel();
        painelInferior.setBackground(new Color(47, 47, 47));
        consultarButton = new JButton("Consultar");
        voltarButton = new JButton("Voltar");

        painelInferior.add(consultarButton);
        painelInferior.add(voltarButton);

        painel.add(painelInferior, BorderLayout.SOUTH);

        // Ações dos botões
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCliente();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioMenuGUI().setVisible(true);
            }
        });

        add(painel);
    }

    private void consultarCliente() {
        String cpf = cpfField.getText().trim();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o CPF!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "SELECT nome, cpf, data_nascimento, telefone, endereco FROM Usuario "
                + "JOIN Cliente ON Usuario.id_usuario = Cliente.id_usuario "
                + "WHERE cpf = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String dataNascimento = resultSet.getDate("data_nascimento").toString();
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");

                resultadoArea.setText("Nome: " + nome + "\n"
                        + "CPF: " + cpf + "\n"
                        + "Data de Nascimento: " + dataNascimento + "\n"
                        + "Telefone: " + telefone + "\n"
                        + "Endereço: " + endereco);
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                resultadoArea.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConsultarClienteGUI().setVisible(true);
        });
    }
}
