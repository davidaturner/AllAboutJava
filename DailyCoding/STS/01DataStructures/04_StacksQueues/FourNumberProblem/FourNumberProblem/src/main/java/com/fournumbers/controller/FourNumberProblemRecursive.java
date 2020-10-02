package com.fournumbers.controller;

import com.fournumbers.classes.FourNumberProblem;
import com.fournumbers.interfaces.Evaluable;

public class FourNumberProblemRecursive implements Evaluable {

	private FourNumberProblem problem;
	private String evaluation;
	private boolean bruteforce = false;
	
	private int failsafe = 0;
	private static int attempts = 1;
	
	@Override
	public String evaluate() {
		return evaluate(this.problem);
	}
	
	public String evaluate(FourNumberProblem problem) {
		
		// Simple case.
		if (problem == null) {
			return Evaluable.NOT_EVALUATED;
		}
		String evaluation = checkIfResolved(problem);
		if (evaluation != null) {
			return evaluation;
		}

		// Recursive case.
		int[] choices = problem.getChoices();
		for(int choice : choices) {
			// Add
			FourNumberProblem reduced = reduce(problem, FourNumberProblem.OP_ADD, choice);
			evaluation = evaluate(reduced);
			if (evaluation != null) {
				return evaluation;
			}
			// Subtract
			reduced = reduce(problem, FourNumberProblem.OP_SUBTRACT, choice);
			evaluation = evaluate(reduced);
			if (evaluation != null) {
				return evaluation;
			}
			// Multiply
			reduced = reduce(problem, FourNumberProblem.OP_MULTIPLY, choice);
			evaluation = evaluate(reduced);
			if (evaluation != null) {
				return evaluation;
			}
			// Divide
			reduced = reduce(problem, FourNumberProblem.OP_DIVIDE, choice);
			evaluation = evaluate(reduced);
			if (evaluation != null) {
				return evaluation;
			}
		}

		return null;
	}

	public String checkIfResolved(FourNumberProblem problem) {
		if (problem != null) {
			int[] choices = problem.getChoices();
			if (choices != null && choices.length == 1) {
				return (choices[0] == problem.getGoal())?
					Evaluable.EVALUATED : Evaluable.EVALUATING;
			}
		}
		return null;
	}
	
	public FourNumberProblem reduce(FourNumberProblem problem, String op, int byChoice) {
		attempts++;
		if (problem == null ||failsafe > 0 && failsafe <= attempts) {
			return null;
		}

		int a = problem.getGoal();
		int b = byChoice;
		switch (op) {
		case FourNumberProblem.OP_ADD:
			a += b;
			break;
		case FourNumberProblem.OP_SUBTRACT:
			a -= b;
			break;
		case FourNumberProblem.OP_MULTIPLY:
			a *= b;
			break;
		case FourNumberProblem.OP_DIVIDE:
			if (a % b != 0) {
				return null;
			}
			a /= b;
			break;
		default:
			break;
		}
		
		int[] choices = reduceChoices(problem.getChoices(), b);
		FourNumberProblem reduced = new FourNumberProblem(a, choices);
		reduced.setPrestep(generatePrestep(a, b, op));
		return reduced;

	}
	
	public int[] reduceChoices(int [] choices, int byChoice) {
		int[] c = new int[choices.length-1];
		int i=0;
		for(int choice : choices) {
			if (choice != byChoice) {
				c[i] = choice;
				i++;
			} else {
				break;
			}
		}
		return null;
	}
	
	public String generatePrestep(int a, int b, String op) {
		return op + " " + b;
	}
	
	public static void display(FourNumberProblem problem) {
		System.out.println(problem.describe());
	}
	public static void display(String message) {
		System.out.println(message);
	}
	// Getter and Setter
	public FourNumberProblem getProblem() {
		return problem;
	}

	public void setProblem(FourNumberProblem problem) {
		this.problem = problem;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public boolean isBruteforce() {
		return bruteforce;
	}

	public void setBruteforce(boolean bruteforce) {
		this.bruteforce = bruteforce;
	}

	public int getFailsafe() {
		return failsafe;
	}

	public void setFailsafe(int failsafe) {
		this.failsafe = failsafe;
	}

	// Testing
	public static void main(String[] args) {

		int goal = 33;
		int[]choices = {4, 9, 35, 8};
		FourNumberProblem problem = new FourNumberProblem(goal, choices);
		
		display(problem);
		
		FourNumberProblemRecursive e = new FourNumberProblemRecursive();
		String prestep = e.generatePrestep(goal-choices[0], choices[0], FourNumberProblem.OP_SUBTRACT);
		display(prestep);
	}



}
