package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class InserePrimeiro {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		System.out.println(inserePrimeiro(linha));
		rdr.close();
	}

	static String inserePrimeiro(String texto) {
		String numeros[] = texto.split(" ");
		int localDoNumero = 0;
		for (int i = 1; i < numeros.length; i++) {
			if (Integer.parseInt(numeros[localDoNumero]) > Integer.parseInt(numeros[i])) {
				String aux = numeros[localDoNumero];
				numeros[localDoNumero] = numeros[i];
				numeros[i] = aux;
				localDoNumero++;
			} else {
				return Arrays.toString(numeros);
			}

		}
		return Arrays.toString(numeros);
	}
}