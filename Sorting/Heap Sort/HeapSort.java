/*
Order statistics: The Heap data structure can be 
used to efficiently find the kth smallest (or largest) 
element in an array.
 See method 4 and 6 of this post for details.

 
 A Binary Heap is a Complete Binary Tree where items 
 are stored in a special order such that value in a parent node 
 is greater(or smaller) than the values in its two children nodes.
  The former is called as max heap and the latter is called min heap. 
 The heap can be represented by binary tree or array 


http://quiz.geeksforgeeks.org/heap-sort/  


Algo 

1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps until size of heap is greater than 1.

Time Complexity is 
Time complexity of heapify is O(Logn). 
Time complexity of createAndBuildHeap() is O(n)
 and overall time complexity of Heap Sort is
  O(nLogn).


Heap Sort is not a Stable Algo 

in-place algorithm ?(I dont Know what is this)

Mostly QuickSort is preferred Heap Sort is not preferred so much

Applications are of Heap Data structure 

http://www.geeksforgeeks.org/nearly-sorted-algorithm/
http://www.geeksforgeeks.org/applications-of-heap-data-structure/
http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
*/

  import java.io.*;
import java.util.*;
class HeapSort{


	public void sort(int arr[]){

		/*
				 So the heapification must be performed in the bottom up order.

		*/

		int n=arr.length;

		//Build Heap 
		//Bottom Up Order
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
		//One by One Extract Element (root) and call Heapify function
		for(int i=n-1;i>=0;i--){

			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;

			heapify(arr,i,0);
		}

		
	}

	public void heapify(int arr[],int n,int i){
			int largest=i;//i is the root
			int l=2*i+1;
			int r=2*i+2;
			//n is the size of the heap

			if(l<n && arr[l]>arr[largest]){

				largest=l;

			}

			if(r<n && arr[r]>arr[largest]){
				largest=r;
			}
			if(largest!=i){

				int swap=arr[i];
				arr[i]=arr[largest];
				arr[largest]=swap;
			
				heapify(arr,n,largest);
			}


		
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
 
        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println("\nSorted array");
        printArray(arr);

	}

}