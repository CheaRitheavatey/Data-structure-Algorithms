import java.util.*;

public class PrimLazy {
    static class Edge implements Comparable<Edge> {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void prim(int[][] graph) {
        int numVertices = graph.length;
        boolean[] inMST = new boolean[numVertices];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        
        // Start from the first vertex (index 0)
        inMST[0] = true;
        for (int i = 0; i < numVertices; i++) {
            if (graph[0][i] != 0) { // Check if there's an edge
                minHeap.offer(new Edge(i, graph[0][i]));
            }
        }

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int dest = edge.dest;

            // If the destination vertex is already included in MST, skip it
            if (inMST[dest]) {
                continue;
            }

            // Include the edge in MST
            inMST[dest] = true;
            System.out.println("Edge included: (0, " + dest + ") with weight " + edge.weight);

            // Add all edges from the new vertex to the minHeap
            for (int i = 0; i < numVertices; i++) {
                if (graph[dest][i] != 0 && !inMST[i]) { // Check if there's an edge and it's not in MST
                    minHeap.offer(new Edge(i, graph[dest][i]));
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example graph (adjacency matrix)
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        prim(graph);
    }
}