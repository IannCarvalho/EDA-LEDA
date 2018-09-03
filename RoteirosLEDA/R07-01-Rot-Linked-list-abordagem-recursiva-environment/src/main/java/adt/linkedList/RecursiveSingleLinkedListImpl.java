package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return (data == null);
	}

	@Override
	public int size() {
		int contador = 0;

		if (isEmpty()) {
			return contador;
		} else {
			contador++;
			return contador + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (isEmpty()) {
			return null;
		} else if (data.equals(element)) {
			return element;
		} else {
			return next.search(element);
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				data = element;
				next = new RecursiveSingleLinkedListImpl<T>();
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (data.equals(element)) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		toArrayAuxiliar(array, this, 0);
		return array;
	}

	public void toArrayAuxiliar(T[] array, RecursiveSingleLinkedListImpl<T> atual, int i) {
		if (!atual.isEmpty()) {
			array[i] = (T) atual.data;
			i++;
			toArrayAuxiliar(array, atual.next, i);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
