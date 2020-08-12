package com.udacity.DogRestApi.mapper;

import com.udacity.DogRestApi.model.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DogMapper extends CrudRepository<Dog, Long> {
}
