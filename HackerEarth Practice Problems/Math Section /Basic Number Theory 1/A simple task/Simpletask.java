
import java.io.*;
import java.util.*;
class Simpletask {
    public static void main(String args[] ) throws Exception {
      InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int t=Integer.parseInt(in.readLine());
		long a[]=new long[t];
		long smallest=1000000000;
		long largest=0;
		for(int i=0;i<t;i++){
		
			a[i]=Long.parseLong(in.readLine());
			if(a[i]<smallest){
				smallest=a[i];
			}
			if(a[i]>largest){
				largest=a[i];
			}
		
		}
		int result=0;
		StringBuilder sb=new StringBuilder();
		for(int i=2;i<=smallest*10;i++){
			//Iteate throught the array a
			int ind=0;
			long ele_match=a[0]%i;
			//System.out.println(ele_match);
			for(int j=1;j<a.length;j++){
				if(a[j]%i!=ele_match){
					ind=1;
					break;
				}
			}
			if(ind==0){

				sb.append(i+" ");

			}
		}
		System.out.println(sb.toString());





		}
    }

