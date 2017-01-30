import java.io.*;
import java.util.*;
/*


Coin Chaning Bottom Up DP
https://www.youtube.com/watch?v=NJuKJ8sasGk&t=57s



*/
class CoinChanging{

	//Need to revise thi again

	public int minimumCoinTopDown(int total,int coins[],Map<Integer,Integer> map){

		if(total==0){//Means total is reached now----See down recursive call
			return 0;
		}
		if(map.containsKey(total)){
			return map.get(total);
		}

		int min=Integer.MAX_VALUE;
		//Iterate through all the coins and see whether it can make total
		for(int i=0;i<coins.length;i++){
			if(coins[i]>total){
				continue;
			}

			int val=minimumCoinTopDown(total-coins[i],coins,map);

			if(val<min){
				min=val;
			}
		}

		min=(min==Integer.MAX_VALUE)?min:min+1;

		//Memorize the min for current total
		map.put(total,min);
		return min;
	}



	public int minimumCoinBottomUp(int total,int coins[]){

		int T[]=new int[total+1];
		int R[]=new int[total+1];
		T[0]=0;
		for(int i=1;i<=total;i++){

			 /**
     * Bottom up way of solving this problem.
     * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
     * can be very low negative number
     * Returns Integer.MAX_VALUE - 1 if solution is not possible.
     */
			T[i]=Integer.MAX_VALUE-1;//will tell min coins needed
			R[i]=-1;//Will contain the path
		}
		for(int j=0;j<coins.length;j++){
			//First Looks for all the combination with ith coin 
			//Then see for i and i+1th coin that is coins[i] and coins[i+1] and keep repeating it
			for(int i=1;i<=total;i++){

				if(i>=coins[j]){

					if((T[i-coins[j]]+1) < T[i]){

						T[i]=1+T[i-coins[j]];//new total number of coins needed
						R[i]=j;//because it came from jth coin
					}
				}

			}
		}
		

		printCombination(R,coins);
		return T[total];

	}

	public void printCombination(int R[],int coins[]){

		if(R[R.length-1]==-1){
			System.out.println("No solution Exist !");
			return;
		}
		int start=R.length-1;
		System.out.println("Coins used for making total are");
		while(start!=0){
			int j=R[start];
			System.out.println(coins[j]+" ");
			start=start-coins[j];
		}
		System.out.println("\n");
	}





	public static void main(String args[]){
		int total=13;
		int coins[]={7,3,2,6};
		CoinChanging cc=new CoinChanging();

		Map<Integer,Integer> map=new HashMap<>();
		int topDownValue=cc.minimumCoinTopDown(total,coins,map);
		int bottomUpValue=cc.minimumCoinBottomUp(total,coins);


		System.out.println(String.format("Bottom Up and Top Down is %s %s",bottomUpValue,topDownValue));
	}
}