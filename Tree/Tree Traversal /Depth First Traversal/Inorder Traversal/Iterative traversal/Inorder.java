import java.io.*;
import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int item){
		data=item;
	}
}

class Inorder{
	Node root;
	
	Inorder(){
				root=null;
	}


	public void printPreOrder(Node root){
		

		Deque<Node> s=new LinkedList<Node>();
		Node node=root;

		while(true){

			if(node!=null){


				s.addFirst(node);
				node=node.left;

			}
			else{

				if(s.isEmpty()){
					break;
				}

				node=s.pollFirst();
				
				System.out.println(node.data);

				node=node.right;


			}
		}
		
		
	}

	
	void printPreOrder(){
				printPreOrder(root);

	}
	



	public static void main(String args[]){

			Inorder tree = new Inorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Inorder traversal of binary tree is ");
        tree.printPreOrder();
 
        
	}



}