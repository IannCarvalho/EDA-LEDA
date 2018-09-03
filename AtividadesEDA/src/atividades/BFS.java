package atividades;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String string = rdr.nextLine();

		int[] array = turnStringToInt(string.split(" "));

		Node root = buildingTree(array, array[0]);

		answer(root);

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

	public static void answer(Node root) {
		String s = "";
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		s += root.getData() + " ";
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			Node leftChild = n.getLeft();
			Node rightChild = n.getRight();
			if (leftChild != null) {
				s += leftChild.getData() + " ";
				q.add(leftChild);
			}
			if (rightChild != null) {
				s += rightChild.getData() + " ";
				q.add(rightChild);
			}
		}
		System.out.println(s.trim());
	}
}

class Node {
	private Node right;
	private Node left;
	private int data;
	private boolean visited;

	public Node(int data) {
		this.right = null;
		this.left = null;
		this.data = data;
		this.visited = false;
	}

	public Node getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
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

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
