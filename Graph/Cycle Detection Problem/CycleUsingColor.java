import java.io.*;
import java.util.*;
enum Color{WHITE,BLACK,GREY;}
class CycleUsingColor{
	public static void main(String args[])throws IOException{
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int t=Integer.parseInt(in.readLine());
		while(t>0){

			Graph g=new Graph(7);
			// g.addEdge(0,1);
			// g.addEdge(1,2);
			// g.addEdge(2,3);
			// g.addEdge(3,2);
			// g.addEdge(3,1);
			// g.DFS(0);

			// g.BFS(0);

			
			g.addEdge(0,1);
			g.addEdge(1,2);
			g.addEdge(2,3);
			g.addEdge(0,4);
			g.addEdge(4,5);
			g.addEdge(5,6);
			g.addEdge(3,0);


			//Lets Check for Cycle here 

			if(g.isCyclic()){
				System.out.println("Graph contains Cycle");

			}
			else{
				System.out.println("Graph doesnot contains Cycle");
			}

					




			t--;
		}
	}

}

class Graph{
//Graph data structure

	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v){

		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList<Integer>();
		}
	}

	void addEdge(int v,int w){
		adj[v].add(w);
	}

	//////// GRAPH GOT CREATED UP ////////////



	boolean isCyclic(){

			Color color[]=new Color[V];
			for(int i=0;i<V;i++){
				color[i]=Color.WHITE;
			}
			for(int i=0;i<V;i++){
				
				if(color[i]==Color.WHITE){
					
				if(isCyclicUtil(i,color)){
					
					return true;
				}
			}
				
			}
			return false;

	}
	boolean isCyclicUtil(int v,Color color[]){

		color[v]=Color.GREY;
		Iterator<Integer> i=adj[v].listIterator();
		while(i.hasNext()){
			int n=i.next();
			if(color[n]==Color.GREY)
				return true;//has Cycle
			if(color[n]==Color.WHITE && isCyclicUtil(n,color))
				return true;

		}
		color[v]=Color.BLACK;


		
		return false;
		

	}



	///////////////DFS Here /////////
	void DFS(int v){
		boolean visited[]=new boolean[V];
		DFSUtil(v,visited);

	}
	void DFSUtil(int v,boolean visited[]){
		visited[v]=true;
		System.out.println("visited this "+v+"th Node");
		Iterator<Integer> i=adj[v].listIterator();
		while(i.hasNext()){
			int n=i.next();
			if(!visited[n]){
				DFSUtil(n,visited);
			}

		}
	}


	/////////BFS here //////////////

	void BFS(int s){
		boolean visited[]=new boolean[V];
		LinkedList<Integer> queue=new LinkedList<Integer>();
		visited[s]=true;
		queue.add(s);
		while(queue.size()!=0){
			s=queue.poll();
			System.out.println("visited Vertex "+s+"th");
			Iterator<Integer> i=adj[s].listIterator();
			while(i.hasNext()){
				int n=i.next();
				if(!visited[n]){

					visited[n]=true;
					queue.add(n);

				}
			}

		}


	}

}