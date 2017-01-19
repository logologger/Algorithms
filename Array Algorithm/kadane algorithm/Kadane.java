/*
http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

Array needs to have negative elements too for this Algorithm

Kadane's algorithm is to look for all
 positive contiguous segments of the array 
 (max_ending_here is used for this

*/

import java.io.*;
import java.util.*;
class Kadane{
	public static void main(String args[])throws IOException{
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int a[]={1,2,5,3,4};
		System.out.println(maxSubarraysum(a));

	}
	public static int maxSubarraysum(int a[]){

		int size=a.length;
		int max_so_far=Integer.MIN_VALUE;
		int max_ending_here=0;
		for(int i=0;i<size;i++){
			max_ending_here=max_ending_here+a[i];
			if(max_so_far<max_ending_here){
				max_so_far=max_ending_here;
			}
			if(max_ending_here<0){
				max_ending_here=0;
			}


			
		}
		return max_so_far;

	}
}