package Graphs;

import java.util.ArrayList;

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
    }

    void printGraph(){
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

        System.out.println("Graph created successfully!");
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

