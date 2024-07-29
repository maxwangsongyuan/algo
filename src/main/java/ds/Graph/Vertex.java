package ds.Graph;

import java.util.List;

public class Vertex {
    String name;
    List<Edge> edges;
    boolean visited;

    public Vertex(String name, List<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }

    public Vertex(String name, List<Edge> edges, boolean visited) {
        this.name = name;
        this.edges = edges;
        this.visited = visited;
    }

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    /*
    graph:

      -> b  ->
     |        |

    a          d

     |        |
      -> c ->

     */
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
    }
}
