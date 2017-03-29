
import java.util.*;
import java.io.*;
 
class DifficultCharacters {
    public static void main(String args[] ) throws Exception {
       
 
        //Scanner
        Print print = new Print();
        Scan s = new Scan();
        
        //Iterate through the hashTable and give counts for all the characters
        int n=s.scanInt();
        while(n-->0){
        String str=s.scanString();

        Hashtable<Character,Integer> hs=new Hashtable<>();
        for(int i='a';i<='z';i++){

            Character ch=new Character((char)i);
            hs.put(ch,1);
        }
        for(int i=0;i<str.length();i++){
            Character ch=new Character(str.charAt(i));
            hs.put(ch,hs.get(ch)+1);
        }
       //One can use ValueComparator for sorting elements here

        Map<Integer,ArrayList<Character>> hsa=new TreeMap<>();
        for(Map.Entry m : hs.entrySet()){

           
            if(hsa.get((int)m.getValue())==null)
            {

                ArrayList<Character> al=new ArrayList<>();
               
                al.add(Character.valueOf((char)m.getKey()));
                hsa.put((int)m.getValue(),al);

            }
            else{

                  ArrayList<Character> al=hsa.get((int)m.getValue());
                 
                  al.add(Character.valueOf((char)m.getKey()));
                  hsa.put((int)m.getValue(),al);


            }
            

        }

         Map<Integer,ArrayList<Character>> lhsa=new LinkedHashMap<>();

         lhsa.putAll(hsa);

         

        
        for(Map.Entry m : lhsa.entrySet()){
            
            Stack<Character> stack=new Stack<>();
           

            ArrayList<Character> al_3=(ArrayList)m.getValue();
          
            Collections.sort(al_3);

          
            for(Character ch:al_3){

                stack.add(ch);

            }


        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

        }
        
       //Iterate through the array List and get them in stack and print it
        System.out.println();

        //System.out.println(hsa);
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