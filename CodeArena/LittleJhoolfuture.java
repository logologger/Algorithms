

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
class LittleJhoolfuture {
    public static void main(String args[] ) throws Exception {
      InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		String s=in.readLine();
		int ind=0;
		for(int i=0;i<s.length()-5;i++){
			//System.out.println(s.substring(i,i+6));
			
				if(s.substring(i,i+6).equals("000000") || s.substring(i,i+6).equals("111111")){
					ind=1;
					System.out.println("Sorry, sorry!");
					break;
				}

			}
		
		if(ind==0){
			System.out.println("Good luck!");
		}

		}
    }

