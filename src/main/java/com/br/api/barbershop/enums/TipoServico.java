package com.br.api.barbershop.enums;

public enum TipoServico {
    CABELO("Cabelo", 1, 15.0d), BARBA("Barba", 2, 10.0d), PINTAR("Pintar", 3, 20.50d);


    TipoServico(String descricao, Integer tipo, Double preco) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public Double getPreco() {
        return preco;
    }

    private String descricao;
    private Integer tipo;
    private Double preco;
}
