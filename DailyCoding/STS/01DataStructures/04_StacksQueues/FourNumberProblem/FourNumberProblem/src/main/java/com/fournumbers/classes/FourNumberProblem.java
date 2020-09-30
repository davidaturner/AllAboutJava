package com.fournumbers.classes;

import com.fournumbers.interfaces.Problematic;
import com.fournumbers.interfaces.Solvable;

public class FourNumberProblem implements Problematic {

	private final int goal;
	private final int[] choices;
	private String prestep;
	
	public FourNumberProblem(FourNumberProblemPOJO problem) {
		this(problem.getGoal(), problem.getChoices());
	}
	public FourNumberProblem(int goal, int[]choices) {
		this.goal 	= goal;
		this.choices = choices;
		this.prestep = Solvable.NOT_STARTED;
	}
	
	@Override
	public String describe() {
		String result = "Goal: " + goal;
		if (choices != null && choices.length>0) {
			result += " Choices:";
			for(int choice : choices) {
				result += " " + choice;
			}
		}
		result += " Prestep: " + prestep;
		return result;
	}

	@Override
	public boolean validate() {
		return (goal >= 0 && choices != null && choices.length>0 && choices.length<=4);
	}

	// Getters and setters
	public String getPrestep() {
		return prestep;
	}

	public void setPrestep(String prestep) {
		this.prestep = prestep;
	}

	public int getGoal() {
		return goal;
	}

	public int[] getChoices() {
		return choices;
	}
	
	//Main
	public static void main(String[] args) {
		int goal = 33;
		int[] choices = {5, 8, 4, 19};
		
		FourNumberProblem problem = new FourNumberProblem(goal, choices);
		System.out.println(problem.describe());
		System.out.println(problem.validate());
	}

}
