import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];

        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u); // Since the graph is undirected
        E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append("\n");
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (int w : adj[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s){
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");

            for (int v:adj[u]){
                if(!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                }
            }
        }

    }

    public void dfs(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while (!stack.empty()){
            int u = stack.peek();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u+" ");

                for (int v: adj[u]){
                    if(!visited[v]){
                        stack.push(v);

                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
//        g.bfs(0);
        g.dfs(0);
        System.out.println(g);
    }
}
