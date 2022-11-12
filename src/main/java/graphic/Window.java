package graphic;

import javax.swing.*;
import java.util.ArrayList;

public class Window extends JFrame {

    private final ArrayList<Layer> layers = new ArrayList<>();

    public Window(String title, int width, int height, int nbLayer) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < nbLayer; i++) {
            Layer layer = new Layer();
            layers.add(layer);
            super.add(layer);
        }
    }

    public void start() {
        setVisible(true);
    }

    public void addIdentity(IGraphicIdentity identity) {
        layers.get(identity.getLayer()).put(identity.getId(), identity);
    }

    public void removeIdentity(String id) {
        for (Layer layer : layers) if (layer.contain(id)) { layer.remove(id); return ; }
    }

    public IGraphicIdentity getIdentity(String id) {
        IGraphicIdentity identity = null;
        for (Layer layer : layers) if (layer.contain(id)) { identity = layer.get(id); break;}
        return identity;
    }

    public void update() {
        for (Layer layer : layers) layer.repaint();
        validate();
    }
}
