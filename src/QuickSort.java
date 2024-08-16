
public class QuickSort {
	
	public static long sort(int[] array, int low, int high) {
		
		//Start timer
		long start = System.nanoTime();
		
		//Perform sorting
		int stackSize = high - low + 1;
		int[] stack = new int[stackSize];
		int top = -1;
		
		stack[++top] = low;
		stack[++top] = high;
		
		while (top >= 0) {
			
			high = stack[top--];
			low = stack[top--];
			
			int pivot = partition(array, low, high);
			
			if (pivot-1 > low) {
				stack[++top] = low;
				stack[++top] = pivot - 1;
			}
			
			if (pivot + 1 < high) {
				stack[++top] = pivot + 1;
				stack[++top] = high;
			}
		}
		
		//End timer
		long end = System.nanoTime();
		
		//Return runtime in nanoseconds
		return (end - start);	
	}
	
	
	private static int partition(int array[], int low, int high) {
		
		int pivot = array[high]; 
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
        	
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
  
        return i + 1;
	}
}
