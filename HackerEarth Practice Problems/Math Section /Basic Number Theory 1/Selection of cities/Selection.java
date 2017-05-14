import java.io.*;
import java.util.*;
class Selection{


    public static void main(String args[])throws IOException{

        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(reader);
        int MOD=(int)Math.pow(10,9)+7;
        int t=Integer.parseInt(in.readLine());
        while(t-->0) {
            int x = 2;
            long y = Long.parseLong(in.readLine());
            long ans = powerinlogntime(x, y, MOD) - 1;
            System.out.println(ans);
        }


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

    public static  long powerinlogntime(int x,long y,int MOD){
        long temp;
        if(y==0){
            return 1;
        }
        temp=powerinlogntime(x,y/2,MOD)%MOD;

        if(y%2==0){
            return (temp%MOD*temp%MOD)%MOD;
        }
        else{
            return (x%MOD*temp%MOD*temp%MOD)%MOD;
        }
    }
}