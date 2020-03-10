package com.isb.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isb.journal.entity.relacional.ObbDefinition;
import com.isb.journal.entity.relacional.ObbDefinitionIdentity;

public interface ObbDefinitionRepository extends JpaRepository<ObbDefinition, ObbDefinitionIdentity>{

	//@Query(value = "select * from journal.obb_definition where o6b_idempr = ?1 AND o6b_codprod = ?2", nativeQuery = true)
	@Query(value = "SELECT * FROM obb_definition WHERE o6b_idempr = ?1 AND o6b_codprod = ?2 "
			+ "AND o6b_codsprod = ?3 and o6b_codopbas = ?4 AND o6b_codopeob = ?5 " 
			+ "AND ((o6b_fecomval <= current_date() AND o6b_fefinval >= current_date()));"
			, nativeQuery = true)
	public ObbDefinition findOne(String idBusiness, String codProd, String codSubProd, String codBasic
			, String codBank);
}
