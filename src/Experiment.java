import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Experiment {
	
	public static int[] records = new int[251281];
	public static HashMap<String, double[]> randomResults = new HashMap<>();
	public static HashMap<String, double[]> sortedResults = new HashMap<>();
	public static HashMap<String, double[]> reversedResults = new HashMap<>();
	public static HashMap<String, double[]> linearResults = new HashMap<>();
	public static HashMap<String, double[]> binaryResults = new HashMap<>();
	public static int[] sizes = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};
	
	
	private static void setResults() {
		
		randomResults.put("selectionSort", new double[10]);
		randomResults.put("quickSort", new double[10]);
		randomResults.put("bucketSort", new double[10]);
		
		sortedResults.put("selectionSort", new double[10]);
		sortedResults.put("quickSort", new double[10]);
		sortedResults.put("bucketSort", new double[10]);
		
		reversedResults.put("selectionSort", new double[10]);
		reversedResults.put("quickSort", new double[10]);
		reversedResults.put("bucketSort", new double[10]);
		
		linearResults.put("randomData", new double[10]);
		linearResults.put("sortedData", new double[10]);
		binaryResults.put("sortedData", new double[10]);	
	}
	
	
	private static void readData(String path) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    
			String line = br.readLine();
		    int i = 0;
		    
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records[i] = Integer.parseInt(values[6]);
		        i++;
		    }
		} 
		catch (IOException e) {
			System.out.println("NO SUCH FILE!");
			e.printStackTrace();
		}
	}
	
	
	private static void measureSelectionSort() {
		
		int[] sorted = new int[250000];
		
		//For each input size (Random Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				//Copy original array
				int[] unsorted = new int[sizes[i]];
				System.arraycopy(records, 0, unsorted, 0, sizes[i]);
				time += SelectionSort.sort(unsorted, sizes[i]);
				
				if (sizes[i] == 250000) 
					System.arraycopy(unsorted, 0, sorted, 0, 250000);
			}
			randomResults.get("selectionSort")[i] = time/10000000;
			System.out.println("Selection Sort with random data!");
		}
		
		
		//For each input size (Sorted Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				int[] temp = new int[sizes[i]];
				System.arraycopy(sorted, 0, temp, 0, sizes[i]);
				time += SelectionSort.sort(temp, sizes[i]);
			}
			sortedResults.get("selectionSort")[i] = time/10000000;
			System.out.println("Selection Sort with sorted data!");
		}
		
		
		//For each input size (Reversed Data)
		sorted = reverse(sorted);
				
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				int[] temp = new int[sizes[i]];
				System.arraycopy(sorted, 0, temp, 0, sizes[i]);
				time += BucketSort.sort(temp);
			}
			reversedResults.get("selectionSort")[i] = time/10000000;
			System.out.println("Selection Sort with reversed data!");
		}
	}
	
	
	private static void measureQuickSort() {
		
		int[] sorted = new int[250000];
		
		//For each input size (Random Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				//Copy original array
				int[] unsorted = new int[sizes[i]];
				System.arraycopy(records, 0, unsorted, 0, sizes[i]);
				time += QuickSort.sort(unsorted, 0, sizes[i]-1);
				
				if (sizes[i] == 250000) 
					System.arraycopy(unsorted, 0, sorted, 0, 250000);	
			}
			randomResults.get("quickSort")[i] = time/10000000;
			System.out.println("Quick Sort with random data!");
		}
		
		
		//For each input size (Sorted Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				int[] temp = new int[sizes[i]];
				System.arraycopy(sorted, 0, temp, 0, sizes[i]);
				time += QuickSort.sort(temp, 0, sizes[i]-1);
			}
			sortedResults.get("quickSort")[i] = time/10000000;
			System.out.println("Quick Sort with sorted data!");
		}
		
		
		//For each input size (Reversed Data)
		sorted = reverse(sorted);
				
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				int[] temp = new int[sizes[i]];
				System.arraycopy(sorted, 0, temp, 0, sizes[i]);
				time += BucketSort.sort(temp);
			}
			reversedResults.get("quickSort")[i] = time/10000000;
			System.out.println("Quick Sort with reversed data!");
		}
	}
	
	
	private static void measureBucketSort() {
		
		int[] sorted = new int[250000];
		
		//For each input size (Random Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				//Copy original array
				int[] temp = new int[sizes[i]];
				System.arraycopy(records, 0, temp, 0, sizes[i]);
				time += BucketSort.sort(temp);
				
				if (sizes[i] == 250000) 
					System.arraycopy(temp, 0, sorted, 0, 250000);
			}
			randomResults.get("bucketSort")[i] = time/10000000;
			System.out.println("Bucket Sort with random data!");
		}
		
		
		//For each input size (Sorted Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				int[] temp = new int[sizes[i]];
				System.arraycopy(sorted, 0, temp, 0, sizes[i]);
				time += BucketSort.sort(temp);
			}	
			sortedResults.get("bucketSort")[i] = time/10000000;
			System.out.println(i + ". Bucket Sort with sorted data!");
		}
		
		
		//For each input size (Reversed Data)
		sorted = reverse(sorted);
		
		for (int i=0; i<10; i++) {
			double time = 0;
			//Sorting 10 times
			for (int j=0; j<10; j++) {
				int[] temp = new int[sizes[i]];
				System.arraycopy(sorted, 0, temp, 0, sizes[i]);
				time += BucketSort.sort(temp);
			}
			reversedResults.get("bucketSort")[i] = time/10000000;
			System.out.println(i + ". Bucket Sort with reversed data!");
		}
	}
	
	
	private static void measureLinearSearch() {
		
		//For each size (Random Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Searching 1000 times
			for (int j=0; j<1000; j++) {
				
				int[] unsorted = new int[sizes[i]];
				System.arraycopy(records, 0, unsorted, 0, sizes[i]);
				int x = getRandom(unsorted);
				
				double start = System.nanoTime();
				Search.linear(unsorted, x);
				double end = System.nanoTime();
				time += (end - start);
			}
			linearResults.get("randomData")[i] = time/1000;
		}
		
		BucketSort.sort(records);
		
		//For each size (Sorted Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Searching 1000 times
			for (int j=0; j<1000; j++) {
				
				int[] sorted = new int[sizes[i]];
				System.arraycopy(records, 0, sorted, 0, sizes[i]);
				int x = getRandom(sorted);

				double start = System.nanoTime();
				Search.linear(sorted, x);
				double end = System.nanoTime();
				time += (end - start);
			}
			linearResults.get("sortedData")[i] = time/1000;
		}
	}
	
	
	private static void measureBinarySearch() {
		
		//For each size (Sorted Data)
		for (int i=0; i<10; i++) {
			double time = 0;
			//Searching 1000 times
			for (int j=0; j<1000; j++) {
						
				int[] sorted = new int[sizes[i]];
				System.arraycopy(records, 0, sorted, 0, sizes[i]);
				int x = getRandom(sorted);

				double start = System.nanoTime();
				Search.binary(sorted, x);
				double end = System.nanoTime();
				time += (end - start);
			}
			binaryResults.get("sortedData")[i] = time/1000;
		}
	}
	
	
	private static void printResults() {
		
		System.out.println("Data Sizes:");
		for (int size : sizes) {
			System.out.print(size + "\t");
		}
		
		String[] lists = {"selectionSort", "quickSort", "bucketSort"};
		for(String s: lists) {
			
			System.out.println("\n\nRandom " + s + ":");
			for (double i: randomResults.get(s)) 
				System.out.print(i + "\t");
			
			System.out.println("\nSorted " + s + ":");
			for (double i: sortedResults.get(s)) 
				System.out.print(i + "\t");
			
			System.out.println("\nReversed " + s + ":");
			for (double i: reversedResults.get(s)) 
				System.out.print(i + "\t");	
		}
		
		System.out.println("\n\nRandom Data Linear Search:");
		for(double i : linearResults.get("randomData"))
			System.out.print(i + "\t");
		
		System.out.println("\nSorted Data Linear Search:");
		for(double i : linearResults.get("sortedData"))
			System.out.print(i + "\t");
		
		System.out.println("\nSorted Data Binary Search:");
		for(double i : binaryResults.get("sortedData"))
			System.out.print(i + "\t");
	}

	
	private static int[] reverse(int[] array) {
		int n = array.length;
		
		int[] reversed = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            reversed[j - 1] = array[i];
            j = j - 1;
        }
		return reversed;
	}
	
	
	private static int getRandom(int[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
	
	
	public static void start(String path) {
		readData(path);
		setResults();
		measureSelectionSort();
		measureQuickSort();
		measureBucketSort();
		measureLinearSearch();
		measureBinarySearch();
		printResults();
		Plotting.plot();
	}
}
