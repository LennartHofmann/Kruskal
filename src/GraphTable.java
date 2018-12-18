import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GraphTable extends ScrollPane {

	GridPane table;
	Graph graph;
	Font textSize;
	
	public GraphTable(Graph graph, boolean isMST) {
		this.graph = graph;
		
		this.table = new GridPane();
		this.table.setGridLinesVisible(true);
		
		this.textSize = new Font(18);
		
		GraphTableCell startNodeHead = new GraphTableCell("Startknoten", this.textSize);
		this.table.add(startNodeHead, 0, 0);
		
		GraphTableCell endNodeHead = new GraphTableCell("Endknoten", this.textSize);
		this.table.add(endNodeHead, 1, 0);
		
		GraphTableCell lengthHead = new GraphTableCell("Länge", this.textSize);
		this.table.add(lengthHead, 2, 0);
		
		
		GraphTableCell startNodeContent;
		GraphTableCell endNodeContent;
		GraphTableCell lengthContent;
		for (int i = 0; i < this.graph.edges.length; i++) {
			if(this.graph.edges[i].getLengh()!=0) {
				startNodeContent = new GraphTableCell(String.valueOf(this.graph.edges[i].getStartNode()), this.textSize);
				this.table.add(startNodeContent, 0, i+1);
								
				endNodeContent = new GraphTableCell(String.valueOf(this.graph.edges[i].getEndNode()), this.textSize);
				this.table.add(endNodeContent, 1, i+1);
				
				lengthContent = new GraphTableCell(String.valueOf(this.graph.edges[i].getLengh()), this.textSize);
				this.table.add(lengthContent, 2, i+1);
			}
			
		}
		
	
		if(graph.isEditable==true) {
			TextField enterStartNode = new TextField();
			enterStartNode.setFont(textSize);
			enterStartNode.setMaxWidth(100);
			this.table.add(enterStartNode, 0, (this.graph.edges.length+1));
			
			TextField enterEndNode = new TextField();
			enterEndNode.setFont(textSize);
			enterEndNode.setMaxWidth(100);
			this.table.add(enterEndNode, 1, (this.graph.edges.length+1));
			
			TextField enterLength = new TextField();
			enterLength.setFont(textSize);
			enterLength.setMaxWidth(100);
			this.table.add(enterLength, 2, (this.graph.edges.length+1));
			
		}
		
		
		this.setPrefSize(315, 500);
		this.disableHorizontalScrollBar();
		
				
		this.setContent(this.table);	
	}
	
	
	
	
	void disableHorizontalScrollBar() {
		this.addEventFilter(ScrollEvent.SCROLL,new EventHandler<ScrollEvent>() {
	        @Override
	        public void handle(ScrollEvent event) {
	            if (event.getDeltaX() != 0) {
	                event.consume();
	            }
	        }
	    });
	}
	
}
