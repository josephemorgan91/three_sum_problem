package Main;

import java.util.*;

public class Graph{
	// Fields
	private int[][] g;	// Use Adjacency Matrix
	private int v;		// Number of verts
	private int e;		// Number of edges
	
	// Constructor
	public Graph(int v){
		g = new int[v][v];
		this.v = v;
		e = 0;
	}
	
	// Methods
	public int V(){
		return v;
	}
	
	public int E(){
		return e;
	}
	
	public void addEdge(int v1, int v2){
		g[v1][v2] = 1;
		g[v2][v1] = 1;
		e++;
	}
	
	public boolean isAdjacent(int v1, int v2){
		return g[v1][v2] == 1;
	}
	
	public boolean isConnected(int v1, int v2){
		int[] bfs = BFStoArray(v1);
		for(int i = 0; i < bfs.length; i++){
			if(bfs[i] == v2)
				return true;
		}
		return false;
	}
	
	public int[] adj(int v){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i < this.v; i++){
			if(g[v][i] == 1)
				al.add(i);
		}
		int[] ret = new int[al.size()];
		for(int i = 0; i < ret.length;i++)
			ret[i] = al.get(i);
		return ret;
	}
	
	public String adjString(int v){
		int[] a = adj(v);
		String ret = "Verts adjacent to " + v + ": ";
		for(int i = 0; i < a.length; i++)
			ret += a[i] + " ";
		return ret;
	}
	
	/* Helper function that can be used later by isConnected as well */
	private int[] BFStoArray(int v){
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean[] visited = new boolean[this.v];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;
		
		int visit;
		while(!q.isEmpty()){
			visit = q.remove();
			al.add(visit);
			for(int i = 0; i < this.v; i++){
				if(isAdjacent(visit, i) && !visited[i]){
					q.add(i);
					visited[i] = true;
				}
			}
		}
		int[] ret = new int[al.size()];
		for(int i = 0; i < ret.length; i++)
			ret[i] = al.get(i);
		return ret;
	}

	private int[] BFStoArray(int v, boolean weighted) {
		ArrayList<Integer> al = new ArrayList<>();
		boolean[] visited = new boolean[this.v];
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;

		int visit;
		while(!q.isEmpty()){
			visit = q.remove();
			al.add(visit);
			for(int i = 0; i < this.v; i++){
				if(isAdjacent(visit, i, weighted) && !visited[i]){
					q.add(i);
					visited[i] = true;
				}
			}
		}
		int[] ret = new int[al.size()];
		for(int i = 0; i < ret.length; i++)
			ret[i] = al.get(i);
		return ret;
	}
	
	public String BFS(int v){
		String ret = "BFS for Vert #" + v + ": ";
		int[] bfs = BFStoArray(v);
		for(int i = 0; i < bfs.length; i++)
			ret += bfs[i] + " ";
		return ret;
	}
	
	/* Initiator (wrapper) method for recursive call */
	public String DFS(int v){
		boolean[] visited = new boolean[this.v];
		String ret = DFS(v, visited,  "DFS for Vert #" + v + ": ");
		return ret;
	}
	
	/* Workhorse (helper) method for recursive call */
	private String DFS(int v, boolean[] visited, String str){
		str += v + " ";
		visited[v] = true;
		for(int i = 0; i < this.v; i++){
			if(isAdjacent(v, i) && !visited[i]){
				str = DFS(i, visited, str);
			}
		}
		return str;
	}
	
	/* This is for adding weighted edges */
	public void addWeightedEdge(int v1, int v2, int weight){
	    g[v1][v2] = weight;
	    g[v2][v1] = weight;
	}
	
	public String shortestPath(int v1, int v2){
	    Stack<Integer> shortestPath;
	    ShortestPathTable spt = new ShortestPathTable(this, v1);
	    spt.needToVisit.set(v1, false);
	    spt.distance.set(v1, 0);
	    getShortestPathTable(v1, spt);
	    shortestPath = getPath(v1, v2, spt);

	    String ret = "[";
	    while (!shortestPath.empty()) {
	    	ret += shortestPath.pop(). toString() + ",";
		}
		ret = ret.substring(0, ret.length() - 1);
		ret += "]";
		return ret;
	}

	private void getShortestPathTable(int rootVertex, ShortestPathTable spt) {
	    for (int neighborVertex = 0; neighborVertex < v; ++neighborVertex) {
	        if (isAdjacent(neighborVertex, rootVertex, true)) {
	        	int distanceToNeighborNode = spt.distance.get(rootVertex) + g[rootVertex][neighborVertex];
	        	if (distanceToNeighborNode < spt.distance.get(neighborVertex)) {
	        	    spt.distance.set(neighborVertex, distanceToNeighborNode);
	        	    spt.previousVertex.set(neighborVertex, rootVertex);
				}
			}
		}
		if (spt.needToVisit.contains(true)) {
			int nextVertexToVisit = getNearestVertex(spt);
			spt.needToVisit.set(nextVertexToVisit, false);
			getShortestPathTable(nextVertexToVisit, spt);
		}
	}

	private boolean isAdjacent(int v1, int v2, boolean isWeighted) {
		if (isWeighted) {
			if (g[v1][v2] >= 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return isAdjacent(v1, v2);
		}
	}

	private int getNearestVertex(ShortestPathTable spt) {
		int shortestDistance = Integer.MAX_VALUE;
		int nearestVertex = -1;

	    for (int i = 0; i < v; ++i) {
	        if (spt.needToVisit.get(i) && spt.distance.get(i) < shortestDistance) {
	        	nearestVertex = i;
				shortestDistance = spt.distance.get(i);
			}
		}
	    return nearestVertex;
	}

	private Stack<Integer> getPath(int v1, int v2, ShortestPathTable spt) {
		Stack<Integer> ret = new Stack<>();
		int nextVertex = v2;
		ret.push(nextVertex);
		while (nextVertex != v1) {
			nextVertex = spt.previousVertex.get(nextVertex);
			ret.push(nextVertex);
		}
		return ret;
	}

	private class ShortestPathTable {
	    public ArrayList<Integer> distance;
		public ArrayList<Boolean> needToVisit;
		public ArrayList<Integer> previousVertex;

	    public ShortestPathTable(Graph g, int startingVertex) {
			distance = new ArrayList<>();
			needToVisit = new ArrayList<>();
			previousVertex = new ArrayList<>();

			for (int i = 0; i < g.v; ++i) {
				distance.add(Integer.MAX_VALUE);
				needToVisit.add(false);
				previousVertex.add(-1);
			}

			for (int i : g.BFStoArray(startingVertex, true)) {
				needToVisit.set(i, true);
			}
		}
	}
}