/* 
https://www.youtube.com/watch?v=oP2-8ysT3QQ

*/
import java.util.*;
import java.io.*;

class MSTPrim{

public List<Edge<Integer>> primMST(Graph<Integer> graph ){

MinHeapwithMap<Vertex<Integer>> minHeap=new MinHeapwithMap<>();

Map<Vertex<Integer>,Edge<Integer>> vertexToEdge=new HashMap<>();

List<Edge<Integer>> result=new ArrayList<>();

for(Vertex v:graph.getAllVertex()){

	minHeap.add(Integer.MAX_VALUE,v);
}
//Pick up any Random Vertex
Vertex<Integer> startVertex=graph.getAllVertex().iterator().next();

minHeap.decrease(startVertex,0);
while(!minHeap.empty()){

	Vertex<Integer> current=minHeap.extractMin();

	Edge<Integer> spanningTreeEdge=vertexToEdge.get(current);

	if(spanningTreeEdge!=null){
		result.add(spanningTreeEdge);
	}

	for(Edge<Integer> edge:current.getEdges()){

		Vertex<Integer> adjacent=getVertexForEdge(current,edge);

		if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent)>edge.getWeight()){
			minHeap.decrease(adjacent,edge.getWeight());
			vertexToEdge.put(adjacent,edge);
		}
	}


}
return result;



}


private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }
    public static void main(String args[]){
    	 Graph<Integer> graph = new Graph<>(false);
     /* graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);*/

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        MSTPrim prims = new MSTPrim();
        Collection<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }


}




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
	// public static void main(String args[]){
 //        MinHeapwithMap<String> heap = new MinHeapwithMap<String>();
 //        heap.add(3, "Tushar");//weight and key
       
 //        heap.add(4, "Ani");
 //        heap.add(8, "Vijay");
 //        heap.add(10, "Pramila");
 //        heap.add(5, "Roy");
 //        heap.add(6, "NTF");
 //        heap.add(2,"AFR");
 //        heap.decrease("Pramila", 1);
 //        heap.printHeap();
 //        heap.printPositionMap();
 //    }






}


class Graph<T>{

	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertex;
	boolean isDirected=false;

	public Graph(boolean isDirected){

		allEdges=new ArrayList<Edge<T>>();
		allVertex=new HashMap<Long,Vertex<T>>();
		this.isDirected=isDirected;

	}
	public void addEdge(long id1,long id2){
		addEdge(id1,id2,0);

	}

	public void addVertex(Vertex<T> vertex){
		if(allVertex.containsKey(vertex.getId())){
			return;
		}
		allVertex.put(vertex.getId(),vertex);
		for(Edge<T> edge:vertex.getEdges()){
			allEdges.add(edge);
		}
	}
	public Vertex<T> addSingleVertex(long id){
		if(allVertex.containsKey(id)){
			return allVertex.get(id);
		}
		Vertex<T> vertex=new Vertex<T>(id);
		allVertex.put(id,vertex);
		return vertex;
	}
	public Vertex<T> getVertex(long id){
		return allVertex.get(id);

	}
	public void addEdge(long id1,long id2,int weight){
		Vertex<T> vertex1=null;
		if(allVertex.containsKey(id1)){
			vertex1=allVertex.get(id1);
		}
		else{

			vertex1=new Vertex<T>(id1);
			allVertex.put(id1,vertex1);
		}
		Vertex<T> vertex2=null;
		if(allVertex.containsKey(id2)){
			vertex2=allVertex.get(id2);
		}
		else{
			vertex2=new Vertex<T>(id2);
			allVertex.put(id2,vertex2);
		}

		Edge<T> edge=new Edge<T>(vertex1,vertex2,isDirected,weight);
		allEdges.add(edge);
		vertex1.addAdjacentVertex(edge,vertex2);
		if(!isDirected){
			vertex2.addAdjacentVertex(edge,vertex1);
		}
	}

	public List<Edge<T>> getAllEdges(){
		return allEdges;
	}
	public Collection<Vertex<T>> getAllVertex(){
		return allVertex.values();
	}
	public void setDataForVertex(long id,T data){
		if(allVertex.containsKey(id)){
			Vertex<T> vertex=allVertex.get(id);
			vertex.setData(data);
		}
	}

	@Override
	public String toString(){
		StringBuffer buffer=new StringBuffer();
		for(Edge<T> edge:getAllEdges()){
			buffer.append(edge.getVertex1()+" "+edge.getVertex2()+" "+edge.getWeight());
			buffer.append("\n");
		}
		return buffer.toString();
	}


}

class Vertex<T>{
	
	long id;
	private T data;
	private List<Edge<T>> edges=new ArrayList<>();
	private List<Vertex<T>> adjacentVertex =new ArrayList<>();
	Vertex(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}

	public void setData(T data){

		this.data=data;
	}
	public T getData(){
		return data;
	}
	public void addAdjacentVertex(Edge<T> e,Vertex<T> v){
			edges.add(e);
			adjacentVertex.add(v);

	}
	public String toString(){
		return String.valueOf(id);
	}
	public List<Vertex<T>> getAdjacentVertex(){
		return adjacentVertex;
	}
	public List<Edge<T>> getEdges(){
		return edges;
	}
	public int getDegree(){
		return edges.size();
	}


}
class Edge<T>{


	private boolean isDirected=false;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weight;
	Edge(Vertex<T> vertex1,Vertex<T> vertex2){
		this.vertex1=vertex1;
		this.vertex2=vertex2;
	}

	Edge(Vertex<T> vertex1,Vertex<T> vertex2,boolean isDirected,int weight){
		this.vertex1=vertex1;
		this.vertex2=vertex2;
		this.isDirected=isDirected;
		this.weight=weight;
	}

	Edge(Vertex<T> vertex1,Vertex<T> vertex2,boolean isDirected){
		this.vertex1=vertex1;
		this.vertex2=vertex2;
		this.isDirected=isDirected;
	}
	Vertex<T> getVertex1(){
        return vertex1;
    }
    
    Vertex<T> getVertex2(){
        return vertex2;
    }
    
    int getWeight(){
        return weight;
    }
    
    public boolean isDirected(){
        return isDirected;
    }
    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }
    /*

http://www.javaworld.com/article/2074996/hashcode-and-equals-method-in-java-object---a-pragmatic-concept.html
    */
}