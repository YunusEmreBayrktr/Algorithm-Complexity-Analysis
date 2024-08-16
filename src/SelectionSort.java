
public class SelectionSort {
	
	public static long sort(int[] array, int size) {
		
		//Start timer
		long start = System.nanoTime();
		
		//Perform sorting
		for (int i = 0; i < size-1; i++) {
			int min = i;
			
			for (int j = i+1; j < size; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		
		//End timer
		long end = System.nanoTime();
		
		//Return runtime in nanoseconds
		return (end - start);	
	}
}
