package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	/**
	 * Test if the queue is full, if is not, adds an element to the queue. If
	 * element to be added is the first one, head, tail and elements will be
	 * increased by one, if it is not, the tail will be increased by one or go
	 * back to the start and elements will be increased.
	 */
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		tail = (tail + 1) % array.length;
		array[tail] = element;
		elements++;
		if (head == -1) {
			head++;
		}
	}

	/**
	 * Test if the queue is empty, if is not, remove an element of queue.
	 * head will be increased or go back to start, elements will be decreased
	 * and return the removed element.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T elem = array[head];
		head = (head + 1) % array.length;
		elements--;
		return elem;
	}

	/**
	 * Return the first element on the queue, if it is empty, returns null.
	 */
	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}
		return array[head];
	}

	/**
	 * Return a boolean who says if the queue is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return (elements == 0);
	}

	/**
	 * Return a boolean who says if the queue is full or not.
	 */
	@Override
	public boolean isFull() {
		return (elements == array.length);
	}

}
