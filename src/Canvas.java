
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.*;


public class Canvas {
    public static int[][] pixels;
    public static int width;
    public static int height;
    public static Color bkgCol;
    private static JFrame frame;
    private static JLabel label;

    public Canvas(int width, int height, Color bkgCol) {
        pixels = new int[width][height];
        Canvas.width = width;
        Canvas.height = height;
        Canvas.bkgCol = bkgCol;
        frame=new JFrame();
        frame.addKeyListener(new CameraControl());
        frame.setTitle("GRAPHICS");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        label=new JLabel();
        label.setIcon(new ImageIcon(arrayToImage(width, height, pixels)));
        frame.getContentPane().add(label,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void drawPoint(int x, int y, Color color) {
        //translate origin to middle

        x += width/2;
        y = (height - y) - height/2;

        if (x >= width || y >= height || x <= 0 || y <= 0) {
            return;
        }
        pixels[y][x] = color.getRGB();
    }
    public static void drawLine(int[] p1, int[] p2, Color color) {
        //https://en.wikipedia.org/wiki/Digital_differential_analyzer_(graphics_algorithm)
        float dx = p2[0]-p1[0];
        float dy = p2[1]-p1[1];
        float step, x, y;
        int i;
        step = Math.max(abs(dx), abs(dy));
        dx = dx / step;
        dy = dy / step;
        x = p1[0];
        y = p1[1];
        i = 1;
        while (i <= step) {
            drawPoint((int) x,(int) y, color);
            x = x + dx;
            y = y + dy;
            i++;
        }
    }
    public static void doFrame(){
        Image image = arrayToImage(width, height, pixels);

        label.setIcon(new ImageIcon(image));

        for (int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[0].length; j++) {
                pixels[i][j] =  bkgCol.getRGB();
            }
        }
    }

    private static BufferedImage arrayToImage(int width, int height, int[][] colors) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, colors[y][x]);
            }
        }
        return image;
    }

}
