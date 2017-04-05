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

<h3> Mind Palaces Problem </h3>

<p> This is one of the excellent problems that uses Algorithm Approach </p>

<p><i>https://www.youtube.com/watch?v=0-rX-Wocuew</i></p>

<p>First thing to get is to see that the 2D array is sorted.Now sorted means Binary Search ...
Binary Search Tecnhique is good but maximum complexity is O(nlogn)  ...If we go through the diagnol approach...
then also it takes O(n ki power 1.324) something like this
</p>

<p>
<h4>Now Comes Step Down Algorithm 
</h4>
This Approach is helpful it runs in O(n) time only.

Go to the top right place in your 2D Matrix ...

If the element there is equal to the query then ok stop ...else if element is less then go down or left based on the less then or greater the situation of the array ..Whether the array is sorted in Descending order or Ascending order.

```java
while(column>=0 && row<n){
            
        if(a[row][column]==q){
            System.out.println((row)+" "+(column));
            ind=1;
            break;

        }
        else if(a[row][column]<q){

            //go down
            row=row+1;

        }
        else{
            column=column-1;

            //go up

        }
    }
```

<i>Whenever you see Sorted 2D Matrix try this approach ...The Video also contains the best description for this Algorithm</i>
</p>

<h2>XSquare Palindrome</h2>
<i><a href="">Problem Link</a></i>
<p>
Question was easy ..Need to find how to make a string palindrom  by deleting or adding characters and reshuffling ..
Deleting and adding cost is 1.

You need to find number of characters need to add so that the string becomes palindrome.

..So count the frequencey of each characters ...find all letters that have odd frequency ..Except one odd character no other odd character is allowed ..Thus Answer will <b><i>number of odd character-1</i> </b>

```java

 Hashtable<Character,Integer> hs=getHashTable(str);
             int sum=0;
             for(Map.Entry m:hs.entrySet()){

                //You need one odd and all even frequency word

                if( (int)m.getValue()%2!=0){

                    sum=sum+1;
                }

             }
             if(sum!=0){
                System.out.println(sum-1);
             }
             else{
                System.out.println(sum);
             }

```
</p>

<h2>Bob and String</h2>
<i><a href="https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/bob-and-string-easy/">Problem Link</a></i>

<p>It's an easy approach that counts the difference between the frequency of all characters from 1 to 127..means all the 
characters that are present in the string</p>

```java
             String str=s.scanString();
             String str1=s.scanString();
             Hashtable<Character,Integer> hs=getHashTable(str);
             Hashtable<Character,Integer> hs1=getHashTable(str1);
             
             int sum=0;
             for(int t=0;t<127;t++){
                Character ch=new Character((char)t);
                int first_value=hs.get(ch)!=null ? hs.get(ch):0;
                int second_value=hs1.get(ch)!=null ? hs1.get(ch):0;
                sum+=Math.abs(first_value-second_value);
             }

```

<h2>Alien Language</h2>
<i><a href="https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/alien-language/">Problem Link</a></i>

<p>The Problem say given two strings .tell whether the second string is a substring of first string </p>
<p>The String will be of small Characters only ..so iterate from a to z and find if there is any character in second which is present in both the string ..then second string is a substring of first string</p>

``` java
String str1=s.scanString();
             String str2=s.scanString();
             
             Hashtable<Character,Integer> hs1=getHashTable(str1);
             Hashtable<Character,Integer> hs2=getHashTable(str2);

             int ind=0;
             for(int j=97;j<=122;j++){
                Character ch=new Character((char)j);
                if(hs1.get(ch)!=null && hs2.get(ch)!=null)
                {
                    System.out.println("YES");
                    ind=1;
                    break;
                }
             }


```


<h2>Marut and Girls</h2>
<i><a href="https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/marut-and-girls/">Problem Link</a></i>
<p>The Problem says that Marut has some Qualities ...and there are some girls who want to marry Marut ...but he will marry only when the girl has the qualities which marut ...</p>
<p>So Given Girls Qualities ..Count the number of girls which Marut can marry</p>
<p>He can marry only when the girls have all the qualities which Marut has</p>

```java


while(st.hasMoreTokens()){
                hs.put(Integer.parseInt(st.nextToken()),1);//Get the Girls Qualities in HashTable
            }
            for(int j=0;j<n;j++){
                if(hs.get(a[j])==null){ //If any of the Qualities which boys have are not there in Girls then that girl is not eligible
                    ind=1;
                }
            }

```