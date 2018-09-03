package atividades;

import java.util.Scanner;

public class InverteFrase {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		System.out.println(toString(meuSplit(linha)));
		rdr.close();
	}

	public static int size(String texto) {
		int contador = 1;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == ' ') {
				contador++;
			}
		}
		return contador;
	}

	public static String[] meuSplit(String texto) {
		String[] splitFeito = new String[size(texto)];
		int contador = 0;
		String stringDaVez = "";
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == ' ') {
				splitFeito[contador] = stringDaVez;
				contador++;
				stringDaVez = "";
			} else {
				stringDaVez += texto.charAt(i);
			}
		}
		splitFeito[contador] = stringDaVez;
		return splitFeito;
	}

	public static String toString(String[] palvras) {
		String stringPronta = "";
		for (int i = palvras.length - 1; i > -1; i--) {
			stringPronta = stringPronta + palvras[i];
			if (i != 0) {
				stringPronta += " ";
			}
		}
		return stringPronta;
	}
}