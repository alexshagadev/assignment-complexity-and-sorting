package shapes;

public class Pyramid extends Prism {	
	public Pyramid(double height, double side) {
		super(height, side);
	}
	
	public double calcBaseArea() {
		return getSide() * getSide();
	}
	
	public double calcolume() {
		return (1 / 3) * calcBaseArea() * getHeight();
	}
}
