import java.io.*;
import java.util.*;
/*
https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
*/
class Trie{

	private class TrieNode{

		Map<Character,TrieNode> children;
		boolean endOfWord;
		public TrieNode(){
			children=new HashMap<>();
			endOfWord=false;
		}
	}
	private final TrieNode root;
	public Trie{
		root=new TrieNode();
	}

	public void insert(String word){
		TrieNode current=root;
		for(int i=0;i<i.word.length();i++){
			char ch=word.charAt(i);
			TrieNode node=current.children.get(ch);
			if(node==null){
				node=new TrieNode();
				current.children.put(ch,node);
			}

			current=node;
		}

		current.endOfWord=true;


	}

	public boolean search(String word){
		TrieNode current=root;
		for(int i=0;i<word.length;i++){
			char ch=word.charAt(i);
			TrieNode node=current.children.get(ch);

			if(node==null){
				return false;
			}

			current=node;
		}
		return current.endOfWord;
	}

	public void delete(String word){
		delete(root,word,0);
	}

	public boolean delete(TrieNode current,String word,int index){
		//When end of word is reached
		if(index==word.length()){

			if(!current.endOfWord){
				return false;
			}

			current.endOfWord=false;

			return current.children.size()==0;

		}
		char ch=word.charAt(index);
		TrieNode node=current.children.get(ch);

		if(node==null){
			return false;
		}

		boolean shouldDeleteCurrentNode=delete(node,word,index+1);
		//delete the children 
		if(shouldDeleteCurrentNode){
			current.children.remove(ch);
			//return true if no mapping are found
			return current.children.size()==0;
		}

		return false;
	}
	public static void main(String args[]){

	}
}