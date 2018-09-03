package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int ini = 0;
		if (leftIndex <= rightIndex) {
			bubbleStep(array, ini, leftIndex, rightIndex);
			sort(array, leftIndex + 1, rightIndex);
		}
	}

	public void bubbleStep(T[] array, int ini, int leftIndex, int rightIndex) {
		for (int j = ini; j <= rightIndex - 1 - leftIndex; j++) {
			if (array[j].compareTo(array[j + 1]) > 0) {
				T aux = array[j];
				array[j] = array[j + 1];
				array[j + 1] = aux;
			}
		}
	}

}
