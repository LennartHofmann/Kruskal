import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class OwnFileSaver {

	
	public void safeGraph(Graph graph, File saveFile) throws Exception {
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
		String toWrite = new String();
		
		for (int i = 0; i < graph.edges.length; i++) {
			if(graph.edges[i].getLengh()!=0) {
				toWrite = String.valueOf(graph.edges[i].getStartNode());
				toWrite = toWrite + "  ";
				toWrite = toWrite + String.valueOf(graph.edges[i].getEndNode());
				toWrite = toWrite + "  ";
				toWrite = toWrite + String.valueOf(graph.edges[i].getLengh());
				System.out.println("zeile geschrieben");
				bw.write(toWrite);
				bw.newLine();
			}
			else {
				break;
			}
		}
		bw.flush();
		bw.close();
	}
	
	
	
}
