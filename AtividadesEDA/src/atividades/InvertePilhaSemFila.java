package atividades;

import java.util.Scanner;

public class InvertePilhaSemFila {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String maior = rdr.nextLine();
		String linha = rdr.nextLine();
		String numerosEmString[] = linha.split(" ");
		toString(numerosEmString);
		rdr.close();
	}

	public static void toString(String[] palvras) {
		for (String palavra : palvras) {
			System.out.println(palavra);
		}
	}
}
