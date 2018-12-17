import javafx.geometry.HPos;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GraphTable extends ScrollPane {

	GridPane table;
	Graph graph;
	
	public GraphTable(Graph graph) {
		this.graph = graph;
		
		this.table = new GridPane();
		this.table.setGridLinesVisible(true);
		
		Label startNodeHead = new Label();
		startNodeHead.setText("Startknoten");
		this.table.add(startNodeHead, 0, 0);
		this.table.setHalignment(startNodeHead, HPos.CENTER);
		
		Label endNodeHead = new Label();
		endNodeHead.setText("Endknoten");
		this.table.add(endNodeHead, 1, 0);
		this.table.setHalignment(endNodeHead, HPos.CENTER);
		
		Label lenghtHead = new Label();
		lenghtHead.setText("Länge");
		this.table.add(lenghtHead, 2, 0);
		this.table.setHalignment(lenghtHead, HPos.CENTER);
		
		
		Label startNodeContent;
		Label endNodeContent;
		Label lengthContent;
		Boolean lastEntry = true;
		for (int i = 0; i < this.graph.edges.length; i++) {
			if(this.graph.edges[i].getLengh()!=0) {
				startNodeContent = new Label();
				startNodeContent.setText(String.valueOf(this.graph.edges[i].getStartNode()));
				this.table.add(startNodeContent, 0, i+1);
				this.table.setHalignment(startNodeContent, HPos.CENTER);
								
				endNodeContent = new Label();
				endNodeContent.setText(String.valueOf(this.graph.edges[i].getEndNode()));
				this.table.add(endNodeContent, 1, i+1);
				this.table.setHalignment(endNodeContent, HPos.CENTER);
				
				lengthContent = new Label();
				lengthContent.setText(String.valueOf(this.graph.edges[i].getStartNode()));
				this.table.add(lengthContent, 2, i+1);
				this.table.setHalignment(lengthContent, HPos.CENTER);
			}
			else if(lastEntry==true) {
				startNodeContent = new Label();
				startNodeContent.setPrefWidth(100);
				this.table.add(startNodeContent, 0, i+1);
				this.table.setHalignment(startNodeContent, HPos.CENTER);
				
				endNodeContent = new Label();
				endNodeContent.setPrefWidth(100);
				this.table.add(endNodeContent, 1, i+1);
				this.table.setHalignment(endNodeContent, HPos.CENTER);
				
				lengthContent = new Label();
				lengthContent.setPrefWidth(100);
				this.table.add(lengthContent, 2, i+1);
				this.table.setHalignment(lengthContent, HPos.CENTER);
				
				lastEntry = false;
			}
		}
		
		
		this.setPrefSize(315, 500);
		
		this.setContent(this.table);
		
	}
	
	
}
