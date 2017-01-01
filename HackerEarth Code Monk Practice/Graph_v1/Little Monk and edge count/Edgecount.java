import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
public class Edgecount{
	static ArrayList[] al;
	static boolean visited[];
	static int value[];
	static int count=0;
	static class pair implements Comparable<pair>
	{
		Integer x,y;
		pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		public int compareTo(pair o) {
			if(x!=o.x)
				return x.compareTo(o.x);
			else
				return y.compareTo(o.y);
		}  
	}
	public static void main(String[] args) throws IOException {
		new Thread(null ,new Runnable(){
            public void run(){
                try{
                    solve();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        },"1",1<<26).start();
	}
	public static void solve() throws IOException{
	{
	InputReader in=new InputReader(System.in);
	PrintWriter w=new PrintWriter(System.out);
	int n=in.nextInt();
	int q=in.nextInt();
	al=new ArrayList[n+1];
	for(int i=0;i<=n;i++)
		al[i]=new ArrayList<Integer>();
	visited=new boolean[n+1];
	value=new int[n+1];
	Arrays.fill(value,1);
	pair p[]=new pair[n+1];
	for(int i=0;i<n-1;i++)
	{
		int x=in.nextInt();
		int y=in.nextInt();
		al[x].add(y);
		al[y].add(x);
		p[i]=new pair(x,y);
	}
	dfs(1);
	System.out.println(Arrays.toString(value));
	for(int i=0;i<q;i++)
	{
		int t=in.nextInt();
		pair temp=p[t-1];
		if(value[temp.y]<=value[temp.x])
			System.out.println((value[temp.y]*1L)*(n-value[temp.y]));
		else
			System.out.println((value[temp.x]*1L)*(n-value[temp.x]));
	}
	}
}
public static int dfs(int start)
{

	System.out.println(Arrays.toString(value) +"     "+start);
	visited[start]=true;
	if(value[start]!=1)
		return value[start];
	System.out.println(al[start]);
	for(int i=0;i<al[start].size();i++)
	{
		int temp=(int)al[start].get(i);
		//System.out.println("temp is "+temp);
		if(!visited[temp])
			value[start]+=dfs(temp);
	}
	return value[start];
}
public static long lcm(long a,long b )
{
	return a*b/gcd(a,b);
}
public static long gcd(long x, long y)
{
	if(x==0)
		return y;
	if(y==0)
		return x;
	long r=0, a, b;
	a = (x > y) ? x : y; // a is greater number
	b = (x < y) ? x : y; // b is smaller number
	r = b;
	while(a % b != 0)
	{
		r = a % b;
		a = b;
		b = r;
	}
	return r;
}
static class InputReader {
	 
	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;
	private SpaceCharFilter filter;
 
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
 
	public int snext() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int nextInt() {
		int c = snext();
		while (isSpaceChar(c)) {
			c = snext();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = snext();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = snext();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public long nextLong() {
		int c = snext();
		while (isSpaceChar(c)) {
			c = snext();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = snext();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = snext();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}
 
	public String readString() {
		int c = snext();
		while (isSpaceChar(c)) {
			c = snext();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = snext();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public String nextLine() {
		int c = snext();
		while (isSpaceChar(c))
			c = snext();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = snext();
		} while (!isEndOfLine(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
}