
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
 
class MonkOperation {
    public static void main(String args[] ) throws Exception {
       
 
       
        Print print = new Print();
        Scan s = new Scan();
        int n=s.scanInt();
        int m=s.scanInt();
        long arr[][]=new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                arr[i][j]=s.scanInt();

            }
        }
        int v1=s.scanInt();
        int v2=s.scanInt();
        int v3=s.scanInt();
        int v4=s.scanInt();
        /*

            Check all the rows first 
            In each Row check for which operation absolute value is high 

            Similarly check for column
            In each column check for which operation absolute is high

        */
            long row_sum=0;
            long column_sum=0;
            for(int i=0;i<n;i++){

                //get sum 
                
                long sum_v=sum_add(arr[i],v1);
                long update_v=sum_update(arr[i],v2);//v2 for update
                long sum_arr_row=sum_arr(arr[i]);//row sum
              //  System.out.println(sum_v+"  "+update_v+" "+sum_arr_row);
                
                if(sum_v>update_v){
                    if(sum_arr_row<sum_v)
                        row_sum+=sum_v;
                    else
                        row_sum+=sum_arr_row;

                }
                else{
                    if(sum_arr_row<update_v)
                        row_sum+=update_v;
                    else
                        row_sum+=sum_arr_row;
                }
           
                
        }
        //System.out.println("row sum is "+row_sum);

        long sum_u=0;
        long update_u=0;


        for(int i=0;i<m;i++){

            long temp_arr[]=new long[n];
            for(int j=0;j<n;j++){

               temp_arr[j]=arr[j][i];
            }
            //get sum and update one
              sum_u=sum_add(temp_arr,v3);
              update_u=sum_update(temp_arr,v4);//v2 for update
              long sum_arr_2=sum_arr(temp_arr);
              //System.out.println(sum_u+"  "+update_u+" "+sum_arr_2);
             // if(sum_arr_2<sum_u && sum_arr_2<update_u){
              if(sum_u>update_u){
                if(sum_arr_2<sum_u)
                        column_sum+=sum_u;
                    else
                        column_sum+=sum_arr_2;
              }
              else{
                if(sum_arr_2<update_u)
                        column_sum+=update_u;
                    else
                        column_sum+=sum_arr_2;
              }
          

        }
       // System.out.println("column sum is "+column_sum);

        if(column_sum>row_sum)
            System.out.println(column_sum);
        else
            System.out.println(row_sum);



        
            

        print.close();
    }
    public static long sum_add(long arr[],int v){

        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=Math.abs(((arr[i])+v));
        }
        return sum;

    }
    public static long sum_update(long arr[],int v){

        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=(v);
        }
        return sum;


    }
    public static long sum_arr(long arr[]){

        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=Math.abs(arr[i]);
        }
        return sum;


    }
}
 
class Scan {
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Scan() {
        in=System.in;
    }
 
    public int scan()throws IOException {
        if(total<0) {
            throw new InputMismatchException();
        }
        if(index>=total) {
            index=0;
            total=in.read(buf);
            if(total<=0) {
                return -1;
            }
        }
        return buf[index++];
    }
 
    public int scanInt()throws IOException {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n)) {
            n=scan();
        }
        int neg=1;
        if(n=='-') {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n)) {
            if(n>='0'&&n<='9') {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
 
    public long scanLong()throws IOException {
        long integer=0;
        int n=scan();
        while(isWhiteSpace(n)) {
            n=scan();
        }
        int neg=1;
        if(n=='-') {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n)) {
            if(n>='0'&&n<='9') {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
 
    public double scanDouble()throws IOException {
        double doub=0;
        int n=scan();
        while(isWhiteSpace(n))
            n=scan();
        int neg=1;
        if(n=='-') {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n)&&n!='.') {
            if(n>='0'&&n<='9') {
                doub*=10;
                doub+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        if(n=='.') {
            n=scan();
            double temp=1;
            while(!isWhiteSpace(n)) {
                if(n>='0'&&n<='9') {
                    temp/=10;
                    doub+=(n-'0')*temp;
                    n=scan();
                }
                else throw new InputMismatchException();
            }
        }
        return doub*neg;
    }
 
    public String scanString()throws IOException {
        StringBuilder sb=new StringBuilder();
        int n=scan();
        while(isWhiteSpace(n)) {
            n=scan();
        }
        while(!isWhiteSpace(n)) {
            sb.append((char)n);
            n=scan();
        }
        return sb.toString();
    }
 
    public byte[] scanBytes(int N)throws IOException {
        byte[] bytes = new byte[N];
        int diff = total-index;
        int i=index;
        for (;i<total && i-index < N; i++) {
            bytes[i-index] = buf[i];
        }
        index = i;
        if (diff >= N) {
            return bytes;
        }
        in.read(bytes, diff, N-diff);
        return bytes;
    }
 
    public boolean scanBoolean() throws IOException {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n)) {
            n=scan();
        }
        return n == '1';
    }
 
    private boolean isWhiteSpace(int n) {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1) {
            return true;
        }
        return false;
    }
}
 
class Print {
    private final BufferedWriter bw;
    public Print() {
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(String str)throws IOException {
        bw.append(str);
    }
    public void printLine(String str)throws IOException {
        print(str);
        bw.append("\n");
    }
    public void close()throws IOException {
        bw.close();
    }
}