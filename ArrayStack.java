/**
 * 
 */
package edu.westga.dsdm.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayStack - implements the Stack interface
 * 
 * @author mcken
 * @version Spring 2023
 * @param <T> the type of the stack elements
 * 
 * LIFO
 */
public class ArrayStack<T> implements IterableStack<T> {
	private ArrayList<T> elements;
	private int last;
	private int size;
	
	/**
	 * Initialize newly created stack (arrayList)
	 */
	public ArrayStack() {
		this.elements = new ArrayList<T>();
		this.last = 0;
		this.size = 0;
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
		this.elements.add(last, newValue);
		this.last++;
		this.size++;
		
		if (last > this.elements.size() - 1) {
			last = 0;
		}
	}

	@Override
	public T peek() {
		return this.elements.get(last);
	}

	@Override
	public T pop() {
		this.size--;
		return this.elements.remove(last);
	}

}
