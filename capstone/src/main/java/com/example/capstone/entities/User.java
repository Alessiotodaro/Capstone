package com.example.capstone.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private String dataNascita;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Ad> ads;
    
    public User(){}

    public User(String nome, String cognome, String dataNascita, String email, String password){
        this.setNome(nome);
        this.setCognome(cognome);
        this.setDataNascita(dataNascita);
        this.setEmail(email);
        this.setPassword(password);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getDataNascita() {
        return dataNascita;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public List<Ad> getAds() {
        return ads;
    }
    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
}
