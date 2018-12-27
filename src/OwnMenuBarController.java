import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class OwnMenuBarController implements EventHandler<javafx.event.ActionEvent> {

	OwnFileReader owr;
	OwnFileSaver ofs;
	MenuAndContent mac;
	
	public OwnMenuBarController(MenuAndContent mac) {
		this.mac = mac;
	}
	
	@Override
	public void handle(ActionEvent event){
		
				
		if(event.getSource() instanceof MenuItem) {
			if (((MenuItem) event.getSource()).getId()=="1") {
				this.mac.graphTable1.graph = new Graph();
				this.mac.graphTable1.paint();
								
				this.removeMST();
				this.mac.omb.editGraph.setSelected(false);		
				
			}
			else if (((MenuItem) event.getSource()).getId()=="2") {
				FileChooser fc = new FileChooser();
				fc.setInitialDirectory(new File("D:\\Programmierung\\Kruskal"));
				fc.getExtensionFilters().add(new ExtensionFilter("TXT files (*.txt)", "*.txt"));
				File graphFile = fc.showOpenDialog(null);
				this.owr = new OwnFileReader();
				
				try {
					this.mac.content.getChildren().remove(this.mac.graphTable1);
					this.mac.graphTable1 = new GraphTable(owr.readFile(graphFile), this.mac, false);
					this.mac.content.add(this.mac.graphTable1, 0, 1);


					this.removeMST();
					this.mac.omb.editGraph.setSelected(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			else if (((MenuItem) event.getSource()).getId()=="3") {
				FileChooser fc = new FileChooser();
				fc.setInitialDirectory(new File("D:\\Programmierung\\Kruskal"));
				fc.getExtensionFilters().add(new ExtensionFilter("TXT files (*.txt)", "*.txt"));
				File saveFile = fc.showOpenDialog(null);
				this.ofs = new OwnFileSaver();
				try {
					ofs.safeGraph(this.mac.graphTable1.graph, saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if (((MenuItem) event.getSource()).getId()=="4") {
				this.mac.graphTable1.graph.setEditable(this.mac.omb.editGraph.isSelected());
				this.mac.graphTable1.paint();
				
				this.removeMST();
				
			}
			else if (((MenuItem) event.getSource()).getId()=="10") {
				this.mac.getChildren().remove(this.mac.omb);
				this.mac.getChildren().remove(this.mac.content);
				this.mac.omb = new OwnMenuBar(this, true);				
				this.mac.getChildren().add(this.mac.omb);
				this.mac.getChildren().add(this.mac.content);
				
				this.mac.content.add(this.mac.graphTable2Head, 1, 0);
				
				//Graph mst = this.mac.graphTable1.graph.findMST()
				
				Graph  mst = this.mac.graphTable1.graph;
				
				this.mac.graphTable2 = new GraphTable(mst, this.mac, true);
				
				
				
				this.mac.content.add(this.mac.graphTable2, 1, 1);
				this.mac.stage.sizeToScene();
				
			}
			
			
			else if (((MenuItem) event.getSource()).getId()=="11") {
				FileChooser fc = new FileChooser();
				fc.setInitialDirectory(new File("D:\\Programmierung\\Kruskal"));
				fc.getExtensionFilters().add(new ExtensionFilter("TXT files (*.txt)", "*.txt"));
				File saveFile = fc.showOpenDialog(null);
				this.ofs = new OwnFileSaver();
				try {
					ofs.safeGraph(this.mac.graphTable2.graph, saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		}
		
	}

	
	public void removeMST() {
		try {
			this.mac.content.getChildren().remove(this.mac.graphTable2Head);
			this.mac.content.getChildren().remove(this.mac.graphTable2);
			
			this.mac.getChildren().remove(this.mac.omb);
			this.mac.getChildren().remove(this.mac.content);
			this.mac.omb = new OwnMenuBar(this, false);				
			this.mac.getChildren().add(this.mac.omb);
			this.mac.getChildren().add(this.mac.content);
			
			this.mac.stage.sizeToScene();
		} 
		catch (Exception e) {
		}
	}
	
	
}
