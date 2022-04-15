package com.company.customids;

import com.amplicode.core.graphql.annotation.GraphQLId;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class TestEntityController {
    private final TestEntityRepository crudRepository;

    public TestEntityController(TestEntityRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @MutationMapping(name = "deleteTestEntity")
    @Transactional
    public void delete(@GraphQLId @Argument String id) {
        TestEntity entity = crudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Unable to find entity by id: %s ", id)));

        crudRepository.delete(entity);
    }

    @QueryMapping(name = "testEntityList")
    @Transactional
    public List<TestEntity> findAll() {
        return crudRepository.findAll();
    }

    @QueryMapping(name = "testEntity")
    @Transactional
    public TestEntity findById(@GraphQLId @Argument String id) {
        return crudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Unable to find entity by id: %s ", id)));
    }

    @MutationMapping(name = "updateTestEntity")
    @Transactional
    public TestEntity update(@Argument TestEntity input) {
        if (input.getId() != null) {
            if (!crudRepository.existsById(input.getId())) {
                throw new RuntimeException(
                        String.format("Unable to find entity by id: %s ", input.getId()));
            }
        }
        return crudRepository.save(input);
    }
}