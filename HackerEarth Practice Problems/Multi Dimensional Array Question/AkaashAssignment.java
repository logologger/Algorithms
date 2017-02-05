
    import java.io.DataInputStream;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.LinkedHashMap;
    import java.util.Map.Entry;
    import java.util.*;
     
     //This input Class is not suitable for reading large inputs of string
    class AkaashAssignment {
     
    	public static void main(String[] args) throws IOException {
    	
    		Reader in = new Reader();
    		//OutputStream out = new BufferedOutputStream ( System.out );
    		PrintWriter out = new PrintWriter(System.out);


            int n=in.nextInt();
            int q=in.nextInt();
           // String s=in.readLine();
            StringBuilder sb=new StringBuilder();
            int arr[][]=new int[26][n+1];
            for(int i=1;i<=n;i++){
            	String ch=in.readLine();
            	int pos=ch.charAt(0)-'a';

            	arr[pos][i]++;
            	//copy from i to n
            	for(int j=i+1;j<=n;j++){
            		arr[pos][j]++;
            	}

            }
            // for(int i=0;i<26;i++){
            // 	for(int j=0;j<n;j++){
            // 		System.out.print(arr[i][j]+" ");
            		
            // 	}
            // 	System.out.println();
            		
            // 	}

            
            for(int i=0;i<q;i++){
            	int start=in.nextInt();
            	int end=in.nextInt();
            	int K=in.nextInt();
            	int result=0;
            	char ans='a';
            	int ind=0;
            	int k=0;
            	if(K>0 && K<=end-start+1){
            	
            	for(k=0;(K>(arr[k][end]-arr[k][start-1])) && k<26;k++){
            		K=K-(arr[k][end]-arr[k][start-1]);

            		if(K<0){
            			break;
            		}


            	}
            	ans=(char)(k+'a');
            	
            	System.out.println(ans);
            	//System.out.println(ans);
            }
            	
            	//Arrays.sort(subarr);
            	
            
            	else
            	System.out.println("Out of range");
            
            }
            System.out.println(sb.toString());
    						
    		out.close();
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
    			byte[] buf = new byte[1]; // line length
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