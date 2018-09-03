package atividades;

import java.util.Scanner;

public class Parenteses {
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		if (valido(linha)) {
			System.out.println('S');
		} else {
			System.out.println('N');
		}
		rdr.close();
	}

	public static boolean valido(String linha) {
		int direita = 0;
		int esquerda = 0;
		for (int i = 0; i < linha.length(); i++) {
			if (direita >= esquerda) {
				if (linha.charAt(i) == '(') {
					direita++;
				} else if (linha.charAt(i) == ')') {
					esquerda++;
				}
			} else {
				return false;
			}
		}
		if (direita != esquerda) {
			return false;
		}
		return true;
	}

}
