<h2>Formula for finding Binomial Coefficients</h2>


```java

public int binomailCoefficient(int n,int k){

		int res=1;

		if(k>n-k){
			k=n-k;   //Check by formula nCk === nC(n-k)
		}
		// Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
		for(int i=0;i<k;i++){
			res*=(n-i);
			res/=(i+1);
		}

		return res;

	}
```


