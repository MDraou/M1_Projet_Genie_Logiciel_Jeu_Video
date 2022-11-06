package graphic;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {

  public Window(int width, int height, String title) {
    setTitle(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void start() {
    setVisible(true);
  }

  @Override
  public Component add(Component component, int index) {
    super.add(component, index);
    super.validate();
    return component;
  }
}
