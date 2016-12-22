import java.io.*;
import java.util.*;
/*

 A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 * 
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)

*/

class FenwickTree{

	public int getSum(int binaryIndexedTree[],int index){

		index=index+1;//binary Index tree stores indices + 1 from original input array 
		int sum=0;
		while(index>0){
			sum+=binaryIndexedTree[index];
			index=getParent(index);
		}
		return sum;

	}

	//Update the index node  and keep on doing for the next Node till it is greater then length of binaryIndex tree
	public void updateBinaryIndexedTree(int binaryIndexedTree[],int val,int index){
		while(index<binaryIndexedTree.length){
			binaryIndexedTree[index]+=val;
			index=getNext(index);
		}

	}

	//Create Fenwick tree is like updating it

	public int[] createTree(int input[]){
		int binaryIndexedTree[]=new int[input.length+1];
		for(int i=1;i<=input.length;i++){
			updateBinaryIndexedTree(binaryIndexedTree,input[i-1],i);
		}

		return binaryIndexedTree;
	}

	/**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
	public int getNext(int index){
		return index + (index & -index);
	}
	/**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
	public int getParent(int index){

		return index - (index & -index);

	}


	public static void main(String args[]){

		 int input[] = {1,2,3,4,5,6,7};
        FenwickTree ft = new FenwickTree();
        int binaryIndexedTree[] = ft.createTree(input);
        System.out.println("1 == "+ft.getSum(binaryIndexedTree, 0));

	}

}