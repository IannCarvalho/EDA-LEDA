package adt.hashtable.closed;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionDivisionMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import util.Util;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size. For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
			// the immediate prime
			// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method, realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number. You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
		// If number is even, turn it to odd, because even numbers is not prime.
		if (number % 2 == 0) {
			number++;
		}
		// Just consider the odd numbers and verifies if it is prime.
		while (!Util.isPrime(number))
			number += 2;
		return number;
	}

	@SuppressWarnings("unchecked")
	private LinkedList<T> getCell(int index) {
		if (super.table[index] == null) {
			super.table[index] = new LinkedList<T>();
		}
		return (LinkedList<T>) super.table[index];
	}

	private int CellIndex(T element) {
		int index = ((HashFunctionDivisionMethod<T>) getHashFunction()).hash(element);
		LinkedList<T> cell = getCell(index);
		int CellIndex = 0;
		int elementHash = element.hashCode();
		for (T walker : cell) {
			int walkerHash = walker.hashCode();
			// assuming that elements are equals if their hashcode are equals
			if (walkerHash == elementHash) {
				break;
			}
			CellIndex++;
		}
		if (CellIndex == cell.size()) {
			CellIndex = -1;
		}
		return CellIndex;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			int indexCell = ((HashFunctionDivisionMethod<T>) getHashFunction()).hash(element);
			boolean containsElement = CellIndex(element) != -1;
			boolean positionHasElements = !getCell(indexCell).isEmpty();
			if (!containsElement) {
				if (positionHasElements) {
					COLLISIONS++;
				}
				getCell(indexCell).add(element);
				elements++;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			int indexCell = ((HashFunctionDivisionMethod<T>) getHashFunction()).hash(element);
			int elementCellPosition = CellIndex(element);
			int cellSize = getCell(indexCell).size();
			if (elementCellPosition != -1) {
				if (cellSize > 1) {
					COLLISIONS--;
				}
				getCell(indexCell).remove(elementCellPosition);
				elements--;
			}
		}
	}

	@Override
	public int search(T element) {
		int index = -1;
		if (element != null && !this.isEmpty()) {
			int elementPosition = ((HashFunctionDivisionMethod<T>) getHashFunction()).hash(element);
			if (CellIndex(element) != -1) {
				index = elementPosition;
			}
		}
		return index;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if (element != null && !this.isEmpty()) {
			int elementPosition = ((HashFunctionDivisionMethod<T>) getHashFunction()).hash(element);
			if (CellIndex(element) != -1) {
				index = elementPosition;
			}
		}
		return index;
	}

}
