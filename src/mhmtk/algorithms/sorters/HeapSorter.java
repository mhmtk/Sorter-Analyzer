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
	 * @param list
	 * @return 
	 */
	public static int[] sort(int[] list){ 
		mList=list; 
		buildheap();

		for(int i=n;i>0;i--){ 
			swap(0, i); 
			n=n-1; 
			maxheap(0); 
		} 
		return mList;
	} 

	/**
	 * 
	 */
	private static void buildheap(){ 
		n=mList.length-1; 
		for(int i=n/2;i>=0;i--){ 
			maxheap(i); 
		} 
	} 

	/**
	 * 
	 * @param i
	 */
	private static void maxheap(int i){ 
		left=2*i; 
		right=2*i+1; 
		if(left <= n && mList[left] > mList[i]){ 
			largest=left; 
		} 
		else{ 
			largest=i; 
		} 

		if(right <= n && mList[right] > mList[largest]){ 
			largest=right; 
		} 
		if(largest!=i){ 
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