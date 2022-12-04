package gameplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private State state;

    public Controller(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int event = e.getKeyCode();
        switch (event) {
            case KeyEvent.VK_Z -> state.ZPressedAction();
            case KeyEvent.VK_S -> state.SPressedAction();
            case KeyEvent.VK_UP -> state.UpPressedAction();
            case KeyEvent.VK_DOWN -> state.DownPressedAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int event = e.getKeyCode();
        switch (event) {
            case KeyEvent.VK_Z -> state.ZReleasedAction();
            case KeyEvent.VK_S -> state.SReleasedAction();
            case KeyEvent.VK_UP -> state.UpReleasedAction();
            case KeyEvent.VK_DOWN -> state.DownReleasedAction();
        }
    }
}
