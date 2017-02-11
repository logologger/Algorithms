import java.io.*;
import java.util.*;
class Matrixchain{
	/*
		https://www.youtube.com/watch?v=vgLJZMUfnsU

		http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 		
 		Recurisve approach 

 		 for (k = i; k <j; k++)
		    {
		        count = MatrixChainOrder(p, i, k) +
		                MatrixChainOrder(p, k+1, j) +
		                p[i-1]*p[k]*p[j];
		 
		        if (count < min)
		            min = count;
		    }


		    There will application of this algo in the geeksforgeeks ..Please chek this later

	*/
	public static void main(String args[])throws IOException{
		Matrixchain mmc = new Matrixchain();
        int arr[] = {4,2,3,5,3};
        int cost = mmc.findCost(arr);
		System.out.print(cost);

	}
	public int findCost(int arr[]){
		int temp[][]=new int[arr.length][arr.length];
		int q=0;
		for(int l=2;l<arr.length;l++){
			for(int i=0;i<arr.length;i++){
				int j=i+l;
				temp[i][j]=100000;
				for(int k=i+1;k<j;k++){
					q=temp[i][k]+temp[k][j]+arr[i]*arr[k]*arr[j];
					if(q<temp[i][j]){
						temp[i][j]=q;
					}
				}

			}
		}
		return temp[0][arr.length-1];
	}
}