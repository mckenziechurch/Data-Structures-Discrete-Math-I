package edu.westga.dsdm.model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedListStack - implements the Stack interface 
 * 
 * @author mcken
 * @version Spring 2023
 * @param <T> the type of the stack elements
 * 
 * LIFO
 */
public class LinkedListStack<T> implements IterableStack<T> {
	private LinkedList<T> elements;
	
	/**
	 * Initialize newly created stack (linkedList)
	 */
	public LinkedListStack() {
		this.elements = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		return this.elements.isEmpty();
	}

	@Override
	public int size() {
		return this.elements.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.elements.iterator();
	}

	@Override
	public void push(T newValue) {
		// add newValue to the beginning of the list
		this.elements.addFirst(newValue);
	}

	@Override
	public T peek() {
		// return element at the beginning of the list (which is inherently, the most recently-added)
		return this.elements.getFirst();
	}

	@Override
	public T pop() {
		return this.elements.removeFirst();
	}
	// remember: stack functions as LIFO
	
}
