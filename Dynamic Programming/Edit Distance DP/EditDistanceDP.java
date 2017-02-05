import java.io.*;
import java.util.*;
class EditDistanceDP{
	public static void main(String args[]){
		String str1 = "sunday";
        String str2 = "saturday";
  
        System.out.println( editDistRec( str1 , str2 , str1.length(), str2.length()) );
        System.out.println("Dynamic one "+dynamicEditDistance(str1.toCharArray(),str2.toCharArray()));
    }

	

	public static int min(int x,int y,int z){
		return Math.min(Math.min(x,y),z);
	}
	public static int editDistRec(String str1,String str2,int m,int n){
		if(m==0){
			return n;
		}
		if(n==0){
			return m;
		}
		if(str1.charAt(m-1)==str2.charAt(n-1)){
			return editDistRec(str1,str2,m-1,n-1);
		}
		return 1+min(editDistRec(str1,str2,m,n-1),//insert moved left
			editDistRec(str1,str2,m-1,n),//Remove --moved up
			editDistRec(str1,str2,m-1,n-1));//Replace
	}

	public static int dynamicEditDistance(char[] str1,char[] str2){

		int temp[][]=new int[str1.length+1][str2.length+1];

		for(int i=0;i<temp[0].length;i++){
			temp[0][i]=i;

		}
		for(int i=0;i<temp.length;i++){
			temp[i][0]=i;
		}

		for(int i=1;i<=str1.length;i++){
			for(int j=1;j<=str2.length;j++){

				if(str1[i-1]==str2[j-1]){
					temp[i][j]=temp[i-1][j-1];
				}
				else{
					temp[i][j]=1+min(temp[i][j-1],temp[i-1][j-1],temp[i-1][j]);
				}

			}
		}
		printActualEdits(temp,str1,str2);
		return temp[str1.length][str2.length];

	}
	public static void printActualEdits(int T[][],char[] str1,char[] str2){
		int i=T.length-1;
		int j=T[0].length-1;
		while(true){
			if(i==0 || j==0){
				break;
			}
			if(str1[i-1]==str2[j-1]){
				i=i-1;
				j=j-1;
			}
			else if(T[i][j]==T[i-1][j-1]+1){
				//Edit case
				System.out.println("Edited "+str2[j-1]+" to "+str1[i-1]);
				i=i-1;
				j=j-1;
			}
			else if(T[i][j]==T[i-1][j]+1){
				System.out.println("Insert "+str1[i-1]);
				i=i-1;
			}
			else if(T[i][j]==T[i][j-1]+1){
				System.out.println("Delete in String "+str2[j-1]);
				j=j-1;
			}
			else{
				System.out.println("something wrong happened");
			}
		}
	}
}