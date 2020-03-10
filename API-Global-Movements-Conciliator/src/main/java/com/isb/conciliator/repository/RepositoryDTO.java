package com.isb.conciliator.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isb.conciliator.entity.ConciliatorEntity;

public interface RepositoryDTO extends MongoRepository<ConciliatorEntity, UUID> {

}
