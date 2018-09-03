package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex >= 0 && array.length > 0
				&& array.length >= rightIndex) {

			for (int i = leftIndex; i < rightIndex; i++) {
				int indiceDoMenor = i;
				for (int j = i + 1; j <= rightIndex; j++) {
					if (array[j].compareTo(array[indiceDoMenor]) < 0)
						indiceDoMenor = j;
				}
				Util.swap(array, indiceDoMenor, i);
			}
		}
	}
}
