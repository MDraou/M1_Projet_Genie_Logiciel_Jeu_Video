package kernel;

import graphic.GraphicEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import physic.PhysicEngine;

import java.text.MessageFormat;

public class EngineBuilder implements IEngineBuilder {

    private final EngineManager manager;

    private static final Logger logger = LogManager.getLogger(EngineBuilder.class);

    public EngineBuilder(EngineManager manager) {
        this.manager = manager;
    }

    @Override
    public void reset() {
        manager.clear();
    }

    public void buildGraphicEngine(String name, int width, int height, int nbLayer) {
        if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Creating graphic engine...", (Object) null));
        manager.setGraphic(new GraphicEngine(name, width, height, nbLayer));
    }

    public void buildPhysicEngine() {
        if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Creating physic engine...", (Object) null));
        manager.setPhysic(new PhysicEngine());
    }
}
