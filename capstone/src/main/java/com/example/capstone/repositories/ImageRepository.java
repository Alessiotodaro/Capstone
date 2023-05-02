package com.example.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstone.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}