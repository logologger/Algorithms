    import java.io.DataInputStream;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.LinkedHashMap;
    import java.util.Map.Entry;
    import java.util.TreeMap;
    import java.util.*;
    import java.io.*;

    class ICPCTeam {
     
        public static void main(String[] args) throws IOException {
        
 
            InputStreamReader reader=new InputStreamReader(System.in);
            BufferedReader in=new BufferedReader(reader);
            int t=Integer.parseInt(in.readLine());
       for(int j=0;j<t;j++){
        StringTokenizer st=new StringTokenizer(in.readLine());
       int n=Integer.parseInt(st.nextToken());
       int k=Integer.parseInt(st.nextToken());
      
       int actual_divide=n/k;
       Hashtable<Integer,Integer> hs=new Hashtable<>();
       for(int i=0;i<n;i++){

        String str=in.readLine();
        int len=str.length();
      
       if(hs.get(len)!=null){
        
        hs.put(len,hs.get(len)+1);
    }
        else{
           
            hs.put(len,1);
        }
     
       }
       int ind=0;
      // System.out.println(hs);
        for(Map.Entry m : hs.entrySet()){
       if((int)m.getValue()%k!=0){
            ind=1;
            System.out.println("Not possible");
            break;
          
        }
    }
       
       if(ind==0){
        System.out.println("Possible");
       }
       
   }

            
                
     
            
                }
                            
           
        }
     
     