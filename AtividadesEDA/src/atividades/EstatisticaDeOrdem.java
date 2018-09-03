package atividades;

import java.util.Scanner;

public class EstatisticaDeOrdem {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		System.out.println(estatistica(linha));
		rdr.close();
	}

	public static int estatistica(String texto) {
		String numeros[] = texto.split(" ");
		int estatistica = 1;
		for (int i = 1; i < numeros.length; i++) {
			if (Integer.parseInt(numeros[i]) < Integer.parseInt(numeros[0])) {
				estatistica++;
			}
		}
		return estatistica;
	}

}
