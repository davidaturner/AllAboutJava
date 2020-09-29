package com.fournumbers.classes;

import java.util.ArrayList;

import com.fournumbers.interfaces.Stackable;
import com.fournumbers.interfaces.StackableElement;

public class NumberWithOpStack implements Stackable {

	ArrayList<NumberWithOpElement>stack = new ArrayList<>();
	
	@Override
	public void push(StackableElement toBePushed) {
		stack.add((NumberWithOpElement)toBePushed);	
	}

	@Override
	public StackableElement pop() {
		return (stack.size()>0)?stack.remove(stack.size()-1): null;
	}

	@Override
	public StackableElement peek() {
		return (stack.size()>0)?stack.get(stack.size()-1): null;
	}
	
	// Getters and Setters
	public ArrayList<NumberWithOpElement> getStack() {
		return stack;
	}

	public void setStack(ArrayList<NumberWithOpElement> stack) {
		this.stack = stack;
	}

	public static void main(String[] args) {
		
		String elementNumber = "33";
		String elementOp = "Subtract";
		
		NumberWithOpStack nwo = new NumberWithOpStack();
		NumberWithOpElement toBePushed = new NumberWithOpElement();
		toBePushed.setElementNumber(elementNumber);
		toBePushed.setElementOp(elementOp);
		nwo.push(toBePushed);
		
		int stacksize = nwo.getStack().size();
		for(int i=0; i<stacksize; i++) {
			NumberWithOpElement nwoe = (NumberWithOpElement) nwo.pop();
			System.out.println(nwoe.getElementNumber() + " " + nwoe.getElementOp());
		}
	}

}
