package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	/**
	 * Returns the last element of the stack, if it is empty, returns null.
	 */
	@Override
	public T top() {
		if (isEmpty()) {
			return null;
		}
		return array[top];
	}

	/**
	 * Return a boolean who says if the stack is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * Return a boolean who says if the stack is full or not.
	 */
	@Override
	public boolean isFull() {
		return (top == array.length - 1);
	}

	/**
	 * Test if the queue is full, if is not, adds an element to the stack. top
	 * will be increased by one to replace the element on the right place.
	 */
	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		top++;
		array[top] = element;
	}

	/**
	 * Test if the queue is empty, if is not, remove an element of stack. top
	 * will be decreased by one, and the removed will be returned.
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		top--;
		return array[top + 1];
	}

}
