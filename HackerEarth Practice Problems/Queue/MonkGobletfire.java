import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
 
 
class Schoolplusroll{
    int rollno;
    int school;
    
    @Override
    public String toString() {
        return String.format(school+" "+rollno);
    }
    
}
 
class MonkGobletfire {
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
        int n=s.scanInt();
        ArrayDeque<Schoolplusroll> schoolroll=new ArrayDeque<Schoolplusroll>();
        Deque<Schoolplusroll> schoolroll_copy=new ArrayDeque<Schoolplusroll>();
        
        for(int i=0;i<n;i++){
            
            String input=s.scanString();
            char ch=input.charAt(0);
            
            if(ch=='E'){

                int ind=0;
                //Take two more inputs
                Schoolplusroll sc=new Schoolplusroll();
                sc.school=s.scanInt();// School will range from 1 to 4 here only
                //Search from the Queue Last and search for that School 
                sc.rollno=s.scanInt();

                if(schoolroll.size()==0){

                    schoolroll.add(sc);
                    ind=1;
                }
                else{

                while(schoolroll.size()!=0){
                
                if(schoolroll.peekLast().school==sc.school){

                    schoolroll.add(sc);
                    ind=1;
                    break;

                	


                }

                else{



                	schoolroll_copy.add(schoolroll.removeLast());
                    //System.out.println(schoolroll_copy);
                }
            }
        }

        //System.out.println("School copy "+schoolroll_copy);

            while(schoolroll_copy.size()!=0){

                schoolroll.add(schoolroll_copy.removeLast());


            }
            if(ind==0){
                schoolroll.add(sc);
            }


               // System.out.println(schoolroll);


            }
            else{
                //Means it is 'D'
                //Remove it from the Queue

                System.out.println(schoolroll.poll());
                
                
                
                
            }
            
        }
 
        
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