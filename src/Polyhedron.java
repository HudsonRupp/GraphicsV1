import java.awt.*;
import java.util.ArrayList;

public class Polyhedron {
    public Vertex[] vertices;
    public Color color;

    public Polyhedron(Vertex[] vertices, Color color) {
        this.vertices = vertices;
        this.color = color;
    }
    public void hide() {

    }
    public void show() {

        //method for drawing convex polyhedron
        //find closest point(s) and draw lines to them
        //options:
        // find the closest point(s) and draw lines to them. would bug out for certain edge cases ( long skinny rect),
        //can try to find the closest n points (how do we choose n)
        //  Draw triangles for every tuple of points, would be messy in the middle.


        //could calculate this based on # of points and then use array, too lazy rn
        ArrayList<Polygon> tris = new ArrayList<Polygon>();
        //option 1
        /*
        for (int i = 0; i < vertices.length-2; i++) {
            tris.add(new Polygon(new Vertex[]{vertices[i], vertices[i+1], vertices[i+2]}));
        }

         */
        //option 2
        //draw triangles for every vertex combination
        for (int i = 0; i < vertices.length; i++) {
            for (int j =0; j < vertices.length; j++) {
                for (int k = 0; k < vertices.length; k++) {
                    tris.add(new Polygon(new Vertex[]{vertices[i], vertices[j], vertices[k]}, this.color));
                }
            }
        }

        //option 3;
        /*
        for (int i = 0; i < vertices.length; i++) {
            Vertex cur = vertices[i];
            ArrayList<Vertex> closest = new ArrayList<>();
            double closestDistance;
            for (int j = 0; j < vertices.length; j++) {
                if (closest.size() == 2) {
                    break;
                }
                Vertex comp  = vertices[j];
                double distance = Math.abs(Math.sqrt(Math.pow((comp.x-cur.x), 2) + Math.pow((comp.y-cur.y), 2) + Math.pow((comp.z-cur.z), 2)));

            }
        }

         */
        for (Polygon tri : tris) {
            //System.out.println(tri);
            tri.show();
        }

    }
    public void move(Vertex v) {
        for (Vertex a : this.vertices) {
            a.x += v.x;
            a.y += v.y;
            a.z += v.z;
        }
    }
    public String toString() {
        return vertices[0].toString();
    }
}
