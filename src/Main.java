
import java.awt.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Timer;


public class Main {
    private static ArrayList<Polyhedron> onScreen = new ArrayList<>();
    public static void main(String args[]) {
        //ArrayList<Polyhedron> onScreen = new ArrayList<>();
        int width = 1000;
        int height = 1000;
        Color ln = new Color(0,0,0);
        new Canvas(width,height, new Color(255,255,255));
        double[][] ico = new double[][]{{0.85065081,   0.52573111,     0.00000000,},
                {0.85065081,-0.52573111,0.00000000},
                {0.52573111,0.00000000,0.85065081},
                {0.52573111,0.00000000,-0.85065081},
                {0.00000000,0.85065081,0.52573111},
                {0.00000000,0.85065081,-0.52573111},
                {0.00000000,-0.85065081,0.52573111},
                {0.00000000,-0.85065081,-0.52573111},
                {-0.52573111,0.00000000,0.85065081},
                {-0.52573111,0.00000000,-0.85065081},
                {-0.85065081,0.52573111,0.00000000},
                {-0.85065081,-0.52573111,0.00000000}};
        double[][] octahedron = new double[][]{
                {.5,2,6},
                {-.5,3,6},
                {-.5,2,7},
                {-1.5,2,6},
                {-.5,1,6},
                {-.5,2,5}
        };
        double[][] cube = new double[][]{{-2, -0.5, 5},
                {-2,  0.5, 5},
                {-1,  0.5, 5},
                {-1, -0.5, 5},
                {-2, -0.5, 6},
                {-2,  0.5, 6},
                {-1,  0.5, 6},
                {-1, -0.5, 6}};
        for(int i = 0; i < ico.length; i++) {
            ico[i][2] += 6;
            ico[i][0] += 1;
        }
        add(cube);
        add(ico);
        add(octahedron);
        long startTime = System.currentTimeMillis();

        while (true) {
            long currentTime = (System.currentTimeMillis() - startTime) / 1000;

            //movement
            if (currentTime % 3 <= 1) {
                onScreen.get(0).move(new Vertex(0, 0.01, 0));
                onScreen.get(1).move(new Vertex(0.01, 0, 0));
                onScreen.get(2).move(new Vertex(0, 0, 0.01));
            } else {
                onScreen.get(0).move(new Vertex(0, -0.02, 0));
                onScreen.get(1).move(new Vertex(-0.02, 0, 0));
                onScreen.get(2).move(new Vertex(0, 0, -0.02));
            }


            for (Polyhedron p : onScreen) {
                p.show();
            }
            Canvas.doFrame();
        }
    }
    public static void add(double[][] coords) {
        Vertex[] vertices = new Vertex[coords.length];
        for (int r=0; r < coords.length; r++) {
            vertices[r] = new Vertex(coords[r][0], coords[r][1], coords[r][2]);
        }
        Polyhedron poly = new Polyhedron(vertices, new Color(0,0,0));
        Graphics.polyhedra.add(poly);
        onScreen.add(poly);
    }


    public static Vertex[] doubleToVertex(double[][] coords) {
        Vertex[] ret = new Vertex[coords.length];
        for (int r = 0; r < coords.length; r++) {
            ret[r] = new Vertex(coords[r][0], coords[r][1], coords[r][2]);
        }
        return ret;
    }
    //doesnt work
    private static int[][] demo(int w, int h) {
        // 1000 x 1000 screen or breaks
        int[][] ra = new int[h][w];
        for (int row = 0; row < h; row ++) {
            for (int col = 0; col < w; col++) {

                ra[row][col] = new Color(row / 4, col / 4, 255 - ((row + col) / 8)).getRGB();
            }
        }
        return ra;
    }
}
