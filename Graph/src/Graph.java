import java.util.Arrays;

public class Graph {

    private int V; // Number of vertices
    private int E; // Number of edges
    private int[][] adjMatrix; // Adjacency matrix

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    // Method to add edges to the graph
    public void addEdges(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Since it's an undirected graph
        E++;
    }

    // Overriding toString method to print the graph
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices: ").append(V).append(", Edges: ").append(E).append("\n");
        sb.append("Adjacency Matrix:\n");
        for (int i = 0; i < V; i++) {
            sb.append(Arrays.toString(adjMatrix[i])).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 3);
        g.addEdges(3, 0);

        System.out.println(g);
    }
}
