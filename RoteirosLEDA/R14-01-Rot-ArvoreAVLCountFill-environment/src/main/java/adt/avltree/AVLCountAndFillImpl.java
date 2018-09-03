package adt.avltree;

import java.util.Arrays;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);
		if (balance > 1) {
			BSTNode<T> leftChild = (BSTNode<T>) node.getLeft();
			if (this.calculateBalance(leftChild) <= -1) {
				this.leftRotation(leftChild);
				this.rightRotation(node);
				LRcounter++;
			} else {
				this.rightRotation(node);
				LLcounter++;
			}
		} else if (balance < -1) {
			BSTNode<T> rightChild = (BSTNode<T>) node.getRight();
			if (this.calculateBalance(rightChild) >= 1) {
				this.rightRotation(rightChild);
				this.leftRotation(node);
				RLcounter++;
			} else {
				this.leftRotation(node);
				RRcounter++;
			}
		}
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		Arrays.sort(array);
		if (array.length > 0)
			addWithoutRebalance(array, 0, array.length);
	}

	public void addWithoutRebalance(T[] array, int begin, int end) {
		if (begin != end) {
			int middle = (end + begin) / 2;
			superInsert(array[middle]);
			addWithoutRebalance(array, begin, middle);
			addWithoutRebalance(array, middle + 1, end);
		}
	}

}
