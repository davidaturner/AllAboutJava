package com.fournumbers.classes;

import com.fournumbers.interfaces.StackableElement;

public class NumberWithOpElement implements StackableElement {
	private String elementNumber;
	private String elementOp;
	
	public String getElementNumber() {
		return elementNumber;
	}
	public void setElementNumber(String elementNumber) {
		this.elementNumber = elementNumber;
	}
	public String getElementOp() {
		return elementOp;
	}
	public void setElementOp(String elementOp) {
		this.elementOp = elementOp;
	}	
}

