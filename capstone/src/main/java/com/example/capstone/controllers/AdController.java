package com.example.capstone.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.capstone.entities.Ad;
import com.example.capstone.entities.Image;
import com.example.capstone.services.AdService;
import com.example.capstone.services.ImageService;
import com.example.capstone.services.UserService;

@Controller
public class AdController {
    
    private AdService adService;
    private ImageService imageService;
    private UserService userService;

    public AdController(AdService adService, ImageService imageService, UserService userService){ 
        this.adService=adService;
        this.imageService=imageService;
        this.userService=userService;
    }

    //Per visualizzare tutti gli annunci
    @GetMapping("/ricerca")
    public String listAds(Model model){
        model.addAttribute("ads", adService.getAllAds());
        return "ricerca";
    }

    //Per visualizzare un annuncio in particolare
    @GetMapping("/ricerca/annuncio/{id}")
    public String showAdDetails(@PathVariable Long id, Model model){
        model.addAttribute("ad", adService.getAdById(id));
        return "annuncio";
    }

    @GetMapping("/ricerca/new")
    public String showNewAdForm(Model model){
        Ad ad=new Ad();

        model.addAttribute("ad", ad);

        return "inserisci";
    }

    @PostMapping("/ricerca")
    public String saveAdIntoDB(@ModelAttribute("ad") Ad ad, @RequestParam("image") MultipartFile imageMultipartFile) throws IOException{
        //Acquisisci nome immagine
        String fileName = StringUtils.cleanPath(imageMultipartFile.getOriginalFilename());

        //Visto che non gestiamo il login assegno l'user con id 1
        ad.setUser(userService.getUserById(Long.valueOf(5)));
        //Salva annuncio
        adService.saveAd(ad);
        
        //Salva immagine come oggetto
        imageService.saveImage(new Image(fileName, ad));

        //Manca il salvataggio della foto nel path

        return "redirect:/ricerca";
    }

    @GetMapping("/ricerca/{id}")
    public String deleteAdFromDB(@PathVariable Long id, Model model){

        adService.deleteAdById(id);

        return "redirect:/ricerca";
    }

}
