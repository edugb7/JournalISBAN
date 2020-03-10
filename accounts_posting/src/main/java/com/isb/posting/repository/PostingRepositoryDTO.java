package com.isb.posting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isb.posting.entity.InputContract;

public interface PostingRepositoryDTO extends MongoRepository<InputContract, String> {

}
