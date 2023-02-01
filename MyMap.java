package edu.westga.dsdm.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class MyMap
 * 
 * Maintains a collection of key-value pairs
 * 
 * @author CS3151
 * @version Spring 2023
 */
public class MyMap {

	private Map<String, String> pairs;
	private String specialKey;

	/**
	 * Creates a new MyMap instance
	 * 
	 * @pre none
	 * @post isEmpty()
	 */
	public MyMap() {
		this.pairs = new HashMap<String, String>();
		this.specialKey = null;
	}

	/**
	 * Returns the number of key-value pairs in this collection
	 * 
	 * @pre none
	 * @post none
	 * 
	 * @return the number of key-value pairs
	 */
	public int size() {
		return this.pairs.size();
	}

	/**
	 * Gets the special key
	 * 
	 * @pre none
	 * @post none - no change to any params/vars in the method
	 * 
	 * @return the special key
	 */
	public String getSpecialKey() {
		return this.specialKey;
	}

	/**
	 * Checks if this collection contains a pair with the specified key
	 * 
	 * @pre none
	 * @post none
	 * 
	 * @param key the key of the pair to be checked
	 * @return true if and only if there is a pair with the specified key
	 */
	public boolean containsKey(String key) {
		return this.pairs.containsKey(key);
	}

	/**
	 * Checks if the specified item is the key or value of a key-value pair in this
	 * collection
	 * 
	 * @pre none
	 * @post none
	 * 
	 * @param item the item to be check for being a key or value
	 * @return true if and only if there is a pair containing the specified item as
	 *         a value
	 */
	public boolean contains(String item) {
		return this.pairs.containsValue(item);
	}

	/**
	 * Removes the pair with the specified key
	 * 
	 * @pre none - nothing must hold for the method to terminate
	 * @post NOT containsKey(key) -> what happens if implementation does NOT meet postcon? 
	 * 		the current implementation assumes that ONLY the key is removed (nothing else is changed)
	 * 		postCon is not truly met bc more than one element is changed (key-value are PAIRS)
	 * 		therefore, we should specify removeITEM
	 * 
	 * @param key the key of the key-value pair to be removed
	 */
	public void remove(String key) {
		this.pairs.clear(); // does this meet postcon?
	}

	/**
	 * Adds the specified key-value pair
	 * 
	 * @pre NOT (key == null) AND NOT (value == null)
	 * @post size() == size()@pre + 1 AND containsKey(key)
	 * 		postcon should only refer to PUBLIC params/vars
	 * 		the specification of size @pre is needed to indicate that size at the time of precondition (BEFORE) the method is being changed
	 * 
	 * @param key   the key of the pair to be added
	 * @param value the value of the pair to be added
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public void add(String key, String value) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}
		this.pairs.put(key, value); // this does not meet postcon. bc size MAY not increase guaranteed by calling put()
	}

	/**
	 * Sets the special key to the specified key if the specified key is contained
	 * in this map
	 * 
	 * @pre none
	 * @post (NOT containsKey(key) IMPLIES getSpecialKey() == null) OR
	 *       (getSpecialKey().equals(key))
	 * 
	 * @param key the key of the special value to be set
	 */
	public void setSpecialKey(String key) {
		this.specialKey = null; // postcon TECHNICALLY met by the proposition "p -> T", but the postcon can be written better
	}

	/**
	 * Gets the length of the value with the specified key
	 * 
	 * @pre containsKey(key)
	 * @post none
	 * 
	 * @param key the key of the value
	 * @return the length of the value with the specified key
	 */
	public int getLength(String key) {
		return this.pairs.get(key).length();
	}
}
