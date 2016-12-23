import java.io.*;
import java.util.*;


class Knapsack{

/*
	//The Recursive appoach has two things
	//Optimal Sub structure 
	//Overlapping Sub problems
	
When the subproblems are evaluated again and again then 
It can be considered as a case of dynamic programming

In order to avoid this we can create a temporary array that will 
store the result which can be later used 


Dynamic Programming is of two types 

Top Down 
Bottom Up 

http://stackoverflow.com/questions/6164629/dynamic-programming-and-memoization-bottom-up-vs-top-down-approaches



	*/



	public static int max(int a,int b){

		return (a>b)?a:b;
	}


	public static int knapsack(int W,int wt[],int val[],int n){

		if(n==0 || W==0){
			return 0;
		}
		//Weight of nth item  is greater the knapsack Capacity W
		//Then this item will not be included in the option
		if(wt[n-1]>W){

			return knapsack(W,wt,val,n-1);

		}

		else 
			/*

			return the maximum of two cases
			 nth item included 
			 not included

			*/
		{
			return max(val[n-1]+knapsack(W-wt[n-1],wt,val,n-1),knapsack(W,wt,val,n-1));
		}
	}
	//Knapsack using Dynamic Programming
	//This is Bottom up approach used in Dynamic Programming
	public static int knapsackDynamic(int W,int wt[],int val[],int n){

		int i,w=0;
		int K[][]=new int[n+1][W+1];

		//Bottom Up Manner

		for(i=0;i<=n;i++){// go from 0 items to n items

			for(w=0;w<=W;w++){//Go from weight 0 to W

				if(i==0 || w==0){
					//because you are picking no items here
					K[i][w]=0;
				}
				else if(wt[i-1]<=w){

					//Since ith Item is lesser then w so you pick item here
					//that will be max of either picked(which is val[i-1] + Kth Item here ) or not 

					K[i][w]=max(val[i-1]+K[i-1][w-wt[i-1]] , K[i-1][w]);
					//Here you will pick the max of 

				}
				else{
					//System.out.println(i+"  "+w);
					K[i][w]=K[i-1][w];//you dont pick ith item here

				}



			}
		}

			return K[n][W];



	}

	public static void main(String args[]){


		 int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
    int  W = 50;
    int n = val.length;
    System.out.println(knapsack(W, wt, val, n));
    System.out.println(knapsackDynamic(W, wt, val, n));



	}
}