package physicpackage;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine {
    private List<PhysicalEntity> physicalEntities = new ArrayList<>();

    public void addPhysicalEntity(PhysicalEntity physicalEntity) {
        physicalEntities.add(physicalEntity);
    }

    public PhysicalEntity getPhysicalEntity(int index) {
        return physicalEntities.get(index);
    }

    public void update() {
        for (PhysicalEntity physicalEntity : physicalEntities) {
            physicalEntity.update();
        }
    }
}
