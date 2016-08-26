package com.srini.microservices.accounts;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent account entity with JPA markup.
 * 
 * @author Srini Vanga
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

	//private static final long serialVersionUID = 1L;

	//public static Long nextId = 0L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "account_number")
	protected String accountNumber;

	protected String name;

	protected String description;

	@Column(name = "account_type")
	protected String accType;

	protected String purpose;

	protected Boolean taxdeferred;

	@Column(name = "institution_name")
	protected String institutionName;

	@Column(name = "owner_id")
	protected Long ownerId;

	protected Boolean closed;

	@Column(name = "closed_on")
	protected Date dateClosed;

	@Column(name = "opened_on")
	protected Date dateOpened;

	protected Boolean hide; // hide it in user accounts list

	@Column(name = "cash_balance")
	protected BigDecimal cashBalance;
	
	
	/**
	 * Default constructor for JPA only.
	 */
	public Account() {
		cashBalance = BigDecimal.ZERO;
	}

	
	
	public Account(String accountNumber, String name, String description, String accType, String purpose,
			Boolean taxdeferred, String institutionName, Long ownerId, Boolean closed, Date dateClosed, Date dateOpened,
			Boolean hide, BigDecimal cashBalance) {

		this.accountNumber = accountNumber;
		this.name = name;
		this.description = description;
		this.accType = accType;
		this.purpose = purpose;
		this.taxdeferred = taxdeferred;
		this.institutionName = institutionName;
		this.ownerId = ownerId;
		this.closed = closed;
		this.dateClosed = dateClosed;
		this.dateOpened = dateOpened;
		this.hide = hide;
		this.cashBalance = cashBalance;
	}


/**
	public static Long getNextId() {
		return nextId;
	}

	public static void setNextId(Long nextId) {
		Account.nextId = nextId;
	}
	*/

	public Long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Boolean getTaxdeferred() {
		return taxdeferred;
	}

	public void setTaxdeferred(Boolean taxdeferred) {
		this.taxdeferred = taxdeferred;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Boolean getHide() {
		return hide;
	}

	public void setHide(Boolean hide) {
		this.hide = hide;
	}

	public BigDecimal getCashBalance() {
		return cashBalance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void withdraw(BigDecimal amount) {
		cashBalance.subtract(amount);
	}

	public void deposit(BigDecimal amount) {
		cashBalance.add(amount);
	}

	/**
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	**/



	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", name=" + name + ", description="
				+ description + ", accType=" + accType + ", purpose=" + purpose + ", taxdeferred=" + taxdeferred
				+ ", institutionName=" + institutionName + ", ownerId=" + ownerId + ", closed=" + closed
				+ ", dateClosed=" + dateClosed + ", dateOpened=" + dateOpened + ", hide=" + hide + ", cashBalance="
				+ cashBalance + "]";
	}
	
	

}
