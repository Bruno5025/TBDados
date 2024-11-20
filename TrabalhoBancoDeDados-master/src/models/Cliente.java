package models;

public class Cliente {
    private int idCliente;
    private int idUsuario;

    // Construtor completo
    public Cliente(int idCliente, int idUsuario) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
    }

    // Construtor sem ID
    public Cliente(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
