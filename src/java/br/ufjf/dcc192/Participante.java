package br.ufjf.dcc192;
public class Participante {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Participante sorteado;

    public Participante(Integer id, String nome, String email, String senha, Participante sorteado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sorteado = sorteado;
    }
    
    public Participante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Participante getSorteado() {
        return sorteado;
    }

    public void setSorteado(Participante sorteado) {
        this.sorteado = sorteado;
    }
    
}
