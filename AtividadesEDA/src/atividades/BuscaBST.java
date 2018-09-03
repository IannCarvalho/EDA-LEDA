package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class BuscaBST {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String string = rdr.nextLine();
		int searchedNumber = rdr.nextInt();

		if (string.trim() == " ".trim()) {
			int[] array = new int[0];
			printArray(array);
		} else {
			int[] array = turnStringToInt(string.split(" "));

			Node root = buildingTree(array, array[0]);
			int[] answer = answer(BSTsearch(root, array.length, searchedNumber));
			printArray(answer);
		}
		rdr.close();
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

	private static Integer[] BSTsearch(Node root, int length, int searchedNumber) {
		Integer[] array = new Integer[length];

		BSTrecursiveSearch(root, array, 0, searchedNumber);

		return array;
	}

	private static void BSTrecursiveSearch(Node node, Integer[] array, int i, int searchedNumber) {
		if (node.getData() > searchedNumber) {
			array[i++] = node.getData();
			if (node.getLeft() != null) {
				BSTrecursiveSearch(node.getLeft(), array, i, searchedNumber);
			}
		} else if (node.getData() < searchedNumber) {
			array[i++] = node.getData();
			if (node.getRight() != null) {
				BSTrecursiveSearch(node.getRight(), array, i, searchedNumber);
			}
		} else if (node.getData() == searchedNumber) {
			array[i] = node.getData();
		}
	}

	private static int[] answer(Integer[] subAnswer) {
		int counter = 0;
		int i = 0;
		while (i < subAnswer.length) {
			if (subAnswer[i] == null) {
				break;
			}
			i++;
			counter++;
		}

		int[] answer = new int[counter];

		for (int y = 0; y < counter; y++) {
			answer[y] = subAnswer[y];
		}

		return answer;
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
