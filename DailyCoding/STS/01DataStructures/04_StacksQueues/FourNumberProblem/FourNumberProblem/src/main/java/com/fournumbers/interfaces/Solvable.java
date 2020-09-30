package com.fournumbers.interfaces;

public interface Solvable extends Problematic {
 
	public static String SOLVED = "SOLVED";
	
	public static String NOT_RESOLVED = "NOT RESOLVED";
	public static String RESOLVED = "RESOLVED";
	
	public static String NOT_STARTED = "NOT STARTED";
	
	String evaluate(); 	
	String[] solve();
}
