import java.io.*;
import java.util.*;


// class Node{

// 	int data;
// 	Node left,right;
// 	Node(item){
// 		data=item;
// 		left=right=null;
// 	}

// }
enum Color{
	RED,
	BLACK
}


//Actually it is BST Insertion and we know that in Binary Tree there is no order by which we can insert Nodes

//This implementation will come handy in Red Black Tree and Other Implmentation
class Node{
	Node left;
	Node right;
	int data;
	int height;
	int size;
	Color color;
	int lis;
	Node next;
	public static Node newNode(int data){
		Node n=new Node();
		n.left=null;
		n.right=null;
		n.data=data;
		n.lis=-1;
		n.height=1;
		n.color=Color.RED;
		n.size=1;
		return n;
	}
}



class MorrisInorder{




	public void inorder(Node root){
		Node current=root;
		while(current!=null){

			if(current.left==null){
				System.out.println(" "+current.data);
				current=current.right;
			}
			else{
				Node predecessor=current.left;
				while(predecessor.right!=null && predecessor.right!=current){
					predecessor=predecessor.right;
				}

				if(predecessor.right==null){
						predecessor.right=current;
						current=current.left;
				}
				else{
					predecessor.right=null;
					System.out.println(current.data+" ");
					current=current.right;


				}




			}
		}
	}
	public void preorder(Node root){
		Node current=root;
		while(current!=null){

			if(current.left==null){
				System.out.println(" "+current.data);
				current=current.right;
			}
			else{
				Node predecessor=current.left;
				while(predecessor.right!=null && predecessor.right!=current){
					predecessor=predecessor.right;
				}

				if(predecessor.right==null){
						predecessor.right=current;
						System.out.println(current.data+" ");
						current=current.left;
				}
				else{
					predecessor.right=null;
					
					current=current.right;


				}




			}
		}
	}
	public static void main(String args[]){

		BinaryTree bt=new BinaryTree();
		Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(50, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(7, root);
        root = bt.addNode(9, root);
        root = bt.addNode(-20, root);
        root = bt.addNode(30, root);
        MorrisInorder m=new MorrisInorder();
        m.inorder(root);
        System.out.println("  ");
        m.preorder(root);

	}

}


class BinaryTree{

public Node addNode(int data,Node head){
		Node tempHead=head;
		Node n=Node.newNode(data);
		if(head==null){//means the first node
			head=n;
			return head;
		}
		Node prev=null;
		while(head!=null){
			prev=head;
			if(head.data<data){
				head=head.right;
			}
			else{
				head=head.left;
			}
		}
		if(prev.data<data){
			prev.right=n;
		}
		else{
			prev.left=n;
		}
		return tempHead;
	}

	public int height(Node root){

		if(root==null){
			return 0;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);

		return Math.max(leftHeight,rightHeight)+1;

	}





}