import java.io.*;
import java.util.*;

/*

Total Complexity is O(m+n) as compared to naive which is 
O(m*n)

https://www.youtube.com/watch?v=GTJr8OvyEVQ



*/
class KMP{
	public static void main(String args[])throws IOException{

		String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP ss = new KMP();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
		System.out.print(result);

	}
	public boolean KMP(char text[],char pattern[]){
		//Now first compute the prefix and suffix array
		int lps[]=computeTemporaryArray(pattern);
		int i=0;
		int j=0;
		while(i<text.length && j<pattern.length){
			if(text[i]==pattern[j]){
				i++;
				j++;
			}
			else{
				if(j!=0){
					j=lps[j-1];
				}
				else{
					i++;

				}
			}




		}

		if(j==pattern.length){
			return true;
		}
		else{
			return false;
		}
	}

	public int[] computeTemporaryArray(char pattern[]){

		int [] lps=new int[pattern.length];
		int index=0;

		for(int i=1;i<pattern.length;){

			if(pattern[i] == pattern[index]){

				lps[i]=index+1;
				index++;
				i++;
			}
			else{
				if(index!=0){

					index=lps[index-1];

				}
				else{
					lps[i]=0;
					i++;
				}

			}


		}

		return lps;


	}
}