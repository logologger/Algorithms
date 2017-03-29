<h2>Comparator in HashMap</h2>

Came to now about ValueComparator in hashMap from this link 

http://stackoverflow.com/questions/17533272/how-to-make-a-generic-valuecomparator-for-sorting-multiple-hashmaps


It's a good concept of how you want your hashMap to be implemented 

<b>LinkedHashMap</b> ---Maintains the order --- the way it is inserted and the way it is poped out will be same

<b>TreeMap</b> -- Mantains the sorted order in HashMap


Using Comparator we can mantain the way we want 

like 
```java

Map<Broker, Integer> brokerSalesCountList = new HashMap<Broker, Integer>();

private static ValueComparator<Broker> bvc =  new ValueComparator<Broker>(brokerSalesCountList);




public class ValueComparator<T> implements Comparator<T> {  
    Map<T, Integer> base;
    public ValueComparator(Map<T, Integer> base) {
        this.base = base;
    }

    @Override
    public int compare(T a, T b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }

}


```


<h3> Pair Sum Problem </h3>


<p>This Problem is unique in the way that you need to find the pair which sum to some specific number </p>
<p>Normal Approach would be to iterate through an entire for loop and find which pair sums to some specific sum
This Approach will take O(n^2) time
</p>
<p>
    But If you implement it using hashMap find whether the rem=(sum-input) is there in the hashMap then it will be straight forewar approach which runs in O(n) time.

</p>