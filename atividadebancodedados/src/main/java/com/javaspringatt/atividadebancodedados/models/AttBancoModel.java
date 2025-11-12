package com.javaspringatt.atividadebancodedados.models;


import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class AttBancoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    public AttBancoModel(){

    }

    public AttBancoModel(int id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }    

    // public int getId(){
    //     return id;
    // }

    // public void setId(int id){
    //     this.id = id;
    // }

    // public String getNome(){
    //     return nome;
    // }

    // pulb



}
