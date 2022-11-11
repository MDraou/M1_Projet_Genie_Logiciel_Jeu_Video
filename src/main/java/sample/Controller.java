package sample;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.beans.EventHandler;
import java.net.MalformedURLException;

public class Controller implements KeyListener {
      EventHandler eventHandler;
      Controller(PlayerController player) {

          this.eventHandler = (EventHandler) event -> {
              try {
                  switch () {
                      case KeyEvent.VK_UP:
                      case KeyEvent.VK_Z:
                          player.goNorth();
                          break;
                      case KeyEvent.VK_DOWN:
                      case KeyEvent.VK_S:
                          player.goSouth();
                          break;
                      case KeyEvent.VK_LEFT:
                      case KeyEvent.VK_Q:
                          player.goWest();
                          break;
                      case KeyEvent.VK_RIGHT:
                      case KeyEvent.VK_D:
                          player.goEast();
                          break;
                  }
              } catch (MalformedURLException exception) {
                  exception.printStackTrace();
              }
          };
      }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
