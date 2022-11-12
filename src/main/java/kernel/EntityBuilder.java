package kernel;

import graphic.GraphicIdentity;
import physic.PhysicIdentity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.MessageFormat;

public class EntityBuilder implements IEntityBuilder {

    private Entity entity;

    private static final Logger logger = LogManager.getLogger(EntityBuilder.class);

    @Override
    public void reset() {
        entity.clear();
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void buildGraphicIdentity(String spritePath, int x, int y, int width, int height, int layer) {
        if (entity == null) return ;
        if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Creating graphic identity to {0}...", entity.getId()));
        try { entity.setGraphic(new GraphicIdentity(entity.getId(), spritePath, x, y, width, height, layer)); }
        catch (IOException e) { logger.error(MessageFormat.format("Error: Cannot load image at path: {0}", spritePath)); }
    }

    public void buildPhysicIdentity(int x, int y, int width, int height, int layer) {
        if (entity == null) return ;
        if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Creating physic identity to {0}...", entity.getId()));
        entity.setPhysic(new PhysicIdentity(entity.getId(), x, y, width, height, layer));
    }
}
