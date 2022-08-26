import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;

public class CameraControl implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        //redo
        double yAng = 0;
        double xAng = 0;
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            yAng += 0.05;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            yAng -= 0.05;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xAng -= 0.05;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xAng += 0.05;
        }

        Vertex cameraMove = new Vertex(0, 0, 0);
        if (e.getKeyCode() == KeyEvent.VK_A) {
            cameraMove.x += 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            cameraMove.x -= 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            cameraMove.z -= 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            cameraMove.z += 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            cameraMove.y -= 0.1;
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {
            cameraMove.y += 0.1;
        }
        Graphics.translateVertices(cameraMove);
        Graphics.rotateY(yAng);
        Graphics.rotateX(xAng);

    }


    public void keyReleased(KeyEvent e) {

    }
}
