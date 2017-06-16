import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code
		
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		/*
		
		        2
                5 2
                12 5 787 1 23
                7 3
                1 23 12 9 30 2 50
		
		*/
		
		int t=Integer.parseInt(in.readLine());
		while(t-->0){
		    String str[]=in.readLine().split(" ");
		    int n=Integer.parseInt(str[0]);
		    int q=Integer.parseInt(str[1]);
		    //Lets build a  max heap now
		    int arr[]=new int[n];
		    String str2[]=in.readLine().split(" ");
		    Maxheap m=new Maxheap(n);
		    for(int i=0;i<n;i++){
		        //insert into heap elements of this array str2
		        m.insert(Integer.parseInt(str2[i]));
		        
		        
		    }
		    for(int i=0;i<q;i++){
		        System.out.print(m.extractMax()+" ");
		    }
		    
		    System.out.println();
		    
		    //calls extract max k times to get top 3 elements
		}
	}
}

//Here we implement Max Heap Data structure
class Maxheap{
    
    int size;//currently how many elements are filled
    int capacity;//the maximum limit
    int arr[];//contains the heap element in this
    public Maxheap(int capacity){
        
        this.capacity=capacity;
        arr=new int[this.capacity];
        this.size=0;//because there is no element in the heap right now
        
    }
    
    //Some Properties of Heap are left ,right ,parent
    public int parent(int i){//parent index of heap
        return (i-1)/2;
    }
    public int left(int i){//left of heap tree
        return 2*i+1;
    }
    public int right(int i){//right of heap tree
        return 2*i+2;
    }
    //swap the two elements in the array 
    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    //Maximum elements in Max heap is always at the root location
    public int getMax(){
        if(size<=0){//If size is less then 0 then nothing exist
            System.out.println("Heap Underflow");
            return Integer.MIN_VALUE;
        }
        
        return arr[0];
    }
    public int extractMax(){
        if(size<=0){
            System.out.println("Heap Underflow");
            return Integer.MIN_VALUE;
        }
        
        if(size==1){
            //No Need to manage the heap or restructure it
            size--;
            return arr[0];
        }
        //swap the element 
        int root=arr[0];
        arr[0]=arr[size-1];
        
        size--;
        
        //decrease the size we dont delete from array we just decrease the heap size .even though the element is there in the array
        maxHeapify(0);
        //reorder the tree ..means make it max heap again
        return root;
    }
    public void maxHeapify(int i){
        
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
    
    
    public void fixUpwards(int i){
        //FixUpwards from current key to root of the heap
        while(i!=0 && arr[i]>arr[parent(i)]){
            swap(arr,i,parent(i));
            i=parent(i);
        }
        
    }
    
    public void insert(int key){
        if(size==capacity){
            System.out.println("Heap Overflow");
            return;
        }
        
        arr[size++]=key;
        fixUpwards(size-1);
    }
    
    
    
}