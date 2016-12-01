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


class computeHeight{


	Node root;

	public int maxDepth(Node node){

		//System.out.println("called");
		if(node==null)
			return 0;
		else{
			//System.out.println("Before it is "+lDepth+"  "+rDepth);
			int lDepth=maxDepth(node.left);
		//	System.out.println("Middle it is "+lDepth);
			int rDepth=maxDepth(node.right);
		//	System.out.println("After it is "+lDepth+"  "+rDepth);

			if(lDepth>rDepth){

		//	System.out.println("Left it is "+lDepth+"  "+rDepth);
				return (lDepth+1);
			}
			else{
		//		System.out.println("Right it is "+lDepth+"  "+rDepth);
				return (rDepth+1);
			}
		}


	}
	public static void main(String args[]){

		computeHeight ch=new computeHeight();

		ch.root=new Node(1);
		ch.root.left=new Node(2);
		ch.root.right=new Node(3);
		ch.root.left.left = new Node(4);
        ch.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + 
                                      ch.maxDepth(ch.root));

	}

}