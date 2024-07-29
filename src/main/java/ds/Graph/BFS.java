package ds.Graph;

import java.util.LinkedList;
import java.util.List;

public class BFS {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();

        bfs(a);
    }

    public static void bfs(Vertex vertex) {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        vertex.visited = true; // Mark as visited when added to queue

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.println(current.getName());

            for (Edge edge : current.edges) {
                if (!edge.linked.visited) {
                    queue.add(edge.linked);
                    edge.linked.visited = true; // Mark as visited when added to queue to avoid duplicates
                }
            }
        }
    }
}
