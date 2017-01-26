import java.io.*;
import java.util.*;
class subset{

	public static void main(String args[]){
		char set[]={'a','b','c'};
		printSubsets(set);



	}
	public static void printSubsets(char set[]){
		int n=set.length;
		for(int i=0;i<1<<n;i++){//There are 2 raised to power n subsets
			System.out.print("{");
			for(int j=0;j<n;j++){
				if((i & (1<<j))>0){    //Main Formuala is here it tells whether in ith number i bit is set
					System.out.print(set[j]+" ");
				}
			}
			System.out.println("}");
		}
	}

}