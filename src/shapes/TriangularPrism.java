package shapes;

public class TriangularPrism extends Prism {
	
    public TriangularPrism(double height, double side) {
        super(height, side);  
    }

    /*
     * Calculates the base area of the triangular prism
     * @return the area as a double
     */
    @Override
    public double calcBaseArea() {
    	// Math.pow is too slow lol
        return (getSide() * getSide() * Math.sqrt(3)) / 4;
    }
}
