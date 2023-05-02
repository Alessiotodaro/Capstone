package com.example.capstone.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.capstone.entities.Ad;
import com.example.capstone.repositories.AdRepository;

@Service
public class AdService {
    
    private AdRepository adRepository;

    public AdService(AdRepository adRepository){
        this.adRepository=adRepository;
    }

    public List<Ad> getAllAds(){
        return adRepository.getAllAds();
    }

    public Ad saveAd(Ad ad){
        return adRepository.save(ad);
    }

    public Ad getAdById(Long id){
        return adRepository.findById(id).get();
    }

    public Ad updateAd(Ad ad){
        return adRepository.save(ad);
    }

    public void deleteAdById(Long id){
        adRepository.deleteById(id);
    }

}
