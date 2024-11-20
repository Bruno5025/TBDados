package models;

public class Funcionario {
    private int idFuncionario;
    private String codigoFuncionario;
    private String cargo;
    private int idUsuario;

    // Construtor completo
    public Funcionario(int idFuncionario, String codigoFuncionario, String cargo, int idUsuario) {
        this.idFuncionario = idFuncionario;
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
        this.idUsuario = idUsuario;
    }

    // Construtor sem ID
    public Funcionario(String codigoFuncionario, String cargo, int idUsuario) {
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
        this.idUsuario = idUsuario;
    }

    // Getters e Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
