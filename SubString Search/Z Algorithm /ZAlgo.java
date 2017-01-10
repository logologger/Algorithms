import java.io.*;
import java.util.*;
//Video https://www.youtube.com/watch?v=CpZh4eF8QBw
class ZAlgo{
	public static void main(String args[])throws IOException{

		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aaabc";
        ZAlgo zAlgorithm = new ZAlgo();
        List<Integer> result = zAlgorithm.matchPattern(text.toCharArray(), pattern.toCharArray());
		result.forEach(System.out::println);//requires java 8

	}
	public List<Integer> matchPattern(char text[],char pattern[]){

		char newString[]=new char[text.length+pattern.length+1];
		int i=0;
		//Let's make the new String text+$+pattern
		for(char ch:pattern){
			newString[i]=ch;
			i++;
		}
		newString[i]='$';
		i++;
		for(char ch:text){
			newString[i]=ch;
			i++;
		}

		List<Integer> result=new ArrayList<>();
		int Z[]=calculateZ(newString);

		for( i=0;i<Z.length;i++){
			if(Z[i]==pattern.length){
				result.add(i-pattern.length-1);
			}
		}
		return result;

	}


	//Let's calculate the Z
	public int[] calculateZ(char input[]){
		int Z[]=new int[input.length];
		int left=0;
		int right=0;
		for(int k=1;k<input.length;k++){
			if(k>right){
				left=right=k;
				while(right<input.length && input[right]==input[right-left]){
					right++;
				}
				Z[k]=right-left;//left will be always be k--just note that
				right--;
			}
			else{
				//operating inside box
				int k1=k-left;//left will be the last k

				if(Z[k1] < right-k+1){
					//if value does not stretches till right bound
					Z[k]=Z[k1];

				}
				else{
					//try to see if there are more matches
					left=k;
					while(right<input.length && input[right]==input[right-left]){
					right++;
				}
				Z[k]=right-left;//left will be always be k--just note that
				right--;

				}


			}
		}
		return Z;
	}
}