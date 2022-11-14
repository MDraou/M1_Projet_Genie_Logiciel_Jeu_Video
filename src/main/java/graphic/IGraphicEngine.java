package graphic;

import kernel.Engine;

/**
 * The interface representing the graphic engines.
 */
public interface IGraphicEngine extends Engine {
    /**
     * Return the graphic engine window.
     * @return the window
     */
    Window getWindow();
    void start();
}
