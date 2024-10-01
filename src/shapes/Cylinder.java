package shapes;

public class Cylinder
{
	protected double radius;
	protected double height;
	
	public Cylinder(double height, double radius) {
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
	
	public double getVolume() {
		return getBaseArea() * height;
	}

}
