package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			select(array, leftIndex, rightIndex);
			sort(array, leftIndex + 1, rightIndex);
		}
	}

	public void select(T[] array, int leftIndex, int rightIndex) {
		int menor = leftIndex;
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[menor].compareTo(array[j]) > 0) {
				menor = j;
			}
		}
		T temp = array[leftIndex];
		array[leftIndex] = array[menor];
		array[menor] = temp;
	}
}
