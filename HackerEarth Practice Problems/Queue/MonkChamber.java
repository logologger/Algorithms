
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;


class MonkElement{
    int index;
    int value;
    MonkElement(){
        index=0;
        value=0;
    }
    @Override
    public String toString() {
        return String.format(" "+value);
    }
}
 
class MonkChamber {
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
        int n=s.scanInt();
        int x=s.scanInt();

        Deque<MonkElement> deque = new ArrayDeque<MonkElement>();
        Deque<MonkElement> temp_deque = new ArrayDeque<MonkElement>();
         
        for(int i=0;i<n;i++){

            MonkElement me=new MonkElement();

            me.index=i+1;
            me.value=s.scanInt();
           
            
            deque.add(me);//kya chutiyapa hae yeh

        }
        ArrayList<Integer> result=new ArrayList<>();
        
        while(deque.size()!=0){
            int max=-1;
            int max_index=0;
            int ind=0;

            for(int i=0;i<x && deque.size()!=0;i++){

                MonkElement me=new MonkElement();
                me=deque.removeFirst();
                temp_deque.add(me);

                if(me.value>max){
                    // if(me.value==max){
                    //     ind=1;
                    // }
                    max=me.value;
                    max_index=me.index;
                }
               
                
            }
            result.add(max_index);
            for(int i=1;i<=x && temp_deque.size()!=0;i++){
                if(temp_deque.peek().index!=max_index){
                    MonkElement me=new MonkElement();
                    me.index=temp_deque.peek().index;

                    me.value=temp_deque.peek().value-1>0?temp_deque.peek().value-1:0;
                    deque.add(me);
                }

                     temp_deque.removeFirst();
            // }
            // else{
            //     temp_deque.removeFirst();
            // }

            }
            

           // System.out.println(deque);
            //int a=s.scanInt();
            //System.out.println(result);
            //Add all -1 keeping 



        }

        for(int i=0;i<x;i++)

            System.out.print(result.get(i)+" ");

         
         
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