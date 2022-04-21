package com.company.customids;

import com.amplicode.core.graphql.annotation.GraphQLId;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class PetController {
    private final PetRepository crudRepository;

    public PetController(PetRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @MutationMapping(name = "deletePet")
    @Transactional
    public void delete(@GraphQLId @Argument String customizedId) {
        Pet entity = crudRepository.findById(customizedId)
                .orElseThrow(() -> new RuntimeException(String.format("Unable to find entity by id: %s ", customizedId)));

        crudRepository.delete(entity);
    }

    @QueryMapping(name = "petList")
    @Transactional
    public List<Pet> findAll() {
        return crudRepository.findAll();
    }

    @QueryMapping(name = "pet")
    @Transactional
    public Pet findById(@GraphQLId @Argument String customizedId) {
        return crudRepository.findById(customizedId)
                .orElseThrow(() -> new RuntimeException(String.format("Unable to find entity by id: %s ", customizedId)));
    }

    @MutationMapping(name = "updatePet")
    @Transactional
    public Pet update(@Argument Pet input) {
        if (input.getCustomizedId() != null) {
            if (!crudRepository.existsById(input.getCustomizedId())) {
                throw new RuntimeException(
                        String.format("Unable to find entity by id: %s ", input.getCustomizedId()));
            }
        }
        return crudRepository.save(input);
    }
}