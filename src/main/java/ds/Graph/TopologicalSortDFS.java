package ds.Graph;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();

//        d.edges = List.of(new Edge(c)); // cycle , topological sort not possible


        List<Vertex> graph = List.of(a, b, c, d);

        LinkedList<String> stack = new LinkedList<>();
        for (Vertex vertex : graph) {
            dfs(vertex, stack);
        }

        System.out.println(stack);


    }

    public static void dfs(Vertex vertex, LinkedList<String> stack) {
        // 0: unvisited, 1: visiting, 2: visited
        if (vertex.status == 1) {
            throw new RuntimeException("Cycle detected");
        }

        if (vertex.status == 2) {
            return;
        }

        vertex.status = 1;
        for (Edge edge : vertex.edges) {
            dfs(edge.linked, stack);
        }
        vertex.status = 2;
        stack.push(vertex.name);
    }


}
