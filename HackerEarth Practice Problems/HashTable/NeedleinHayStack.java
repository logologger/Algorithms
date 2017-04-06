import java.io.*;
import java.util.*;
class NeedleinHayStack{
  public static void main(String args[])throws IOException{
    InputStreamReader reader=new InputStreamReader(System.in);
    BufferedReader in=new BufferedReader(reader);
    int t=Integer.parseInt(in.readLine());
    for(int i=0;i<t;i++){
      String str1=in.readLine();
      String str2=in.readLine();
      int ind=0;
      Hashtable<Character,Integer> hs1=getHashTable(str1);
      for(int j=0;j<str2.length()-str1.length()+1;j++){
      	//System.out.println(j+" "+str1.length()+" "+str2+" "+str1+" "+str2.substring(1,6));
      	String substr=str2.substring(j,j+str1.length());
      	 Hashtable<Character,Integer> hs2=getHashTable(substr);
      	if(checkEqual(hs1,hs2)==true){
      		ind=1;
      		break;
      	}


      }

      if(ind==0){
      	System.out.println("NO");

      }
      else{
      	System.out.println("YES");

      }
      
    }
  }
  public static boolean checkEqual( Hashtable<Character,Integer> hs1, Hashtable<Character,Integer> hs2){
  	for(Map.Entry m:hs1.entrySet()){
  		if(hs2.get(m.getKey())!=null && m.getValue()==hs2.get(m.getKey())){
  			
  		}
  		else{
  			return false;
  		}

  	}
  	return true;
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
