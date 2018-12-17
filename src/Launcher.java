import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) throws Exception{
        launch();
        
	}
	

	
	
	public static void readFile(Graph graph, String fileName) throws Exception{

	    FileReader fr = new FileReader(new File(fileName));
	    BufferedReader br = new BufferedReader(fr);
	    String s = new String();
	    long start = 0;
	    long end = 0;
	    long lengh = 0;
	    int numberOfEdge = 0;
	    s = br.readLine();
		while (s!=null) {
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==32) {
					start = Long.valueOf(s.substring(0, i));
					s = s.substring(i+2);
					break;
				}	
			}
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==32) {
					end = Long.valueOf(s.substring(0, i));
					s = s.substring(i+2);
					break;
				}	
			}
	    	lengh = Long.valueOf(s);
	    	
	    	graph.edges[numberOfEdge] = new Edge(graph, start, end, lengh);
	    	numberOfEdge = numberOfEdge + 1;
	    	start = 0;
		    end = 0;
		    lengh = 0;
		    s = br.readLine();
		}
		
		
		
	}




	@Override
	public void start(Stage primaryStage) throws Exception {
		
		/* Code aus main-Methode */
		long timeStart = System.currentTimeMillis();
		Graph a = new Graph();
		
	    readFile(a, "Hoffmann.txt");
	    
	    //System.out.print(a);
	    
	    long timeEnd = System.currentTimeMillis();
        System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");
		/*Ende des original main-Methoden Quellcodes*/
        
        
        VBox menuAndContent = new VBox();	
		MenuBar menuBar = new ownMenuBar();        
        menuAndContent.getChildren().add(menuBar);
        HBox content = new HBox();
        
        GraphTable graphTable1 = new GraphTable(a);
        content.getChildren().add(graphTable1);
        
        Pane p = new Pane();
        p.setPrefSize(200, 500);
        content.getChildren().add(p);
        
        GraphTable graphTable2 = new GraphTable(a);
        content.getChildren().add(graphTable2);
        
		menuAndContent.getChildren().add(content);
		
		Scene s1 = new Scene(menuAndContent);
		
		primaryStage.setScene(s1);
		primaryStage.show();
		
		
	}
	
}
