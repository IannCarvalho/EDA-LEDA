package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	/**
	 * If queue is not empty return the first element, if it is return null.
	 */
	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}
		return array[0];
	}

	/**
	 * Return a boolean who says if the queue is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return (tail == -1);
	}

	/**
	 * Return a boolean who says if the queue is full or not.
	 */
	@Override
	public boolean isFull() {
		return (tail == array.length - 1);
	}

	/**
	 * Replace all numbers to the left position.
	 */
	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
			array[i] = array[i + 1];
		}
		tail--;
	}

	/**
	 * Test if the queue is full, if is not, adds an element to the queue. tail
	 * will be increased by one to replace the element on the right place.
	 */
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		tail++;
		array[tail] = element;
	}

	/**
	 * Test if the queue is empty, if is not, remove an element of queue.
	 * shiftLeft will be used to replace all numbers to the left, overwriting
	 * the removed number. The removed number will be returned.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T elem = head();
		shiftLeft();
		return elem;
	}

}
