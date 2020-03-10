package com.isb.interapplication.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isb.interapplication.entity.InterapplicationEntity;

public interface InterapplicationRepositoryDTO extends MongoRepository<InterapplicationEntity, UUID> {

}
