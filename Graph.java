/*
 * Peter Hess
 * 4/3/17
 * CSC 172: Lab 15 - Graphs
 */

public class Graph {
	private int vertexCount, edgeCount;
	boolean directed; // false for undirected graphs, true for directed
	private boolean adj[][];

	public Graph(int numVertices, boolean isDirected) {
		vertexCount = numVertices;
		edgeCount = 0;
		directed = isDirected;
		adj = new boolean[numVertices][numVertices];
	}

	public boolean isDirected() {
		return directed;
	}

	public int vertices() { // return the number of vertices
		return vertexCount;
	}

	public int edges() { // return number of edges
		return edgeCount;
	}

	/**
	 * Modifies adjacency matrix to "insert" an edge between two vertices
	 * @param e The edge to be inserted.
	 */
	public void insert(Edge e) {
		if(connected(e.v,e.w)){
			return;
		}
		adj[e.v][e.w] = true;
		if(!isDirected()){
			adj[e.w][e.v] = true;
		}
		edgeCount++;
	}

	/**
	 * Modifies adjacency matrix to "delete" an edge between two vertices
	 * @param e The edge to be removed.
	 */
	public void delete(Edge e) {
		if(!connected(e.v,e.w)){
			return;
		}
		adj[e.v][e.w] = false;
		if(!isDirected()){
			adj[e.w][e.v] = false;
		}
		edgeCount--;
	}

	/*Returns true if node1 is connected to node2 by an edge.*/
	public boolean connected(int node1, int node2) { 
		return adj[node1][node2];
	}

	/*Returns the adjacency list of all vertices connected to the input parameter*/
	public AdjList getAdjList(int vertex) { 
		return new AdjArray(vertex);
	}
	
	/*Prints out adjecency list with -1 at the end of each vertices row.*/
	public void show() {
		for (int s = 0; s < vertices(); s++) {
			System.out.print(s + ": ");
			AdjList A = getAdjList(s);
			for (int t = A.begin(); !A.end(); t = A.next()) // use of iterator
				System.out.print(t + " ");
			System.out.println();
		}
	}

	private class AdjArray implements AdjList {
		private int v; // what vertex we are interested in
		private int i; // so we can keep track of where we are

		public AdjArray(int v) {
			this.v = v;
			i = -1;
		}
		
		/*Iterate to next vertex in adjacency list*/
		public int next() { 
			for(++i; i < vertices(); i++){
				if(connected(v, i)){
					return i;
				}
			}
			return -1;
		}

		/*Reset iterator and begin iteration */
		public int begin() {
			i = -1;
			return next();
		}
		
		/*Returns true once the iterator has found all vertices*/
		public boolean end() {
			return i > vertices();
		}
	}
	
	public static void main(String [] args){
		Graph dirGraph = new Graph(7, true);
		int edgeArr[] = {0,1,0,3, 1,3,1,4, 2,0,2,5, 3,2,3,4,3,5,3,6, 4,6, 6,5}; //Adjacent pairs are an edge.
		for(int i = 0; i < edgeArr.length; i+=2){
			dirGraph.insert(new Edge(edgeArr[i], edgeArr[i+1]));
		}
		
		Graph undirGraph = new Graph(5,false);
		int edgeArr2[] = {0,1,0,3,0,4, 1,2,1,3, 2,3,2,4}; //Adjacent pairs are an edge.
		for(int i = 0; i < edgeArr2.length; i+=2){
			undirGraph.insert(new Edge(edgeArr2[i], edgeArr2[i+1]));
		}
		System.out.println("Adjacency list of the digraph:");
		dirGraph.show();
		System.out.println("Adjacency list of the undirected graph:");
		undirGraph.show();
	}
}