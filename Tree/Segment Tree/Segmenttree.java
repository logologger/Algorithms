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
	public void updateSegmentTree(int input[],int segmentTree[],int index,int delta){
		input[index]+=delta;
		updateSegmentTree(segmentTree,index,delta,0,input.length-1,0);
	}
	public void updateSegmentTree(int segmentTree[],int index,int delta,int low,int high,int pos){
		if(index<low || index>high){
			return;
		}
		if(low==high){
			segmentTree[pos]+=delta;
			return;
		}
		int mid=(low+high)/2;
		updateSegmentTree(segmentTree,index,delta,low,mid,2*pos+1);
		updateSegmentTree(segmentTree,index,delta,mid+1,high,2*pos+2);
		segmentTree[pos]=Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);

	}
	public void updateSegmentTreeRange(int input[],int segmentTree[],int startRange,int endRange,int delta){
		for(int i=startRange;i<=endRange;i++){
			input[i]+=delta;
		}
		updateSegmentTreeRange(segmentTree,startRange,endRange,delta,0,input.length-1,0);
	}
	public void updateSegmentTreeRange(int segmentTree[],int startRange,int endRange,int delta,int low,int high,int pos){
		if(low>high || startRange>high || endRange<low){
			return;
		}
		if(low==high){
			segmentTree[pos]+=delta;
			return;
		}
		int middle=(high+low)/2;
		updateSegmentTreeRange(segmentTree,startRange,endRange,delta,low,middle,2*pos+1);
		updateSegmentTreeRange(segmentTree,startRange,endRange,delta,middle+1,high,2*pos+2);
		segmentTree[pos]=Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);

	}
	public void updateSegmentTreeRangeLazy(int input[],int segmentTree[],int lazy[],int startRange,int endRange,int delta){
			updateSegmentTreeRangeLazy(segmentTree,lazy,startRange,endRange,delta,0,input.length-1,0);
	}
	//Look at private below and public above 
	private void updateSegmentTreeRangeLazy(int segmentTree[],int lazy[],int startRange,int endRange,int delta,int low,int high,int pos){
			if(low>high){
				return;
			}

			if(lazy[pos]!=0){
				segmentTree[pos]+=lazy[pos];
				if(low!=high){
					lazy[2*pos+1]+=lazy[pos];
					lazy[2*pos+2]+=lazy[pos];
				}
				lazy[pos]=0;
			}
			//no overlap condition
			if(startRange>high || endRange<low){
				return;
			}
			//total overlap 
			if(startRange<=low && endRange >=high){
				segmentTree[pos]+=delta;
				if(low!=high){
					lazy[2*pos+1]+=delta;
					lazy[2*pos+2]+=delta;
				}
				return;
			}
			int mid=(high+low)/2;
			updateSegmentTreeRangeLazy(segmentTree,lazy,startRange,endRange,delta,low,mid,2*pos+1);
			updateSegmentTreeRangeLazy(segmentTree,lazy,startRange,endRange,delta,mid+1,high,2*pos+2);
			segmentTree[pos]=Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
	}

	public int rangMinimumQueryLazy(int segmentTree[],int lazy[],int qlow,int qhigh,int len){
		return rangMinimumQueryLazy(segmentTree,lazy,qlow,qhigh,0,len-1,0);
	}
	private int rangMinimumQueryLazy(int segmentTree[],int lazy[],int qlow,int qhigh,int low,int high,int pos){
		if(low>high){
			return Integer.MAX_VALUE;
		}

		if(lazy[pos]!=0){
			segmentTree[pos]+=lazy[pos];
			if(low!=high){
				lazy[2*pos+1]+=lazy[pos];
				lazy[2*pos+2]+=lazy[pos];
			}
			lazy[pos]=0;
		}
		//no overlap
		if(qlow>high || qhigh<low){
			return Integer.MAX_VALUE;
		}

		if(qlow<=low && qhigh >=high){
			return segmentTree[pos];
		}

		int mid=(high+low)/2;
		return Math.min(rangMinimumQueryLazy(segmentTree,lazy,qlow,qhigh,low,mid,2*pos+1),rangMinimumQueryLazy(segmentTree,lazy,qlow,qhigh,mid+1,high,2*pos+2));


	}



	public static void main(String args[]){

		int input[]={-1,2,4,1,7,1,3,2};
		Segmenttree t=new Segmenttree();
		NextPoweroftwo two=new NextPoweroftwo();
		two.nextPowerof2(23);

		int seg[]=t.createSegmentTree(input);

		int result=t.rangMinimumQuery(seg,1,3,input.length);
		System.out.println("Minimum between 1 and 3 is "+result);

		 int input1[] = {-1,2,4,1,7,1,3,2};
        int segTree1[] = t.createSegmentTree(input1);
        int lazy1[] =  new int[segTree1.length];
        t.updateSegmentTreeRangeLazy(input1, segTree1, lazy1, 0, 3, 1);
        t.updateSegmentTreeRangeLazy(input1, segTree1, lazy1, 0, 0, 2);
       System.out.println("1== "+t.rangMinimumQueryLazy(segTree1, lazy1, 3, 5, input1.length));;


	}
}