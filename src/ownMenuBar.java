import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class ownMenuBar extends MenuBar{
	
	
	ownMenuBar() {
		Menu graph = new Menu("Graph");
		MenuItem newGraph = new MenuItem("neuer Graph");
		graph.getItems().add(newGraph);
		MenuItem read = new MenuItem("Graph aus Datei einlesen");
		graph.getItems().add(read);
		MenuItem saveGraph1 = new MenuItem("Quellgraph speichern");
		graph.getItems().add(saveGraph1);
		MenuItem saveGraph2 = new MenuItem("MST speichern");
		graph.getItems().add(saveGraph2);
		
		
		this.getMenus().add(graph);
		
		
	}
	
	
}
