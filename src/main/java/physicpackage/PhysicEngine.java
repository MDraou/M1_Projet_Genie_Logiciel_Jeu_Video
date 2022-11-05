package physicpackage;

import CoreKernel.Engine;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine implements Engine {
    private final List<PhysicalEntity> physicalEntities = new ArrayList<>();

    public void addPhysicalEntity(PhysicalEntity physicalEntity) {
        physicalEntities.add(physicalEntity);
    }

    public PhysicalEntity getPhysicalEntity(int index) {
        return physicalEntities.get(index);
    }

    @Override
    public void update() {
        for (PhysicalEntity physicalEntity : physicalEntities) {
            Move.move(physicalEntity, physicalEntities);
        }
    }
}
