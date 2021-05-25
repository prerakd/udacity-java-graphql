package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.exception.BreedNotFoundException;
import com.udacity.graphql.exception.DogNotFoundException;
import com.udacity.graphql.repository.DogRepository;

import java.util.Optional;

public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog>findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(!optionalDog.isPresent()) {
            throw new DogNotFoundException("Dog not found", id);
        } else {
            return optionalDog.get();
        }
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();

        for(Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public boolean updateDogName(String newName, Long id) {
        boolean deleted = false;
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (!optionalDog.isPresent()) {
            throw new DogNotFoundException("Dog not found", id);
        } else {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
        }
        return deleted;
    }
}
