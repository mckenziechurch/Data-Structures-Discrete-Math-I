package edu.westga.dsdm.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayQueue - implements the Queue interface
 * 
 * @author mcken
 * @version Spring 2023
 * @param <T> the type of the queue elements
 * 
 * FIFO
 */
public class ArrayQueue<T> implements IterableQueue<T> {
	private ArrayList<T> elements;
	private int last;
	private int first;
	private int size;
	
	/**
	 * Initialize newly created queue (arrayList)
	 */
	public ArrayQueue() {
		this.elements = new ArrayList<T>();
		this.last = 0;
		this.first = 0;
		this.size = 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return this.elements.iterator();
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
	public void enqueue(T newValue) {
		this.elements.add(last, newValue);
		last++;
		this.size++;
		
		if (last > this.elements.size() - 1) {
			last = 0;
		}
	}

	@Override
	public T peek() {
		return this.elements.get(first);
	}

	@Override
	public T dequeue() {
		this.size--;
		return this.elements.remove(first);
	}

}
