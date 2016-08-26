package com.srini.microservices.mstar;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

 
public interface MstarDividendsDataRepository extends Repository<Dividend, Long> {
	
	/**
	 * Find dividends for a given ticker symbol
	 * 
	 * @param symbol
	 *            Any stock ticker symbol.
	 * @return The list of matching dividends - always non-null, but may be
	 *         empty.
	 */
	@Query
	public List<Dividend> findBySymbol(String symbol);
	
	/**
	 * Find dividends for a given ticker symbol and for a given year
	 * 
	 * @param symbol
	 *            Any stock ticker symbol.
	 * @param year
	 *            year of interest.
	 *            
	 * @return The list of matching dividends - always non-null, but may be
	 *         empty.
	 */
	@Query
	public List<Dividend> findBySymbolAndYear(String symbol, Integer year);

}
