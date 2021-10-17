package com.udacity.dogRestAPI.repository;

import com.udacity.dogRestAPI.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT DISTINCT s.breed FROM Dog s")
    List<String> findAllBreeds();

    @Query("SELECT s.breed FROM Dog s WHERE s.id = :id")
    String findBreedById(Long id);

    @Query("SELECT DISTINCT s.name FROM Dog s")
    List<String> findAllNames();

}
