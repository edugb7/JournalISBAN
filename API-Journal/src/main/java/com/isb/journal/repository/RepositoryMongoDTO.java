package com.isb.journal.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isb.journal.entity.norelacional.JournalEntityMongo;

public interface RepositoryMongoDTO extends MongoRepository<JournalEntityMongo, UUID> {

}
