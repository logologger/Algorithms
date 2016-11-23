import java.io.*;
import java.util.*;
class MaxHeap{
	int capacity;
	int arr[];
	int size;
	
	public MaxHeap(int capacity){
		this.capacity=capacity;
		arr=new int[this.capacity];
		this.size=0;
	}
	void swap(int arr[],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	int parent(int i){

		return (i-1)/2;
	}
	int left(int i){
		return 2*i+1;
	}
	int right(int i){
		return 2*i+2;
	}
	int getMax(){
		if(size<=0){
			System.out.println("Heap Underflow");
			return Integer.MIN_VALUE;

		}
		return arr[0];
	}
	int extractMax(){
		if(size<=0){
			System.out.println("Heap Underflow");
			return Integer.MIN_VALUE;
		}
		if(size==1){
			size--;
			return arr[0];
		}
		int root=arr[0];
		arr[0]=arr[size-1];
		size--;
		maxHeapify(0);
		return root;
	}
	void maxHeapify(int i){
		int l=left(i);
		int r=right(i);
		int largest=i;

		if(l<size && arr[l]>arr[largest]){
			largest=l;
		}
		if(r<size && arr[r]>arr[largest]){
			largest=r;
		}
		if(largest!=i){
			swap(arr,i,largest);
			maxHeapify(largest);
		}
	}
	void fixUpwards(int i){
		while(i!=0 && arr[i]>arr[parent(i)]){
			swap(arr,i,parent(i));
			i=parent(i);
		}
	}
	void increaseKey(int i,int newKey){
		arr[i]=newKey;
		fixUpwards(i);

	}
	void insert(int key){
		if(size==capacity){
			System.out.println("Heap Overflow");
			return ;
		}
		arr[size++]=key;
		fixUpwards(size-1);


	}
	void delete(int i){
		increaseKey(i,Integer.MAX_VALUE);
		extractMax();
	}
	public void printMinHeap(){
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		System.out.println();
		}
	}





}
class BaseMaxHeap{

	public static void main(String args[]){
		MaxHeap m=new MaxHeap(5);
		m.insert(3);
		m.insert(2);
		m.delete(1);
		m.insert(15);
		m.insert(5);
		m.insert(4);
		m.insert(45);
		m.insert(50);
		m.extractMax();
		m.increaseKey(2,20);
		


	}
}