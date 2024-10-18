package shapes;

public class PentagonalPrism extends Prism {

    public PentagonalPrism(double height, double side) {
        super(height, side); 
    }

    /*
     * Calculates the base area of the pentagonal prism
     * @return the area as a double
     */
    @Override
    public double calcBaseArea() {
    	return (5 * getSide() * getSide() * Math.tan(Math.toRadians(54))) / 4;
    }
}
