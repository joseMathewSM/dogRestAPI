package com.udacity.dogRestAPI.controller;

import com.udacity.dogRestAPI.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="dog")
public class DogController {
    private DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(path="breeds")
    public ResponseEntity<List<String>> getDogBreeds(){
        List<String> breeds = dogService.getDogBreeds();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    @GetMapping(path="names")
    public List<String> getDogNames(){
        return dogService.getDogNames();
    }

    @GetMapping(path="{id}")
    public String getDogBreed(@PathVariable("id") Long id){
       String breed = dogService.getDogBreedById(id);
       if(breed == null)
           return "Does not Exist";
       else
           return breed;
    }
}
