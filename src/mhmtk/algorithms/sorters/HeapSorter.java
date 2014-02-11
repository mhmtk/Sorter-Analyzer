package mhmtk.algorithms.sorters;

//Source code for Heap Sort 
public class HeapSorter 
{ 
	private static int[] mList;

	private static int n; 
	private static int left; 
	private static int right; 
	private static int largest;

	//counters
	private static int swapCount;
	private static int compareCount;

	/**
	 * 
	 * @param list the list to be sorted
	 * @return the sorted list
	 */
	public static int[] sort(int[] list){ 
		mList=list; 
		buildheap();

		for(int i=n;i>0;i--){ 
			compareCount++; //for the comp that put us into the for-loop
			swap(0, i); 
			n=n-1; 
			maxheap(0); 
		}
		compareCount++; //for the comp that put us outside the for-loop
		return mList;
	} 

	/**
	 * 
	 */
	private static void buildheap(){ 
		n=mList.length-1; 
		for(int i=n/2;i>=0;i--){ 
			compareCount++; //for the comp that put us into the for-loop
			maxheap(i); 
		}
		compareCount++; //for the comp that put us into the for-loop
	} 

	/**
	 * 
	 * @param i
	 */
	private static void maxheap(int i){ 
		left=2*i; 
		right=2*i+1; 
		if(left <= n && mList[left] > mList[i]){
			compareCount = compareCount+2; //for the two comps that put us into the if-statement
			largest=left; 
		}
		else{ 
			compareCount = compareCount+2; //for the two comps that put us into the else-statement
			largest=i; 
		}
		
		if(right <= n && mList[right] > mList[largest]){ 
			largest=right;
			compareCount = compareCount+2; //for the two comps that put us into the if-statement
		} 
		if(largest!=i){
			compareCount++; //for the comp that put us into the if-statement
			swap(i,largest); 
			maxheap(largest); 
		} 
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