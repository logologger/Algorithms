/*

https://www.hackerearth.com/codemonk-trees/algorithm/monk-watching-fight/

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

class MonkWatching{

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

	 public static void main(String args[])throws IOException{
        MonkWatching bt = new MonkWatching();
        Node head = null;

        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(reader);
        int t=Integer.parseInt(in.readLine());
        StringTokenizer st=new StringTokenizer(in.readLine());
        while(st.hasMoreTokens()){
        	int n=Integer.parseInt(st.nextToken());
        head = bt.addNode(n, head);
    }
        System.out.println(bt.height(head));
        
    }

}