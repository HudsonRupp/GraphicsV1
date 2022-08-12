import java.awt.*;

public class Square  {
    public Vertex a, b, c, d;

    public Square(Vertex start, double len) {
        this.a = this.b = this.c = this.d = start;
        this.b.y += len;
        this.c.y += len;
        this.c.x += len;
        this.d.x += len;
    }
    public Square(Square another) {
        this.a = another.a;
        this.b = another.b;
        this.c = another.c;
        this.d = another.d;
    }

    public void show() {
        Canvas.drawLine2(Graphics.ProjectVertex(a), Graphics.ProjectVertex(b), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(b), Graphics.ProjectVertex(c), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(c), Graphics.ProjectVertex(d), new Color(255,0,0));
        Canvas.drawLine2(Graphics.ProjectVertex(d), Graphics.ProjectVertex(a), new Color(255,0,0));
    }
}
