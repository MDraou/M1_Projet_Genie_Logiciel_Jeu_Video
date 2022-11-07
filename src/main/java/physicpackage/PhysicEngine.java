package physicpackage;

import CoreKernel.Entity;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine implements IPhysicEngine {
    private final List<PhysicalEntity> physicalEntities = new ArrayList<>();

    public void addPhysicalEntity(PhysicalEntity physicalEntity) {
        physicalEntities.add(physicalEntity);
    }

    public PhysicalEntity getEntity(int index) {
        return physicalEntities.get(index);
    }

    @Override
    public void update() {
        for (PhysicalEntity physicalEntity : physicalEntities) {
            physicalEntity.update(physicalEntities);
        }
    }





}
