package models;

import java.time.LocalDate;

public class ContaCorrente {
    private int idContaCorrente;
    private double limite;
    private LocalDate dataVencimento;
    private int idConta; // FK para a tabela Conta

    // Construtor completo
    public ContaCorrente(int idContaCorrente, double limite, LocalDate dataVencimento, int idConta) {
        this.idContaCorrente = idContaCorrente;
        this.limite = limite;
        this.dataVencimento = dataVencimento;
        this.idConta = idConta;
    }

    // Construtor sem ID (para inserção)
    public ContaCorrente(double limite, LocalDate dataVencimento, int idConta) {
        this.limite = limite;
        this.dataVencimento = dataVencimento;
        this.idConta = idConta;
    }

    // Getters e Setters
    public int getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(int idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "idContaCorrente=" + idContaCorrente +
                ", limite=" + limite +
                ", dataVencimento=" + dataVencimento +
                ", idConta=" + idConta +
                '}';
    }
}
