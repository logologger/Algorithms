
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
class StandardDev {
    public static void main(String args[] ) throws Exception {
      InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int a[]=new int[7];
		double sum=0;
		for(int i=0;i<7;i++){

			String s=in.readLine();
			for(int j=0;j<s.length();j++){
				char ch=s.charAt(j);
				if(ch=='1'){
					a[i]++;
				}
			}
			sum+=a[i];


		}
		
		//System.out.println(a[1]);

		//Now calculate the standard Deviation here
		double mean=sum/7;
		//System.out.println(mean);
		double result_sum=0;
		for(int k=0;k<7;k++){
			double diff=(a[k]-mean)*(a[k]-mean);
			result_sum+=diff;

		}
		// DecimalFormat df = new DecimalFormat("#.#####");
		// System.out.println(df.format(Math.sqrt(result_sum/6)));
		System.out.print(String.format("%.4f", Math.sqrt(result_sum/7)));
		

		
    }
}
