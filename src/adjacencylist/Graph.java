package adjacencylist;

import java.util.ArrayList;

public class Graph {
	int vertex;
	ArrayList<ArrayList<Point>> adjList;

	public Graph(int v) {
		vertex = v;
		adjList = new ArrayList<ArrayList<Point>>();
	}

	public void addEdge(Point p1, Point p2) {
		boolean p1NotFound = true;
		boolean p2NotFound = true;
		for (ArrayList<Point> arrList : adjList) {
			if(arrList.size() > 0){
				Point p = arrList.get(0);
				if(Point.comparePoints(p, p1)){
					arrList.add(p2);
					p1NotFound = false;
				}
				else if(Point.comparePoints(p, p2)){
					arrList.add(p1);
					p2NotFound = false;
				}				
			}
		}
		if(p1NotFound) {					
			ArrayList<Point> a1 = new ArrayList<>();
			a1.add(p1);
			a1.add(p2);
			adjList.add(a1);			
		}
		if(p2NotFound) {
			ArrayList<Point> a2 = new ArrayList<>();
			a2.add(p2);
			a2.add(p1);
			adjList.add(a2);			
		}
		p1NotFound = true;
		p2NotFound = true;
	}

	public void printGraph() {
		for(int i = 0; i < adjList.size(); i++) {
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print( "(" + adjList.get(i).get(j).getX() + ", " + adjList.get(i).get(j).getY() + ")");
				if(j < adjList.get(i).size() - 1){
					System.out.print("->");
				}
			}
			System.out.println("\n");
		}
	}

	public void createGraph(){
		// old graph
//		addEdge(new Point(0,0,0.0), new Point(0, 1, 0.0));
//		addEdge(new Point(0,1,0.0), new Point(0, 2, 0.0));
//		addEdge(new Point(0,1,0.0), new Point(0, 3, 0.0));
		
		
		// new graph
		addEdge(new Point(0,0), new Point(1, 0));
		addEdge(new Point(1,0), new Point(2, 0));
		addEdge(new Point(2,0), new Point(2, 1));
		addEdge(new Point(2,1), new Point(2, 2));
		addEdge(new Point(2,2), new Point(1, 2));
//		addEdge(new Point(1,0), new Point(1, 2));
		addEdge(new Point(1,0), new Point(2, 1));
		addEdge(new Point(1,2), new Point(2, 1));
		
	}

	public ArrayList<ArrayList<Point>> getGraph(){
		return adjList;
	}

	public void test() {
		addEdge(new Point(0,0,0.0), new Point(0, 1, 0.0));
		addEdge(new Point(0,1,0.0), new Point(0, 2, 0.0));
		addEdge(new Point(0,1,0.0), new Point(0, 3, 0.0));

		printGraph();
	}
}
