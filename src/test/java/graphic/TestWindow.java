package graphic;

import engine.graphic.Window;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TestWindow {

    @Test
    void addIdentityAndGetIdentity() throws IOException {
        Window window = new Window("test",100,100,5);
        GraphicIdentity identity = new GraphicIdentity("id","",0,0,10,10,0);
        window.addIdentity(identity);
        assertEquals(identity,window.getIdentity("id"));
    }

    @Test
    void removeIdentity() throws IOException {
        Window window = new Window("test",100,100,5);
        GraphicIdentity identity = new GraphicIdentity("id","",0,0,10,10,0);
        window.addIdentity(identity);
        assertEquals(identity,window.getIdentity("id"));
        window.removeIdentity("id");
        assertNotEquals(identity,window.getIdentity("id"));
    }

}