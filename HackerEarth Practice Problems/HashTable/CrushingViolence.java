
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;


class PersonProps{

    public boolean visited;
    public int beatingfromWhere;
    public int numberofBeatings;
    public PersonProps(){
        visited=false;
        numberofBeatings=0;
        beatingfromWhere=-1;
    }
    @Override
    public String toString(){

        return "*** "+visited+" bf:"+beatingfromWhere+" no."+numberofBeatings+" ***\n";

    }

}
class CrushingViolence {
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
        int n=s.scanInt();
        for(int i=0;i<n;i++){
            int q=s.scanInt();
            int a[]=new int[q+1];
            int b[]=new int[q+1];
            for(int j=1;j<=q;j++){
                a[j]=s.scanInt();

            }
            for(int j=1;j<=q;j++){
                b[j]=s.scanInt();

            }
            //put them in HashMap
            Hashtable<Integer,PersonProps> hs1=new Hashtable<>();//First will be the index
             Hashtable<Integer,PersonProps> hs2=new Hashtable<>();
             for(int j=1;j<=q;j++){

                //System.out.println(j+"   "+b[j]);
                PersonProps boy=new PersonProps();
                 PersonProps girl=new PersonProps();
                 boy.beatingfromWhere=a[b[j]];

                
                 if(boy.beatingfromWhere!=j){
                    PersonProps p=hs1.get(j);
                   
                     PersonProps boy2=new PersonProps();

                     boy2.numberofBeatings=hs1.get(a[b[j]])!=null?hs1.get(a[b[j]]).numberofBeatings+1:1;
                     boy2.beatingfromWhere=hs1.get(a[b[j]])!=null?hs1.get(a[b[j]]).beatingfromWhere:-1;
                    hs1.put(a[b[j]],boy2);
                }
                else{
                    boy.numberofBeatings=hs1.get(a[b[j]])!=null?hs1.get(a[b[j]]).numberofBeatings:0;
                }
                
                //System.out.println(boy);

               hs1.put(j,boy);

               girl.beatingfromWhere=b[a[j]];

              // System.out.println("tg:"+j+"  "+b[a[j]]);
                 if(girl.beatingfromWhere!=j){
                    PersonProps p=hs2.get(j);
                   
                     PersonProps girl2=new PersonProps();

                     girl2.numberofBeatings=hs2.get(b[a[j]])!=null?hs2.get(b[a[j]]).numberofBeatings+1:1;
                     girl2.beatingfromWhere=hs2.get(b[a[j]])!=null?hs2.get(b[a[j]]).beatingfromWhere:-1;
                     //System.out.println(girl2);
                   //  System.out.println("grl "+girl2);
                    hs2.put(b[a[j]],girl2);
                }
                else{
                    girl.numberofBeatings=hs2.get(b[a[j]])!=null?hs2.get(b[a[j]]).numberofBeatings:0;
                }

               hs2.put(j,girl);
             //  hs2.put(j,b[a[j]]);

            }
            //Again iterate to find the pairs if any
            //Find the one having maximum number from other
             // System.out.println(hs1);
             // System.out.println(hs2);
            int numberofpairs=0;
            int maxbeatings=0;
            for(int j=1;j<=q;j++){

                if(hs1.get(j).numberofBeatings>maxbeatings){
                    maxbeatings=hs1.get(j).numberofBeatings;
                }

                if(hs2.get(j).numberofBeatings>maxbeatings){
                    maxbeatings=hs2.get(j).numberofBeatings;
                }

                if(hs1.get(j).visited==false){
                    int boy1=hs1.get(j)!=null?hs1.get(j).beatingfromWhere:0;
                    int boy2=hs1.get(boy1)!=null?hs1.get(boy1).beatingfromWhere:0;
                   // System.out.println(boy1 +" "+boy2+"  "+j);
                    if(j==boy2 && boy1!=boy2 && j!=boy1){//j==boy2 means both form pair
                        numberofpairs++;
                        hs1.get(j).visited=true;
                        hs1.get(boy1).visited=true;

                    }
            }
            if(hs2.get(j).visited==false){

                    int boy1=hs2.get(j)!=null?hs2.get(j).beatingfromWhere:0;
                    int boy2=hs2.get(boy1)!=null?hs2.get(boy1).beatingfromWhere:0;
                    if(j==boy2 && boy1!=boy2 && j!=boy1){//j==boy2 means both form pair
                        numberofpairs++;
                        hs2.get(j).visited=true;
                        hs2.get(boy1).visited=true;

                    }
            }
            }
            System.out.println(maxbeatings+" "+numberofpairs);
            
         
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