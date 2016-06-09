public class Edge<E> implements Comparable< Edge<E> >
{
	 public Vertex<E> source, dest;
	 public double cost;
	 public boolean visited;
	
	 public Edge( Vertex<E> src, Vertex<E> dst, Double cst)
	 {
	    source = src;
	    dest = dst;
	    cost = cst;
	    visited=false;
	 }
	 
	 public Edge( Vertex<E> src, Vertex<E> dst, Integer cst)
	 {
	    this (src, dst, cst.doubleValue());
	 }
	 
	 public Edge()
	 {
	    this(null, null, 1.);
	 }
	 public Edge( Vertex<E> src, Vertex<E> dst){
		 this (src, dst, 0.0);
	 }
	 
	 public String toString(){ return "Edge: "+source.getData() + " to " + dest.getData()
			 + ", distance: " + cost;
	 }
	 
	 public int compareTo( Edge<E> rhs ) 
	 {
	    return (cost < rhs.cost? -1 : cost > rhs.cost? 1 : 0);
	 }

	public Vertex<E> getSource() {
		return source;
	}

	public void setSource(Vertex<E> source) {
		this.source = source;
	}

	public Vertex<E> getDest() {
		return dest;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setDest(Vertex<E> dest) {
		this.dest = dest;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	 
}