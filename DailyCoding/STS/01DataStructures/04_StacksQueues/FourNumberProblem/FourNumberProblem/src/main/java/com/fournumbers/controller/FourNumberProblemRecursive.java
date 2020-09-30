package com.fournumbers.controller;

import com.fournumbers.classes.FourNumberProblem;
import com.fournumbers.interfaces.Evaluable;

public class FourNumberProblemEvaluator implements Evaluable {

	private FourNumberProblem problem;
	private String evaluation;
	private boolean bruteforce = false;
	
	@Override
	public String evaluate() {
		return evaluate(this.problem);
	}
	
	public String evaluate(FourNumberProblem problem) {
		return null;
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

	// Testing
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
