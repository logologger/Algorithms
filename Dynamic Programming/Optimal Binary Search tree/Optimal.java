import java.io.*;
import java.util.*;
/*
https://www.youtube.com/watch?v=hgA4xxlVvfQ&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=7

http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/

The array keys should be sorted array of search keys
Freq array contains the cost that is number of searches to reach key k


*/
class Optimal{
	public static void main(String args[])throws IOException{

		 int input[] = {10,12,20,35,46};
        int freq[] = {34,8,50,21,16};
        Optimal ots = new Optimal();
        System.out.println(ots.minCost(input, freq));
		System.out.println(ots.minCostRec(input, freq));
	}

	public int minCost(int input[],int freq[]){
		int T[][]=new int[input.length][input.length];
		 // For a single key, cost is equal to frequency of the key
		for(int i=0;i<T.length;i++){
			T[i][i]=freq[i];
		}

		//Now we will consider chains of length 2,3,4...
		for(int l=2;l<=input.length;l++){
			for(int i=0;i<=input.length-l;i++){//i for rows
				int j=i+l-1;// j is the column
				T[i][j]=Integer.MAX_VALUE;
				int sum=getSum(freq,i,j);

				for(int k=i;k<=j;k++){
					int val=sum+(k-1<i?0:T[i][k-1])+(k+1>j?0:T[k+1][j]);
					//Take k as root so everything from i to k-1 plus k+1 to j
					if(val<T[i][j]){
						T[i][j]=val;
					}
				}

			}

		}

		return T[0][input.length-1];
	}

	public int getSum(int freq[],int i,int j){
		int sum=0;
		for(int x=i;x<=j;x++){
			sum+=freq[x];
		}
		return sum;
	}
	public int minCostRec(int input[],int freq[]){
		return minCostRec(input,freq,0,input.length-1,1);//last one is level
	}

	public int minCostRec(int input[],int freq[],int low,int high,int level){
		if(low>high){
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int i=low;i<=high;i++){
			int val=minCostRec(input,freq,low,i-1,level+1)+minCostRec(input,freq,i+1,high,level+1)+level*freq[i];
			if(val<min){
				min=val;
			}
		}
		return min;
	}


}