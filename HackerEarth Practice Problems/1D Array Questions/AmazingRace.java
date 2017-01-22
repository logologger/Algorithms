import java.io.*;
import java.util.*;
class AmazingRace{
	public static void main(String args[])throws IOException{

		
		Scan scan=new Scan();
		Print print=new Print();
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		//
		int T=scan.scanInt();
		while(T-->0){

			int N=scan.scanInt();
			int a[]=new int[N];
			for(int i=0;i<N;i++){
				a[i]=scan.scanInt();
			}
			int max_sight=0;
			int result_index=0;
			for(int i=0;i<N;i++){


				//Take a[0]
				//First see behind elements
				//then see after elements
				//Add them both to get X (number of drivers he can see)
				//P is the position of the driver which will be i+1
				//compare the product with the next one instead of later sorting them and displaying result
				
				//befor elements
				int before=0;
				for(int j=i-1;j>=0;j--){
						//System.out.println(a[i]+"   "+a[j]);
						if(a[i]>a[j]){
							before++;
							//System.out.println(a[i]+"   "+a[j]);
							//System.out.println(before+" what  "+i+" j="+j);
						}
						else{
							before++;
							break;
						}

				}
				
				
				//after elements
				for(int j=i+1;j<N;j++){

					if(a[i]>a[j]){
							before++;
						}

						else{
							before++;
							break;
						}


				}
				//System.out.println("Case "+i+": "+before);
				int index=i;
				int max=before==0?1:before;
				int sight=((index+1)*max)%1000000007;
				//System.out.println(index+":"+sight+"  "+sight);
				if(sight>max_sight){
					max_sight=sight;
					result_index=index+1;
				}
			}
			System.out.println(result_index);


		}
		
		
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

