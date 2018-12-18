
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class GraphHead extends StackPane{

	public GraphHead(String text) {
		
		Label graphHeadText = new Label();
		graphHeadText.setText(text);
		graphHeadText.setFont(new Font(25));
		
		this.getChildren().add(graphHeadText);
		
		this.setPrefWidth(315);
		
		
	}
	
}
