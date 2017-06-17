import java.io.*;
import java.util.*;
class triplets{
	public static void main(String args[])throws IOException{
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		//Let the input be an array of specified length
		int n=Integer.parseInt(in.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in.readLine());
		}

		//find the pythagorean Triplets means 
		//find any sequence in the array such that a2=b2+c2

		//Lets see how we can do that

		naiveMethod(arr);

		boolean ans=sortedArrayAppr(arr);
		System.out.println("Sorted Array answer is "+ans);

	}


	public static boolean sortedArrayAppr(int arr[]){

		int n=arr.length;
		for(int i=0;i<arr.length;i++){
			arr[i]*=arr[i];
		}
		Arrays.sort(arr);

		//Now we will use meet in the middle technique to find it

		for(int i=n-1;i>=1;i--){

		
			int l=0;
			int r=i-1;
			while(l<r){
				//We have to make sure that l and r are never equal to i
				if(arr[l]+arr[r]==arr[i]){
					return true;

				}

				int b=(arr[l]+arr[r]<arr[i]) ? l++:r--;
			}
		}
		return false;

	}

	public static void naiveMethod(int arr[]){

		int n=arr.length;
		for(int i=0;i<n;i++){
			int a=arr[i];
			for(int j=i+1;j<n;j++){
				int b=arr[j];
				for(int k=j+1;k<n;k++){
					int c=arr[k];
					if(a*a+b*b==c*c){
						System.out.println("Found "+a+" "+b+" "+c);
					}
				}
			}
		}
	}
}