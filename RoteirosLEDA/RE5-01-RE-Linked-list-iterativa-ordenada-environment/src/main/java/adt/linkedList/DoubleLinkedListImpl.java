package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, null, null);
			DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) head;
			if (isEmpty()) {
				setHead(newNode);
			} else {
				while (node.getNext() != null) {
					node = (DoubleLinkedListNode<T>) node.getNext();
				}
				node.setNext(newNode);
				DoubleLinkedListNode<T> aux = node;
				node = (DoubleLinkedListNode<T>) node.getNext();
				node.setPrevious(aux);
			}
			setLast(newNode);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (size() == 1) {
				setHead(null);
			} else {
				DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) head;
				while (node.getNext() != null) {
					if (element.equals(node.getNext().getData())) {
						node.setNext(node.getNext().getNext());
						break;
					}
					node = (DoubleLinkedListNode<T>) node.getNext();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		int i = 0;
		SingleLinkedListNode<T> node = head;
		while (node != null) {
			array[i] = node.getData();
			i++;
			node = node.getNext();
		}
		return array;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> node = head;
		while (node != null) {
			count++;
			node = node.getNext();
		}
		return count;
	}

	@Override
	public T search(T element) {
		T answer = null;
		SingleLinkedListNode<T> node = head;
		while (node != null) {
			if (node.getData().equals(element)) {
				answer = element;
				break;
			}
			node = node.getNext();

		}
		return answer;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) head;
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, node, null);
			setHead(newNode);
			if (!isEmpty()) {
				node.setPrevious(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			setHead(head.getNext());
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			DoubleLinkedListNode<T> deleted = (DoubleLinkedListNode<T>) last;
			DoubleLinkedListNode<T> newLast = (DoubleLinkedListNode<T>) deleted.getPrevious();
			setLast(newLast);
			newLast.setNext(null);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
