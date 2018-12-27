import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;

public class OwnMenuBar extends MenuBar{
	
	CheckMenuItem editGraph;
	
	OwnMenuBar(OwnMenuBarController mbc, boolean activeMST) {
		
		Font textSize = new Font(15);
		
		Menu graph = new Menu("Startgraph");
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
		saveGraph1.setId("3");
		saveGraph1.setOnAction(mbc);
		graph.getItems().add(saveGraph1);
		
		this.editGraph = new CheckMenuItem("Quellgraph editieren");
		this.editGraph.setId("4");
		this.editGraph.setOnAction(mbc);
		graph.getItems().add(this.editGraph);
		
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
