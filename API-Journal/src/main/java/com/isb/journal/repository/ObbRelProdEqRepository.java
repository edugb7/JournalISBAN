package com.isb.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isb.journal.entity.relacional.ObbRelProdEq;
import com.isb.journal.entity.relacional.ObbRelProdEqIdentity;

public interface ObbRelProdEqRepository extends JpaRepository<ObbRelProdEq, ObbRelProdEqIdentity>{

}
