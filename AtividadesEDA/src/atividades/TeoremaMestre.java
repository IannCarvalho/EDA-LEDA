package atividades;

import java.util.Scanner;

public class TeoremaMestre {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		System.out.println("T(n) = theta(" + String.valueOf(teoremaMestre(linha)) + ")");

		rdr.close();

	}

	static String teoremaMestre(String texto) {
		String numeros[] = texto.split(" ");

		int a = Integer.parseInt(numeros[0]);
		int b = Integer.parseInt(numeros[1]);
		int ord = Integer.parseInt(numeros[2]);

		double resultado = Math.log10(a) / Math.log10(b);

		System.out.println(ord);
		System.out.println(resultado);

		if (ord > resultado) {
			return "n**" + String.valueOf(ord);
		} else if (ord < resultado) {
			return "n**" + String.valueOf(ord) + " ** " + resultado;
		} else {
			return "n**" + String.valueOf(ord) + " * log n";
		}
	}
}
