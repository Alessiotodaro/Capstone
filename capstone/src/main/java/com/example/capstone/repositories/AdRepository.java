package com.example.capstone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.capstone.entities.Ad;

public interface AdRepository extends JpaRepository<Ad, Long>{

    //Se l'annuncio è sprovvisto di immagine non prelevarlo
    @Query("FROM Ad a JOIN Image i ON a.id = i.ad WHERE i.path<>NULL")
    public List<Ad> getAllAds();

}
