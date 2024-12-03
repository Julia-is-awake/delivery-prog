package com.delivery.trabalhoDelivery.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nota")
    private double nota;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante", cascade = CascadeType.ALL) 
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
