import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.Button;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GraphTable extends ScrollPane {

	MenuAndContent mac;
	
	GridPane table;
	Graph graph;
	boolean isMST;
	Font textSize;
	GraphTableController gtc;
	
	TextField enterStartNode;
	TextField enterEndNode;
	TextField enterLength;
	
	Button[] delete;
	
	int numberOfRows = 0;
	
	public GraphTable(Graph graph, MenuAndContent mac, boolean isMST) {
		this.graph = graph;
		this.mac = mac;
		this.isMST = isMST;
		this.gtc = new GraphTableController(this);
		paint();
	}
	
	
	public void paint() {
		this.table = new GridPane();
		this.table.setGridLinesVisible(true);
		this.textSize = new Font(18);
		this.numberOfRows = 0;
		VBox content = new VBox();
		
		
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
				this.numberOfRows = this.numberOfRows + 1;
			}
			else {
				break;
			}
			
		}
		
		if (graph.isEditable==false) {
			this.setPrefSize(315, 500);
			this.disableHorizontalScrollBar();
			content.getChildren().add(this.table);	
		}
		if(graph.isEditable==true) {
			this.setPrefSize(365, 500);
			this.disableHorizontalScrollBar();
			
			this.delete = new Button[this.numberOfRows];
			for (int i = 0; i < this.numberOfRows; i++) {
					delete[i]  = new Button("X");
					delete[i].setId(String.valueOf(i));
					delete[i].setOnAction(gtc);
					delete[i].setPrefWidth(50);
					this.table.add(delete[i], 3, i+1);
			}
			
			content.getChildren().add(this.table);
			
			
			
			this.enterStartNode = new TextField();
			this.enterStartNode.setFont(textSize);
			this.enterStartNode.setMaxWidth(100);
			this.table.add(this.enterStartNode, 0, (this.graph.edges.length+1));
			
			this.enterEndNode = new TextField();
			this.enterEndNode.setFont(textSize);
			this.enterEndNode.setMaxWidth(100);
			this.table.add(this.enterEndNode, 1, (this.graph.edges.length+1));
			
			this.enterLength = new TextField();
			this.enterLength.setFont(textSize);
			this.enterLength.setMaxWidth(100);
			this.table.add(this.enterLength, 2, (this.graph.edges.length+1));
			
			Button addEdge = new Button("Kante hinzufügen");
			addEdge.setFont(textSize);
			addEdge.setId("add");
			addEdge.setOnAction(gtc);
			addEdge.setMaxWidth(350);
			content.getChildren().add(addEdge);
			
		}
		
		

		this.setContent(content);	
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
