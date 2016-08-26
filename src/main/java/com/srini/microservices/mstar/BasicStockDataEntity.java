package com.srini.microservices.mstar;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass  
public abstract class BasicStockDataEntity extends BaseEntity {
	
	protected String symbol;

    protected Integer year; 
	
	protected BigDecimal amount;

	public BasicStockDataEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasicStockDataEntity(String symbol, Integer year, BigDecimal amount) {
		super();
		this.symbol = symbol;
		this.year = year;
		this.amount = amount;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getAmount() {
		return amount.setScale(3, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicStockDataEntity [symbol=");
		builder.append(symbol);
		builder.append(", year=");
		builder.append(year);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	
	

	
}
