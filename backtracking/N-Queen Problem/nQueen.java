import java.io.*;
import java.util.*;


class Position{
	int row,col;
	Position(int row,int col){
		this.row=row;
		this.col=col;
	}


}
class nQueen{
	public static void main(String args[]){

		nQueen n=new nQueen();
		Position[] p=n.solvenQueen(4);
		Arrays.stream(p).forEach(position->System.out.println(position.row+" "+position.col));

	}

	public Position[] solvenQueen(int n){
		Position[] p=new Position[n];
		boolean hasSolution=solvenQueenUtil(n,0,p);
		if(hasSolution){
			return p;
		}
		else{

			//means no solution 
			return new Position[0];

		}
	}

	public boolean solvenQueenUtil(int n,int row,Position[] p){

		if(n==row){
			return true;
		}
		int col;
		for(col=0;col<n;col++){
			
			//System.out.println("row is "+row+" col is "+col);
			boolean foundSafe=true;
			//check whether it is valid for previous rows
			//which are there in Position array p

			for(int queen=0;queen<row;queen++){

				if(p[queen].col==col || p[queen].row-p[queen].col==row-col || p[queen].row+p[queen].col==row+col){
					foundSafe=false;
					break;
				}
			}


			if(foundSafe){
				p[row]=new Position(row,col);
				if(solvenQueenUtil(n,row+1,p)){
					return true;
				}
			}
		}
		return false;

	}
}