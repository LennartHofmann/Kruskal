import javax.swing.text.StyledEditorKit.ForegroundAction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Graph {

	public Edge[] edges;
	
	
	
	public Graph() {
		this.edges = new Edge[10000];
		for (int i = 0; i < edges.length; i++) {
			this.edges[i] = new Edge(this);
		}
		
		
		
	}
	
	
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
	
}
