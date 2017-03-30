import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
 
class BobString {
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
        int n=s.scanInt();

        for(int i=0;i<n;i++){
             String str=s.scanString();
             String str1=s.scanString();
             Hashtable<Character,Integer> hs=getHashTable(str);
             Hashtable<Character,Integer> hs1=getHashTable(str1);
             
             int sum=0;
             for(int t=0;t<127;t++){
                Character ch=new Character((char)t);
                int first_value=hs.get(ch)!=null ? hs.get(ch):0;
                int second_value=hs1.get(ch)!=null ? hs1.get(ch):0;
                sum+=Math.abs(first_value-second_value);
             }
             System.out.println(sum);
             

        }


        
         
         
    }
    public static Hashtable<Character,Integer> getHashTable(String str){
        Hashtable<Character,Integer> hs=new Hashtable<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            Character character=new Character(ch);
            hs.put(character,hs.get(character)!=null ? hs.get(character)+1:1);
        }
        return hs;
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