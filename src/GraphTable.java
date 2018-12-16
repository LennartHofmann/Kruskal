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
		
		this.table.add(new Text(" Endknoten "), 1, 0);
		this.table.add(new Text(" Länge "), 2, 0);
		
		Label startNodeHead = new Label();
		startNodeHead.setText("Startknoten");
		this.table.add(startNodeHead, 0, 0);
		this.table.setHalignment(startNodeHead, HPos.CENTER);
		
		
		
		for (int i = 0; i < this.graph.edges.length; i++) {
			if(this.graph.edges[i].getLengh()!=0) {
				
				Label start = new Label();
				start.setText(String.valueOf(this.graph.edges[i].getStartNode()));
				this.table.add(start, 0, i+1);
				this.table.setHalignment(start, HPos.CENTER);
				
				this.table.add(new Text(String.valueOf(this.graph.edges[i].getEndNode())), 1, i+1);
				this.table.add(new Text(String.valueOf(this.graph.edges[i].getLengh())), 2, i+1);
			}
		}
		
		Label p = new Label();
		p.setPrefWidth(200);
		this.table.add(p, 0, (this.graph.edges.length+1));
		
		this.setPrefSize(300, 300);
		
		this.setContent(this.table);
		
	}
	
	
}
