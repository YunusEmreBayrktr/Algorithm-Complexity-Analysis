
public class Search {
	
	public static int linear(int[] array, int x) {
		
		int size = array.length;
		
		for (int i=0; i < size; i++) {
			if (array[i] == x)
				return i;
		}
		return -1;
	}
	
	
	public static int binary(int[] array, int x) {
		
		int low = 0;
		int high = array.length-1;
		
		while (high - low > 1) {
			int mid = (high+low)/2;
			
			if (array[mid] < x)
				low = mid + 1;
			else 
				high = mid;
		}
		
		if (array[low] == x)
			return low;
		else if (array[high] == x)
			return high;
		
		return -1;
	}
}
