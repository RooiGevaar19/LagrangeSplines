public class Entry {
	private int id;
	private double x;
	private double y;
	private double height;

	public Entry() {

	}

	public Entry(double ax, double ay) {
		this.x = ax;
		this.y = ay;
	}

	public Entry(double ax, double ay, double ac) {
		this.x = ax;
		this.y = ay;
		this.height = ac;
	}

	public double getID() {
		return this.id;
	}

	public void setID(double a) {
		this.id = a;
	}

	public double getX() {
		return this.x;
	} 

	public void setX(double a) {
		this.x = a;
	}

	public double getY() {
		return this.y;
	} 

	public void setY(double a) {
		this.y = a;
	}

	public double getHeight() {
		return this.height;
	} 

	public void setHeight(double a) {
		this.height = a;
	}
}