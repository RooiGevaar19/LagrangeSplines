public class Entry {
	private int id;
	private double distance;
	private double height;

	public Entry() {

	}

	public Entry(double dist) {
		this.distance = dist;
	}

	public Entry(double dist, double high) {
		this.distance = dist;
		this.height = high;
	}

	public Entry(int id1, double dist, double high) {
		this.id = id1;
		this.distance = dist;
		this.height = high;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int a) {
		this.id = a;
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double a) {
		this.distance = a;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double a) {
		this.height = a;
	}
}
