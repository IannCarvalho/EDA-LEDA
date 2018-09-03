package atividades;

import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int[] array = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			array[i] = Integer.parseInt(valores[i]);
		}
		sc.close();
		mergeSort(array, 0, array.length - 1);
	}

	private static void print(int[] numeros, int comeco, int fim) {
		int[] novoArray = new int[fim - comeco + 1];
		int j = 0;
		for (int i = comeco; i <= fim; i++) {
			novoArray[j++] = numeros[i];
		}
		System.out.println(Arrays.toString(novoArray));
	}

	private static void mergeSort(int[] array, int left, int right) {
		print(array, left, right);
		if (left != right) {
			int meio = (right + left) / 2;
			mergeSort(array, left, meio);
			mergeSort(array, meio + 1, right);
			merge(array, left, right, meio);
		}

	}

	private static void merge(int[] array, int left, int right, int meio) {
		int i = left;
		int j = meio + 1;
		int k = left;

		int[] aux = Arrays.copyOf(array, array.length);

		while (i <= meio && j <= right) {
			if (aux[i] < aux[j]) {
				array[k] = aux[i];
				i++;
			} else {
				array[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= meio) {
			array[k] = aux[i];
			i++;
			k++;
		}
		while (j <= right) {
			array[k] = aux[j];
			j++;
			k++;
		}
		print(array, left, right);
	}

}
