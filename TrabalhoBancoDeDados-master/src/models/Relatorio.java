package models;

import java.time.LocalDateTime;

public class Relatorio {
    private int idRelatorio;
    private String tipoRelatorio;
    private LocalDateTime dataGeracao;
    private String conteudo;
    private int idFuncionario;

    // Construtores
    public Relatorio(int idRelatorio, String tipoRelatorio, LocalDateTime dataGeracao, String conteudo, int idFuncionario) {
        this.idRelatorio = idRelatorio;
        this.tipoRelatorio = tipoRelatorio;
        this.dataGeracao = dataGeracao;
        this.conteudo = conteudo;
        this.idFuncionario = idFuncionario;
    }

    public Relatorio(String tipoRelatorio, LocalDateTime dataGeracao, String conteudo, int idFuncionario) {
        this.tipoRelatorio = tipoRelatorio;
        this.dataGeracao = dataGeracao;
        this.conteudo = conteudo;
        this.idFuncionario = idFuncionario;
    }

    // Getters e Setters
    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(String tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
