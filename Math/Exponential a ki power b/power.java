import java.io.*;
import java.util.*;
class power{

	/*
(a+b)%c = (a%c+b%c )%c
(ab)%c = ((a%c)(b%c))%c
(a - b)%c = ((a%c)-(b%c) +c) %c
(a / b)%c = ((a%c)*(b^-1 %c))%c


Here is the algo for Binary Exponential Algorithm

int modularExponentiation(int x,int n,int M)
{
    if(n==0)
        return 1;
    else if(n%2 == 0)        //n is even
        return modularExponentiation((x*x)%M,n/2,M);
    else                             //n is odd
        return (x*modularExponentiation((x*x)%M,(n-1)/2,M))%M;

}

Time Complexity is O(log(n))

	*/

	static int mod=1000000007;
	public static void main(String args[]){

		//call power function from here


	}
	public static long pow(long n,long p){

		if(p==0){
			return 1;
		}
		if(p==1){
				return n%mod;
		}
		if(p%2==0){
			long temp=pow(n,p/2);
			return (temp*temp)%mod;
		}
		else{
			long temp=pow(n,p/2);
			temp=(temp*temp)%mod;
			return (temp*n)%mod;
		}

	}
}