package com.isb.journal.repository.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataBaseConfig {

	@Bean(name = "dbOracle")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/journal").username("root").password("__16623__VIEW__").build();
 
    }

	@Bean(name = "jdbcOracle")
	@Autowired
	public JdbcTemplate oracleJdbcTemplate(@Qualifier("dbOracle") DataSource dbOracle) {
		return new JdbcTemplate(dbOracle);
	}
}
