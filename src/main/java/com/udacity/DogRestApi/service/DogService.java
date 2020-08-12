package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.mapper.DogMapper;
import com.udacity.DogRestApi.model.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DogService {

    private DogMapper dogMapper;

    public DogService(DogMapper dogMapper) {
        this.dogMapper = dogMapper;
    }

    public String retrieveDogBreedById(Long id) {
        Optional<Dog> dog = dogMapper.findById(id);
        Dog d = dog.orElseThrow(DogNotFoundException::new);
        return d.getBreed();
    }

    public ArrayList<String> retrieveDogBreeds() {
        ArrayList<Dog> dogs = (ArrayList<Dog>) dogMapper.findAll();
        ArrayList<String> breeds = new ArrayList<>();
        for (Dog d : dogs) {
            breeds.add(d.getBreed());
        }
        return breeds;
    }

    public ArrayList<String> retrieveDogNames() {
        ArrayList<Dog> dogs = (ArrayList<Dog>) dogMapper.findAll();
        ArrayList<String> names = new ArrayList<>();
        for (Dog d : dogs) {
            names.add(d.getName());
        }
        return names;
    }


}
