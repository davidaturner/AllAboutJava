package com.fournumbers.interfaces;

public interface Problematic {

	public static String VALID = "VALID" ;
	public static String NOT_VALID = "NOT VALID";
	
	String describe();
	boolean validate();
}
