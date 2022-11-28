package gameplay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputEngine implements KeyListener {

    private boolean[] events = new boolean[4];

    public InputEngine() {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int event = e.getKeyCode();
        if(event == KeyEvent.VK_Z){
            events[0]=true;
        }
        if(event == KeyEvent.VK_S){
            events[1]=true;
        }
        if(event == KeyEvent.VK_UP){
            events[2]=true;
        }
        if(event == KeyEvent.VK_DOWN){
            events[3]=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int event = e.getKeyCode();
        if(event == KeyEvent.VK_Z){
            events[0] = false;
        }
        if(event == KeyEvent.VK_S){
            events[1] = false;
        }
        if(event == KeyEvent.VK_UP){
            events[2] = false;
        }
        if(event == KeyEvent.VK_DOWN){
            events[3] = false;
        }
    }
}
