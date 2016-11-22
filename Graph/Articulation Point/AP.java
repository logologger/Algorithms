import java.io.*;
import java.util.*;
class AP{
	public static void main(String args[])throws IOException{
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int t=Integer.parseInt(in.readLine());
		while(t>0){

			Graph g=new Graph(4);

			g.addEdge(0,1);
			g.addEdge(1,2);
			g.addEdge(2,3);
			g.addEdge(3,2);
			g.addEdge(3,1);
			// g.DFS(0);

			// g.BFS(0);
			//Tarzan algo
			g.aPoint();
					




			t--;
		}
	}

}

class Graph{
//Graph data structure

	private int V;
	private LinkedList<Integer> adj[];
	int time=0;
    static final int NIL=-1;

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


void aPoint(){
	boolean visited[]=new boolean[V];
	int disc[]=new int[V];
	int low[]=new int[V];
	int parent[]=new int[V];
	boolean ap[]=new boolean[V];

	for(int i=0;i<V;i++){
		parent[i]=NIL;
		visited[i]=false;
		ap[i]=false;
	}
	for(int i=0;i<V;i++){
		if(visited[i]==false){
			aPointUtil(i,visited,disc,low,parent,ap);
		}
	}
	for(int i=0;i<V;i++){
		if(ap[i]==true){
			System.out.println(i+" ");
		}
	}

}


void aPointUtil(int u,boolean visited[],int disc[],int low[],int parent[],boolean ap[]){
	int children=0;
	visited[u]=true;
	disc[u]=low[u]=++time;
	Iterator<Integer> i=adj[u].listIterator();
	while(i.hasNext()){
		int v=i.next();
		if(visited[v]==false){
			children++;
			parent[v]=u;
			aPointUtil(v,visited,disc,low,parent,ap);

			low[u]=Math.min(low[u],low[v]);
			if(parent[u]==NIL && children>1){
				ap[u]=true;
			}
			if(parent[u]!=NIL && low[v]>=disc[u]){
				ap[u]=true;
			}
		}
		else if(v!=parent[u]){
			low[u]=Math.min(low[u],disc[v]);
		}

	}


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