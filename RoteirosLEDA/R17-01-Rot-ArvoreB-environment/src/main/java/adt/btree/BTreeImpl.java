package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		int height = -1;

		if (isEmpty())
			return height;
		return recursiveHeight(root, height);
	}

	private int recursiveHeight(BNode<T> node, int height) {
		if (node.isLeaf())
			return ++height;
		return recursiveHeight(node.getChildren().getFirst(), ++height);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BNode<T>[] depthLeftOrder() {
		BNode<T>[] array = new BNode[countNodes(root)];

		depthLeftOrder(array, 0, this.root);

		return array;
	}

	private int countNodes(BNode<T> node) {
		if (node.isEmpty())
			return 0;

		int total = 1;

		for (int i = 0; i < node.getChildren().size(); i++) {
			total += countNodes(node.getChildren().get(i));
		}

		return total;
	}

	private int depthLeftOrder(BNode<T> array[], int index, BNode<T> node) {
		if (!node.isEmpty()) {
			array[index++] = node;

			for (int i = 0; i < node.children.size(); i++) {
				index = depthLeftOrder(array, index, node.children.get(i));
			}
		}

		return index;
	}

	@Override
	public int size() {
		return recursiveSize(root);
	}

	private int recursiveSize(BNode<T> node) {
		if (node.isEmpty())
			return 0;

		int size = node.size();

		for (int i = 0; i < node.getChildren().size(); i++) {
			size += recursiveSize(node.getChildren().get(i));
		}

		return size;
	}

	@Override
	public BNodePosition<T> search(T element) {
		if (element == null)
			return new BNodePosition<T>();

		return search(root, element);
	}

	private BNodePosition<T> search(BNode<T> node, T element) {
		int index = 0;

		while (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0)
			index++;

		if (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) == 0)
			return new BNodePosition<T>(node, index);

		if (node.isLeaf())
			return new BNodePosition<T>();

		return search(node.getChildren().get(index), element);
	}

	@Override
	public void insert(T element) {
		if (element != null)
			insert(root, element);
	}

	private void insert(BNode<T> node, T element) {
		if (node.getChildren().isEmpty()) {
			node.addElement(element);
		} else {
			int i = 0;
			while (i < node.size()) {
				T e = node.getElements().get(i);
				if (e.compareTo(element) > 0) {
					insert(node.getChildren().get(i), element);
					break;
				}
				i++;
			}
			if (i == node.size()) {
				while (node.getChildren().size() <= i) {
					BNode<T> nNode = new BNode<T>(order);
					nNode.setParent(node);
					node.getChildren().add(nNode);
				}
				insert(node.getChildren().get(i), element);
			}
		}
		if (node.size() >= order) {
			split(node);
			if (node.getParent() != null)
				node = node.getParent();
		}
	}

	private void split(BNode<T> node) {
		BNode<T> right = new BNode<>(order);
		BNode<T> left = new BNode<>(order);

		T middle = node.getElements().get((order - 1) / 2);
		boolean addInLeft = true;
		for (T e : node.getElements()) {
			if (e.equals(middle)) {
				addInLeft = false;
			} else if (addInLeft) {
				left.addElement(e);
			} else {
				right.addElement(e);
			}
		}

		if (!node.equals(root)) {
			promote(node, left, right);
		} else {
			for (int i = 0; i < node.getChildren().size(); i++) {
				if (i <= (order - 1) / 2) {
					left.addChild(i, node.getChildren().get(i));
				} else {
					right.addChild(i - ((order - 1) / 2) - 1, node.getChildren().get(i));
				}
			}
			left.setParent(node);
			right.setParent(node);

			node.getChildren().clear();
			node.addChild(0, left);
			node.addChild(1, right);

			node.getElements().clear();
			node.addElement(middle);
		}
	}

	private void promote(BNode<T> node, BNode<T> leftChild, BNode<T> rightChild) {
		BNode<T> parent = node.getParent();
		T element = node.getElementAt((order - 1) / 2);
		parent.addElement(element);

		int position = parent.getElements().indexOf(element);
		parent.removeChild(node);

		leftChild.setParent(parent);
		rightChild.setParent(parent);

		node.parent.removeChild(node);
		node.parent.addChild(position, rightChild);
		node.parent.addChild(position, leftChild);
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
