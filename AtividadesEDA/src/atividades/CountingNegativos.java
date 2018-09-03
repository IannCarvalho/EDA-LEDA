package atividades;

import java.util.Arrays;
import java.util.Scanner;

public class CountingNegativos {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		String linha = rdr.nextLine();
		String numerosEmString[] = linha.split(" ");
		int[] numeros = parseIntArray(numerosEmString);
		int maior = rdr.nextInt();
		int menor = rdr.nextInt();
		sort(numeros, maior, menor);
		rdr.close();
	}

	private static int[] parseIntArray(String[] strAr) {
		int[] output = new int[strAr.length];
		for (int i = 0; i < strAr.length; i++) {
			output[i] = Integer.parseInt(strAr[i]);
		}

		return output;
	}

	public static void sort(int[] numeros, int maior, int menor) {
		int[] aux = new int[(maior - menor) + 1];
		for (int i = 0; i < numeros.length; i++) {
			aux[numeros[i] - menor]++;
			System.out.println(Arrays.toString(aux));
		}

		for (int i = 1; i < aux.length; i++) {
			aux[i] += aux[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(aux));

		Integer[] resposta = new Integer[numeros.length];
		for (int i = 0; i < numeros.length; i++) {
			resposta[aux[numeros[i] - menor] - 1] = numeros[i];
			aux[numeros[i] - menor]--;
		}
		System.out.println(Arrays.toString(aux));
		System.out.println(Arrays.toString(resposta));
	}
}
