package mhmtk.algorithms.sorters;

public class MergeSorter {

	private int[] mList;

	//counters
	private int swapCount; 
	private int compareCount;

	/**
	 * 
	 */
	public MergeSorter() {
	}

	/**
	 * 
	 * @param list
	 * @return 
	 */
	public int[] sort(int[] list) {
		resetCounters();
		mList = list;
		mergeSort(0, mList.length -1);
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
	 * @param first the index of the first element in the part of list to sort
	 * @param last the index of the last element in the part of list to sort
	 */
	private void mergeSort(int first, int last) {
		if (first < last) {
			compareCount++; //for the comp that put us into the if-statement
			int middle = (first + last)/2;
			mergeSort(first, middle);
			mergeSort(middle+1, last);
			mergeLists(first, middle, middle +1, last);
		}
		compareCount++; //for the comp that put us outside the if-statement
	}

	/**
	 * 
	 * @param start1
	 * @param end1
	 * @param start2
	 * @param end2
	 */
	private void mergeLists(int start1, int end1, int start2, int end2) {
		int finalStart = start1;
		int finalEnd = end2;
		int indexC = 0;
		int[] result = new int[end2 - start1+1]; //?
		while (start1<=end1 && start2<=end2) {
			compareCount++; //for the comp that put us into the while-loop
			if (mList[start1] < mList[start2]) {
				compareCount++; //for the comp that put us into the if-statement
				result[indexC] = mList[start1];
				swapCount++;
				start1++;
			} 
			else {
				compareCount++; //for the comp that put us into the else-statement
				result[indexC] = mList[start2];
				swapCount++;
				start2++;
			}
			compareCount++; //for the comp that put us outside the if-statement
			indexC++;
		}
		compareCount++; //for the comp that put us outside the while-loop

		//move the part of the list that is left over
		if (start1<=end1) {
			compareCount++; //for the comp that put us into the if-statement
			for (int i=start1; i <= end1; i++) {
				compareCount++; //for the comp that put us into the for-loop
				result[indexC] = mList[i];
				swapCount++;
				indexC++;
			}
			compareCount++; //for the comp that put us outside the for-loop
		}
		else {
			compareCount++; //for the comp that put us into the else-statement
			for (int i=start2; i <= end2; i++) {
				compareCount++; //for the comp that put us into the for-loop
				result[indexC] = mList[i];
				swapCount++;
				indexC++;
			}
			compareCount++; //for the comp that put us outside the for-loop
		}
		compareCount++; //for the comp that put us outside the if-statement

		//now put the result back into the list
		indexC=0;
		for (int i=finalStart; i <= finalEnd; i++) {
			compareCount++; //for the comp that put us into the for-loop
			mList[i] = result[indexC];
			swapCount++;
			indexC++;
		}
		compareCount++; //for the comp that put us outside the for-loop
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
