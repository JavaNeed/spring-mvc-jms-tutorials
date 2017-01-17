package com.jms.testing.spring;

import java.io.Serializable;

public class InstructionMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -295422703255886286L;
	private int instructionType;
	private int productCode;
	private int quantity;
	private int uOM;
	private int timeStamp;
	
	
	public InstructionMessage(int instructionType, int productCode, int quantity, int uOM, int timeStamp) {
		super();
		this.instructionType = instructionType;
		this.productCode = productCode;
		this.quantity = quantity;
		this.uOM = uOM;
		this.timeStamp = timeStamp;
	}

	public int getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(int instructionType) {
		this.instructionType = instructionType;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getuOM() {
		return uOM;
	}

	public void setuOM(int uOM) {
		this.uOM = uOM;
	}

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "InstructionMessage [instructionType=" + instructionType + ", productCode=" + productCode + ", quantity="
				+ quantity + ", uOM=" + uOM + ", timeStamp=" + timeStamp + "]";
	}
}
