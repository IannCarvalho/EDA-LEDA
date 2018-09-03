package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class ParticionaEstavel {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String texto = rdr.nextLine();
		String numeros[] = texto.split(" ");
		System.out.println(sort(numeros, 0));
		rdr.close();
	}

	public static String sort(String[] numeros, int indicePivot) {
		int i = 1;
		while (i < numeros.length) {
			if (Integer.parseInt(numeros[indicePivot]) >= Integer.parseInt(numeros[i])) {
				for (int j = i; j > indicePivot; j--) {
					String aux = numeros[j];
					numeros[j] = numeros[j - 1];
					numeros[j - 1] = aux;
				}
				indicePivot += 1;
			}
			i += 1;
		}
		return Arrays.toString(numeros);
	}
}