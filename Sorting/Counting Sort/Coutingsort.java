import java.io.*;
import java.util.*;
class Countingsort{
	//An array is passed by call by reference
	public static void main(String args[]){

		Countingsort ob = new Countingsort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                      'r', 'g', 'e', 'e', 'k', 's'
                     };
 
        ob.sort(arr);
 
        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(" "+arr[i]);

	}
	public void sort(char arr[]){

		int n=arr.length;
		char output[]=new char[n];

		int count[]=new int[256];

		for(int i=0;i<256;i++){
			count[i]=0;
		}
		for(int i=0;i<n;++i){
			count[arr[i]]++;
		}
		for(int i=1;i<256;i++){
			
			count[i]=count[i]+count[i-1];
		}
		//Here you should understand what's going on
		for(int i=0;i<n;i++){
			output[count[arr[i]]-1]=arr[i];
			--count[arr[i]];
		}

		for(int i=0;i<n;i++){
			arr[i]=output[i];
		}

	}
}