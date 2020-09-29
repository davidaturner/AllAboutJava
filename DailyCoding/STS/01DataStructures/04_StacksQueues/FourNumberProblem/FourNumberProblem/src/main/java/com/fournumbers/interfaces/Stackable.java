package com.fournumbers.interfaces;

public interface Stackable {

	void push(StackableElement toBePushed);
	StackableElement pop();
	StackableElement peek();
}
