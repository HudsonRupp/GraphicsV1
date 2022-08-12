import java.awt.*;

public class Triangle {
    public Vertex a, b, c;

    public Triangle(Vertex a, Vertex b, Vertex c) {
        this.a = a;
        this.b = b;
        this.c = c;
        Canvas.drawLine2(Graphics.ProjectVertex(a), Graphics.ProjectVertex(b), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(b), Graphics.ProjectVertex(c), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(c), Graphics.ProjectVertex(a), new Color(255,0,0));
    }

    public void show() {
        Canvas.drawLine2(Graphics.ProjectVertex(a), Graphics.ProjectVertex(b), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(b), Graphics.ProjectVertex(c), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(c), Graphics.ProjectVertex(a), new Color(255,0,0));
    }
}
