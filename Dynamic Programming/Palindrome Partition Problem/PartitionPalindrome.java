import java.io.*;
import java.util.*;
/*
It is O(n^3) times so next Other Algo will be in lesser time

*/
class PartitionPalindrome{
	public static void main(String args[]){

		char str[]={'a','b','c','b','m'};
		System.out.println("Mnimum Partition is "+minPartition(str));

	}
	public static int minPartition(char str[]){
		int n=str.length;
		int C[][]=new int[n][n];
		boolean P[][]=new boolean[n][n];

		int i,j,k,L;

		for( i=0;i<n;i++){
			P[i][i]=true;
			C[i][i]=0;
		}
		for(L=2;L<=n;L++){
			for(i=0;i<n-L+1;i++){
				j=i+L-1;
				//L is the window like taking only 1 character or taking only 2 characters like this
				//i is the starting index
				//j is the end index
				if(L==2){
					//string of length 2
					P[i][j]=(str[i]==str[j]);
				}
				else{
					P[i][j]=(str[i]==str[j]) && P[i+1][j-1];//Take whether P[i][j] is palindrome or not
				}

				if(P[i][j]==true){
					C[i][j]=0;
				}
				else{
					//Make a cut at every location from i to j
					C[i][j]=Integer.MAX_VALUE;
					for( k=i;k<j;k++){
						C[i][j]=Math.min(C[i][j],C[i][k]+C[k+1][j]+1);
					}
				}
			}
		}

		

		return C[0][n-1];
	}

}