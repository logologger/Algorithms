import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
 
class Balance {
    
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
       
        
            int n=s.scanInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.scanInt();
 
            }
            Stack<Integer> stack=new Stack<>();
            int temp=0;
            int result=0;
            int ind=0;
            int result1=0;
            stack.add(-1);
            
            for(int i=0;i<n;i++){ 
               
 
                       if(a[i]<0){

                        int p=stack.peek();
                        stack.pop();
                        if(p>=0 && a[p]==-a[i]){
                           
                            if(stack.isEmpty()){
                                stack.add(i);
                            }
                            else{
                                 result=Math.max(result,i-stack.peek());
                            }


                        }
                        else{
                            stack.add(i);
                        }
                           
                            
                    
                    }
                    else{
                       
                       
                        stack.add(i);
                        
                    }
 
                
            }
           
             System.out.println(result);
            
            
            
       
         
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