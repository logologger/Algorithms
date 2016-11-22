import java.io.*;
import java.util.*;
class Toposort{
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
			g.topologicalSort();
			/*
				Only Applicable for Directed Acyclic Graph
				https://www.youtube.com/watch?v=ddTC4Zovtbc
				http://www.geeksforgeeks.org/topological-sorting/
				used for scheduling jobs from the given dependencies among jobs

			*/

					




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

	void topologicalSort(){

		Stack stack=new Stack();
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++){
			if(visited[i]==false){
				topologicalSortUtil(i,visited,stack);
			}
		}
		while(stack.empty()==false){
			System.out.println(stack.pop()+" ");
		}

	}
	void topologicalSortUtil(int v,boolean visited[],Stack stack){

		visited[v]=true;
		Iterator<Integer> i=adj[v].listIterator();
		while(i.hasNext()){
			int n=i.next();
			if(visited[n]==false){
				topologicalSortUtil(n,visited,stack);
			}
		}
		stack.push(new Integer(v));

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