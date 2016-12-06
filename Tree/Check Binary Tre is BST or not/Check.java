import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int item){
		data=item;
		left=right=null;
	}
}
class Check{

	Node root;

	public boolean checkBSTinBinaryTree(Node root,int min,int max){

		if(root==null)
			return true;
		if(root.data<=min || root.data>max){
			return false;
		}
		return checkBSTinBinaryTree(root.left,min,root.data)&&checkBSTinBinaryTree(root.right,root.data,max);


		


	}
	
	public boolean checkBSTinBinaryTree(){
		return checkBSTinBinaryTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static void main(String args[])
	{

		 Check tree = new Check();
        tree.root = new Node(12);
        tree.root.left = new Node(9);
        tree.root.right = new Node(18);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(101);
      //  int result=tree.returnLCA(3,10);
        boolean result=tree.checkBSTinBinaryTree();
        //Node resultBinarytree=tree.returnLCAinBinaryTree(new Node(3),new Node(10));
        System.out.println(result);

	}
}