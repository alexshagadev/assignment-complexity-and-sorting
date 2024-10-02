package shapes;

public class Cone extends Prism {
	public Cone(double height, double side){
		super(height, side);
	}
	
	public double calcBaseArea() {
		return Math.PI * getSide() * getSide();
	}
	
	public double calcVolume() {
		return (1 / 3) * calcBaseArea() * getHeight();
	}
}