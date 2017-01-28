import java.io.*;
import java.util.*;
class subsetK{
	public static void main(String args[])throws IOException{

		int A[] = { 1, 2, 3, 4, 5 };
		boolean[] B = new boolean[A.length];
		subsetK i = new subsetK();
		i.subset(A, 3, 0, 0, B);

	}
	public void subset(int A[],int k,int start,int curLen,boolean used[]){

		if(curLen==k){//Here we got the subset of length k

			for(int i=0;i<A.length;i++){
				if(used[i]==true){
					System.out.print(A[i]+" ");
				}
			}

			System.out.println();
			return;
		}
		if(start==A.length){
			return;
		}

			//Either we will select it here by making used[i] as true
			used[start]=true;
			subset(A,k,start+1,curLen+1,used);
			//Either we dont select it here thus not increasing curLen length
			used[start]=false;
			subset(A,k,start+1,curLen,used);			
		}

	}
