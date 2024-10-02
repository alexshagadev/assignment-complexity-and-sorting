package shapes;

public class SquarePrism extends Prism
{
    public SquarePrism(double height, double side)
    {
        super(height, side);
    }

    /*
     * Calculates the base area of the square prism
     * @return the area as a double
     */
    @Override
    public double calcBaseArea()
    {
        return getSide() * getSide();
    }
}