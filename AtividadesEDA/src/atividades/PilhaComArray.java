package atividades;

import java.util.Scanner;

public class PilhaComArray {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		int numero = rdr.nextInt();
		rdr.nextLine();
		String[] opcoes = rdr.nextLine().split(" ");

		int[] array = new int[numero];
		int tail = -1;

		while (!opcoes[0].equals("end")) {
			if (opcoes[0].equals("push")) {
				if (tail == array.length - 1) {
					System.out.println("full");
				} else {
					tail++;
					array[tail] = Integer.parseInt(opcoes[1]);
				}
			} else if (opcoes[0].equals("peek")) {
				if (tail == -1) {
					System.out.println("empty");
				} else {
					System.out.println(array[tail]);
				}
			} else if (opcoes[0].equals("pop")) {
				if (tail == -1) {
					System.out.println("empty");
				} else {
					tail--;
				}
			} else if (opcoes[0].equals("print")) {
				if (tail == -1) {
					System.out.println("empty");
				} else {
					String emString = "";
					for (int i = 0; i <= tail; i++) {
						emString += array[i];
						if (i != tail) {
							emString += " ";
						}
					}
					System.out.println(emString.trim());
				}
			} else if (opcoes[0].equals("end")) {
				break;
			} else {
				System.out.println("opcao invalida");
			}
			opcoes = rdr.nextLine().split(" ");
		}
		rdr.close();
	}
}