import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
	
	public static long sort(int[] array) {
		
		//Start timer
		long start = System.nanoTime();
		
		//Perform sorting
		int bucketAmount = (int) Math.sqrt(array.length);
		int maxInt = getMax(array);
		
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[bucketAmount];
        for (int i = 0; i < bucketAmount; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
        
        for(int num : array)  {  
        buckets[hash(num, maxInt, bucketAmount)].add(num);  
        }  
        
        for(List<Integer> bucket : buckets)  {       
        Collections.sort(bucket);  
        }
        
        int index = 0;
        
        for(List<Integer> bucket : buckets)  {  
        	for(int num : bucket)  {  
        		array[index++] = num;  
        	}  
        }
        
        //End timer
        long end = System.nanoTime();
		
        //Return runtime in nanoseconds
        return (end - start); 
	}
	
	
	private static int getMax(int[] array) {
		int max = array[0];
		
		for (int i : array) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	
	private static int hash(int num,int max, int bucketAmount)  {  
	return (int) Math.floor((num/max*(bucketAmount-1))) ;  
	}  
}
