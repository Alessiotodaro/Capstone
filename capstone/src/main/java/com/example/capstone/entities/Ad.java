package com.example.capstone.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;
    
    @Column(name = "modello")
    private String modello;

    @Column(name = "anno")
    private String anno;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "prezzo")
    private String prezzo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "ad", orphanRemoval=true)
    private List<Image> images;

    public Ad(){}

    public Ad(String marca, String modello, String anno, String descrizione, String prezzo, User user){
        this.setMarca(marca);
        this.setModello(modello);
        this.setAnno(anno);
        this.setDescrizione(descrizione);
        this.setPrezzo(prezzo);
        this.setUser(user);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getModello() {
        return modello;
    }
    public void setAnno(String anno) {
        this.anno = anno;
    }
    public String getAnno() {
        return anno;
    }
    public void setDescrizione(String descrizione) { 
        this.descrizione = descrizione;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }
    public String getPrezzo() {
        return prezzo;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }
}
