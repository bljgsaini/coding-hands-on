package graph;

public class HamiltonCycle {

	public static void main(String[] args) {
		int graph1[][] = {{0, 1, 0, 1, 0},
	            {1, 0, 1, 1, 1},
	            {0, 1, 0, 0, 1},
	            {1, 1, 0, 0, 1},
	            {0, 1, 1, 1, 0},
	        };
		
		hamCycle(graph1);
		
		int graph2[][] = {{0, 1, 0, 1, 0},
	            {1, 0, 1, 1, 1},
	            {0, 1, 0, 0, 1},
	            {1, 1, 0, 0, 0},
	            {0, 1, 1, 0, 0},
	        };
		
		hamCycle(graph2);

	}
	
	
	public static void hamCycle(int graph[][]) {
		
		int v = graph.length;
		
		int path[] = new int[v];
		
		for(int i=0; i<v; i++) {
			path[i] = -1;
		}
		
		path[0] = 0;
		
		if(hasHamCycle(graph, path, 1)) {
			System.out.println("Graph has hamilton cycle : Path is = ");
			for(int i=0; i<v; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println();
		}else {
			System.out.println("Graph doesn't have hamilton cycle");
		}
		
	}
	
	
	
	public static boolean hasHamCycle(int graph[][], int path[], int pos) {
		int v = graph.length;
		if(pos == v) {
			if(graph[path[pos-1]][path[0]] == 1) {
				return true;
			}else {
				return false;
			}
		}
		for(int i=0; i<v; i++) {
			if(isSafe(i, graph, path, pos)) {
				path[pos] = i;
				if(hasHamCycle(graph, path, pos+1 )) {
					return true;
				}
				path[pos] = -1;	
			}			
		}

		return false;
	}
	
	
	public static boolean isSafe(int node, int graph[][], int path[], int pos) {
		
		if(graph[path[pos-1]][node] == 0) {
			return false;
		}
		
		for(int i=0; i<pos; i++) {
			if(path[i] == node) {
				return false;
			}
		}
		return true;	
	}
	
}
