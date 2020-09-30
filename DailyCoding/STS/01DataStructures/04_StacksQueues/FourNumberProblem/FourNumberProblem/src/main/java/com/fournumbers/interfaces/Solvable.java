package com.fournumbers.interfaces;

public interface Solvable extends Evaluable {
 	
	public static String NOT_RESOLVED = "NOT RESOLVED";
	public static String RESOLVED = "RESOLVED";
	
	public static String SOLVED = "SOLVED";

	String[] solve();
}
