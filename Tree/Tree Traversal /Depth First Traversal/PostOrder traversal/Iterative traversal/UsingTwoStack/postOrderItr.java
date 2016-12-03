import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int item){
		data=item;
	}
}

class postOrderItr{
	Node root;
	
	postOrderItr(){
				root=null;
	}
	public void printPostOrder(Node root){

		//Make two stack here

		Deque<Node> stack1=new LinkedList<>();
		Deque<Node> stack2=new LinkedList<>();

		stack1.addFirst(root);

		while(!stack1.isEmpty()){
			root=stack1.pollFirst();
			if(root.left!=null){
				stack1.addFirst(root.left);
			}
			if(root.right!=null){
				stack1.addFirst(root.right);
			}
			stack2.addFirst(root);
		}

		while(!stack2.isEmpty()){
			System.out.println(stack2.pollFirst().data+" ");
		}




	}

	void printPostOrder(){
				printPostOrder(root);
	}



	public static void main(String args[]){

			postOrderItr tree = new postOrderItr();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder();
	}



}