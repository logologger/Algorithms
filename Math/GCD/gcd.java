import java.io.*;
import java.util.*;
class gcd{
	public static void main(String args[]){

		//call gcd function from here
		/*

			int GCD(int A, int B) {
    if(B==0)
        return A;
    else
        return GCD(B, A % B);
}

time Complexity is O(log(Max(A,B)))


when A and M are coprime i.e. GCD(A,M)=1.

		*/


	}
	public static long gcd(long x,long y){

		if(x==0){
			return y;
		}
		else
			return gcd(y%x,x);

	}
}