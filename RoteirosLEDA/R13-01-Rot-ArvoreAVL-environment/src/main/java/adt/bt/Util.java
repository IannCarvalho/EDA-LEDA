package adt.bt;

import adt.bst.BSTNode;

public class Util {

	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		return rotationDefault(node, node.getRight(), node.getRight().getLeft());
	}

	private static <T extends Comparable<T>> BSTNode<T> rotationDefault(BSTNode<T> node, BTNode<T> newNode,
			BTNode<T> sonNode) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		if (parent != null) {
			// � FILHO ESQUERDO
			if (parent.getLeft() == node) {
				parent.setLeft(newNode);
			} else {
				parent.setRight(newNode);
			}
		}

		newNode.setParent(parent);
		node.setParent(newNode);

		if (newNode.getRight() == sonNode) {
			node.setLeft(sonNode);
			newNode.setRight(node);
			sonNode.setParent(node);
		} else {
			node.setRight(sonNode);
			newNode.setLeft(node);
			sonNode.setParent(node);
		}
		return (BSTNode<T>) newNode;
	}

	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		return rotationDefault(node, node.getLeft(), node.getLeft().getRight());
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
