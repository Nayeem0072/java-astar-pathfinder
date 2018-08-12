package adjacencylist;

public class Point implements Comparable<Point>{
	int x;
	int y;
	double costSoFar;

	public Point(int x, int y, double costSoFar) {
		this.x = x;
		this.y = y;
		this.costSoFar = costSoFar;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.costSoFar = 0.0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public double getCostSoFar() {
		return costSoFar;
	}
	public void setCostSoFar(double priority) {
		this.costSoFar = priority;
	}
	@Override
	public int compareTo(Point p1) {
		return (int)(this.costSoFar - p1.getCostSoFar());
	}	

	public static boolean comparePoints (Point p1, Point p2) {
		if (p1.getX() == p2.getX() && p1.getY() == p2.getY())
			return true;
		return false;
	}

	public static double getDistance (Point p1, Point p2) {
		return Math.hypot(p1.getX()-p2.getX(), p1.getY()-p2.getY());
	}
}