package DAA;

import java.util.*;

public class Exp8 {

    public static void dijkstra(int V, int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];

            if (visited[u])
                continue;

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }
        }

        System.out.println("Vertex \t Distance from Source (" + src + ")");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
                { 0, 10, 0, 30, 100 },
                { 10, 0, 50, 0, 0 },
                { 0, 50, 0, 20, 10 },
                { 30, 0, 20, 0, 60 },
                { 100, 0, 10, 60, 0 }
        };

        dijkstra(V, graph, 0);
    }
}
