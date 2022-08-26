import java.awt.*;
import java.util.ArrayList;

public class Polygon {
    public Vertex[] vertices;
    public Color color;

    public Polygon(Vertex[] vertices, Color color) {
        this.vertices = vertices;
        this.color = color;
    }
    public Polygon(Vertex[] vertices) {
        this.vertices = vertices;
        this.color = new Color(255, 0, 0);
    }
    public void show() {

        for(int i = 1; i < vertices.length; i++) {
            Canvas.drawLine(Graphics.ProjectVertex(vertices[i-1]), Graphics.ProjectVertex(vertices[i]), this.color);
        }
        Canvas.drawLine(Graphics.ProjectVertex(vertices[vertices.length-1]), Graphics.ProjectVertex(vertices[0]), this.color);

    }

    public String toString() {
        String r = "Polygon Coordinates-------\n";
        for(Vertex v : this.vertices) {
            r += v + "\n";
        }
        return r;
    }
}
