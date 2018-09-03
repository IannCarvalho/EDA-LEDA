package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node.isEmpty())
			return 0;
		else
			return height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (balance > 1) {
			BSTNode<T> leftChild = (BSTNode<T>) node.getLeft();

			if (calculateBalance(leftChild) <= -1)
				leftRotation(leftChild);

			rightRotation(node);

		} else if (balance < -1) {
			BSTNode<T> rightChild = (BSTNode<T>) node.getRight();

			if (calculateBalance(rightChild) >= 1)
				rightRotation(rightChild);

			leftRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (Math.abs(balance) >= 2)
			rebalance(node);

		if (node.getParent() != null)
			rebalanceUp((BSTNode<T>) node.getParent());

	}

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> balancedNode = Util.leftRotation(node);

		if (balancedNode.getParent() == null)
			root = balancedNode;
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> balancedNode = Util.rightRotation(node);

		if (balancedNode.getParent() == null)
			root = balancedNode;
	}

	@Override
	public void insert(T element) {
		super.insert(element);
		BSTNode<T> node = search(element);
		rebalanceUp(node);
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			node = super.recursiveRemove(node);
			rebalanceUp(node);
		}
	}

}
