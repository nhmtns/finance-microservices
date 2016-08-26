package com.srini.microservices.accounts;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 
 * @author Srini Vanga
 */
public interface AccountRepository extends Repository<Account, Long> {
	/**
	 * Find an account with the specified account number.
	 *
	 * @param accountNumber
	 * @return The account if found, null otherwise.
	 */
	@Query
	public Account findByAccountNumber(String accountNumber);

	/**
	 * Find accounts whose owner name contains the specified string
	 * 
	 * @param partialName
	 *            Any alphabetic string.
	 * @return The list of matching accounts - always non-null, but may be
	 *         empty.
	 */
	@Query
	public List<Account> findByNameContainingIgnoreCase(String partialName);

	/**
	 * Fetch the number of accounts known to the system.
	 * 
	 * @return The number of accounts.
	 */
	@Query("SELECT count(*) from Account")
	public int countAccounts();
}
