import java.io.*;
import java.util.*;


enum Color{
	RED,
	BLACK
}

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

class avltree{

	public Node leftRotate(Node root){

				Node newRoot=root.right;
				root.right=root.right.left;
				newRoot.left=root;
				root.height=setHeight(root);
				root.size=setSize(root);
				newRoot.height=setHeight(newRoot);
				newRoot.size=setSize(newRoot);
				return newRoot;


	}
	public Node rightRotate(Node root){

				Node newRoot=root.left;
				root.left=root.left.right;
				newRoot.right=root;
				newRoot.left=root;
				root.height=setHeight(root);
				root.size=setSize(root);
				newRoot.height=setHeight(newRoot);
				newRoot.size=setSize(newRoot);
				return newRoot;




	}
	public int setHeight(Node root){

		if(root ==null){
			return 0;
		}
		return 1+Math.max((root.left!=null?root.left.height:0),(root.right!=null?root.right.height:0));

	}
	public int height(Node root){
		if(root==null){
			return 0;
		}
		return root.height;

	}
	public int setSize(Node root){
			if(root==null){
			return 0;
		}
		return 1+Math.max((root.left!=null?root.left.size:0),(root.right!=null?root.right.size:0));	
	}
	public Node insert(Node root,int data){



			//insertion will be same as BST insertion but only difference is 
		//that we will keep on watching the height of the tree
		if(root==null){
			return Node.newNode(data);//Need class Node here
		}
		if(data>=root.data){
				root.right=insert(root.right,data);
		}
		else{
			root.left=insert(root.left,data);

		}
		int balance=balance(root.left,root.right);
		if(balance>1){//L case 
				//Means LL or LR case
			if(height(root.left.left)>=height(root.left.right)){
				root=rightRotate(root);
				//Left  height is greater so LL case
			}
			else{
				root=leftRotate(root.left);
				root=rightRotate(root);

			}
		}

		else if(balance<-1){
		

				//Means RR or RL case
		
				if(height(root.right.right)>=height(root.right.left)){
					root=leftRotate(root);
				}
				else{
					root.right=rightRotate(root.right);
					root=leftRotate(root);
				}
		}
		else{
			//means everything is ok on insertion of node  in tree
			root.height=setHeight(root);
			root.size=setSize(root);
		}
		return root;



	} 

	public int balance(Node rootLeft,Node rootRight){
		return height(rootLeft)-height(rootRight);
	}
	public static void printInorder(Node node){
		if(node==null){
			return ;
		}

		printInorder(node.left);

		System.out.println(node.data);

		printInorder(node.right);
	}

	public static void main(String args[]){

		avltree avlTree=new avltree();
		Node root=null;
		 root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);

        //Lets do tree traversal here
        printInorder(root);


	}
}