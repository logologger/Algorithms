import java.io.*;
import java.util.*;
class RodCutting{
	public static void main(String args[]){
		RodCutting rc=new RodCutting();
		 int[] price = {3,5,8,9,10,20,22,25};
        long t1 = System.currentTimeMillis();
        int r = rc.recursiveMaxValue(price,8);
        long t2 = System.currentTimeMillis();
        System.out.println(r);
		System.out.println(t2 - t1);

		long t3 = System.currentTimeMillis();
        int r2 = rc.maxValue(price);
        long t4 = System.currentTimeMillis();
        System.out.println(r2);
		System.out.println(t4 - t3);

	}
	public int recursiveMaxValue(int price[],int len){
		if(len<=0){
			return 0;
		}
		int maxValue=0;
		for(int i=0;i<len;i++){
			int val=price[i]+recursiveMaxValue(price,len-i-1);
			if(maxValue<val){
				maxValue=val;
			}
		}
		return maxValue;

	}
	public int maxValue(int price[]){
		int max[]=new int[price.length+1];
		for(int i=1;i<=price.length;i++){
			max[i]=price[i-1];
		}
		for(int i=1;i<=price.length;i++){
			for(int j=1;j<i;j++){
				max[i]=Math.max(max[i],max[i-j]+max[j]);
			}
		}
		return max[price.length];
	}
}