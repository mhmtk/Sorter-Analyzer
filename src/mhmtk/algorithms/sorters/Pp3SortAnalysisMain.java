package mhmtk.algorithms.sorters;
import mhmtk.algorithms.rengens.RandomListGenerator;

public class Pp3SortAnalysisMain {

	static int Nmin=1000;
	static int Nincrement=1000;
	static int Nmax=1000;

	static int[][] results = new int[(Nmax-Nmin)/Nincrement +1][7];

	public static void main(String[] args) {
		testHMQ();
		printHMQResults();
	}

	private static void testHMQ() {

		// for loop to run the test for different N values
		for (int n=Nmin; n <= Nmax; n=n+Nincrement) {

			//get a list with random numbers, size=N
			RandomListGenerator rlg = new RandomListGenerator(n);
			//make 3 copies of this list
			int[] testList1 = rlg.getRandomList();
			int[] testList2 = testList1;
			int[] testList3 = testList1;

			for (int i=0; i<testList3.length; i++) {
				System.out.println(testList3[i]);
			}
			//sort the testList's respective copy w/ each algorithm
			//			int[] hlist = 
			HeapSorter.sort(testList1);
			//			for (int i=0;i<hlist.length; i++) {
			//				System.out.println(hlist[i]);
			//			}
			//			int[] mlist = 
			MergeSorter.sort(testList2);
			//			for (int i=0;i<mlist.length; i++) {
			//				System.out.println(mlist[i]);
			//			}
			//			int[] qlist = 
			QuickSorter.sort(testList3);
			//			for (int i=0;i<qlist.length; i++) {
			//				System.out.println(qlist[i]);
			//			}
			for (int i=0; i<testList3.length; i++) {
				System.out.println(testList3[i]);
			}

			//store the results
			results[n/Nincrement-1][0] = n;
			results[n/Nincrement-1][1] = HeapSorter.getSwapCount();
			results[n/Nincrement-1][2] = HeapSorter.getCompareCount();
			results[n/Nincrement-1][3] = MergeSorter.getSwapCount();
			results[n/Nincrement-1][4] = MergeSorter.getCompareCount();
			results[n/Nincrement-1][5] = QuickSorter.getSwapCount();
			results[n/Nincrement-1][6] = QuickSorter.getCompareCount();
			System.out.println(results[n/Nincrement-1][5] + results[n/Nincrement-1][6]);
		}

	}

	private static void printHMQResults()
	{
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
