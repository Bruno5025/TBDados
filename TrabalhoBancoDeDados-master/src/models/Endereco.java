package models;

public class Endereco {
    private int idEndereco;
    private String cep;
    private String local;
    private int numeroCasa;
    private String bairro;
    private String cidade;
    private String estado;
    private int idUsuario; // Relacionamento com a tabela Usuario

    // Construtor completo
    public Endereco(int idEndereco, String cep, String local, int numeroCasa, String bairro, String cidade, String estado, int idUsuario) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.local = local;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    // Construtor sem ID (para inserções)
    public Endereco(String cep, String local, int numeroCasa, String bairro, String cidade, String estado, int idUsuario) {
        this.cep = cep;
        this.local = local;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    // Getters e Setters
    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", cep='" + cep + '\'' +
                ", local='" + local + '\'' +
                ", numeroCasa=" + numeroCasa +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
