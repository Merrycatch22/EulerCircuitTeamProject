import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class EulerGraph<E> extends Graph<E> {
	public ArrayList<Edge<E>> edgeAL;

	public EulerGraph() {
		super();
		edgeAL = new ArrayList<Edge<E>>();
	}

	public void addEdge(E source, E dest, double cost) {
		super.addEdge(source, dest, cost);
		edgeAL.add(new Edge<E>(vertexSet.get(source), vertexSet.get(dest)));
		edgeAL.add(new Edge<E>(vertexSet.get(dest), vertexSet.get(source)));
	}

	@Override
	public void addEdge(E source, E dest, int cost) {
		addEdge(source, dest, (double) cost);
	}

	@Override
	public boolean remove(E source, E dest) {
		Iterator<Edge<E>> iter = edgeAL.iterator();
		int directedEdgesRemoved=0;
		while (iter.hasNext()) {
			Edge<E> next = iter.next();
			if ((next.source == vertexSet.get(source) && next.dest == vertexSet.get(dest))
					|| (next.source == vertexSet.get(dest) && next.dest == vertexSet.get(source))) {
				edgeAL.remove(next);
				directedEdgesRemoved++;
			}
		}
		return super.remove(source, dest) && directedEdgesRemoved==2;
	}

	public boolean isCycle() {
		Iterator<Entry<E, Vertex<E>>> vertexSetIter;
		vertexSetIter = vertexSet.entrySet().iterator();
		while (vertexSetIter.hasNext()) {
			if (vertexSetIter.next().getValue().adjList.size() % 2 == 1) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Vertex<E>> findCycle() {
		return findCycle(vertexSet.entrySet().iterator().next().getValue().getData());
	}

	public ArrayList<Vertex<E>> findCycle(E start) {
		return
	}

	public void printCycle() {

	}
}
