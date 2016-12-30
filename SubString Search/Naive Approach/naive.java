import java.io.*;
import java.util.*;
class naive{
	public static void main(String args[])throws IOException{

	}
	public boolean hasSubstring(char text[],char pattern[]){
		//Now first compute the prefix and suffix array
		int i=0,j=0,k=0;
		//i keeps track of text 
		//j is for pattern 
		//in case of mismatch i will be put back to kth position 
		//k is the last mismatch index of the text

		while(i<text.length && j<pattern.length){

			if(text[i]==pattern[j]){
				i++;
				j++;
			}
			else{
				j=0;
				k++;
				i=k;

			}
		}

		if(j==pattern.length){
			return true;
		}
		else{
			return false;
		}
	}

	
}