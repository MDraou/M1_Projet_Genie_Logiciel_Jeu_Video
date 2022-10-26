package graphic;

import java.io.Serial;
import javax.swing.JFrame;

public class Window extends JFrame {

  @Serial
  private static final long serialVersionUID = 42L;

  public Window(int width, int height, String title) {
    setTitle(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void start() {
    setVisible(true);
  }

  public void add(GraphicEntity entity) {
  }

  public static void main(String[] args) {
    new Window(400, 400, "Game").start();
  }
}
