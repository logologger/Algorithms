//https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/Combination.java
import java.io.*;
import java.util.*;
class Subsetbacktracking{

	/*
			Generate all subsets of string in lexicographically sorted order
			 where repetitions of
 			 character is possible in string
 			 or you can call it as combination of characters in a string

	*/



	public static void main(String args[]){


		Subsetbacktracking p=new Subsetbacktracking();
		p.permute("AABC".toCharArray());

	}
	public List<String> permute(char input[]){

		//TreeMap is used for HashMap in Sorted Order
		//HashMap does not have any order of storing elements
		//LinkedHashMap stores element in order
		Map<Character,Integer> countMap=new TreeMap<>();
		for(char ch:input){

			countMap.compute(ch,(key,val)->{
				if(val==null){
					return 1;
				}
				else{
					return val+1;
				}




			});
		}

		char str[]=new char[countMap.size()];
		int count[]=new int[countMap.size()];
		int index=0;
		for(Map.Entry<Character,Integer> entry:countMap.entrySet()){

			str[index]=entry.getKey();//input in sorted order
			count[index]=entry.getValue();
			index++;
		}

		char output[]=new char[input.length];
		permuteUtil(str,count,0,output,0);






	}
	//The Acutal Logic is here
	//input will contain the character --- unique one in sorted order like for aabc it is a,b and c
	//pos is the current starting position for the array
	//len will contain the current length of subset
	//output will contain the output subset
	//count will contain the frequency of characters in sorted order
	
	public void permuteUtil(char input[],int count[],int pos,char output[],int len){
		printArray(output,len);//print the subset of given length len
		for(int i=pos;i<input.length;i++){
			if(count[i]==0){//means no characters are there
				continue;
			}
		
		output[len]=input[i];//assign the ith character of input to output
		count[i]--;//decrease the count of characters since it went to output
		permuteUtil(input,count,i,output,len+1);//Just visualise the recursion that is happening here
		//https://www.youtube.com/watch?v=xTNFs5KRV_g&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh&index=3
		count[i]++;//moving up the recursion increase it

	}
	private void printArray(char input[],int pos){
		for(int i=0;i<pos;i++){
			System.out.print(input[i]);
		}
		System.out.println();
	}
}