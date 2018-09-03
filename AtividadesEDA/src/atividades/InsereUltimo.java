package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class InsereUltimo {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		System.out.println(InsereUltimo(linha));
		rdr.close();
	}

	static String InsereUltimo(String texto) {
		String numeros[] = texto.split(" ");
		int localDoNumero = numeros.length - 1;
		for (int i = numeros.length - 2; i >= 0; i--) {
			if (Integer.parseInt(numeros[localDoNumero]) < Integer.parseInt(numeros[i])) {
				String aux = numeros[localDoNumero];
				numeros[localDoNumero] = numeros[i];
				numeros[i] = aux;
				localDoNumero--;
			} else {
				return Arrays.toString(numeros);
			}

		}
		return Arrays.toString(numeros);
	}

}
