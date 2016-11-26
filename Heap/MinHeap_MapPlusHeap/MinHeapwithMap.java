import java.io.*;
import java.util.*;
class MinHeapwithMap<T>{

	private List<Node> allNodes=new ArrayList<>();
	private Map<T,Integer> nodePosition=new HashMap<>();

	public class Node{
		int weight;
		T key;
	}
	//Takes O(1) time
	public boolean containsData(T key){
		return nodePosition.containsKey(key);
	}
	//Take O(log n) time
	public void add(int weight,T key){


		Node node=new Node();
		node.weight=weight;
		node.key=key;
		allNodes.add(node);
		int size=allNodes.size();
		int current=size-1;
		int parentIndex=(current-1)/2;
		nodePosition.put(node.key,current);

		//Fix Upwards
		while(parentIndex>=0){
			Node parentNode=allNodes.get(parentIndex);
			Node currentNode=allNodes.get(current);
			if(parentNode.weight>currentNode.weight){

				swap(parentNode,currentNode);
				updatePosition(parentNode.key,currentNode.key,parentIndex,current);
				current=parentIndex;
				parentIndex=(parentIndex-1)/2;
			}
			else{
				break;
				//No Need to traverse more up
			}
		}

	}
	public T min(){
		return allNodes.get(0).key;
	}

	public boolean empty(){
		return allNodes.size()==0;
	}

	public void swap(Node node1,Node node2){
		int weight=node1.weight;
		T data=node1.key;

		node1.key=node2.key;
		node1.weight=node2.weight;

		node2.key=data;
		node2.weight=weight;
	}

	public void updatePosition(T data1,T data2,int pos1,int pos2){
		nodePosition.remove(data1);
		nodePosition.remove(data2);
		nodePosition.put(data1,pos1);
		nodePosition.put(data2,pos2);
	}
	//Decrease weight to NewWeight
	public void decrease(T data,int newWeight){

			Integer position=nodePosition.get(data);
			allNodes.get(position).weight=newWeight;
			int parent=(position-1)/2;
			//Call the fixUpwards
			while(parent>=0){
				if(allNodes.get(parent).weight>allNodes.get(position).weight){
					swap(allNodes.get(parent),allNodes.get(position));
					updatePosition(allNodes.get(parent).key,allNodes.get(position).key,parent,position);
					position=parent;
					parent=(parent-1)/2;
				}
				else{
					break;
				}
			}

	}

	public Integer getWeight(T key){
		Integer position=nodePosition.get(key);
		if(position==null){
			return null;
		}
		else{
			return allNodes.get(position).weight;
		}
	}
	public Node extractMinNode(){
		int size=allNodes.size()-1;
		Node minNode=new Node();
		minNode.key=allNodes.get(0).key;
		minNode.weight=allNodes.get(0).weight;

		int lastNodeWeight=allNodes.get(size).weight;
	 	T lastNodeKey=allNodes.get(size).key;
		allNodes.get(0).weight=lastNodeWeight;
		allNodes.get(0).key=lastNodeKey;
		nodePosition.remove(minNode.key);//remove the 0th Node
		nodePosition.remove(allNodes.get(0));//remove the lastNode size
		
		nodePosition.put(lastNodeKey,0);//put the 0th size node here

		allNodes.remove(size);

		int currentIndex=0;
		size--;

		//Here we are implementing MinHeapify function 
		while(true){
			int left=2*currentIndex+1;
			int right=2*currentIndex+2;
			if(left>size){
				break;
			}
			if(right>size){
				right=left;
			}
			int smallerIndex=allNodes.get(left).weight<=allNodes.get(right).weight?left:right;
			if(allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight){


					swap(allNodes.get(currentIndex),allNodes.get(smallerIndex));
					updatePosition(allNodes.get(currentIndex).key,allNodes.get(smallerIndex).key,currentIndex,smallerIndex);
					currentIndex=smallerIndex;
			}
			else{
				break;
			}
		}
		return minNode;


	}

	public T extractMin(){
		Node node=extractMinNode();
		return node.key;
	}
	public void printPositionMap(){
		System.out.println(nodePosition);
	}
	public void printHeap(){
		for(Node n:allNodes){
			System.out.println(n.weight+" "+n.key);
		}
	}
	public static void main(String args[]){
        MinHeapwithMap<String> heap = new MinHeapwithMap<String>();
        heap.add(3, "Tushar");//weight and key
       
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2,"AFR");
        heap.decrease("Pramila", 1);
        heap.printHeap();
        heap.printPositionMap();
    }






}