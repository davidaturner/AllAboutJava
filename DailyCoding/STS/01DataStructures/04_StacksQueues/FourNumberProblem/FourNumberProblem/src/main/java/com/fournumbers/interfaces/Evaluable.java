package com.fournumbers.interfaces;

public interface Evaluable {
	
	public static final String NOT_EVALUATED = "NOT EVALUATED";
	public static final String EVALUATING = "EVALUATING";
	public static final String EVALUATED = "EVALUATED";
	
	String evaluate();
}
