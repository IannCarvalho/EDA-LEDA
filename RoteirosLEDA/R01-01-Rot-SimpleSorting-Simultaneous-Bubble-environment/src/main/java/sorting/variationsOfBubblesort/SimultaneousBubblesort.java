package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex >= 0 && array.length > 0
				&& array.length >= rightIndex) {

			int i = leftIndex;
			while (i < rightIndex) {
				boolean temTroca = false;
				int esquerda = leftIndex + i;
				int direita = rightIndex - i;
				while (esquerda < rightIndex && direita > leftIndex) {
					if (array[esquerda].compareTo(array[esquerda + 1]) > 0) {
						Util.swap(array, esquerda, esquerda + 1);
						temTroca = true;
					}
					if (array[direita].compareTo(array[direita - 1]) < 0) {
						Util.swap(array, direita, direita - 1);
						temTroca = true;
					}
					esquerda++;
					direita--;
				}
				if (!temTroca) {
					break;
				}
				i++;
			}
		}
	}
}