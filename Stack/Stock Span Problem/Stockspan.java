import java.io.*;
import java.util.*;
class Stockspan{
	public static void main(String args[])throws IOException{

		int price[]={10,4,5,90,120,80};
		int n=price.length;
		int S[]=new int[n];

		calculateSpan(price,n,S);
		System.out.println(Arrays.toString(S));
	}
	public static void calculateSpan(int price[],int n,int S[]){
		Stack<Integer> st=new Stack<Integer>();
		st.push(0);
		S[0]=1;
		for(int i=0;i<n;i++){

			while(!st.isEmpty() && price[st.peek()]<=price[i]){
				st.pop();
			}
			S[i]=(st.isEmpty())?(i+1):(i-st.peek());

			st.push(i);
		}
	}
}