package com.isb.posting.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isb.posting.entity.PostingEntity;

public interface PostingRepositoryDTO extends MongoRepository<PostingEntity, UUID> {

}
