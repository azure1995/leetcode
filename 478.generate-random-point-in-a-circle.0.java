class Solution {
    Random rand;
    double radius;
    double x_center;
    double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.rand = new Random();
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double randRadius = Math.sqrt(rand.nextDouble()) * radius;
        double randAngle = rand.nextDouble() * 2 * Math.PI;
        double x = x_center + randRadius * Math.cos(randAngle);
        double y = y_center + randRadius * Math.sin(randAngle);
        return new double[] { x, y };
    }
}