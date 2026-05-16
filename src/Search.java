import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Search<V> {
    protected Vertex<V> source;
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;

    public Search(Vertex<V> source) {
        this.source = source;
        this.marked = new HashSet<Vertex<V>>();
        this.edgeTo = new HashMap<Vertex<V>, Vertex<V>>();
    }

    public boolean hasPathTo(Vertex<V> vertex) {
        return marked.contains(vertex);
    }

    public List<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) {
            return Collections.emptyList();
        }

        List<Vertex<V>> path = new ArrayList<Vertex<V>>();
        Vertex<V> current = vertex;

        while (current != null) {
            path.add(current);

            if (current.equals(source)) {
                break;
            }

            current = edgeTo.get(current);
        }

        Collections.reverse(path);
        return path;
    }
}
