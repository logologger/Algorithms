

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
class UniqueTriangle {
    public static void main(String args[] ) throws Exception {
      InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int t=Integer.parseInt(in.readLine());
		HashMap<String,Integer> hm=new HashMap<>();

		while(t-->0){
			String s=in.readLine();
			String str[]=s.split("\\s");
			String sum="";
			for(String w:str){
				sum=sum+w;
			}
			
			char ch[]=sum.toCharArray();
			Arrays.sort(ch);
			
			String strp=new String(ch);
			hm.put(strp,hm.get(strp)!=null ? hm.get(strp)+1:1);


		}
		//System.out.println(hm.toString());
		int count=0;
		for(Map.Entry<String, Integer> entry : hm.entrySet()){

			if(entry.getValue()==1){
				count++;
			}

		}
		System.out.println(count);
		

		}
    }

