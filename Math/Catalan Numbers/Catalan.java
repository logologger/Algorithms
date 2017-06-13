import java.io.*;
import java.util.*;
class Catalan{



	/*

			In Catalan Number C(0) is 1 and C(n+1) is Ci*C(n-i) ---Catalan Number


	*/

	public int catalan(int n){
		int res=0;
		if(n<=1){
			return 1;
		}

		for(int i=0;i<n;i++){
			res+=catalan(i)*catalan(n-i-1);
		}

		return res;


	}//Takes Exponential Time ...it just a simples
	//implementation of nC2n ----Down n and up 2n while calculating 
	//number of ways to calculate 2n from n numbers
	//will be equal to number of ways of selecting i from 2n and (n-i) from 2n
	public int catalanDP(int n){
		int catalan[]=new int[n+1];
		catalan[0]=catalan[1]=1;

		for(int i=2;i<=n;i++){
			catalan[i]=0;
			for(int j=0;j<i;j++){
				catalan[i]+=catalan[j]*catalan[i-j-1];
			}
		}

		return catalan[n];
	}



	public int CatalanFormula(int n){



		//This Solution runs in O(n) time

		int c=binomailCoefficient(2*n,n);

		return c/(n+1);
	}


	public int binomailCoefficient(int n,int k){

		int res=1;

		if(k>n-k){
			k=n-k;   //Check by formula nCk === nC(n-k)
		}
		// Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
		for(int i=0;i<k;i++){
			res*=(n-i);
			res/=(i+1);
		}

		return res;

	}



	public static void main(String args[]){
		Catalan c=new Catalan();
		for(int i=0;i<10;i++){
			System.out.println(c.catalan(i)+" ");
		}	


		System.out.println("Running DP for Catalan which takes n2 time");

		for(int i=2;i<10;i++){
			System.out.println(c.catalanDP(i)+" ");
		}


		System.out.println("Using Catalan Formula");

		for(int i=2;i<10;i++){

			System.out.println(c.CatalanFormula(i));

		}
	}
}

