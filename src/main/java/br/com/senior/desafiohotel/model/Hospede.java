package br.com.senior.desafiohotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "hospede")
public class Hospede {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 20)
    private String documento;
    @Column(nullable = false, length = 20)
    private String telefone;


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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
