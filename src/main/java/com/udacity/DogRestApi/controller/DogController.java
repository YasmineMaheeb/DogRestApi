package com.udacity.DogRestApi.controller;

import com.udacity.DogRestApi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 404, message = "Sorry, wrong link")})
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/breeds")
    public ResponseEntity<List<String>> getBreeds() {
        List<String> list = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/breed/{dogId:.+}")
    public ResponseEntity<String> getBreed(@PathVariable int dogId) {
        String breed = dogService.retrieveDogBreedById((long) dogId);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
}
