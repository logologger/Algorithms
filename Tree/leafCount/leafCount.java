import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	public Node(int item){

		data=item;

	}
}
class leafCount{


	Node root;
	int countLeaf(){
		return countLeaf(root);
	}

	int countLeaf(Node root){
		if(root==null){
			return 0;
		}
		if(root.left==null && root.right==null){
			return 1;
		}
		else 
			return countLeaf(root.left)+countLeaf(root.right);
	}


	   public static void main(String args[])
    	{
        /* creating a binary tree and entering the nodes */
        leafCount tree = new leafCount();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(7);
 
        System.out.println("The leaf of binary tree is : "
                            + tree.countLeaf());
    	}




}