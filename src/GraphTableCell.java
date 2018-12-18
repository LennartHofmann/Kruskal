import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class GraphTableCell extends StackPane{

	public GraphTableCell(String content, Font textSize) {
		this.setPrefWidth(100);
		Label text = new Label();
		text.setText(content);
		text.setFont(textSize);
		this.getChildren().add(text);
	}
	
}
