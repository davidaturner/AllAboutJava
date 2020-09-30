package com.fournumbers.controller;

import com.fournumbers.classes.FourNumberProblem;
import com.fournumbers.classes.FourNumberProblemPOJO;
import com.fournumbers.classes.NumberWithOpStack;
import com.fournumbers.interfaces.Solvable;

public class FourNumberProblemSolver implements Solvable {

	private final FourNumberProblem problem;
	private static NumberWithOpStack solveStack;
	
	private String evaluation;
	
	private boolean bruteForce;
	
	public FourNumberProblemSolver(FourNumberProblem problem) {
		this.problem = problem;
		solveStack = new NumberWithOpStack();
		evaluation = Solvable.NOT_STARTED;
		bruteForce = true;
	}
	
	@Override
	public String describe() {
		return problem.describe();
	}

	@Override
	public boolean validate() {
		return problem != null && problem.validate();
	}

	@Override
	public String evaluate() {
		return evaluate(problem);
	}

	@Override
	public String[] solve() {
		
		// validate the problem
		if (validate()) {
			
			// describe the problem
			display("Four Number Problem:");
			display(problem.describe());
			
			// start solving the problem
			evaluation = Solvable.NOT_RESOLVED;
			
			// while not resolved continue
			// evaluating the problem.
			while (!isResolved()) {
				evaluation = evaluate(problem);
			}

			// generate solution
			return translate();
		}
		
		return null;
	}

	private boolean isResolved() {
		return evaluation.equals(Solvable.RESOLVED) ||
				evaluation.equals(Solvable.SOLVED);
	}
	private String evaluate(FourNumberProblem problem) {
		return Solvable.SOLVED;
	}
	
	private String[] translate() {
		String[] solution = new String[1];
		solution[0] = Solvable.SOLVED;
		return solution;
	}
	
	// Getters and setters
	public FourNumberProblem getProblem() {
		return problem;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public NumberWithOpStack getSolveStack() {
		return solveStack;
	}

	public boolean isBruteForce() {
		return bruteForce;
	}

	public void setBruteForce(boolean bruteForce) {
		this.bruteForce = bruteForce;
	}

	public static void main(String[] args) {
		int goal = 33;
		int[]choices = {8, 35, 4, 9};
		FourNumberProblemPOJO pojo = new FourNumberProblemPOJO();
		pojo.setGoal(goal);
		pojo.setChoices(choices);
			
		FourNumberProblemSolver solver = new FourNumberProblemSolver(
											new FourNumberProblem(pojo));
		String[] solution = solver.solve();
		if (solution != null && solution.length>0) {
			display("\r\nProcess complete. A Solution was found.");
			displaySolution(solution);			
		} else {
			display("\r\nProcess complete. No solution was found.");
		}
	}
	
	public static void display(String message) {
		System.out.println(message);
	}
	public static void displaySolution(String[] solution) {
		for(String step : solution) {
			System.out.println(step);
		}
	}
}
