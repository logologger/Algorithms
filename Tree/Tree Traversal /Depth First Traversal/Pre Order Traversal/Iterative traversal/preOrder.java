import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int item){
		data=item;
	}
}

class preOrder{
	Node root;
	
	preOrder(){
				root=null;
	}


	public void printPreOrder(Node root){
		

		Deque<Node> s=new LinkedList<Node>();
		s.addFirst(root);
		while(!s.isEmpty()){

			root=s.pollFirst();

			System.out.println(root.data+" ");

			if(root.right!=null){
				s.addFirst(root.right);
			}
			if(root.left!=null){
				s.addFirst(root.left);
			}
		}
		
	}

	
	void printPreOrder(){
				printPreOrder(root);

	}
	



	public static void main(String args[]){

			preOrder tree = new preOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();
 
        
	}



}