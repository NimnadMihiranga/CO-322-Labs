/**
 * Simple sorting algorithms and their performance 
 * Reg: E/18/180
 *
 */

public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
    static void buble_sort(int [] data)  {
	// Implement
		int arrLen = data.length;	//getting length of the array
		boolean swap;				//to avoid the inner loop if array is already sorted
		for(int i=0; i<arrLen-1; i++){
			swap = false;
			for(int j=0; j<arrLen-i-1; j++){
				if(data[j]>data[j+1]){
					swap(data, j+1, j);
					swap = true;
				}
				
				
			}
			if(swap==false){		//if array is already sorted
				break;
			}
			
		}
    }

    static void selection_sort(int [] data) {
	// Implement 
		int arrLen = data.length;
		int minInd;						//to store the index of the minimum value of the array
		for(int i=0; i<arrLen-1; i++){
			minInd = i;
			for(int j=i+1; j<arrLen; j++){
				if(data[j]<data[minInd]){
					minInd = j;			//updating the minimum value index
				}
			}
			int tVal = data[minInd];	//temp variable to store the minimum value
			while(minInd>i){			//shifting the elements in the array one to right till the minimum element in the sub array
				data[minInd] = data[minInd-1];
				minInd--;
			}
			data[i] = tVal;				//putting the minimum element 
		}
    }

    static void insertion_sort(int [] data) {
	// Implement
		int arrLen = data.length;
		for(int i=1; i<arrLen; i++){
			int val = data[i];
			int j= i-1;

			while(j>=0 && data[j]>val){ //shifting the values in the array
				data[j+1] = data[j];
				j=j-1;
			}
			data[j+1] = val; 			//inserting the value
		}
    }

	static void test(int arraySize){
		//for the random array set
		// System.out.printf("Using Random dataset of %d elements\n",arraySize);
		// int[] randArray;
		// randArray = create_rand_data(arraySize);
		// long t1start = System.nanoTime(); 
		// buble_sort(randArray);
		// long t1end = System.nanoTime(); 

		// long t2start = System.nanoTime(); 
		// selection_sort(randArray);
		// long t2end = System.nanoTime(); 

		// long t3start = System.nanoTime(); 
		// insertion_sort(randArray);
		// long t3end = System.nanoTime(); 

		// long t1 = t1end-t1start;
		// long t2 = t2end-t2start;
		// long t3 = t3end-t3start;
		// System.out.printf("Time taken for random Array of %d elements to sort\nBubble Sort\t= %d\nSelection Sort\t= %d\nInserion Sort\t= %d\n\n==================\n",arraySize,t1,t2,t3);
	
		//for the best array
		System.out.printf("Using best case dataset of %d elements\n",arraySize);
		int[] bestArray;
		bestArray = create_best_data(arraySize);

		long t7start = System.nanoTime(); 
		buble_sort(bestArray);
		long t7end = System.nanoTime();

		long t8start = System.nanoTime(); 
		selection_sort(bestArray);
		long t8end = System.nanoTime(); 

		long t9start = System.nanoTime(); 
		insertion_sort(bestArray);
		long t9end = System.nanoTime();

		long t7 = t7end-t7start;
		long t8 = t8end-t8start;
		long t9 = t9end-t9start;
		System.out.printf("Time taken for best Array of %d elements to sort\nBubble Sort\t= %d\nSelection Sort\t= %d\nInserion Sort\t= %d\n\n==================\n",arraySize,t7,t8,t9);

		//for the worst case array
		System.out.printf("Using Worst case dataset of %d elements\n",arraySize);
		int[] worstArray;
		worstArray = create_worst_data(arraySize);

		long t4start = System.nanoTime(); 
		buble_sort(worstArray);
		long t4end = System.nanoTime(); 

		long t5start = System.nanoTime(); 
		selection_sort(worstArray);
		long t5end = System.nanoTime(); 

		long t6start = System.nanoTime(); 
		insertion_sort(worstArray);
		long t6end = System.nanoTime();

		long t4 = t4end-t4start;
		long t5 = t5end-t5start;
		long t6 = t6end-t6start;
		System.out.printf("Time taken for worst Array of %d elements to sort\nBubble Sort\t= %d\nSelection Sort\t= %d\nInserion Sort\t= %d\n\n==================\n",arraySize,t4,t5,t6);

		
	}

    

    public static void main(String [] args) {
	

	int num[] = {100,1000,10000,100000};
	for(int i=0; i<4; i++){
		test(num[i]);
	}

    }
}