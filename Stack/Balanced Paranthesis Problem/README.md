Given a Set of Positive Number as Opening Paranthesis and Negative Number as Closing Paranthesis .

Find the Subarray with the maximum length of balanced Paranthesis


Here approach is that if number is positive then push current index into the stack

If number is negative then pop top index from the stack and compare it with the current array element 
if both are equal and stack is not empty then result is max of result and current index-stack top else if stack is empty then push the element in the stack

Please refer following url for more info
https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/little-monk-and-balanced-parentheses/description/
http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/