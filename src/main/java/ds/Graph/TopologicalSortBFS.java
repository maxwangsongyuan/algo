package ds.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSortBFS {

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();

        //cycle
//        d.edges = List.of(new Edge(c)); // cycle , topological sort not possible


        List<Vertex> graph = new ArrayList<>(List.of(a, b, c, d));

        //1.统计每个节点的入度（indegree）
        for (Vertex vertex : graph) {
            for (Edge edge : vertex.edges) {
                edge.linked.inDegree++;
            }
        }

//        for (Vertex vertex : graph) {
//            System.out.println(vertex.getName() + " " + vertex.inDegree);
//        }

        //2. 将入度为0的节点加入队列
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph) {
            if (vertex.inDegree == 0) {
                queue.add(vertex);
            }
        }

        //3. 遍历队列，将节点的邻接节点的入度减1，如果减到0，加入队列
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
//            System.out.println(current.getName());
            result.add(current.getName());
            //遍历当前节点的邻接节点, 然后-1
            for (Edge edge : current.edges) {
                edge.linked.inDegree--; //if there's a cycle, this will be never be 0
                if (edge.linked.inDegree == 0) {
                    queue.add(edge.linked);
                }
            }
        }

        System.out.println(result.size() == graph.size());//if there's a cycle, this will be false
    }

}
