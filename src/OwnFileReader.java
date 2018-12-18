import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class OwnFileReader {

	public Graph readFile(File graphfile) throws Exception{
		Graph graph = new Graph();
		
		BufferedReader br = new BufferedReader(new FileReader(graphfile));
		
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
		
		graph.setEditable(false);
		return graph;
	
	}
}