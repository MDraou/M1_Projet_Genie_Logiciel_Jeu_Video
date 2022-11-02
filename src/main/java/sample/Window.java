package sample;

import java.io.Serial;
import javax.swing.*;


/**
 * An extended version of javax.swing.JFrame containing a panel to draw images.
 */
public class Window extends JFrame {

  @Serial
  private static final long serialVersionUID = 42L;

  /**
   * Constructs a new visible frame.
   */
  public Window(String name, int width, int height) {
    setTitle(name);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void start() {
    setVisible(true);
  }

  public static void main(String[] args) {
    Window window = new Window("Penguin", 500, 500);
    window.add(new Panel());
    window.start();
  }
}