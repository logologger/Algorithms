/*
https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/monk-and-graph-problem/

*/

import java.util.*;
import java.io.*;


//Here is the sum of degree is equal to twice the number of edges --Handshaking Lemma

class EdgeCountMySolution{


    static long result[];



    public static void main(String args[])throws IOException{


        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(reader);
        StringTokenizer st=null;
        st=new StringTokenizer(in.readLine());
        int N=Integer.parseInt(st.nextToken());//N is no. of vertices
        int E=Integer.parseInt(st.nextToken());//E is the no. of queries
        

        Graph<Integer> graph=new Graph<Integer>(false);

		 for(int i=1;i<=N;i++){

			 Vertex<Integer> v=new Vertex<Integer>(i);
			 graph.addVertex(v);
		}


        for(int i=1;i<=N-1;i++){
            st=new StringTokenizer(in.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            graph.addEdge(v1,v2,i);

        }

       
        //Lets Run DFS here 

         result=new long[N+1];
         Arrays.fill(result,1L);


        Set<Vertex<Integer>> visited = new HashSet<>();


         for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }

           
         
           
            DFSUtil(graph.getVertex(1L), visited,(int)graph.getVertex(1L).getId());
            
            //System.out.println(Arrays.toString(result));
          
           
            
           
        }
        for(int i=1;i<=E;i++){

            int Q=Integer.parseInt(in.readLine());
            //Q will be the Edge 

            
            Edge edge=graph.getEdge((long)Q);

            Vertex<Integer> v1=edge.getVertex1();
            Vertex<Integer> v2=edge.getVertex2();

            int ver1=(int)v1.getId();

            int ver2=(int)v2.getId();
            long smaller=0;

            if(result[ver1]<=result[ver2]){

                smaller=result[ver1];
                
            }
            else{
               smaller=result[ver2];
            }

            System.out.println(smaller*(N-smaller));









        }
        //System.out.println(Arrays.toString(result));
        

    }


    
	 private static long DFSUtil(Vertex<Integer> vertex,
            Set<Vertex<Integer>> visited,int value) {

	  // System.out.println(Arrays.toString(result)+"  "+value+"   "+vertex.getAdjacentVertexes());

	 	if(result[value]!=1L){
            return result[value];
        }

        visited.add(vertex);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
        	
            if (visited.contains(v)) {
                continue;
            }

            int index_id=(int)v.getId();
            result[value]+=DFSUtil(v, visited,index_id);
        }
        return result[value];
       
    }
}




class Graph<T>{

    private List<Edge<T>> allEdges;
    private Map<Long,Edge<T>> allEdges_Q;
    private Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;
    
    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long,Vertex<T>>();
        allEdges_Q=new HashMap<Long,Edge<T>>();
        this.isDirected = isDirected;
    }
    
    public void addEdge(long id1, long id2,long edge_id){
        addEdge(id1,id2,0,edge_id);
    }
    
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(Edge<T> edge : vertex.getEdges()){
            allEdges.add(edge);

        }
    }
    
    public Vertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }
    
    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }

    public Edge<T> getEdge(long id){
        return allEdges_Q.get(id);
    }
    
    public void addEdge(long id1,long id2, int weight,long id){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight,id);
        allEdges.add(edge);
        allEdges_Q.put(id,edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    
    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }
    public void setDataForVertex(long id, T data){
        if(allVertex.containsKey(id)){
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}


class Vertex<T> {
    long id;
     T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
    
    Vertex(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<Edge<T>> getEdges(){
        return edges;
    }
    
    public int getDegree(){
        return edges.size();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class Edge<T>{
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;
    private long id;// Every Edge will have an ID with it for this specific Question
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2,long id){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.id=id;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight,long id){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
        this.id=id;
    }
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,long id){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
        this.id=id;
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

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}

 