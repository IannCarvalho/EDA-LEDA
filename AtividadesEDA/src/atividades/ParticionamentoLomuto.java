package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class ParticionamentoLomuto {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		String numerosEmString[] = linha.split(" ");
		int[] numeros = parseIntArray(numerosEmString);
		particionaLomuto(numeros, 0, numeros.length - 1);
		System.out.println(Arrays.toString(numeros));
		rdr.close();
	}

	public static int[] parseIntArray(String[] strAr) {
		int[] output = new int[strAr.length];
		for (int i = 0; i < strAr.length; i++) {
			output[i] = Integer.parseInt(strAr[i]);
		}

		return output;
	}

	private static int particionaLomuto(int[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] < (array[leftIndex])) {
				i++;
				int aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				System.out.println(Arrays.toString(array));
			}
		}
		int aux = array[i];
		array[i] = array[leftIndex];
		array[leftIndex] = aux;
		System.out.println(Arrays.toString(array));
		return i;
	}
}
