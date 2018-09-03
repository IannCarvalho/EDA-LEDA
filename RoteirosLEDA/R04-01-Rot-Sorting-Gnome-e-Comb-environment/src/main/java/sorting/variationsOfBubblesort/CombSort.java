package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			double fator = 1.25;
			int gap = (int) (rightIndex - leftIndex + 1 / fator);

			while (gap >= 1) {
				for (int i = leftIndex; i + gap <= rightIndex; i++) {
					if (array[i].compareTo(array[i + gap]) > 0) {
						util.Util.swap(array, i, i + gap);
					}
				}
				gap = (int) (gap / fator);
			}
		}
	}
}
