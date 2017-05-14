import java.io.*;
import java.util.*;
class Raisedxton{
	public static void main(String args[])throws IOException{

		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int x=Integer.parseInt(in.readLine());
		int y=Integer.parseInt(in.readLine());
		int ans=powerinlogntime(x,y);
		System.out.println(ans);

		
	}

	public static int powerinntime(int x,int y){
		if(y==0){
			return 1;
		}
		else if(y%2==0){
			return powerinntime(x,y/2)*powerinntime(x,y/2);


		}
		else{
			return x*powerinntime(x,y/2)*powerinntime(x,y/2);
		}
	}

	public static  int powerinlogntime(int x,int y){
		int temp;
		if(y==0){
			return 1;
		}
		temp=powerinlogntime(x,y/2);

		if(y%2==0){
			return temp*temp;
		}
		else{
		    //For handling Negative y scenarios
            if(y>0)
			    return x*temp*temp;
            else
                return (temp*temp)/x;
		}
	}
}