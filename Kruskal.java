import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        /* Fill this method (The statement return null is here only to compile) */

	// preparing stuff we need
        WGraph result = new WGraph();
	ArrayList<Edge> sortEdges = g.listOfEdgesSorted();
	DisjointSets dSets = new DisjointSets(g.getNbNodes());

	// actual algorithm to go over the edges and add it if safe to do so
	for(int i=0 ; i < sortEdges.size() ; i++){
    		if(IsSafe(dSets,sortEdges.get(i))){
    			dSets.union(sortEdges.get(i).nodes[0], sortEdges.get(i).nodes[1]);
    			result.addEdge(sortEdges.get(i));
    		}
	}

        return result;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){

        /* Fill this method (The statement return 0 is here only to compile) */
        
	// not safe if already in the same set
	if ( p.find(e.nodes[0]) == p.find(e.nodes[1]) ) {
            return false;
        }
	// otherwise, its safe
        else {
            return true;
        }
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
