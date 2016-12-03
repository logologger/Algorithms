import java.io.*;
import java.util.*;

class Node{
		int data;
		Node left,right;
				Node(int item){
					data=item;
				}

}

/*

Queue offer returns special value as compared to add which throws Exception when 
something goes wrong


There is Recursion based approach for level Order traversal .Next will be that 

*/
class Levelorder{
	 Node root;

	public Levelorder(){
		root=null;
	}

	public static void levelOrder(Node root){
		
		if(root==null){
			System.out.println("Not a valid tree");
			return ;
		}
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(root);
		while(queue.size()>0){

			root=queue.poll();
			System.out.println(root.data+" ");
			if(root.left!=null){
				queue.add(root.left);
			}
			if(root.right!=null){
				queue.add(root.right);
			}

		}


	}
	public void levelOrder(){
		levelOrder(root);
	}
	public static void main(String args[]){
			Levelorder tree = new Levelorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
 
        System.out.println("\nLevelorder traversal of binary tree is ");
        tree.levelOrder();
	}
}