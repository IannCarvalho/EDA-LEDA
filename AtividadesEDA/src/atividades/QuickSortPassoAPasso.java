package atividades;

import java.util.Scanner;

public class QuickSortPassoAPasso {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		String numerosEmString[] = linha.split(" ");
		int[] numeros = parseIntArray(numerosEmString);
		sort(numeros, 0, numeros.length - 1);
		rdr.close();
	}

	public static int[] parseIntArray(String[] strAr) {
		int[] output = new int[strAr.length];
		for (int i = 0; i < strAr.length; i++) {
			output[i] = Integer.parseInt(strAr[i]);
		}

		return output;
	}

	public static void sort(int[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex) {
			int pivot = particionaLomuto(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private static int particionaLomuto(int[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] < (array[leftIndex])) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i, leftIndex);
		print(array);
		return i;
	}

	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public static void print(int[] array) {
		String arrayEmString = "";
		for (int i = 0; i < array.length; i++) {
			arrayEmString += array[i];
			if (i != array.length - 1) {
				arrayEmString += " ";
			}
		}
		System.out.println(arrayEmString);
	}
}
