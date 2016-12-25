import java.io.*;
import java.util.*;
/*

If there is negative in diagnol in distance Matrix then Negative Cycle exist in the graph
https://www.youtube.com/watch?v=LwJdNfdLF9s

*/
class FloydWarshall{

	class NegativeCycleException extends RuntimeException{



	}

	public static final int INF=100000;

	public int[][] allPairShortestPath(int[][] distanceMatrix){

		int length=distanceMatrix.length;
		int distance[][]=new int[length][length];
		int path[][]=new int[length][length];

		for(int i=0;i<distanceMatrix.length;i++){
			for(int j=0;j<distanceMatrix.length;j++){
				distance[i][j]=distanceMatrix[i][j];
				if(distanceMatrix[i][j]!=INF && i!=j){
					path[i][j]=i;
				}
				else{
					path[i][j]=-1;
				}
			}


		}

		for (int k=0;k<length ;k++) {

			for (int i=0;i<length;i++) {
				for (int j=0;j<length;j++) {

					if(distance[i][k]==INF || distance[k][j]==INF){
						continue;
					}
					if(distance[i][j]>distance[i][k]+distance[k][j]){

						distance[i][j]=distance[i][k]+distance[k][j];
						path[i][j]=path[k][j];

					}
					
				}
				
			}
			
		}

		for(int i=0;i<length;i++){
			if(distance[i][i]<0){
				throw new NegativeCycleException();
			}
		}
		printPath(path,3,2);
		return distance;


	}
	public void printPath(int[][] path,int start,int end){
		if(start < 0 || end<0 || start >=path.length || end>=path.length){
			throw new IllegalArgumentException();
		}

		System.out.println("Actual Path - "+start+" "+end);
		Deque<Integer> stack=new LinkedList<>();
		stack.addFirst(end);
		while(true){
			end=path[start][end];
			if(end==-1){
				return;
			}
			stack.addFirst(end);
			if(end==start){
				break;
			}
		}

		while(!stack.isEmpty()){
			System.out.print(stack.pollFirst()+" ");
		}
		System.out.println();


	}

	public static void main(String args[]){

		int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };

        FloydWarshall shortestPath = new FloydWarshall();
        int[][] distance = shortestPath.allPairShortestPath(graph);
        System.out.println("Minimum Distance matrix");
        for(int i=0; i < distance.length; i++){
            for(int j=0; j < distance.length; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }

	}

}