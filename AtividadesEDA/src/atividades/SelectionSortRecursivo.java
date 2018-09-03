package atividades;

import java.util.Arrays;

import java.util.Scanner;

public class SelectionSortRecursivo {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String texto = rdr.nextLine();
		String numeros[] = texto.split(" ");
		sort(numeros, 0);
		rdr.close();
	}

	public static void sort(String[] numeros, int k) {
		int indiceDoMenor = k;
		for (int j = k + 1; j < numeros.length; j++) {
			if (Integer.parseInt(numeros[j]) < Integer.parseInt(numeros[indiceDoMenor])) {
				indiceDoMenor = j;
			}
		}
		String aux = numeros[indiceDoMenor];
		numeros[indiceDoMenor] = numeros[k];
		numeros[k] = aux;
		if (k < numeros.length - 1) {
			System.out.println(Arrays.toString(numeros));
			sort(numeros, k + 1);
		}
	}
}