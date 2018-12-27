public class Graph {

	public Edge[] edges;
	public boolean isEditable;
	
	
	public Graph() {
		this.edges = new Edge[10000];
		for (int i = 0; i < edges.length; i++) {
			this.edges[i] = new Edge(this);
		}
		
		isEditable = false;
		
		
	}
	
	
	public void removeEdge(int i) {
		for (int z = i+1; z < this.edges.length; z++) {
			this.edges[z-1].setStartNode(this.edges[z].getStartNode());
			this.edges[z-1].setEndNode(this.edges[z].getEndNode());
			this.edges[z-1].setLengh(this.edges[z].getLengh());
			
			if(this.edges[z].getLengh()==0) {
				this.edges[z-1].setStartNode(this.edges[z].getStartNode());
				this.edges[z-1].setEndNode(this.edges[z].getEndNode());
				this.edges[z-1].setLengh(this.edges[z].getLengh());
				
				break;
			}
			
		}
	}
	
	
	
	/*
	@Override
	public String toString() {
		String output = new String();
		output = "enthaltene Knoten: ";
		long knownNodes[] = this.getKnownNodes();
	
		for (int i = 0; i < knownNodes.length; i++) {
			if(knownNodes[i]!=0) {
				output = output + knownNodes[i] + ", ";
			}
		}
		
		output = output.substring(0, output.length()-2) + "\n";
				
		for (int j = 0; j <this.edges.length; j++) {
			if(this.edges[j].getLengh()!=0) {
				output = output + this.edges[j];
			}
		}
		
		//output = output + "\n";
		
		return (output);

	}
	*/
	
	public boolean isEditable() {
		return isEditable;
	}


	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	/*
	public long[] getKnownNodes() {
		long knownNodes[] = new long[100];
		
		boolean alreadyExists = false;
		for (int i = 0; i < 10000; i++) {
			alreadyExists = false;
			
			for (int j = 0; j < 100; j++) {
				if(this.edges[i].getStartNode()==knownNodes[j]) {
					alreadyExists = true;
				}
			}
			if(alreadyExists==false) {
				for (int j = 0; j < 100; j++) {
					if(knownNodes[j]==0) {
						knownNodes[j] = this.edges[i].getStartNode();
						break;
					}
				}
			}
		}
		for (int i = 0; i < 10000; i++) {
			alreadyExists = false;
			
			for (int j = 0; j < 100; j++) {
				if(this.edges[i].getEndNode()==knownNodes[j]) {
					alreadyExists = true;
				}
			}
			if(alreadyExists==false) {
				for (int j = 0; j < 100; j++) {
					if(knownNodes[j]==0) {
						knownNodes[j] = this.edges[i].getEndNode();
						break;
					}
				}
			}
		}
		
		return knownNodes;
	}
	*/
}
