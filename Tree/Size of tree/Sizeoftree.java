import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	public Node(int item){

		data=item;

	}
}
class Sizeoftree{


	Node root;
	int size(){
		return size(root);
	}

	int size(Node root){
		if(root==null){
			return 0;
		}
		else 
			return size(root.left)+1+size(root.right);
	}


	   public static void main(String args[])
    	{
        /* creating a binary tree and entering the nodes */
        Sizeoftree tree = new Sizeoftree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(7);
 
        System.out.println("The size of binary tree is : "
                            + tree.size());
    	}




}