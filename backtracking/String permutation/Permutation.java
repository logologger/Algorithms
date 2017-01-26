//https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/StringPermutation.java
import java.io.*;
import java.util.*;
class Permutation{

	/*
			Generate all permutations of string in lexicographically sorted order
			 where repetitions of
 			 character is possible in string

	*/



	public static void main(String args[]){


		Permutation p=new Permutation();
		p.permute("AABC".toCharArray()).forEach(s->System.out.println(s));//power of Java 8
	}
	public List<String> permute(char input[]){

		//TreeMap is used for HashMap in Sorted Order
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

			str[index]=entry.getKey();
			count[index]=entry.getValue();
			index++;
		}

		List<String> resultList=new ArrayList<>();
		char result[]=new char[input.length];
		permuteUtil(str,count,result,0,resultList);
		return resultList;






	}
	//The Acutal Logic is here
	//str will contain the character --- unique one in sorted order like for aabc it is a,b and c
	//count will contain the count of that character in str
	//level will contain the level in the recursion tree
	//result will contain the permuted String
	//resultList will contain all the permuted String
	public void permuteUtil(char str[],int count[],char result[],int level,List<String> resultList){
		if(level==result.length){

			resultList.add(new String(result));
			return;
		}
		for(int i=0;i<str.length;i++){
			if(count[i]==0){
				continue;
			}
			result[level]=str[i];
			count[i]--;
			permuteUtil(str,count,result,level+1,resultList);
			count[i]++;
		}

	}
	private void printArray(char input[]){
		for(char ch:input){
			System.out.print(ch);
		}
		System.out.println();
	}
}