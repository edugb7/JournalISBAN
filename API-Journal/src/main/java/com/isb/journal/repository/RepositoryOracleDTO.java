package com.isb.journal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isb.journal.entity.relacional.JournalEntityOracle;

public interface RepositoryOracleDTO extends JpaRepository<JournalEntityOracle, UUID>{

}

