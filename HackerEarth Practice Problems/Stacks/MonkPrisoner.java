
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
 
class MonkPrisoner {
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(reader);
        // // char ch=s.scan();
         //int n=s.scanInt();
         //   int q=s.scanInt();
        int n=s.scanInt();
       // int n=Integer.parseInt(br.readLine());
       // StringTokenizer st=new StringTokenizer(br.readLine());
        long a[]=new long[n];
        long x[]=new long[n];
        
        long y[]=new long[n];
        Arrays.fill(y,-1);
        
        //String s2=br.readLine();
       // System.out.println(s2);
         // for(int i=0;i<n;i++){
         //     a[i]=s.scanLong(); 

         // }
        //StringTokenizer st=new StringTokenizer(s2);
        Reader in = new Reader();

        //System.out.println(n);
         for(int i=0;i<n;i++){
          a[i]=s.scanLong(); 
           // a[i]=in.nextLong();
    }

    Arrays.fill(x,-1);
    Stack<Integer> stack=new Stack<>();
    for(int i=0;i<n;i++){

        if(i==0)
            stack.add(i);
        else{

            while(!stack.isEmpty() && a[i]>a[stack.peek()]){
                x[stack.peek()]=i+1;
                stack.pop();

            }

            stack.add(i);



        }
    }
    for(int i=n-1;i>=0;i--){

        if(i==n-1)
            stack.add(i);
        else{

            while(!stack.isEmpty() && a[i]>a[stack.peek()]){
                y[stack.peek()]=i+1;
                stack.pop();

            }

            stack.add(i);



        }
    }
    
        //    // a[i]=Long.parseLong(st.nextToken());
        //    // System.out.println(i+"  "+a[i]);
        //     int ind=0;
        //     if(i>0){
        //         for(int j=i-1;j>=0;j--){
        //             if(a[j]>a[i]){
        //                 x[i]=j+1;
        //                 ind=1;
        //                 break;
        //             }
        //         }
        //         if(ind==0){
        //             x[i]=-1;
        //         }
        //     }

        //     if( i!=0){

        //         //run a loop from 0 to i-1 and check for every element
        //         for(int j=0;j<i;j++){

        //             if(a[j]<a[i] && y[j]==-1){
        //                 y[j]=i+1;
        //             }


        //         }
        //        // System.out.println(Arrays.toString(y));

        //     }
        //     //check for i=0;

        // }


        //System.out.println(Arrays.toString(y));
        //System.out.println(Arrays.toString(x));
        long result[]=new long[n];
        for(int i=0;i<n;i++){
            result[i]=(x[i]+y[i]);
        }
       String resultarr= Arrays.toString(result)
        .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "")  //remove the left bracket
    .trim();

    System.out.println(resultarr);
        // System.out.println(Arrays.toString(y));
        // long y[]=new long[n];
        // y[n-1]=-1;
        // for(int i=0;i<n-1;i++){
        //     long p=a[i];
        //     int ind=0;
        //     for(int j=i+1;j<n;j++){
        //         if(p<a[j]){
        //             ind=1;
        //             y[i]=j+1;
        //             break;

        //         }
        //     }
        //     if(ind==0){
        //         y[i]=-1;
        //     }
        //     System.out.print(x[i]+y[i]+" ");

        // }
        // System.out.print(x[n-1]+y[n-1]+" ");
       
        // for(int i=n-1;i>=1;i--){
        //     long p=a[i];
        //     int ind=0;
        //     for(int j=i-1;j>=0;j--){
        //         if(p<a[j]){
        //             ind=1;
        //             x[i]=j+1;
        //             break;

        //         }
        //     }
        //     if(ind==0){
        //         x[i]=-1;
        //     }

        // }
        
        //System.out.println(Arrays.toString(x));

        }
        static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
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