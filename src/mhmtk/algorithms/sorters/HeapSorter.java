package mhmtk.algorithms.sorters;

/**
 * 
 * @author mehmetk
 * @version Feb 6th, 2014
 */
public class HeapSorter {

	private int[] mList;

	//counters
	private int swapCount;
	private int compareCount;

	/**
	 * Constructor 
	 */
	public HeapSorter() {}

	/**
	 * HeapSorts the given list
	 * @return 
	 * 
	 * @paran list the list to be sorted
	 */
	public int[] sort(int[] list) {
		resetCounters();
		mList = list;
		heapSort(mList.length);
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
	 * @param N size of the list
	 */
	private void heapSort(int N) {
		for (int i= N/2; i>=0; i--) {
			compareCount++; //for the comparisons that put is into the for-loop
			fixHeap(i, mList[i], N-1);
		}
		compareCount++; //for the comparisons that put is outside the for-loop
		for (int i=N-1; i>=1; i--) {
			compareCount++; //for the comparisons that put is into the for-loop
			int max=mList[1];
			fixHeap(1, mList[i], i);
			mList[i]=max;
		}
		compareCount++; //for the comparisons that put is outside the for-loop
	}

	/**
	 * 
	 * @param root
	 * @param key
	 * @param bound
	 */
	private void fixHeap(int root, int key, int bound) {
		int vacant = root;
		if (vacant==0) 
				vacant = 1;
		while (2*vacant <=bound) {
			compareCount++; //for the comparisons that put is into the while-loop
			int largerChild = 2*vacant;
			//find the larger of the two children
			if (largerChild < bound && 
					mList[largerChild+1] > mList[largerChild]) {
				compareCount = compareCount +2; //for the comparisons that put is into the if=statement
				largerChild = largerChild+1;
			}
			compareCount = compareCount +2; //for the comparisons that put is outside the if=statement
			
			//does the key belong above this child?
			if (key>mList[largerChild]) {
				compareCount++; //for the comparisons that put is into the if-statement
				//yes, stop looping
				break;
			}
			else {
				compareCount++; //for the comparisons that put is into the else-statement
				//no, move the larger child up
				mList[vacant] = mList[largerChild];
				swapCount++;
				vacant = largerChild;
			}
			compareCount++; //for the comparisons that put is into the if-statement
		}
		compareCount++; //for the comparisons that put is outside the while-loop
		
		mList[vacant] = key;
		swapCount++;
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