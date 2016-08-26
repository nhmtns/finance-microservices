package com.srini.microservices.mstar;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * The dividends Spring configuration.
 * 
 * @author Srini Vanga
 */
@Configuration
@ComponentScan
@EntityScan("com.srini.microservices.mstar")
@EnableJpaRepositories("com.srini.microservices.mstar")
@PropertySource("classpath:mstardata-server/db-config.properties")
public class MstarDataConfiguration {

	protected Logger logger;

	public MstarDataConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	/**
	 * Creates an in-memory database populated with test data for fast
	 * testing
	 */
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		// Create an in-memory H2 relational database containing some demo
		// dividends.
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:mstardata-server/db/schema.sql")
				.addScript("classpath:mstardata-server/db/testdata.sql").build();

		logger.info("dataSource = " + dataSource);

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> dividends = jdbcTemplate.queryForList("SELECT id FROM dividend_f");
		logger.info("System has dividends for " + dividends.size() + " companies");

		// Populate with random dividend amounts
		Random rand = new Random();

		for (Map<String, Object> item : dividends) {
			Long id = (Long) item.get("id");
			BigDecimal balance = new BigDecimal(rand.nextInt(10000000) / 100.0).setScale(2, BigDecimal.ROUND_HALF_UP);
			jdbcTemplate.update("UPDATE dividend_f SET amount = ? WHERE id = ?", balance, id);
		}

		return dataSource;
	}
}
