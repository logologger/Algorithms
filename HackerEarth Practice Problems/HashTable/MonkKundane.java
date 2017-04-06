    import java.io.DataInputStream;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.LinkedHashMap;
    import java.util.Map.Entry;
    import java.util.TreeMap;
    import java.util.*;
    import java.io.*;

    class MonkKundane {
     
        public static void main(String[] args) throws IOException {
        
 
            InputStreamReader reader=new InputStreamReader(System.in);
            BufferedReader in=new BufferedReader(reader);

            Hashtable<Character,Integer> hs=new Hashtable<>();
            hs=getHash();
           // System.out.println(hs);cd 

            int t=Integer.parseInt(in.readLine());

       for(int j=0;j<t;j++){
         int sum=0;
        StringTokenizer st=new StringTokenizer(in.readLine());
        int len=0;
        while(st.hasMoreTokens()){
          String str=st.nextToken();
          
          for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            sum+=(hs.get(ch)+i);
          }
          len++;

        }
        System.out.println(len*sum);
                }
                            
           
        }
        public static Hashtable<Character,Integer> getHash(){
          String str="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          Hashtable<Character,Integer> hs=new Hashtable<>();
          for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            hs.put(ch,i);

          }

          return hs;

        }
      }
     
     