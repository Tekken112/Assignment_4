import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        this.vertices = new HashSet<Vertex<V>>();
        this.directed = directed;
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        addVertex(source);
        addVertex(destination);

        source.addAdjacentVertex(destination, weight);

        if (!directed) {
            destination.addAdjacentVertex(source, weight);
        }
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
