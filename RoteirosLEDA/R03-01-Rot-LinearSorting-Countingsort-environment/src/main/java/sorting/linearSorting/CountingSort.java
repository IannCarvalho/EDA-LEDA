package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int maior = procuraMaiorElemento(array, leftIndex, rightIndex);

			int[] contador = new int[maior + 1];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				contador[array[i]]++;
			}

			for (int i = 1; i < contador.length; i++) {
				contador[i] += contador[i - 1];
			}

			Integer[] resposta = new Integer[array.length];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				resposta[contador[array[i]] - 1] = array[i];
				contador[array[i]]--;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = resposta[i];
			}
		}
	}

	public int procuraMaiorElemento(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior)
				maior = array[i];
		}
		return maior;
	}
}
