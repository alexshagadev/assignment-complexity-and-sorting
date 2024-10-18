package shapes;

public abstract class Prism implements Comparable<Prism> {
    protected double height; // Height of prism
    protected double side; // Base side length

    public Prism(double height, double side) {
        this.height = height;
        this.side = side;
    }

    public double getHeight() {
        return height;
    }
    
    public double getSide() {
        return side; 
    }
    
    public abstract double calcBaseArea();
    
    // Volume is the same for each prism, so we'll just implement it here.
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

    // Shapes will be compared by height by default (aka natural order)
    @Override
    public int compareTo(Prism other) {
        if (this.getHeight() > other.getHeight()) {
        	return 1; 
        } else if (this.getHeight() < other.getHeight()) {
        	return -1;
        } else {
        	return 0;
        }
    }

    public static class BaseAreaComparator implements java.util.Comparator<Prism> {
        @Override
        public int compare(Prism p1, Prism p2) {
            if (p1.calcBaseArea() > p2.calcBaseArea()) {
                return 1;
            } else if (p1.calcBaseArea() < p2.calcBaseArea()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static class VolumeComparator implements java.util.Comparator<Prism> {
        @Override
        public int compare(Prism p1, Prism p2) {
            if (p1.calcVolume() > p2.calcVolume()) {
                return 1;
            } else if (p1.calcVolume() < p2.calcVolume()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
