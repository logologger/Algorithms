/*

https://www.hackerearth.com/codemonk-trees/algorithm/monk-and-cursed-tree/

*/
import java.io.*;
import java.util.*;


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

class MonkCursedTree{

	static int max_result=0;

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

	public void traversePath(Node head,int data){
			// go from data1 to data2
		/*
			How ?



		*/

	}
	public Node search(Node root,int data,int max){

		if(root.data>max){
			max=root.data;
			max_result=max;
		}

			if(root==null || root.data==data){
				return root;
			}
			if(root.data > data){
				return search(root.left,data,max);
			}

			return search(root.right,data,max);		
	}

	public static int returnLCA(Node root,int p,int q){

		//System.out.println(" right and left "+root.left.data);
			if(root.data>Math.max(p,q)){
				return returnLCA(root.left,p,q);

			}
			else if(root.data<Math.min(p,q)){
			return	returnLCA(root.right,p,q);

			}
			else{
				//System.out.println("return what "+root.data);
				return root.data;

			}
			//return root.data;
			// return 0;

	}

	 public static void main(String args[])throws IOException{
        MonkCursedTree bt = new MonkCursedTree();
        Node head = null;

        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(reader);
        int t=Integer.parseInt(in.readLine());
        StringTokenizer st=new StringTokenizer(in.readLine());
        StringTokenizer st2=new StringTokenizer(in.readLine());
    	int data1=Integer.parseInt(st2.nextToken());
    	int data2=Integer.parseInt(st2.nextToken());
        while(st.hasMoreTokens()){
        	int n=Integer.parseInt(st.nextToken());
        	head = bt.addNode(n, head);

    	}
       // System.out.println(bt.height(head));
    
    //bt.traversePath(head,data1,data2);
    	//Print the path from root to data1 and data2
    	//Fails in cases where root is not involved
    	
    	//Find LCA
    	int lca_data=returnLCA(head,data1,data2);
    	//System.out.println(lca_data);
    	Node root_temp=bt.search(head,lca_data,0);

    	// System.out.println(root_temp.data);

    	bt.search(root_temp,data1,0);
    	int temp_max_result=max_result;
    
    	bt.search(root_temp,data2,0);
    	
    	if(temp_max_result<max_result){

    		temp_max_result=max_result;
    	}

    	System.out.print(temp_max_result);
    	

    }

}