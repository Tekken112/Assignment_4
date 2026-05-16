import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        this.distTo = new HashMap<Vertex<V>, Double>();
        dijkstra(source);
    }

    private void dijkstra(Vertex<V> source) {
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<Vertex<V>>(new Comparator<Vertex<V>>() {
            @Override
            public int compare(Vertex<V> v1, Vertex<V> v2) {
                return Double.compare(getDistance(v1), getDistance(v2));
            }
        });

        distTo.put(source, 0.0);
        marked.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDistance = getDistance(current) + weight;

                if (newDistance < getDistance(neighbor)) {
                    distTo.put(neighbor, newDistance);
                    edgeTo.put(neighbor, current);
                    marked.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public double getDistance(Vertex<V> vertex) {
        if (!distTo.containsKey(vertex)) {
            return Double.POSITIVE_INFINITY;
        }

        return distTo.get(vertex);
    }
}
