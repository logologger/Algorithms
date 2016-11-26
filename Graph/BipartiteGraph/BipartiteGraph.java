import java.io.*;
import java.util.*;

class BipartiteGraph{
/*

Applicable only for Strongly Connected GRaph 

BFS is applied here 

http://www.geeksforgeeks.org/bipartite-graph/

*/

final static int V=4;
public boolean isBipartite(int G[][],int src){

int colorArr[]=new int[V];
for(int i=0;i<V;i++){
	colorArr[i]=-1;
}
colorArr[src]=1;

LinkedList<Integer> queue=new LinkedList<Integer>();

queue.add(src);

while(queue.size()!=0){

int u=queue.poll();

for(int v=0;v<V;v++){
	if(G[u][v]==1 && colorArr[v]==-1){
		colorArr[v]=1-colorArr[u];
		queue.add(v);
	}
	else if(G[u][v]==1 &&  colorArr[v]==colorArr[u]){
		return false;

	}
}


}
return true;


}

public static void main(String args[]){
	int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        BipartiteGraph b=new BipartiteGraph();
        if(b.isBipartite(G,0))
        	System.out.println("yes");
        else
        	System.out.println("no");
}


}