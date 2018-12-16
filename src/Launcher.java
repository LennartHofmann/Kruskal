import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	    
	    System.out.print(a);
	    
	    long timeEnd = System.currentTimeMillis();
        System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");
		
		
        HBox p = new HBox();		

        timeStart = System.currentTimeMillis();
        GraphTable graphTable1 = new GraphTable(a);
        timeEnd = System.currentTimeMillis();
        System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");
		
        
		p.getChildren().add(graphTable1);
		
		Scene s1 = new Scene(p);
		
		primaryStage.setScene(s1);
		primaryStage.show();
		
		
	}
	
}
