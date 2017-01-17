import java.io.*;
import java.util.*;
class NiceArches{
	public static void main(String args[])throws IOException{

		
		Scan scan=new Scan();
		Print print=new Print();
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		//
		int t=scan.scanInt();
		int result=0;
		
		while(t-->0){
			String s=scan.scanString();
			//Apply logic here
			Stack<Character> stack=new Stack<>();
			if((s.length()%2)!=0){
				//nothing to do 
				//odd length is not allowed according to the question
			}
			else{
				//length is even then it's eligible here
				//the number of A should be equal to number of B's
				for(int i=0;i<s.length();i++){
					char ch=s.charAt(i);
					Character c=new Character(ch);
					if(!stack.isEmpty()){

						if(stack.peek().compareTo(c)==0){
							stack.pop();
						}
						else{
							stack.add(c);
						}


					}
					else{
						stack.add(c);
					}



				}
				if(stack.isEmpty()){
					result++;
				}

			}//end of else

			

		}
		System.out.println(result);
		
		
}//End of main function 
}//End of Class
class Scan
{
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	public Scan()
	{
		in=System.in;
	}
	public int scan()throws IOException
	{
		if(total<0)
		throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
			return -1;
		}
		return buf[index++];
	}
	public int scanInt()throws IOException
	{
		int integer=0;
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n))
		{
			if(n>='0'&&n<='9')
			{
				integer*=10;
				integer+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		return neg*integer;
	}
	public double scanDouble()throws IOException
	{
		double doub=0;
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n)&&n!='.')
		{
			if(n>='0'&&n<='9')
			{
				doub*=10;
				doub+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		if(n=='.')
		{
			n=scan();
			double temp=1;
			while(!isWhiteSpace(n))
			{
				if(n>='0'&&n<='9')
				{
					temp/=10;
					doub+=(n-'0')*temp;
					n=scan();
				}
				else throw new InputMismatchException();
			}
		}
		return doub*neg;
	}
	public String scanString()throws IOException
	{
		StringBuilder sb=new StringBuilder();
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		while(!isWhiteSpace(n))
		{
			sb.append((char)n);
			n=scan();
		}
		return sb.toString();
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
		return true;
		return false;
	}
}
 
class Print
{
	private final OutputStream out;
	/*public Print(OutputStream outputStream)
	{
		writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}*/
	public Print()
	{
		this.out=System.out;
	}
	public void print(String str)throws IOException
	{
		//buf=str.getBytes();
		for (int i = 0; i < str.length(); i++)
		{
			/*if (i != 0)
			out.write(' ');*/
			out.write(str.charAt(i));
		}
	}
	public void printLine(String str)throws IOException
	{
		print(str);
		out.write('\n');
	}
	public void close()throws IOException
	{
		out.close();
	}
} 

