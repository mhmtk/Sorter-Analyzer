package mhmtk.algorithms.sorters;

//Source code for Heap Sort 
public class HeapSort 
{ 
	private static int[] mList;

	private static int n; 
	private static int left; 
	private static int right; 
	private static int largest;

	//counters
	private int swapCount;
	private int compareCount;

	public void sort(int[] list){ 
		mList=list; 
		buildheap(mList);

		for(int i=n;i>0;i--){ 
			swap(0, i); 
			n=n-1; 
			maxheap(mList, 0); 
		} 
	} 

	private void buildheap(int []a){ 
		n=a.length-1; 
		for(int i=n/2;i>=0;i--){ 
			maxheap(a,i); 
		} 
	} 

	private void maxheap(int[] a, int i){ 
		left=2*i; 
		right=2*i+1; 
		if(left <= n && a[left] > a[i]){ 
			largest=left; 
		} 
		else{ 
			largest=i; 
		} 

		if(right <= n && a[right] > a[largest]){ 
			largest=right; 
		} 
		if(largest!=i){ 
			swap(i,largest); 
			maxheap(a, largest); 
		} 
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