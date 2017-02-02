
    import java.io.DataInputStream;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.LinkedHashMap;
    import java.util.Map.Entry;
    import java.util.TreeMap;
    import java.util.*;
    /*

    http://stackoverflow.com/questions/40690034/number-of-subsets-of-an-array-size-n-of-size-k-having-difference-between-maxim


		Do subset of GCD also after that

    */
     
    class Numbergame {

    	static int MAX=500001;
    	static long MOD=(long)Math.pow(10,9)+7L;
    	static long factorial[]=new long[MAX];
     
    	public static void main(String[] args) throws IOException {
    		calculateAllFactorial();
    	
    		Reader in = new Reader();
    		//OutputStream out = new BufferedOutputStream ( System.out );
    		PrintWriter out = new PrintWriter(System.out);
    		int N=in.nextInt();
    		int K=in.nextInt();
    		int X=in.nextInt();
    		int A[]=new int[N];
    		for(int i=0;i<N;i++){
    			A[i]=in.nextInt();
    		}
    		Arrays.sort(A);
    		long res=0;
    		for(int i=0;i<N;i++){
    			int e=X+A[i];
    			int ind=right_most_binary_search(A,0,N,N,e);
    			//System.out.println(ind);
    			if(ind-i<K-1){
    				if(ind==N)
    					break;
    				//continue;
    			}
    			System.out.println((ind-i)+"  "+(K-1));
    			res+=combination(ind-i,K-1);
    			//System.out.println(combination(ind-i,K-1));
    			res=res%MOD;
    		}
    		System.out.println(res);



    		






            
    						
    		out.close();
    	}

    	public static int right_most_binary_search(int a[],int l,int r,int n,int e){
    		int m;
    		while((r-l)>1){

    			m=l+(r-l)/2;

    			if(a[m]<=e){
    				l=m;
    			}
    			else{
    				r=m;
    			}

    		}
    		if(l==n || a[l]>e){
    			return l-1;
    		}

    		return l;


    	}

    	public static void calculateAllFactorial(){

    		factorial[0]=1;
    		for(int i=1;i<MAX;i++){

    			factorial[i]=(factorial[i-1]*i)%MOD;
    		}

    	}

    	public static long combination(int n,int r){

    		if(r>n){
    			return 0;
    		} 
    		long numerator=factorial[n];
    		long denominator=(factorial[n-r]*factorial[r])%MOD;
    		//System.out.println(numerator+" "+denominator);
    		denominator=power(denominator,MOD-2);
    		//System.out.println(numerator+" "+denominator);
    		return (numerator*denominator)%MOD;

    	}

    	public static long power(long x,long n){

    		if(n==0)
    			return 1;
    		if(n==1)
    			return x;
    		long t=power(x,n/2);
    		t=(t*t)%MOD;
    		return (t*power(x,n%2))%MOD;

    	}





    	//Calculate subset of element of given size K from Array A --Recursive approach
    	public void subset(int A[],int k,int start,int curLen,boolean used[]){

		if(curLen==k){//Here we got the subset of length k

			for(int i=0;i<A.length;i++){
				if(used[i]==true){
					System.out.print(A[i]+" ");
				}
			}

			System.out.println();
			return;
		}
		if(start==A.length){
			return;
		}

			//Either we will select it here by making used[i] as true
			used[start]=true;
			subset(A,k,start+1,curLen+1,used);
			//Either we dont select it here thus not increasing curLen length
			used[start]=false;
			subset(A,k,start+1,curLen,used);			
		}
     
     
    	static class Reader{
    		final private int BUFFER_SIZE = 1 << 16;
    		private DataInputStream din;
    		private byte[] buffer;
    		private int bufferPointer, bytesRead;
     
    		public Reader(){
    			din = new DataInputStream(System.in);
    			buffer = new byte[BUFFER_SIZE];
    			bufferPointer = bytesRead = 0;
    		}
     
    		public Reader(String file_name) throws IOException{
    			din = new DataInputStream(new FileInputStream(file_name));
    			buffer = new byte[BUFFER_SIZE];
    			bufferPointer = bytesRead = 0;
    		}
     
    		public String readLine() throws IOException{
    			byte[] buf = new byte[512]; // line length
    			int cnt = 0, c;
    			while ((c = read()) != -1){
    				if (c == '\n')
    					break;
    				buf[cnt++] = (byte) c;
    			}
    			return new String(buf, 0, cnt);
    		}
     
    		public int nextInt() throws IOException{
    			int ret = 0;
    			byte c = read();
    			while (c <= ' ')
    				c = read();
    			boolean neg = (c == '-');
    			if (neg)
    				c = read();
    			do{
    				ret = ret * 10 + c - '0';
    			} while ((c = read()) >= '0' && c <= '9');
     
    			if (neg)
    				return -ret;
    			return ret;
    		}
     
    		public long nextLong() throws IOException{
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
     
    		public double nextDouble() throws IOException{
    			double ret = 0, div = 1;
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
     
    			if (c == '.'){
    				while ((c = read()) >= '0' && c <= '9'){
    					ret += (c - '0') / (div *= 10);
    				}
    			}
    			
    			if (neg)
    				return -ret;
    			return ret;
    		}
     
    		private void fillBuffer() throws IOException{
    			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    			if (bytesRead == -1)
    				buffer[0] = -1;
    		}
     
    		private byte read() throws IOException{
    			if (bufferPointer == bytesRead)
    				fillBuffer();
    			return buffer[bufferPointer++];
    		}
     
    		public void close() throws IOException{
    			if (din == null)
    				return;
    			din.close();
    		}
    	}
    }