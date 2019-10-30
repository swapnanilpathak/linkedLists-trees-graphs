import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


//simple graph class implemented using adjacency matrix with following functions
//Breadth First Search
//Depth First Search
public class Graph {
	int n,m;
	int[][] adjacencyMatrix;
	boolean[] visited;
	void initializeAdjacencyMatrix(int n){
		this.n=n;
		
		adjacencyMatrix = new int[n][n];
	}
	void printAdjacencyMatrix() {
		for(int i=0;i<this.n;i++) {
			for(int j=0;j<this.n;j++) {
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	void readUndirectedEdges(int m) {
		this.m=m;
		Scanner s = new Scanner(System.in);
		for(int i=0;i<m;++i) {
			int x, y;
			
			x = s.nextInt();
			y = s.nextInt();
			adjacencyMatrix[x-1][y-1]=1;
			adjacencyMatrix[y-1][x-1]=1;
		}
		s.close();
	}
	void readDirectedEdges(int m) {
		this.m=m;
		Scanner s = new Scanner(System.in);
		for(int i=0;i<m;++i) {
			int x, y;
			
			x = s.nextInt();
			y = s.nextInt();
			adjacencyMatrix[x-1][y-1]=1;
		}
		s.close();
	}
	
	
	void DFS(int vertex) {
		visited = new boolean[this.n];
		Stack<Integer> s = new Stack<Integer>();
		s.push(vertex);
		while(s.isEmpty()!=true) {
			int v = s.pop();
			System.out.print((v+1)+" ");
			if(visited[v]==false) {
				visited[v]=true;
				for(int i=0;i<adjacencyMatrix.length;i++) {
					if(adjacencyMatrix[v][i]==1&&visited[i]!=true) {
						s.push(i);
					}
				}
			}
		}
	}
	void BFS(int vertex) {
		visited = new boolean[this.n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(vertex);
		while(q.isEmpty()!=true) {
			int v = q.remove();
			System.out.print((v+1)+" ");
			if(visited[v]==false) {
				visited[v]=true;
				for(int i=0;i<adjacencyMatrix.length;i++) {
					if(adjacencyMatrix[v][i]==1&&visited[i]!=true) {
						q.add(i);
					}
				}
			}
		}
	}
	 

	public static void main(String[] args) {
		int nodes,edges;
		Scanner s = new Scanner(System.in);
		nodes = s.nextInt();
		edges = s.nextInt();
		Graph g = new Graph();
		g.initializeAdjacencyMatrix(nodes);
		g.printAdjacencyMatrix();
		g.readUndirectedEdges(edges);
		g.printAdjacencyMatrix();
		for(int i=0;i<nodes;i++) {
			g.DFS(i);
			System.out.println();
		}
		for(int i=0;i<nodes;i++) {
			g.BFS(i);
			System.out.println();
		}
		s.close();
	}
	

}

/*
Input/Output
4			//no of vertices
3			//no of edges
0 0 0 0 	//initial adjacency matrix
0 0 0 0 	
0 0 0 0 	
0 0 0 0 	
1			//read the edges for undirected graph
2			
2			
3			
2			
4			
0 1 0 0 	//adjacency matrix after reading edges
1 0 1 1 	
0 1 0 0 	
0 1 0 0 	
1 2 4 3 	//DFS results
2 4 3 1 	
3 2 4 1 	
4 2 3 1 	
1 2 3 4 	//BFS results
2 1 3 4 	
3 2 1 4 	
4 2 1 3 	

 */

