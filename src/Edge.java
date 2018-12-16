public class Edge {

	public Graph parent;
	
	private long startNode;
	private long endNode;
	private long lengh;
	
	
	public Edge(Graph graph) {
		this();
		this.setParent(graph);
	}

	public Edge() {
		this.setStartNode(0);
		this.setEndNode(0);
		this.setLengh(0);
	}
	
	public Edge(Graph graph, long start, long end, long lengh) {
		this.setParent(graph);
		this.setStartNode(start);
		this.setEndNode(end);
		this.setLengh(lengh);
	}
	
	
	@Override
	public String toString() {
		String output = new String();
		output = "Startknoten: " + this.getStartNode() + "\t";
		output = output + "Endknoten: " + this.getEndNode() + "\t";
		output = output + "Länge: " + this.getLengh()+ "\n";
		
		
		return (output);
	}
	
	
	//Getters und Setters
	public long getStartNode() {
		return this.startNode;
	}

	public void setStartNode(long startNode) {
		this.startNode = startNode;
	}

	public long getEndNode() {
		return this.endNode;
	}

	public void setEndNode(long endNode) {
		this.endNode = endNode;
	}

	public long getLengh() {
		return this.lengh;
	}

	public void setLengh(long lengh) {
		this.lengh = lengh;
	}
	
	public Graph getParent() {
		return this.parent;
	}

	public void setParent(Graph graph) {
		this.parent = graph;
	}
	
	
	
}
