
import java.util.*;
class LargestTree {
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        adj[u].push(v);
        adj[v].push(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;

        for (int i = 0; i < adj[u].size(); i++)
            if (!visited.get(adj[u].get(i))) {
                size += DFS(adj[u].get(i), adj, visited);
            }

        return size;

    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++)
        {
            visited.add(false);
        }
        int largestTreeLength = 0;

        for (int u = 0; u < V; u++)
        {
            if (!visited.get(u))
            {
                largestTreeLength = Math.max(largestTreeLength, DFS(u, adj, visited));
            }
        }
        return largestTreeLength;

    }
}

