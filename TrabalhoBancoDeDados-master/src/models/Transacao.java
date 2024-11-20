package models;

import java.time.LocalDateTime;

public class Transacao {
    private int id;
    private String tipoTransacao; // "DEPOSITO", "SAQUE", "TRANSFERENCIA"
    private double valor;
    private LocalDateTime dataHora; // Data e hora da transação
    private int idConta; // ID da conta associada

    // Construtor completo
    public Transacao(int id, String tipoTransacao, double valor, LocalDateTime dataHora, int idConta) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.dataHora = dataHora;
        this.idConta = idConta;
    }

    // Construtor sem ID (para inserções)
    public Transacao(String tipoTransacao, double valor, int idConta) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now(); // Define o horário atual por padrão
        this.idConta = idConta;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", idConta=" + idConta +
                '}';
    }
}
