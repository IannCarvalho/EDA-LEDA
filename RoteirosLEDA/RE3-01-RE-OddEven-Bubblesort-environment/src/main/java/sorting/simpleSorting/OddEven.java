package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class OddEven<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex >= 0 && array.length > 0
				&& array.length >= rightIndex) {
			
			boolean sorted = false;
			
			while (!sorted) {
				sorted = true;
				
				for (int x = 1; x < array.length - 1; x += 2)
					if (array[x].compareTo(array[x + 1]) > 0) {
						Util.swap(array, x, x + 1);
						sorted = false;
					}
				
				for (int x = 0; x < array.length - 1; x += 2)
					if (array[x].compareTo(array[x + 1]) > 0) {
						Util.swap(array, x, x + 1);
						sorted = false;
					}
			}
		}
	}
	}