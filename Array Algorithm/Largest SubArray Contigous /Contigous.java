import java.io.*;
import java.util.*;
/*


http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/


 If all elements are distinct, 
 then a subarray has contiguous elements
  if and only if the difference
   between maximum and minimum elements 
 in subarray is equal to the difference 
 between last and first indexes of subarray

*/
class Contigous{
	public static void main(String args[])throws IOException{
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int n = arr.length;
        System.out.println("Length of the longest contiguous subarray is "
                + findLength(arr, n));
	}
	public static int findLength(int arr[],int n){

		int max_len=1;
		for(int i=0;i<n-1;i++){
			int mn=arr[i];
			int mx=arr[i];
			for(int j=i+1;j<n;j++){

				mn=Math.min(mn,arr[j]);
				mx=Math.max(mx,arr[j]);

				if((mx-mn)==j-i)//logic for the 
				{
					max_len=Math.max(max_len,mx-mn+1);
				}
			}

		}
		return max_len;

	}
}