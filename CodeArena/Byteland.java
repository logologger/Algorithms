/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/
import java.io.*;
import java.util.*;
class Byteland {
    public static void main(String args[] ) throws Exception {
      InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		long coin=0;
		String check_input;
		while((check_input=(in.readLine()))!=null){
		    coin=Long.parseLong(check_input);
	
		long one=Math.round(coin/4);
		long two=Math.round(coin/3);
		long three=Math.round(coin/2);
		long sum=one+two+three;
		//System.out.println(sum);

		if(sum>coin){
		    System.out.println(sum);
		}
		else{
		    System.out.println(coin);
		}
		}

    }
}
