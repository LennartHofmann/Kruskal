import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class OwnMenuBarController implements EventHandler<javafx.event.ActionEvent> {

	OwnFileReader owr;
	MenuAndContent mac;
	
	public OwnMenuBarController(MenuAndContent mac) {
		this.mac = mac;
	}
	
	@Override
	public void handle(ActionEvent event){
		
				
		if(event.getSource() instanceof MenuItem) {
			if (((MenuItem) event.getSource()).getId()=="1") {
				this.mac.content.getChildren().remove(this.mac.graphTable1);
				this.mac.graphTable1 = new GraphTable(new Graph(), false);
				this.mac.content.add(this.mac.graphTable1, 0, 1);
				
				this.mac.content.getChildren().remove(this.mac.graphTable2Head);
				this.mac.content.getChildren().remove(this.mac.graphTable2);
				this.mac.stage.sizeToScene();
				
			}
			else if (((MenuItem) event.getSource()).getId()=="2") {
				FileChooser fc = new FileChooser();
				fc.setInitialDirectory(new File("D:\\Programmierung\\Kruskal"));
				File graphFile = fc.showOpenDialog(null);
				owr = new OwnFileReader();
				
				try {
					this.mac.content.getChildren().remove(this.mac.graphTable1);
					this.mac.graphTable1 = new GraphTable(owr.readFile(graphFile), false);
					this.mac.content.add(this.mac.graphTable1, 0, 1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			
			else if (((MenuItem) event.getSource()).getId()=="10") {
				this.mac.getChildren().remove(this.mac.omb);
				this.mac.getChildren().remove(this.mac.content);
				this.mac.omb = new OwnMenuBar(this, true);				
				this.mac.getChildren().add(this.mac.omb);
				this.mac.getChildren().add(this.mac.content);
				
			}
			
			
			
			
		}
		
	}

	
	
}
