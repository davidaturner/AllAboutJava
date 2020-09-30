package com.fournumbers.controller;

import com.fournumbers.classes.FourNumberProblem;
import com.fournumbers.classes.FourNumberProblemPOJO;
import com.fournumbers.classes.NumberWithOpStack;
import com.fournumbers.interfaces.Evaluable;
import com.fournumbers.interfaces.Problematic;
import com.fournumbers.interfaces.Solvable;

public class FourNumberProblemSolver implements Solvable, Problematic {

	private static NumberWithOpStack solveStack = new NumberWithOpStack();
	
	private FourNumberProblem problem;	
	private Evaluable evaluator;
	
	public FourNumberProblemSolver(FourNumberProblem problem,
									FourNumberProblemEvaluator evaluator) {
		this.problem = problem;
		this.evaluator = evaluator;
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
	public String[] solve() {
		
		// validate the problem
		if (validate()) {
			
			// describe the problem
			display("Four Number Problem:");
			display(problem.describe());
			
			// start solving the problem
			
			// while not resolved continue
			// evaluating the problem.

			// generate solution
			return translate();
		}
		
		return null;
	}

	@Override
	public String evaluate() {
		return evaluator.evaluate();
	}
	
	private String[] translate() {
		String[] solution = new String[1];
		solution[0] = Solvable.SOLVED;
		return solution;
	}
		
	// Testing
	public static void main(String[] args) {
		int goal = 33;
		int[]choices = {8, 35, 4, 9};
		FourNumberProblemPOJO pojo = new FourNumberProblemPOJO();
		pojo.setGoal(goal);
		pojo.setChoices(choices);
			
		FourNumberProblemSolver solver = new FourNumberProblemSolver(
											new FourNumberProblem(pojo),
											new FourNumberProblemEvaluator());
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
