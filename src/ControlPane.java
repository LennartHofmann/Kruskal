import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ControlPane extends StackPane{

	public ControlPane() {
		
		VBox content = new VBox();
		
		
		//this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 1, 0, 1))));
	    this.setPrefSize(250, 500);
	    
	    Button mst = new Button();
	    mst.setFont(new Font(15));
	    mst.setText("Minimal Spanning Tree finden!");
	    mst.setPrefWidth(250);
	    content.getChildren().add(mst);
	    this.getChildren().add(content);
	    
	    	    
	    
	}
	
	
}
