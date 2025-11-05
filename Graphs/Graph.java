package Graphs;

import java.util.*;

public class Graph {
    ArrayList<Edge>[] adjList;
    int V;

    @SuppressWarnings("unchecked")
    public Graph(int v){
        V = v;
        adjList = new ArrayList[V];

        for(int i=0; i<V; i++){
            adjList[i] = new ArrayList<>();
        }
    }

    void addEdge(int src, int dest, int wt){
        adjList[src].add(new Edge(src, dest, wt));
        adjList[dest].add(new Edge(dest, src, wt)); 
    }


    void bfs(int start){ // O( V + E ) coz we used adjacency list
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (Edge e : adjList[node]) {
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    queue.offer(e.dest);
                }
            }
        }
    }

    void dfsUtil(int node, boolean[] visited){ // O( V + E ) coz we used adjacency list
        visited[node] = true;
        System.out.print(node + " ");

        for(Edge e: adjList[node]){
            if(!visited[e.dest]){
                dfsUtil(e.dest, visited);
            }
        }
    }

    void dfs(int start){
        boolean[] visited = new boolean[V];
        dfsUtil(start, visited);
    }


    void printGraph(){
        System.out.println("Graph adjacency list: src -> dest : wt");
        for(int i=0; i<V; i++){
            System.out.println("Adjacency list of vertex "+i);
            for(Edge e: adjList[i]){
                System.out.println(e.src+" -> "+e.dest+" : "+e.wt);
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(5);

        g.addEdge(0, 1, 0);
        g.addEdge(0, 2, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(1, 3, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(2, 4, 0);
        g.addEdge(3, 4, 0);

        g.printGraph();

        g.bfs(0);
        System.out.println();
        g.dfs(0);
    }
}

class Edge{
    int src, dest, wt;

    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

