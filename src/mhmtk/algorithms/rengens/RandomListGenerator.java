package mhmtk.algorithms.rengens;

public class RandomListGenerator {

	private int N;
	private int[] list;

	/**
	 * 
	 * @param max The maximum number to be in the list. The list created with 
	 * getRandomList() will return a list of random numbers in the range of 1 to max.
	 */
	public RandomListGenerator(int max){
		this.N = max;
		list = new int[N];
	}

	/**
	 * 
	 * 
	 * @return Returns a list of random numbers in the range of 1 to 'max', 
	 * max is specified in the constructor.
	 */
	public int[] getRandomList() {
		for (int i=0; i<N; i++) {
			list[i] = 0;
		}
		int location = 1;
		int freeCount = N;
		for (int i=1; i<=N; i++) {
			double skip = Math.floor(freeCount * Math.random() + 1);
			while (skip > 0) {
				location = location % N + 1;
				if (list[location-1] == 0) 
					skip--;
			}
			list[location-1] = i;
			freeCount--;
		}
		return list;
	}
}