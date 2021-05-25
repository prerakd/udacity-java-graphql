package com.udacity.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphql.repository.DogRepository;

public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
}
