import java.util.*;
import java.io.*;
class MinHeap{

	int arr[];
	int size;
	int capacity;
	public MinHeap(int capacity){
		

		this.capacity=capacity;
		arr=new int[this.capacity];
		this.size=0;
	
	}

	public void swap(int arr[],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;


	}
	public int parent(int i){

		return (i-1)/2;
	}
	public int left(int i){

		return 2*i+1;
	}

	public int right(int i){

		return 2*i+2;
	}
	public int getMin(){

		if(size<=0){
			System.out.println("Heap Underflow");
			return Integer.MAX_VALUE;
		}
		return arr[0];

	}
	public int extractMin(){

		if(size<=0){
			System.out.println("Heap Underflow");
			return Integer.MAX_VALUE;
		}
		if(size==1){
			size--;
			return arr[0];
		}
		int root=arr[0];
		arr[0]=arr[size-1];
		size--;
		minHeapify(0);
		return root;
	}
	void minHeapify(int i){
		int l=left(i);
		int r=right(i);
		int smallest=i;

		if(l<size && arr[l]<arr[smallest]){

			smallest=l;
		}
		if(r<size && arr[r]<arr[smallest]){
			
			smallest=r;
		}
		if(smallest!=i){
			swap(arr,i,smallest);
			minHeapify(smallest);
		}
	}
	public void fixUpwards(int i){
		while(i!=0 && arr[i]<arr[parent(i)]){

			swap(arr,i,parent(i));
			i=parent(i);

		}
	}
	public void decreaseKey(int i,int newKey){

		arr[i]=newKey;
		fixUpwards(i);
	}
	public void insert(int key){
		if(size==capacity){
			System.out.println("Heap Overflow");
			return;
		}
		arr[size++]=key;
		fixUpwards(size-1);
	}
	public void delete(int i){

		decreaseKey(i,Integer.MIN_VALUE);
		extractMin();

	}
	public void printMinHeap(){
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		System.out.println();
		}
	}


}



class BaseMinHeap{


	public static void main(String args[])throws IOException{

		InputStreamReader reader =new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		MinHeap m=new MinHeap(5);
		
		m.insert(3);
		m.insert(2);
		m.delete(1);
		m.insert(15);
		m.insert(5);
		m.insert(4);
		m.insert(45);
		m.insert(50);
		m.extractMin();
		m.getMin();
		m.decreaseKey(2,1);
		m.getMin();
		m.printMinHeap();



	}



}