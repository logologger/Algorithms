import java.io.*;
import java.util.*;
class LCS{
	/*
		http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
	*/
	public static void main(String args[]){
		LCS lcs = new LCS();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        int result = lcs.LCSDynamic(str1.toCharArray(), str2.toCharArray());
		System.out.print(result);

	}
	public int LCS_recursive(char str1[],char str2[],int len1,int len2){


		//Recursive Approach for LCS
		if(len1==0 || len2==0){
			return 0;
		}
		if(str1[len1]==str2[len2]){
			return 1+LCS_recursive(str1,str2,len1+1,len2+1);
		}
		else{
			return Math.max(LCS_recursive(str1,str2,len1+1,len2),LCS_recursive(str1,str2,len1,len2+1));
		}

	}
	public int LCSDynamic(char str1[],char str2[]){
		int temp[][]=new int[str1.length+1][str2.length+1];
		int max=0;
		for(int i=1;i<temp.length;i++){
			for(int j=1;j<temp[i].length;j++){
				if(str1[i-1]==str2[j-1]){
					temp[i][j]=temp[i-1][j-1]+1;
				}
				else{
					temp[i][j]=Math.max(temp[i-1][j],temp[i][j-1]);
				}
				if(temp[i][j]>max){
					max=temp[i][j];//same as temp[str1.length-1][str2.length-1]
				}
			}
		}
		return max;
	}
}