public class Quadrilateral {

    double[] points = new double[4];

    public Quadrilateral(double[] points) {
        this.points = points;
    }

    public double[] getPoints() {
        return points;
    }

    public String determineShape(double[] points) {
        String shape = "Rectangle";
        return shape;
    }
}
