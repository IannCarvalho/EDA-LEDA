package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (getHead().isNIL());
	}

	@Override
	public int size() {
		int contador = 0;
		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = getHead();
			while (!aux.isNIL()) {
				contador++;
				aux = aux.getNext();
			}
		}
		return contador;
	}

	@Override
	public T search(T element) {
		if (!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = getHead();
			while (!aux.isNIL()) {
				if (aux.getData().equals(element)) {
					return element;
				}
				aux = aux.getNext();
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> proximo = new SingleLinkedListNode<T>();
			if (isEmpty()) {
				SingleLinkedListNode<T> head = new SingleLinkedListNode<T>(element, proximo);
				setHead(head);
			} else {
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL()) {
					aux = aux.getNext();
				}
				aux.setData(element);
				aux.setNext(proximo);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (this.head.getData().equals(element)) {
				head = head.getNext();
			} else {
				SingleLinkedListNode<T> previous = new SingleLinkedListNode<T>();
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.getNext();
				}
				if (!aux.isNIL()) {
					previous.setNext(aux.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.getHead();
		T[] array = (T[]) new Object[size()];
		int i = 0;
		while(!aux.isNIL()){
			array[i] = aux.getData();
			aux = aux.getNext();
			i++;
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
