package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (top.size() == this.size) {
			throw new StackOverflowException();
		}
		top.insertFirst(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (top.isEmpty()) {
			throw new StackUnderflowException();
		}
		T removido = ((RecursiveDoubleLinkedListImpl<T>) top).getData();
		top.removeFirst();
		return removido;
	}

	@Override
	public T top() {
		if (!top.isEmpty()) {
			return ((RecursiveDoubleLinkedListImpl<T>) top).getData();
		}
		return null;

	}

	@Override
	public boolean isEmpty() {
		return (top.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (top.size() == size);
	}

}
