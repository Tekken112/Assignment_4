public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<String>(false);

        Vertex<String> astana = new Vertex<String>("Astana");
        Vertex<String> almaty = new Vertex<String>("Almaty");
        Vertex<String> shymkent = new Vertex<String>("Shymkent");
        Vertex<String> karaganda = new Vertex<String>("Karaganda");
        Vertex<String> aktobe = new Vertex<String>("Aktobe");

        graph.addEdge(astana, karaganda, 2.0);
        graph.addEdge(astana, almaty, 7.0);
        graph.addEdge(karaganda, almaty, 3.0);
        graph.addEdge(almaty, shymkent, 4.0);
        graph.addEdge(shymkent, aktobe, 6.0);
        graph.addEdge(karaganda, aktobe, 10.0);

        System.out.println("BFS path from Astana to Aktobe:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<String>(astana);
        System.out.println(bfs.pathTo(aktobe));

        System.out.println();

        System.out.println("Dijkstra shortest path from Astana to Aktobe:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<String>(astana);
        System.out.println(dijkstra.pathTo(aktobe));
        System.out.println("Distance: " + dijkstra.getDistance(aktobe));
    }
}
