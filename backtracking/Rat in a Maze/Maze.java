import java.io.*;
import java.util.*;
class Maze{

	final int N=4;
	public static void main(String args[]){

		Maze m=new Maze();
		int maze[][] = {{1, 1, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1}
        };
        m.solveMaze(maze);



	}

	void printSolution(int sol[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(" "+sol[i][j]);
			}
			System.out.println();
		}
	}

	boolean isSafe(int maze[][],int x,int y){
		return (x>=0 && x<N && y>=0 && y<N && maze[x][y]==1);
	}

	boolean solveMaze(int maze[][]){

		int sol[][]={

			{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}


		};
		if(solveMazeUtil(maze,0,0,sol)==false){
				System.out.println("Solution doesnt exist!");
				return false;

		}
		else{

			printSolution(sol);
			return true;


		}


	}

	boolean solveMazeUtil(int maze[][],int x,int y,int sol[][]){
		
		if(x==N-1 && y==N-2){//Base point where recursion may stop
			sol[x][y]=1;
			return true;
		}

		System.out.println("x = "+x+" y= "+y);

		//Backtracking starts
		if(isSafe(maze,x,y)==true){
			sol[x][y]=1;

			//Proceed in x direction or Y direction 
			if(solveMazeUtil(maze,x+1,y,sol)){
				return true;

			}
			if(solveMazeUtil(maze,x,y+1,sol)){
				return true;
			}

			sol[x][y]=0;
			return false;
		}
		return false;//Means above if condition is false
	}
}