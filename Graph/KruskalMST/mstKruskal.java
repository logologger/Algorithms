import java.io.*;
import java.util.*;


class mstKruskal{


public class EdgeComparator implements Comparator<Edge<Integer>>{


	@Override
	public int compare(Edge<Integer> edge1,Edge<Integer> edge2){
		if(edge1.getWeight() <= edge2.getWeight()){
			return -1;
		}
		else
		{
			return 1;
		}
	}
}

public List<Edge<Integer>> getMST(GraphbyMe<Integer> graph){

	List<Edge<Integer>> allEdges=graph.getAllEdges();
	EdgeComparator edgeComparator=new EdgeComparator();

	Collections.sort(allEdges,edgeComparator);

	DisjointSet disjointSet=new DisjointSet();

	for(Vertex<Integer> vertex:graph.getAllVertex()){

		disjointSet.makeSet(vertex.getId());
	}

	List<Edge<Integer>> resultEdge=new ArrayList<Edge<Integer>>();

	for(Edge<Integer> edge:allEdges){

		long root1=disjointSet.findSet(edge.getVertex1().getId());
		long root2=disjointSet.findSet(edge.getVertex2().getId());

		if(root1==root2){
			continue;
		}
		else{
			resultEdge.add(edge);
			disjointSet.union(root1,root2);
		}
	}
	return resultEdge;
}
 public static void main(String args[]) {
        GraphbyMe<Integer> graph = new GraphbyMe<Integer>(false);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);
        mstKruskal mst = new mstKruskal();
        List<Edge<Integer>> result = mst.getMST(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getVertex1() + " " + edge.getVertex2());
        }
    }

}

class DisjointSet{

	private Map<Long,Node> map=new HashMap<>();

	class Node{

		long data;
		Node parent;
		int rank;
	}

/*

WE have three operations here
MakeSet
Union 
findSet
*/

public void makeSet(long data){

Node node=new Node();
node.data=data;
node.parent=node;
node.rank=0;
map.put(data,node);

}

/*
returns true if data1 and data2 are in different set else false
*/
public boolean union(long data1,long data2){

Node node1=map.get(data1);
Node node2=map.get(data2);

Node parent1=findSet(node1);
Node parent2=findSet(node2);

if(parent1.data==parent2.data){

	return false;//Union is not possible since both are in same set

}

//You has higher rank becomes parent 
if(parent1.rank>=parent2.rank){

parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
parent2.parent=parent1;

}
else{

parent1.parent=parent2;

}
return true;

}

public long findSet(long data){
	return findSet(map.get(data)).data;
}

private Node findSet(Node node){

	Node parent=node.parent;
	if(parent==node){
		return parent;
	}
	node.parent=findSet(node.parent);
	return node.parent;
}
}




class GraphbyMe<T>{

	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertex;
	boolean isDirected=false;

	public GraphbyMe(boolean isDirected){

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