public class Vertex {
    public double x, y, z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public Vertex(Vertex another) {
        this.x = another.x;
        this.y = another.y;
        this.z = another.z;
    }
    public boolean equals(Vertex another) {
        return this.x == another.x && this.y == another.y && this.z == another.z;
    }

    public String toString() {
        return x + " " + y + " " + z;
    }
}
