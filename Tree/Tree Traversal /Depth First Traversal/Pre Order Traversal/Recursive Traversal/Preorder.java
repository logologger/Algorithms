import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int item){
		data=item;
	}
}

class Preorder{
	Node root;
	
	Preorder(){
				root=null;
	}
	// public void printPostOrder(Node node){
	// 	if(node==null){
	// 		return ;
	// 	}
	// 	printPostOrder(node.left);

	// 	printPostOrder(node.right);
		
	// 	System.out.print(" "+node.data);
	// }

	public void printPreOrder(Node node){
		if(node==null){
			return ;
		}
		System.out.print(" "+node.data);

		printPreOrder(node.left);

		printPreOrder(node.right);
	}

	// public void printInorder(Node node){
	// 	if(node==null){
	// 		return ;
	// 	}a

	// 	printInorder(node.left);

	// 	System.out.println(node.data);

	// 	printInorder(node.right);
	// }

	// void printInOrder(){
	// 			printInorder(root);
	// }
	void printPreOrder(){
				printPreOrder(root);

	}
	// void printPostOrder(){
	// 			printPostOrder(root);
	// }



	public static void main(String args[]){

			Inorder tree = new Inorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();
 
        // System.out.println("\nInorder traversal of binary tree is ");
        // tree.printInOrder();
 
        // System.out.println("\nPostorder traversal of binary tree is ");
        // tree.printPostOrder();
	}



}