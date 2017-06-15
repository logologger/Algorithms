<h2>nth Fibonacci Number</h2>

<p>Do we have methods to find nth Fibonacci number in less than a second?

Yes. We have few methods to do this. Out of them matrix exponentiation is most commonly used concept. Another well known concept is fast doubling method, which we are going to learn now.</p>

<b>We will see how fast doubling is used to get nth fibonacci number faster</b>



<p>Source:<i>https://www.hackerearth.com/practice/notes/fast-doubling-method-to-find-nth-fibonacci-number/</i></p>

<b>Formula for it is</b>

```java
F(2n) = F(n)[2*F(n+1) – F(n)]
F(2n + 1) = F(n)2 + F(n+1)2
```




The Entire Logic is here 

<br>


```java
#define MOD 1000000007;
long long int a,b,c,d;

void fast_fib(long long int n,long long int ans[])
{
    if(n == 0)
    {
        ans[0] = 0;
        ans[1] = 1;
        return;
    }
    fast_fib((n/2),ans);
    a = ans[0];             /* F(n) */
    b = ans[1];             /* F(n+1) */
    c = 2*b - a;
    if(c < 0)
        c += MOD;
    c = (a * c) % MOD;      /* F(2n) */
    d = (a*a + b*b) % MOD;  /* F(2n + 1) */
    if(n%2 == 0)
    {
        ans[0] = c;
        ans[1] = d;
    }
    else
    {
        ans[0] = d;
        ans[1] = c+d;
    }
}
```

