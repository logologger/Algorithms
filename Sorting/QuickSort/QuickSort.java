/*

QuickSort can be implemented in different ways by changing the choice of pivot,
 so that the worst case rarely occurs for a given type of data. However,
  merge sort is generally considered better when data is huge and stored in external storage


 QuickSort is faster in practice, because its inner loop 
 can be efficiently implemented on most architectures, 
 and in most real-world data. QuickSort can be implemented 
 in different ways by changing the choice of pivot,
  so that the worst case rarely occurs for a given type of data. 
  However, merge sort is generally considered better when data is 
  huge and stored in external storage. 


Quick Sort in its general form is an in-place sort 
(i.e. it doesn’t require any extra storage) 
whereas merge sort requires O(N) extra storage,
 N denoting the array size which may be quite expensive.
  Allocating and de-allocating the extra space
   used for merge sort increases the running time 
   of the algorithm. Comparing average complexity 
   we find that both type of sorts have O(NlogN)
    average complexity but the constants differ.
     For arrays, merge sort loses due to the use 
     of extra O(N) storage space.

Most practical implementations of Quick Sort use randomized version. The randomized version has expected time complexity of O(nLogn). The worst case is possible in randomized version also, but worst case doesn’t occur for a particular pattern (like sorted array) and randomized Quick Sort works well in practice.

Quick Sort is also a cache friendly sorting algorithm as it has good locality of reference when used for arrays.

Quick Sort is also tail recursive, therefore tail call optimizations is done

*/

  import java.io.*;
import java.util.*;
class QuickSort{

	//Time Complexity is nlog n for best and average case and n^2 for worst case
	//Not a Stable Algorithm

	public void sort(int arr[],int low,int high){

		if(low<high){

			int pi=partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}

		
	}

	public int partition(int arr[],int low,int high){
			int pivot=arr[high];
			int i=(low-1);
			for(int j=low;j<=high-1;j++){

				if(arr[j]<=pivot){
					i++;

					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}

			}
					int temp=arr[i+1];
					arr[i+1]=arr[high];
					arr[high]=temp;
return i+1;
		
	}

	public static void printArray(int arr[]){

		int n=arr.length;
		for(int i=0;i<n;i++){
			System.out.print(" "+arr[i]);
		}
		System.out.println();


	}



	public static void main(String args[]){

		 int arr[] = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);

	}

}