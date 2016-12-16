import java.io.*;
import java.util.*;

class NextPoweroftwo{
	public int nextPowerof2(int num){

		if(num==0){
			return 1;
		}
		if(num > 0 && (num & (num-1))==0){

			return num;


		}
		while((num & (num-1))>0){
		//	System.out.println("before "+num);
			num=num & (num-1);
		//	System.out.println("after "+num);

		}
		return num<<1;
		//Shift num bits to 1 bit left if it is 16 then it
		//will be 32 as answer
	}


}
class Segmenttree{

	public int[] createSegmentTree(int input[]){
		NextPoweroftwo np2=new NextPoweroftwo();
		int nextPoweroftwo=np2.nextPowerof2(input.length);

		int segmentTree[]=new int[nextPoweroftwo*2-1];
		for(int i=0;i<segmentTree.length;i++){
			segmentTree[i]=Integer.MAX_VALUE;
		}

		constructSegmentTree(segmentTree,input,0,input.length-1,0);
		return segmentTree;



		
	}
	public void constructSegmentTree(int segmentTree[],int input[],int low,int high,int pos){

//Time to construct this tree is O(n)
		if(low==high){
			segmentTree[pos]=input[low];
			return;
		}
		int mid=(high+low)/2;
		constructSegmentTree(segmentTree,input,low,mid,2*pos+1);
		constructSegmentTree(segmentTree,input,mid+1,high,2*pos+2);
		segmentTree[pos]=Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
	}

	public int rangMinimumQuery(int segmentTree[],int qlow,int qhigh,int len){
		return rangMinimumQuery(segmentTree,0,len-1,qlow,qhigh,0);
	}

	public int rangMinimumQuery(int segmentTree[],int low,int high,int qlow,int qhigh,int pos){

		if(qlow<=low && qhigh>=high){
			return segmentTree[pos];//Total Overlap
		}
		if(qlow>high || qhigh<low){
			return Integer.MAX_VALUE;
		}//No Overlap

		int mid=(high+low)/2;
		return Math.min(rangMinimumQuery(segmentTree,0,mid,qlow,qhigh,2*pos+1),rangMinimumQuery(segmentTree,mid+1,high,qlow,qhigh,2*pos+2));
	}

	public static void main(String args[]){

		int input[]={-1,2,4,1,7,1,3,2};
		Segmenttree t=new Segmenttree();
		NextPoweroftwo two=new NextPoweroftwo();
		two.nextPowerof2(23);

		int seg[]=t.createSegmentTree(input);

		int result=t.rangMinimumQuery(seg,1,3,input.length);
		System.out.println("Minimum between 1 and 3 is "+result);


	}
}