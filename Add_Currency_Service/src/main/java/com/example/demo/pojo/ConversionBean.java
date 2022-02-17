package com.example.demo.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ConversionBean {
	@Id
	private int id;
	private String valueTo;
	private String valueFrom;
	private BigDecimal conversionMultiple;
	@Transient
	private int port;
	public ConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConversionBean(int id, String valueTo, String valueFrom, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.valueTo = valueTo;
		this.valueFrom = valueFrom;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValueTo() {
		return valueTo;
	}
	public void setValueTo(String valueTo) {
		this.valueTo = valueTo;
	}
	public String getValueFrom() {
		return valueFrom;
	}
	public void setValueFrom(String valueFrom) {
		this.valueFrom = valueFrom;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "ConversionBean [id=" + id + ", valueTo=" + valueTo + ", valueFrom=" + valueFrom
				+ ", conversionMultiple=" + conversionMultiple + ", port=" + port + "]";
	}
	
}
