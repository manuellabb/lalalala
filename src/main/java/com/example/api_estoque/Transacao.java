package com.example.api_estoque;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private Double valor;

    private LocalDate data_transacao;

    @Column(name = "tipo_transacao")
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(LocalDate data_transacao) {
        this.data_transacao = data_transacao;
    }

    public String getTipo_transacao() {
        return tipo;
    }

    public void setTipo_transacao(String tipo_transacao) {
        this.tipo = tipo_transacao;
    }

    public Transacao(int id, String descricao, Double valor, LocalDate data_transacao, String tipo_transacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.tipo = tipo_transacao;
    }

    public Transacao(int id, String descricao, Double valor, String tipo_transacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo_transacao;
    }

    public Transacao(){

    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data_transacao=" + data_transacao +
                ", tipo_transacao=" + tipo +
                '}';
    }
}
