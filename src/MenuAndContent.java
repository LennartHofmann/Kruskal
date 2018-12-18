import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuAndContent extends VBox{

	OwnMenuBar omb;
	OwnMenuBarController ombc;
	GraphTable graphTable1;
	GraphTable graphTable2;
	GridPane content;
	GraphHead graphTable2Head;
	Stage stage;
	
	public MenuAndContent(Graph graph1, Graph mst, Stage stage) {
		this.stage = stage;
		
		this.ombc = new OwnMenuBarController(this);
		this.omb = new OwnMenuBar(this.ombc, false);
				
		this.getChildren().add(omb);
	     
	    this.content = new GridPane();
	     
	    long timeStart = System.currentTimeMillis();
	     
	    GraphHead graphTable1Head = new GraphHead("Startgraph");
	    this.content.add(graphTable1Head, 0, 0);
	    StackPane emptyPane = new StackPane();
	    
	    this.graphTable2Head = new GraphHead("Minimal Spanning Tree");
	    //this.content.add(this.graphTable2Head, 1, 0);
	    
	    
	    this.graphTable1 = new GraphTable(graph1, false);
	    this.content.add(this.graphTable1, 0, 1);
	    
	     
	    //this.graphTable2 = new GraphTable(new Graph(), true);
	    //this.content.add(this.graphTable2, 1, 1);
	     
	    long timeEnd = System.currentTimeMillis();
	     
	    System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");
	     
		this.getChildren().add(content);
		this.stage.sizeToScene();
	}
	
	public MenuAndContent(Stage s) {
		this(new Graph(), new Graph(), s);
	}
	
	public MenuAndContent(Graph graph1, Stage s) {
		this(graph1, new Graph(), s);
	}
	
}
