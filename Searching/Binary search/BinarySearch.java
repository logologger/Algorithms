import java.io.*;
import java.util.*;

//Array should be sorted in order to implement Binary Search
class BinarySearch{

	public static void main(String args[]){

		 BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
         int result = ob.recursiveBinarySearch(arr,0,n-1,x);

          if (result == -1)
            System.out.println("Element not present recursive");
        else
            System.out.println("Element found at index recursive "+result);


         result = ob.iterativeBinarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present iterative");
        else
            System.out.println("Element found at index iterative "+result);

	}
	//Recursive Appoarch
	public int recursiveBinarySearch(int arr[],int l,int r,int x){


		if(r>=l){
			int mid=l+(r-l)/2;//equal to (r+l)/2

			if(arr[mid]==x){
				return mid;
			}

			if(arr[mid]>x){

				return recursiveBinarySearch(arr,l,mid-1,x);
			}

			return recursiveBinarySearch(arr,mid+1,r,x);


		}
		return -1;
	}

	public int iterativeBinarySearch(int arr[],int x){


		int l=0;
		int r=arr.length-1;
		
		while(l<=r){

			int m=(l+r)/2;

			if(arr[m]==x){
				return m;
			}

			if(arr[m]>x){
				r=m-1;
			}
			else{
				l=m+1;
			}
		}
		return -1;
	}


}