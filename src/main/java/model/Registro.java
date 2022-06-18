/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Registro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String produto;
    private String endereco;
    private String telefone;
   

    public Registro() {
    }

    public Registro(String nome, String produto, String endereco, String telefone) {
        this.nome = nome;
        this.produto = produto;
        this.endereco = endereco;
        this.telefone = telefone;
    }

   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", nome=" + nome + ", produto=" + produto + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

    
}