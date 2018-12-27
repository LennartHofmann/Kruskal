import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class GraphTableController implements EventHandler<javafx.event.ActionEvent> {

	GraphTable graphTable;
	
	public GraphTableController(GraphTable graphTable) {
		this.graphTable = graphTable;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		if(((Button) event.getSource()).getId()=="add") {	
			for (int i = 0; i < this.graphTable.graph.edges.length; i++) {
				if(this.graphTable.graph.edges[i].getLengh()==0) {
					this.graphTable.graph.edges[i].setStartNode(Long.valueOf(this.graphTable.enterStartNode.getText()));
					this.graphTable.graph.edges[i].setEndNode(Long.valueOf(this.graphTable.enterEndNode.getText()));
					this.graphTable.graph.edges[i].setLengh(Long.valueOf(this.graphTable.enterLength.getText()));
					this.graphTable.paint();
					break;
				}
			}
		}
		for (int i = 0; i < this.graphTable.numberOfRows; i++) {
			if(((Button) event.getSource()).getId().compareTo(String.valueOf(i))==0) {
				this.graphTable.graph.removeEdge(i);
				this.graphTable.paint();
			}
		}
		
		
		
	}

	
}
