package ds.Graph;

import java.util.LinkedList;
import java.util.List;

public class DFS {

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

//        dfs(a);

        dfs3(a);
    }

    /* dfs:
     recursive function that takes a vertex as an argument
     */

    public static void dfs(Vertex vertex) {
        System.out.println(vertex.getName());
        vertex.visited = true;
        for (Edge edge : vertex.edges) {
            if (!edge.linked.visited) {
                dfs(edge.linked);
            }
        }

    }

    /*
    stack dfs:
    a -> c -> d -> b
     */
    public static void dfs2(Vertex vertex) {
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            System.out.println(current.getName());
            current.visited = true;

            for (Edge edge : current.edges) {
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                }
            }
        }
    }

    public static void dfs3(Vertex vertex) {
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(vertex);
        vertex.visited = true; // Mark as visited when added to stack

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            System.out.println(current.getName());

            for (Edge edge : current.edges) {
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                    edge.linked.visited = true; // Mark as visited when added to stack
                }
            }
        }
    }

}
