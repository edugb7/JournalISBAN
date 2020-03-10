package com.isb.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isb.journal.entity.relacional.JournalOperationData;

public interface RepositoryDataListDTO extends JpaRepository<JournalOperationData, Integer>{

}

