package com.company.customids;

import com.amplicode.core.graphql.annotation.GraphQLId;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class OwnerController {
    private final OwnerRepository crudRepository;

    public OwnerController(OwnerRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @MutationMapping(name = "deleteOwner")
    @Transactional
    public void delete(@GraphQLId @Argument String ownerId) {
        Owner entity = crudRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException(String.format("Unable to find entity by id: %s ", ownerId)));

        crudRepository.delete(entity);
    }

    @QueryMapping(name = "ownerList")
    @Transactional
    public List<Owner> findAll() {
        return crudRepository.findAll();
    }

    @QueryMapping(name = "owner")
    @Transactional
    public Owner findById(@GraphQLId @Argument String ownerId) {
        return crudRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException(String.format("Unable to find entity by id: %s ", ownerId)));
    }

    @MutationMapping(name = "updateOwner")
    @Transactional
    public Owner update(@Argument Owner input) {
        if (input.getOwnerId() != null) {
            if (!crudRepository.existsById(input.getOwnerId())) {
                throw new RuntimeException(
                        String.format("Unable to find entity by id: %s ", input.getOwnerId()));
            }
        }
        return crudRepository.save(input);
    }
}