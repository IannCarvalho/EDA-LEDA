package atividades;

import java.util.Arrays;

import java.util.Scanner;

public class BuildHeap {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String string = rdr.nextLine();
		int[] array = turnStringToInt(string.split(" "));
		Heap heap = new Heap(array.length);

		heap.buildHeap(array);

		System.out.println(heap.toString());

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

class Heap {
	private int[] heap;
	private int tail;

	public Heap(int capacidade) {
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	private int left(int i) {
		return (i * 2 + 1);
	}

	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public void buildHeap(int[] array) {
		heap = array;
		tail = array.length - 1;

		for (int i = array.length / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	private void heapify(int position) {
		int leftIndex = left(position);
		int rightIndex = right(position);
		int aux = position;

		if (leftIndex <= tail) {
			aux = leftIndex;
		}

		if (rightIndex <= tail) {
			aux = maiorElemento(heap, leftIndex, rightIndex);
		}

		aux = maiorElemento(heap, position, aux);

		if (aux != position) {
			int swap = heap[aux];
			heap[aux] = heap[position];
			heap[position] = swap;
			heapify(aux);
		}
	}

	private int maiorElemento(int[] array, int elem1, int elem2) {
		if (array[elem1] > array[elem2])
			return elem1;
		else
			return elem2;
	}

	public String toString() {
		return Arrays.toString(heap);
	}

}
