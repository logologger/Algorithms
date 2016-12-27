

import java.util.*;
import java.io.*;


class Learning{


    public static void main(String args[])throws IOException{


        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(reader);
        StringTokenizer st=null;
        st=new StringTokenizer(in.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        Graph<Integer> graph=new Graph<Integer>(false);

        
        int val[]=new int[N];
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            val[i]=Integer.parseInt(st.nextToken());
            //Create Vertex here
            Vertex<Integer> v=new Vertex<Integer>(i+1);
            v.setData(new Integer(val[i]));
            graph.addVertex(v);



           
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(in.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            graph.addEdge(v1,v2);

        }

       

        //traverse through each node and print the kth Sorted intger in descending order
        //get all Adjacent vertex and store them in array .
        // Sort the arnray in descending and if the kth index exist then print it else print -1
       
    //     Comparator<Vertex<Integer>> comparator = new Comparator<Vertex<Integer>>() {

    //     @Override
    //     public int compare(Vertex<Integer> o1, Vertex<Integer> o2) {
    //         if(o1.id<(o2.id)) return -1;
    //         if(o1.id>(o2.id)) return 1;
    //         return 0;

    //     }
    // };

        for(int i=1;i<=N;i++){
            Vertex<Integer> v=graph.getVertex(i);

           
           
             List<Vertex<Integer>> temp=new ArrayList<Vertex<Integer>>();
             int j=0;
             int value=100000;
             int sec_lar=0;
            for(Vertex<Integer> vertex:v.getAdjacentVertexes()){
               
                temp.add(vertex);
                // System.out.println("Vertex data is "+vertex.getData());
                j++;


               // System.out.println(temp[j]);
            }

            


            if(j<k){
                System.out.println("-1");
            }
            else{

                
                

                // for(int ctr = 0; ctr < temp.length; ctr++) {
                //     objectArray[ctr] = Long.valueOf(temp[ctr]); // returns Integer value
                // }

                
                Collections.sort(temp,new Comparator<Vertex<Integer>>() {

                @Override
                public int compare(Vertex<Integer> o1, Vertex<Integer> o2) {

                    if(o1==null || o2==null){
                        return 0;
                    }

                   // System.out.println(o1.getData()+" "+o2.getData());
                    if(o1.getData().intValue()<o2.getData().intValue()) return 1;
                    if(o1.getData().intValue()>o2.getData().intValue()) return -1;

                    if(o1.getId()<o2.getId()) return 1;
                    if(o1.getId()>o2.getId()) return -1;
                    return 0;
                    
                   
                    // System.out.println(o1);
                    // return o1.getData().compareTo(o2.getData());


                }
    });
               System.out.println(temp.get(k-1));
                
                //System.out.println(temp.get(1));
            }
        }
       
       


    }
}




class Graph<T>{

    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;
    
    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long,Vertex<T>>();
        this.isDirected = isDirected;
    }
    
    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
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
    
    public void addEdge(long id1,long id2, int weight){
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

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
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
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
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

 