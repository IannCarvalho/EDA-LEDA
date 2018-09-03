package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class Rotacoes {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String string = rdr.nextLine();
		int[] array = turnStringToInt(string.split(" "));
		AVL avl = new AVL();

		for (int value : array)
			avl.add(value);

		avl.balenceIT();

		rdr.close();
	}

	public static int[] turnStringToInt(String[] array) {
		int[] aux = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;
	}
}

class AVL {
	private Node root;

	public AVL() {
		this.root = null;
	}

	public void add(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			recursiveAdd(value, root);
		}
	}

	private void recursiveAdd(int value, Node node) {
		if (value > node.getValue()) {
			if (node.getRight() == null) {
				node.setRight(new Node(value));
			} else {
				recursiveAdd(value, node.getRight());
			}
		} else if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(value));
			} else {
				recursiveAdd(value, node.getLeft());
			}
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
	}

	public int getBalance() {
		if (root == null)
			return 0;

		return height(root.getLeft()) - height(root.getRight());
	}

	public void balenceIT() {
		if (root.getRight() != null && root.getLeft() != null)
			System.out.println("balanceada");
		else {
			int balance = getBalance();
			while (balance < -1 || balance > 1) {
				if (balance > 1) {
					if (root.getLeft().getRight() == null) {
						System.out.println("rot_dir(" + root.getValue() + ")");
						Node aux = root;
						root = root.getLeft();
						root.setRight(aux);
						aux.setLeft(null);
						System.out.println(Arrays.toString(preOrder()));
					} else {
						Node aux = root.getLeft();
						System.out.println("rot_esq(" + aux.getValue() + ")");
						root.setLeft(aux.getRight());
						aux.getRight().setLeft(aux);
						aux.setRight(null);
						System.out.println(Arrays.toString(preOrder()));
					}
				} else {
					if (root.getRight().getLeft() == null) {
						System.out.println("rot_esq(" + root.getValue() + ")");
						Node aux = root;
						root = root.getRight();
						root.setLeft(aux);
						aux.setRight(null);
						System.out.println(Arrays.toString(preOrder()));
					} else {
						Node aux = root.getRight();
						System.out.println("rot_dir(" + aux.getValue() + ")");
						root.setRight(aux.getLeft());
						aux.getLeft().setRight(aux);
						aux.setLeft(null);
						System.out.println(Arrays.toString(preOrder()));
					}
				}
				balance = getBalance();
			}
		}
	}

	public int[] preOrder() {
		int[] array = new int[3];
		recursivePreOrder(array, 0, root);
		return array;
	}

	private int recursivePreOrder(int[] array, int i, Node node) {
		if (node != null) {
			array[i++] = node.getValue();
			i = recursivePreOrder(array, i, node.getLeft());
			i = recursivePreOrder(array, i, node.getRight());
		}
		return i;
	}

}

class Node {
	private int value;
	private Node left, right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
