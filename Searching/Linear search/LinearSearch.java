import java.io.*;
import java.util.*;

class LinearSearch{

	public static void main(String args[]){

		//Demo Code for Linear Search goes here
		//Complexity is O(n)

	}

	public static int search(int arr[],int n,int x){
		for(int i=0;i<n;i++){

		if(arr[i]==x){
			return i;
		}
	}
	return -1;
	}
}