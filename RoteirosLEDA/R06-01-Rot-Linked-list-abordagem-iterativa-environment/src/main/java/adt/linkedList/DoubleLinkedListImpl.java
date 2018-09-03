package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) getHead();
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, head, new DoubleLinkedListNode<T>());

			head.setPrevious(newHead);
			setHead(newHead);

			if (getLast().isNIL()) {
				setLast(newHead);
			} else {
				getLast().setPrevious(newHead);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			if (size() == 1) {
				setHead(new DoubleLinkedListNode<T>());
				setLast(new DoubleLinkedListNode<T>());
			} else {
				DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) super.getHead();
				head.setPrevious(new DoubleLinkedListNode<T>());
				setHead(head);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (size() == 1) {
				DoubleLinkedListNode<T> penultimo = getLast().getPrevious();
				last = penultimo;
				last.setNext(new DoubleLinkedListNode<T>());
			} else {
				DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.head;
				setLast(head);
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
