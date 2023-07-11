package com.br.api.barbershop.enums;

public enum TipoServico {
    CABELO("Cabelo", 15.0d), BARBA("Barba", 10.0d), PINTAR("Pintar", 20.50d);


    TipoServico(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    private String descricao;
    private Double preco;
}
