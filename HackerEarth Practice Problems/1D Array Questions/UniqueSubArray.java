
import java.io.*;
import java.util.*;
class UniqueSubArray{
	public static void main(String args[])throws IOException{

		
		Scan scan=new Scan();
		Print print=new Print();
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		//
		int t=scan.scanInt();
		while(t-->0){
			int n=scan.scanInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){

				a[i]=scan.scanInt();
				
			}
			printDistinct(a,n);
			
			}
		}

		static void printDistintNaiveApporoach(int a[],int n){
			Set<Integer> set;
			int p=n;
			int g=n;
			int result=0;
			for(int i=n;i>=0;i--){
				p=0;
				int j=0;
				int h=i;
				while(j!=n){

				set=new HashSet<>();
				for( j=p;j<h;j++){


						//System.out.print(a[j]+" ");
						set.add(a[j]);
				
						

				}
				//System.out.println("h-p"+(h-p));

				if(set.size()==(h-p)){
					result=result+set.size();
				}

				h++;
				p++;
				
				}
				
			}
			System.out.println(result);


		}

		static void printDistinct(int arr[],int n){

			Set<Integer> s=new HashSet<>();
			int j=0,ans=0;
			for(int i=0;i<n;i++){

				System.out.println(s.contains(arr[j])+" "+arr[j]+" "+j);

				while(j<n && s.contains(arr[j])){
					s.add(arr[j]);
					j++;
				}

				ans+=((j-i)*(j-i+1))/2;

				s.remove(arr[i]);
			}
			System.out.println(ans);

		}
		
		
}//End of main function 
//End of Class

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

