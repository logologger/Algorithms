import java.io.*;
class selectionSort{

	public static void sort(int arr[]){
		int n=arr.length;
		for(int i=0;i<n-1;i++){
			int min_idx=i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[min_idx]){

					min_idx=j;
					
				}
			}
			int temp=arr[min_idx];
			arr[min_idx]=arr[i];
			arr[i]=temp;
			
		}
	}
	public static void printArray(int arr[]){

		int length=arr.length;
		for(int i=0;i<length;i++){
			System.out.print(" "+arr[i]);
		}
	}
	public static void main(String args[]){
		 int arr[] = {12, 11, 13, 5, 6};
 
        selectionSort ob = new selectionSort();        
        ob.sort(arr);
         
        printArray(arr);

	}


}