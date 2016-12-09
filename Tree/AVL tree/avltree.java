import java.io.*;
import java.util.*;

class avltree{

	public Node leftRotate(Node root){

				Node newRoot=node.right;
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
	public static void main(String args[]){

	}
}