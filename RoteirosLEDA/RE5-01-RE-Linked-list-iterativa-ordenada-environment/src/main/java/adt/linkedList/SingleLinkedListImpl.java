package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = null;
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
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, null);
			SingleLinkedListNode<T> node = head;
			if (isEmpty()) {
				head = newNode;
			} else {
				while (node.getNext() != null) {
					node = node.getNext();
				}
				node.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			SingleLinkedListNode<T> node = head;
			if (!isEmpty()) {
				if (size() == 1) {
					setHead(null);
				} else {
					while (node != null) {
						if (node.getNext() == null) {
							node = null;
							break;
						} else if (node.getNext().getData().equals(element)) {
							node.setNext(node.getNext().getNext());
							break;
						}
						node = node.getNext();
					}
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

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
