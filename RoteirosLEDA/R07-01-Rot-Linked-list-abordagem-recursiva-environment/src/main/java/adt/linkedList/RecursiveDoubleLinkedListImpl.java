package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				data = element;
				setNext(new RecursiveDoubleLinkedListImpl<T>());
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (data.equals(element)) {
				removeFirst();
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			RecursiveDoubleLinkedListImpl<T> second = new RecursiveDoubleLinkedListImpl<T>(this.getData(),
					this.getNext(), this);
			this.setNext(second);
			this.setData(element);
			if (this.getPrevious() == null)
				this.setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> add = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
			this.data = add.getData();
			this.next = add.getNext();

			if (add.getNext() != null) {
				RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) add.getNext();
				aux.previous = this;
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(null);
			} else {
				RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) next;
				aux.removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
