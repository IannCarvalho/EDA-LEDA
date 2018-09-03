package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			int menor = menor(array);
			int maior = maior(array);

			int[] aux = new int[(maior - menor) + 1];
			for (int i = leftIndex; i <= rightIndex; i++) {
				aux[array[i] - menor]++;
			}

			for (int i = 1; i < aux.length; i++) {
				aux[i] += aux[i - 1];
			}

			Integer[] resposta = new Integer[array.length];
			for (int i = leftIndex; i <= rightIndex; i++) {
				resposta[aux[array[i] - menor] - 1] = array[i];
				aux[array[i] - menor]--;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = resposta[i];
			}
		}
	}

	public int maior(Integer[] array) {
		int maior = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior)
				maior = array[i];
		}

		return maior;
	}

	public int menor(Integer[] array) {
		int menor = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor)
				menor = array[i];
		}

		return menor;
	}
}
