package shapes;

public class Pyramid extends Prism {	
	public Pyramid(double height, double side) {
		super(height, side);
	}
	
	public double calcBaseArea() {
		return getSide() * getSide();
	}
	
	@Override
	public double calcVolume() {
		return (1 / 3.0) * calcBaseArea() * getHeight();
	}
}