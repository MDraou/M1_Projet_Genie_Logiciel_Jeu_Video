package graphic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Sprite {
    private static BufferedImage spriteSheet;
    private static int TILE_SIZE = 32;

    private static final Logger logger = LogManager.getLogger(Sprite.class);

    public static BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Loading image at path {0}", file));
        try { sprite = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource(file))); }
        catch (NullPointerException | IOException e) { logger.error(MessageFormat.format("Error: Cannot load image at path: {0}", file)); }
        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid) {
        BufferedImage sprite = null;
        if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Loading sprite at index [{0}, {1}]", xGrid, yGrid));
        try { sprite = spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE); }
        catch (NullPointerException e) { logger.error(MessageFormat.format("Error: No sprite loaded", (Object) null)); }
        return sprite;
    }

    public static void setTileSize(int size) {
        TILE_SIZE = size;
    }
}
