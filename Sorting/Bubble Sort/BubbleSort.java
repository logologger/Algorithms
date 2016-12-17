import java.io.*;
class BubbleSort{

	public static void sort(int arr[]){
		int n=arr.length;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
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
 
        BubbleSort ob = new BubbleSort();        
        ob.sort(arr);
         
        printArray(arr);

	}


}