import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;

public class OwnMenuBar extends MenuBar{
	
	
	OwnMenuBar(OwnMenuBarController mbc, boolean activeMST) {
		
		Font textSize = new Font(15);
		
		Menu graph = new Menu("Graph");
		graph.setStyle("-fx-font-size: 15px");
		MenuItem newGraph = new MenuItem("neuer Graph");
		newGraph.setId("1");
		newGraph.setOnAction(mbc);
		graph.getItems().add(newGraph);
		MenuItem read = new MenuItem("Graph aus Datei einlesen");
		read.setId("2");
		read.setOnAction(mbc);
		graph.getItems().add(read);
		MenuItem saveGraph1 = new MenuItem("Quellgraph speichern");
		graph.getItems().add(saveGraph1);
		MenuItem saveGraph2 = new MenuItem("MST speichern");
		graph.getItems().add(saveGraph2);
		this.getMenus().add(graph);
		
		
		
		Menu mstMenu = new Menu("Minimal Spanning Tree");
		mstMenu.setStyle("-fx-font-size: 15px");
		if (activeMST==false) {
			MenuItem findMST = new MenuItem("MST finden (Kruskal)");
			findMST.setId("10");
			findMST.setOnAction(mbc);
			mstMenu.getItems().add(findMST);
		}
		else {
			MenuItem saveMST = new MenuItem("MST speichern");
			saveMST.setId("11");
			saveMST.setOnAction(mbc);
			mstMenu.getItems().add(saveMST);
		}
		this.getMenus().add(mstMenu);
		
		
		
		
		
	}
	
	
}
