package mhmtk.algorithms.sorters;

public class QuickSorter{

	private int[] mList;
	
	//counters
	private int swapCount;
	private int compareCount;

	/**
	 * 
	 */
	public QuickSorter() {
	}
	
	/**
	 * 
	 * @param list
	 * @return 
	 */
	public int[] sort(int[] list) {
		resetCounters();
		mList = list;
		quickSort(0, mList.length-1);
		return mList;
	}
	
	/**
	 * resets the counters back to zero
	 */
	private void resetCounters() {
		swapCount = 0;
		compareCount = 0;
	}
	
	/**
	 * 
	 * @param first
	 * @param last
	 */
	private void quickSort(int first, int last) {
		if (first < last) {
			compareCount++; //for the comp that put us into the if-statement
			int pivot = pivotList(first, last);
			quickSort(first, pivot-1);
			quickSort(pivot+1, last);
		}
		compareCount++; //for the comp that put us outside the if-statement
	}

	/**
	 * 
	 * @param first the index of the first element in the part of list to sort
	 * @param last the index of the last element in the part of list to sort
	 * @return
	 */
	private int pivotList(int first, int last) { 
		int pivotValue = mList[first];
		int pivotPoint = first;
		for (int index = first +1; index<=last;index++) {
			compareCount++; //for the comparisons that put is into the for-loop
			if (mList[index]<pivotValue) {
				compareCount++; //for the comparisons that put is into the if-statement
				pivotPoint++;
				swap(mList[pivotPoint], mList[index]);
			}
			compareCount++; //for the comparisons that put is outside the if-statement
		}
		compareCount++; //for the comparisons that put us outside of the for-loop
		//move pivot value into correct place
		swap(first, pivotPoint);
		return pivotPoint;
	}

	/**
	 * swaps the elements of the given indexes
	 * 
	 * @param i index of the first element
	 * @param j index of the second element
	 */
	private void swap(int i, int j) {
		int temp = mList[i];
		mList[i] = mList[j];
		mList[j] = temp;
		swapCount = swapCount +3;
	}
	
	/**
	 * 
	 * @return the swap count of the last sort
	 */
	public int getSwapCount() {
		return swapCount;
	}

	/**
	 * 
	 * @return the compare count of the last sort
	 */
	public int getCompareCount() {
		return compareCount;
	}

}
