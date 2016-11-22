import java.io.*;
import java.util.*;
class Topo{
	public static void main(String args[])throws IOException{
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(reader);
		int t=Integer.parseInt(in.readLine());
		while(t>0){
					




			t--;
		}
	}

}


JSONArray array=new JSONArray();
String key=args.getString(5);

array.put(Crypto.encrypt(key, args.getString(0)));
array.put(Crypto.encrypt(key, args.getString(1)));
array.put(Crypto.encrypt(key, args.getString(2)));
array.put(Crypto.encrypt(key, args.getString(3)));
array.put(Crypto.encrypt(key, args.getString(4)));
array.put(Crypto.encrypt(key, args.getString(6)));

intent.putExtra(Intent.EXTRA_TEXT, String.valueOf(array));
                    // Set the type of data i.e 'text/plain'
                    intent.setType("text/plain");
