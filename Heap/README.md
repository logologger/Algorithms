<p>Please refer the following lecture for the good tutorials
</p>

<p>
https://www.youtube.com/watch?v=2fA1FdxNqiE
</p>

<b>Problem : </b><p>http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/</p>


<b>
What is Heap ?</b>


<p>You have some balls ...you start collecting them at one place ..then what happens ...it gets created in the form of heap ....That's y we call it has heap</p>


<b>What is Max -heap </b>

<p>
	
Max-Heap is one in which root is greater then left and right

</p>

<b>What is Min-Heap then ?</b>

<p>Min Heap is one in which root is lesser then left and right</p>

<p>Two Things we should considered in Heap Data structure</p>
<ul>
<li>
	ExtractMax --Get the maximum element from the root of the heap tree
</li>
<li>
	
	MaxHeapify -- Run the heapify algo means make parent should be greater then left and right subchild

	AFter ExtractMax -- we run the maxheapify so that entire tree can be conveted 
	to max heap - maxheapify starts from the bottom of the tree or from the top
</li>
<li>
	
	Complete Binary Tree -- It is a concept that says that a parent can have only two children or 0 but not one
</li>
</ul>


<h3>Extract Max in Max heapify</h3>

```java 
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
    
```


<h3>Max heapify </h3>
```java
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
```