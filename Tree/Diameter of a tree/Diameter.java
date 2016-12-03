import java.io.*;
import java.util.*;

class Node{
int data;
Node left,right;
public Node(int item){
	data=item;
	left=right=null;
}
}

//Time Complexity is O(n^2)


class Diameter{

	Node root;
	public int  diameter(Node root){

		if(root==null){
			return 0;
		}

		int lheight=height(root.left);
		int riheight=height(root.right);

		int ldiameter=diameter(root.left);
		int rdiameter=diameter(root.right);

		return Math.max(lheight+riheight+1,Math.max(ldiameter,rdiameter));

	}

	public int diameter(){
			return diameter(root);
	}

	public static int height(Node node){
		if(node==null){
			return 0;

		}
		int lheight=height(node.left);
		int riheight=height(node.right);
		return 1+Math.max(lheight,riheight);

	}
	public static void main(String args[]){

		 Diameter tree = new Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter());

	}
}