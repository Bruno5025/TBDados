package models;

public class Conta {
    private int idConta;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private String tipoConta;
    private int idCliente;

    // Construtores
    public Conta(int idConta, String numeroConta, String agencia, double saldo, String tipoConta, int idCliente) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.idCliente = idCliente;
    }

    public Conta(String numeroConta, String agencia, double saldo, String tipoConta, int idCliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.idCliente = idCliente;
    }

    // Getters e Setters
    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
