package shapes;

public class Cone
{
	protected double height;
	protected double radius;
	
	public Cone(double height, double radius) {
		this.radius = radius;
		this.height = height;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getBaseArea() {
		return Math.PI * radius * radius;
	}

}
