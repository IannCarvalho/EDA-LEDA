package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			throw new HashtableOverflowException();
		}
		if (element != null && search(element) == null) {
			hashFunction(element, 1);
			int i = 0;
			int hashIndex = hashFunction(element, i);
			while (i < capacity()) {
				if (table[hashIndex] == null || deletedElement.equals(table[hashIndex])) {
					table[hashIndex] = element;
					elements++;
					return;
				} else {
					i++;
					hashIndex = hashFunction(element, i);
					COLLISIONS++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && indexOf(element) != -1) {
			int hashIndex = indexOf(element);
			table[hashIndex] = deletedElement;
			elements--;
		}
	}

	@Override
	public T search(T element) {
		if (element != null) {
			int i = 0;
			int hashIndex = hashFunction(element, i);
			while (i < capacity() && table[hashIndex] != null && !deletedElement.equals(table[hashIndex])) {
				if (table[hashIndex].equals(element)) {
					return element;
				} else {
					i++;
					hashIndex = hashFunction(element, i);
				}
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		if (element != null) {
			int i = 0;
			int hashIndex = hashFunction(element, i);
			while (i < capacity() && table[hashIndex] != null && !deletedElement.equals(table[hashIndex])) {
				if (table[hashIndex].equals(element)) {
					return hashIndex;
				} else {
					i++;
					hashIndex = hashFunction(element, i);
				}
			}
		}
		return -1; // INVALID INDEX
	}

	private int hashFunction(T element, int i) {
		int hashIndex = ((HashFunctionOpenAddress<T>) super.hashFunction).hash(element, i);
		return hashIndex;
	}
}
