package mhmtk.algorithms.sorters;
import mhmtk.algorithms.rengens.RandomListGenerator;

public class Pp4SortAnalysisMain {

	static int Nmin=100;
	static int Nincrement=100;
	static int Nmax=100;

	static int[][] results = new int[(Nmax-Nmin)/Nincrement +1][7];

	public static void main(String[] args) {
		test();
	}

	private static void test() {

		//create sorters
		HeapSorter hSorter = new HeapSorter();
		MergeSorter mSorter = new MergeSorter();
		QuickSorter qSorter = new QuickSorter();

		for (int n=Nmin; n <= Nmax; n=n+Nincrement) {

			//get a list with random numbers, size=N
			RandomListGenerator rlg = new RandomListGenerator(n);
			int[] testList = rlg.getRandomList();

			//sort a copy of the testList w/ each algorithm
			int[] hlist = 
					hSorter.sort(testList);
			for (int i=0;i<hlist.length; i++) {
				System.out.println(hlist[i]);
			}
//			int[] mlist = 
					mSorter.sort(testList);
//			for (int i=0;i<mlist.length; i++) {
//				System.out.println(mlist[i]);
//			}
//			int[] qlist = 
					qSorter.sort(testList);
//			for (int i=0;i<qlist.length; i++) {
//				System.out.println(qlist[i]);
//			}

			//store the results
			results[n/Nincrement-1][0] = n;
			results[n/Nincrement-1][1] = hSorter.getSwapCount();
			results[n/Nincrement-1][2] = hSorter.getCompareCount();
			results[n/Nincrement-1][3] = mSorter.getSwapCount();
			results[n/Nincrement-1][4] = mSorter.getCompareCount(); 
			results[n/Nincrement-1][5] = qSorter.getSwapCount();
			results[n/Nincrement-1][6] = qSorter.getCompareCount();
		}
		for (int i=0; i<results.length; i++)
			System.out.println(
					"For N = " + results[i][0] +
					", HeapSort did " + results[i][1] + " swaps , and "
					+ results[i][2] + " comparisons" +
					", MergeSort did " + results[i][3] + " swaps , and "
					+ results[i][4] + " comparisons" +
					", QuickSort did " + results[i][5] + " swaps , and "
					+ results[i][6] + " comparisons.");
	}
}
