package atividades;

import java.util.Scanner;

public class MaxHeap {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String string = rdr.nextLine();

		int[] array = turnStringToInt(string.split(" "));

		System.out.println(isHeap(array));

		rdr.close();
	}

	public static int[] turnStringToInt(String[] array) {
		int[] aux = new int[array.length + 1];

		aux[0] = -1;
		for (int i = 0; i < array.length; i++) {
			aux[i + 1] = Integer.parseInt(array[i]);
		}
		return aux;
	}

	public static boolean isHeap(int[] array) {
		int i = 1;
		boolean isHeap = true;
		while (i <= array.length) {
			if (leftExists(i, array.length)) {
				if (array[i] < array[2 * i]) {
					isHeap = false;
					break;
				}
			}
			if (rightExists(i, array.length)) {
				if (array[i] < array[2 * i + 1]) {
					isHeap = false;
					break;
				}
			}
			i++;
		}
		return isHeap;
	}

	public static boolean leftExists(int i, int len) {
		return (2 * i < len);
	}

	public static boolean rightExists(int i, int len) {
		return (2 * i + 1 < len);
	}

}
