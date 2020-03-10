package com.isb.journal.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isb.journal.entity.relacional.ObbDefinition;

public class ObbDefinitionConverter {

	static Map<String, String> map = new HashMap<String, String>();
	
	static ObjectMapper mapper = new ObjectMapper();
	
	static public com.isb.journal.entity.norelacional.ObbDefinition converter(ObbDefinition obbDefinition) {
		map.put("instance", obbDefinition.getObbDefinitionIdentity().getInstance());
		map.put("business", obbDefinition.getObbDefinitionIdentity().getBusiness());
		map.put("product", obbDefinition.getObbDefinitionIdentity().getProduct());
		map.put("subtype", obbDefinition.getObbDefinitionIdentity().getSubtype());
		map.put("basic", obbDefinition.getObbDefinitionIdentity().getBasic());
		map.put("bank", obbDefinition.getObbDefinitionIdentity().getBank());
		map.put("startDate", obbDefinition.getObbDefinitionIdentity().getStartDate().toString());
		map.put("endDate", obbDefinition.getObbDefinitionIdentity().getEndDate().toString());
		map.put("version", obbDefinition.getVersion());
		map.put("accumulator", obbDefinition.getAccumulator());
		map.put("situation", obbDefinition.getSituation());
		map.put("technicalObject", obbDefinition.getTechnicalObject());
		map.put("indicatorBbc", obbDefinition.getIndicatorBbc());
		map.put("operationType", obbDefinition.getOperationType());
		return mapper.convertValue(map, com.isb.journal.entity.norelacional.ObbDefinition.class);
	}

}
