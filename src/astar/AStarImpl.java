package astar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import adjacencylist.Graph;
import adjacencylist.Point;

public class AStarImpl {
	private int heuristicManhattan(Point p1, Point p2) {
		return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
	}

	public ArrayList<Point> getNeighbors (ArrayList<ArrayList<Point>> adjList, Point curPoint){
		for(int i = 0; i < adjList.size(); i++) {
			if(Point.comparePoints(adjList.get(i).get(0), curPoint)){
				return adjList.get(i);
			}
		}
		return null;
	}

	public int aStarCostCalc(ArrayList<ArrayList<Point>> adjList, Point start, Point goal) {
		PriorityQueue<Point> openPoints = new PriorityQueue<>();
		HashMap<Point, Double> costSoFar =  new HashMap<Point, Double>();
		HashMap<Point, Point> cameFrom =  new HashMap<Point, Point>();

		openPoints.add(start);
		costSoFar.put(start, 0.0);
		cameFrom.put(start, start);

		while (!openPoints.isEmpty()){
			Point curPoint = openPoints.poll();
			if(Point.comparePoints(curPoint, goal)){
				reconstructPath(cameFrom, start, curPoint);
				break;
			}			
			ArrayList<Point> neighbors = getNeighbors(adjList, curPoint);
			for (int i = 0; i < neighbors.size(); i++) {
				Point neighbor = neighbors.get(i);
				if(!Point.comparePoints(curPoint, neighbor)){
					double fcost = costSoFar.get(curPoint) + Point.getDistance(curPoint, neighbor);
					if (!costSoFar.containsKey(neighbor) || fcost < costSoFar.get(neighbor)){
						costSoFar.put(neighbor, fcost);
						double priority = fcost + heuristicManhattan(neighbor, goal);
						neighbor.setFcost(priority);
						openPoints.add(neighbor);
						cameFrom.put(neighbor, curPoint);
					}
				}
			}
		}		
		return 0;
	}
		
	public void reconstructPath(HashMap<Point, Point> cameFrom, Point start,Point current){
		ArrayList<Point> finalPath = new ArrayList<>();
		finalPath.add(current);
		
		while (cameFrom.containsKey(current)){
			current = cameFrom.get(current);			
			finalPath.add(current);
			if(Point.comparePoints(current, start)){
				break;
			}
		}
		
		System.out.println("Final Path: ");
		for (int i = finalPath.size() - 1; i >= 0; i--) {
			System.out.print( "(" + finalPath.get(i).getX() + ", " + finalPath.get(i).getY() + ")");
			if(i != 0){
				System.out.print("<->");
			}
		}
	}
	
	public void testGraph(){
		Graph g = new Graph();
		g.createGraph();
		g.printGraph();
		ArrayList<ArrayList<Point>> arr = g.getGraph();

		aStarCostCalc(arr, new Point(0, 0), new Point(1, 2));



	}

}
