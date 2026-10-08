package com.info.mercadoriaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mercadoria {
    @Id
    private String codBarras;
    private String descricao;
    private Double estoqueMinimo;
    private String marca;
    private Double quantidade;

    public Mercadoria(){}

    public Mercadoria(String codBarras, String descricao, Double estoqueMinimo,String marca, Double quantidade){
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.estoqueMinimo = estoqueMinimo;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
