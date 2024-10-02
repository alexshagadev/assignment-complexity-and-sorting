package shapes;

public class Cylinder extends Prism {
	public Cylinder(double height, double side) {
		super(height, side);
	}
	
	public double calcBaseArea() {
		return Math.PI * getSide() * getSide();
	}
}