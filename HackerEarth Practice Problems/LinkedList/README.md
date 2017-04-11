<h2>Remove Friends</h2>

<p>Somehow I believe from this Problem that ArrayList and Linked List are much heavier operations then Using Stack</p>

<p>Logic Which  I Applied as per the Author asked ....but using ArrayList it gave Time Limit Excceeeded But using Stack it was Accepted</p>


<p>Logic Applied here was simple</p>
<i>when you have removed say ith friend than you don't need to go back to start of the list. You just need to go back 1 index if the friend removed is not the 0th index friend, if the removed friend is at 0th index than you just begin from start i.e you just stay at 0th index else if we remove ith friend we just need to start our search from (i-1)th index. Now if you are able to remove k friends than it is fine else if suppose you are only able to remove k1 friends than at the end just remove last k-k1 friends to get the answer.</i>


<p>Thus wherever Possible if the question is solvable using Stack ..then it will be efficient than using List</p>