package atividades;

import java.util.Arrays;

import java.util.Scanner;

public class EncaminhamentoEmBST {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String string = rdr.nextLine();

		if (string.trim() == " ".trim()) {
			int[] array = new int[0];
			printArray(array);
		} else {
			int[] array = turnStringToInt(string.split(" "));

			Node root = buildingTree(array, array[0]);

			int[] preOrder = Arrays.copyOf(array, array.length);
			preOrder(preOrder, 0, root);
			int[] order = Arrays.copyOf(array, array.length);
			order(order, 0, root);
			int[] posOrder = Arrays.copyOf(array, array.length);
			posOrder(posOrder, 0, root);
			

			printArray(preOrder);
			printArray(order);
			printArray(posOrder);
		}
		rdr.close();
	}
	
	private static int order(int[] array, int i, Node node) {
		if (node.getLeft() != null)
			i = order(array, i, node.getLeft());
		array[i++] = node.getData();
		if (node.getRight() != null)
			i = order(array, i, node.getRight());
		return i;
	}

	private static int preOrder(int[] array, int i, Node node) {
		array[i++] = node.getData();
		if (node.getLeft() != null)
			i = preOrder(array, i, node.getLeft());
		if (node.getRight() != null)
			i = preOrder(array, i, node.getRight());
		return i;
	}
	
	private static int posOrder(int[] array, int i, Node node) {
		if (node.getLeft() != null)
			i = posOrder(array, i, node.getLeft());
		if (node.getRight() != null)
			i = posOrder(array, i, node.getRight());
		array[i++] = node.getData();
		return i;
	}

	public static int[] turnStringToInt(String[] array) {
		int[] aux = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;
	}

	private static Node buildingTree(int[] array, int value) {
		Node root = new Node(value);

		for (int i = 1; i < array.length; i++) {
			addNode(array[i], root);
		}
		return root;
	}

	private static void addNode(int data, Node node) {
		if (data > node.getData()) {
			if (node.getRight() == null) {
				node.setRight(new Node(data));
			} else {
				addNode(data, node.getRight());
			}
		} else if (data < node.getData()) {
			if (node.getLeft() == null) {
				node.setLeft(new Node(data));
			} else {
				addNode(data, node.getLeft());
			}
		}
	}

	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
}

class Node {
	private Node right;
	private Node left;
	private int data;

	public Node(int data) {
		this.right = null;
		this.left = null;
		this.data = data;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public int getData() {
		return data;

	}
}
