package adt.bst.extended;

import java.util.LinkedList;
import java.util.Queue;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FullRecursiveBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FullRecursiveBST<T> {

	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	// Maxiumum já estava recursivo

	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	// Minimum já estava recursivo

	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a direita
	 * entao o sucessor sera o minimum do filho a direita. Caso contrario o
	 * sucessor sera o primeiro ascendente a ter um valor maior.
	 */
	// Sucessor já estava recursivo

	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a
	 * esquerda entao o predecessor sera o maximum do filho a esquerda. Caso
	 * contrario o predecessor sera o primeiro ascendente a ter um valor menor.
	 */
	// Predecessor já estava recursivo

	@SuppressWarnings("unchecked")
	@Override
	public T[] elementsAtDistance(int k) {
		String s = "";
		Queue<BSTNode<T>> q = new LinkedList<BSTNode<T>>();
		q.add(root);
		s += root.getData() + " ";
		while (!q.isEmpty()) {
			BSTNode<T> n = (BSTNode<T>) q.remove();
			BSTNode<T> leftChild = (BSTNode<T>) n.getLeft();
			BSTNode<T> rightChild = (BSTNode<T>) n.getLeft();
			if(leftChild != null){
				leftChild = (BSTNode<T>) n.getRight();
				s += leftChild.getData() + " ";
				q.add(leftChild);
			}
			if(rightChild != null){
				rightChild = (BSTNode<T>) n.getRight();
				s += rightChild.getData() + " ";
				q.add(rightChild);
			}
			
		}
		System.out.println(s.trim());
	}
}
