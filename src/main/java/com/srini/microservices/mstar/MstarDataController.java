package com.srini.microservices.mstar;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.microservices.accounts.Account;
import com.srini.microservices.exceptions.AccountNotFoundException;
import com.srini.microservices.exceptions.FinancialDataNotFoundException;

/**
 * A RESTFul controller for accessing Morningstar Historical Stock Data.
 * 
 * @author Srini Vanga
 */
@RestController
public class MstarDataController {

	protected Logger logger = Logger.getLogger(MstarDataController.class.getName());
	protected MstarDividendsDataRepository mstarDividendsRepo;

	/**
	 * Create an instance plugging in the respository.
	 * 
	 * @param mstarDividendsRepo
	 *            repository implementation.
	 */
	@Autowired
	public MstarDataController(MstarDividendsDataRepository mstarDividendsRepo) {
		this.mstarDividendsRepo = mstarDividendsRepo;

		logger.info("MstarDividendsDataRepository says hello");
	}

	/**
	 * Fetches all available dividends data for a given stock or just for a given year for that stock
	 * This method is accomplishing this over loaded behavior through use of Optional.
	 * 
	 * @param symbol
	 * @param year (optional)
	 * @return
	 */
	
	@RequestMapping(value = {"/dividends/{symbol}/year/{year}", "/dividends/{symbol}"} )
	public List<Dividend> bySymbol(@PathVariable("symbol") String symbol, @PathVariable Optional<Integer> year) {

		logger.info(
				"mstardata-service bySymbol() invoked: " + mstarDividendsRepo.getClass().getName() + " for " + symbol);
		
		List<Dividend> dividends = null;
		if (year.isPresent()) {
			Integer yr = new Integer(year.orElse(null));
			dividends = mstarDividendsRepo.findBySymbolAndYear(symbol, yr);
		} else {
			dividends = mstarDividendsRepo.findBySymbol(symbol);
			logger.info("mstardata-service bySymbol() found: " + dividends);
		}

		if (dividends == null || dividends.size() == 0)
			throw new FinancialDataNotFoundException(symbol);
		else {
			return dividends;
		}

	}
}
