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
class LCA{

	Node root;

	public Node returnLCAinBinaryTree(Node root,Node n1,Node n2){
		if(root==null){
			return null;
		}
		if(root==n1 || root==n2){
			return root;
		}
		Node left=returnLCAinBinaryTree(root.left,n1,n2);
		Node right=returnLCAinBinaryTree(root.right,n1,n2);

		if(left!=null && right!=null)
			return root;
		return left!=null?left:right;


	}
	public  int returnLCA(Node root,int p,int q){

		System.out.println(" right and left "+root.left.data);
			if(root.data>Math.max(p,q)){
				return returnLCA(root.left,p,q);

			}
			else if(root.data<Math.min(p,q)){
			return	returnLCA(root.right,p,q);

			}
			else{
				System.out.println("return what "+root.data);
				return root.data;

			}
			//return root.data;
			// return 0;

	}
	public int returnLCA(int p,int q){
		return returnLCA(root,p,q);
	}
	public Node returnLCAinBinaryTree(Node n1,Node n2){
		return returnLCAinBinaryTree(root,n1,n2);
	}
	public static void main(String args[])
	{

		 LCA tree = new LCA();
        tree.root = new Node(12);
        tree.root.left = new Node(9);
        tree.root.right = new Node(18);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(10);
        int result=tree.returnLCA(3,10);
        Node resultBinarytree=tree.returnLCAinBinaryTree(new Node(3),new Node(10));
        System.out.println(result+" "+resultBinarytree.data);

	}
}