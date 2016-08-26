package com.srini.microservices.services.mstar;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.srini.microservices.mstar.MstarDividendsDataRepository;
import com.srini.microservices.mstar.MstarDataConfiguration;

/**
 * Morning Star Historical Data micro-service
 * 
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link MstarDataConfiguration}. This is a deliberate separation of concerns.
 * 
 * @author Srini Vanga
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(MstarDataConfiguration.class)
public class MstarDataServer {

	@Autowired
	protected MstarDividendsDataRepository dividendDataRepository;

	protected Logger logger = Logger.getLogger(MstarDataServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for mstardata-server.properties or
		// mstardata-server.yml
		System.setProperty("spring.config.name", "mstardata-server");
		System.setProperty("spring.config.location", "classpath:mstardata-server/");

		SpringApplication.run(MstarDataServer.class, args);
	}
}
