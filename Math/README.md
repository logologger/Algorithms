<h2>To Check whether Number is power of 2</h2>

```java
public static boolean checkIsPowerOftwo(int n){

        return (n & (n - 1)) == 0;

    }




```

<h2>Number of Divisors for perfect and non-perfect square</h2>
<p>
If a number is a perfect square, it will have an odd number of factors 
(e.g., 4 has factors 1, 2, 4), whereas all other numbers have an even 
number of factors.


<i>http://mathforum.org/library/drmath/view/55843.html</i>
</p>

<p>
To show that square numbers always have an odd number of factors, 
consider a square, such as 36.

This can be put into prime factors as 2^2*3^2. Note that all its prime 
factors will be raised to EVEN powers since it is a perfect square.</p>



<h2>Number of divisors using seive of atkin</h2>


