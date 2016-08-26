package com.srini.microservices.mstar;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity  
@Table(name = "dividend_f") 
/**
@AttributeOverride(name = "id", column = @Column(name = "customer_id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED")) */
public class Dividend extends BasicStockDataEntity {

	public Dividend() {
		super();
	}

	public Dividend(String symbol, Integer year, BigDecimal amount) {
		super(symbol, year, amount);
 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dividend [symbol=");
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
