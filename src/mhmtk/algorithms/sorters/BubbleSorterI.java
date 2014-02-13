package mhmtk.algorithms.sorters;

public class BubbleSorterI {
	
	private static int[] mList;

	//counters
	private static int swapCount;
	private static int compareCount;

	/**
	 * 
	 * @param list the list to be sorted
	 * @return the sorted list
	 */
	public static int[] sort(int[] list){ 
		resetCounters();
		mList=list; 
		
		return mList;
	}

	/**
	 * resets the counters back to zero
	 */
	private static void resetCounters() {
		swapCount = 0; 
		compareCount = 0;
	}


	/**
	 * swaps the elements of the given indexes
	 * 
	 * @param i index of the first element
	 * @param j index of the second element
	 */
	private static void swap(int i, int j) {
		int temp = mList[i];
		mList[i] = mList[j];
		mList[j] = temp;
		swapCount = swapCount +3;
	}

	/**
	 * 
	 * @return the swap count of the last sort
	 */
	public static int getSwapCount() {
		return swapCount;
	}

	/**
	 * 
	 * @return the compare count of the last sort
	 */
	public static int getCompareCount() {
		return compareCount;
	}
}
