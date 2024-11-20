package models;

public class ContaPoupanca {
    private int idContaPoupanca;
    private double taxaRendimento;
    private int idConta; // FK para a tabela Conta

    // Construtor completo
    public ContaPoupanca(int idContaPoupanca, double taxaRendimento, int idConta) {
        this.idContaPoupanca = idContaPoupanca;
        this.taxaRendimento = taxaRendimento;
        this.idConta = idConta;
    }

    // Construtor sem ID (para inserção)
    public ContaPoupanca(double taxaRendimento, int idConta) {
        this.taxaRendimento = taxaRendimento;
        this.idConta = idConta;
    }

    // Getters e Setters
    public int getIdContaPoupanca() {
        return idContaPoupanca;
    }

    public void setIdContaPoupanca(int idContaPoupanca) {
        this.idContaPoupanca = idContaPoupanca;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
