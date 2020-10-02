package com.example.demo.classes;

import java.util.ArrayList;

import com.example.demo.interfaces.Stackable;

public class BasicStack implements Stackable{
	
	private ArrayList<String>stack = new ArrayList<>();

	@Override
	public void push(String ontoStack) {
		
		stack.add(ontoStack);
	}

	@Override
	public String pop() {
		
		return (stack.size()>0)?stack.remove(stack.size()-1):null;
	}

	@Override
	public String peek() {

		return (stack.size()>0)?stack.get(stack.size()-1): null;
	}
	
	// Getters and Setters
	public ArrayList<String> getStack() {
		return stack;
	}

	public void setStack(ArrayList<String> stack) {
		this.stack = stack;
	}

	public static void main(String[] args) {

		BasicStack bs = new BasicStack();
		
		System.out.print("Push: ");
		for(int i=0; i<10; i++) {
			System.out.print(i + " ");
			bs.push("" + i);
		}
		System.out.println("Size: " + bs.getStack().size());
		System.out.print("Pop: ");
		int size = bs.getStack().size();
		for(int i=0; i<size; i++) {
			System.out.print(bs.pop() + " ");	
		}
		System.out.println("Size: " + bs.getStack().size());
	}

}