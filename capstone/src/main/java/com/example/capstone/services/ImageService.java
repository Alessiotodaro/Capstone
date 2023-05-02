package com.example.capstone.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.capstone.entities.Image;
import com.example.capstone.repositories.ImageRepository;

@Service
public class ImageService {
    
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository){
        this.imageRepository=imageRepository;
    }

    public List<Image> getAllImages(){
        return imageRepository.findAll();
    }

    public Image saveImage(Image image){
        return imageRepository.save(image);
    }

    public Image getImageById(Long id){
        return imageRepository.findById(id).get();
    }

    public Image updateImage(Image image){
        return imageRepository.save(image);
    }

    public void deleteImageById(Long id){
        imageRepository.deleteById(id);
    }

}