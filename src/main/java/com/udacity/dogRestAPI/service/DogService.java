package com.udacity.dogRestAPI.service;

import com.udacity.dogRestAPI.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<String> getDogBreeds(){
        return dogRepository.findAllBreeds();
    }

    public String getDogBreedById(Long id){
        return dogRepository.findBreedById(id);
    }

    public List<String> getDogNames(){
        return dogRepository.findAllNames();
    }

}
