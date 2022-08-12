
import java.awt.*;


public class Main {
    public static void main(String args[]) {
        int width = 1000;
        int height = 1000;
        Color ln = new Color(255,0,0);
        Canvas c = new Canvas(width,height, new Color(0,0,0));
        Tetrahedron t1 = new Tetrahedron(new Vertex(1, 1, 5), 1.0);
        t1.show();
        Tetrahedron tri = new Tetrahedron(new Vertex(2,0,5), new Vertex(1,0,3), new Vertex(1.5,-0.5,4), new Vertex(1.5,-0.25,6));
        tri.show();
        /*
        for (int i = 0; i < 100; i++) {
            c.drawLine((int) (Math.random() * width), (int) (Math.random() * height), (int) (Math.random() * width), (int) (Math.random() * height), new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
        }
        */

        //c.pixels = demo(width, height);
        // The four "front" vertices
        double[] vAf = {-2, -0.5, 5};
        double[] vBf = {-2,  0.5, 5};
        double[] vCf = {-1,  0.5, 5};
        double[] vDf = {-1, -0.5, 5};

// The four "back" vertices
        double[] vAb = {-2, -0.5, 6};
        double[] vBb = {-2,  0.5, 6};
        double[] vCb = {-1,  0.5, 6};
        double[] vDb = {-1, -0.5, 6};

// The front face
        c.drawLine2(ProjectVertex(vAf), ProjectVertex(vBf), ln);
        c.drawLine2(ProjectVertex(vBf), ProjectVertex(vCf), ln);
        c.drawLine2(ProjectVertex(vCf), ProjectVertex(vDf), ln);
        c.drawLine2(ProjectVertex(vDf), ProjectVertex(vAf), ln);

// The back face
        c.drawLine2(ProjectVertex(vAb), ProjectVertex(vBb), ln);
        c.drawLine2(ProjectVertex(vBb), ProjectVertex(vCb), ln);
        c.drawLine2(ProjectVertex(vCb), ProjectVertex(vDb), ln);
        c.drawLine2(ProjectVertex(vDb), ProjectVertex(vAb), ln);

// The front-to-back edges
        c.drawLine2(ProjectVertex(vAf), ProjectVertex(vAb), ln);
        c.drawLine2(ProjectVertex(vBf), ProjectVertex(vBb), ln);
        c.drawLine2(ProjectVertex(vCf), ProjectVertex(vCb), ln);
        c.drawLine2(ProjectVertex(vDf), ProjectVertex(vDb), ln);



        c.display();

    }
    public static int[] vtc(double x, double y) {
        int[] r = {(int) (x * 1000),(int) (y * 1000)};
        return r;
    }

    public static int[] ProjectVertex(double[] cord) {
        return vtc(cord[0] / cord[2], cord[1] / cord[2]);
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
    /*
    public static BufferedImage getImageFromArray(int[] pixels, int width, int height) {
        BufferedImage image = new BufferedImage(width, height,     BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0,0,width,height,pixels);
        image.setData(raster);
        return image;
    }
    */

}
