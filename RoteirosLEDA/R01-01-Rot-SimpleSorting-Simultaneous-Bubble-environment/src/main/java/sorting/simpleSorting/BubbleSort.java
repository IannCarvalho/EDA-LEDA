package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex >= 0 && array.length > 0
				&& array.length >= rightIndex) {

			int i = leftIndex;
			while (i < rightIndex) {
				boolean temTroca = false;
				for (int y = leftIndex; y < rightIndex - i; y++) {
					if (array[y].compareTo(array[y + 1]) > 0) {
						Util.swap(array, y, y + 1);
						temTroca = true;
					}
				}
				if (!temTroca) {
					break;
				}
				i++;
			}
		}

	}
}