package sample;

import CoreKernel.CoreKernel;
import graphic.GraphicEngine;
import physicpackage.PhysicEngine;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Prototype {
    public static void main(String[] args) throws InterruptedException {
        CoreKernel coreKernel = new CoreKernel(new PhysicEngine(), new GraphicEngine(700, 700, "OISEAU"));
        coreKernel.start();
        Dimension2D dimension = new Dimension(70, 70);
        int idTux = coreKernel.createEntity(new Point2D.Double(150, 150), "image.png", dimension);
        int idTux2 = coreKernel.createEntity(new Point2D.Double(500, 150), "image.png", dimension);

        Dimension2D dimensionHWall = new Dimension(700, 100);
        coreKernel.createEntity(new Point2D.Double(0.0, 0.0), "wall_h.png", dimensionHWall);
        coreKernel.createEntity(new Point2D.Double(0.0, 600), "wall_h.png", dimensionHWall);
        Dimension2D dimensionVWall = new Dimension(100, 700);
        coreKernel.createEntity(new Point2D.Double(0.0, 0.0), "wall_v.png", dimensionVWall);
        coreKernel.createEntity(new Point2D.Double(600, 0.0), "wall_v.png", dimensionVWall);

        coreKernel.getPhysicEngine().getPhysicalEntity(idTux).getPhysicalInformations().setSpeed(2, 0);
        coreKernel.getPhysicEngine().getPhysicalEntity(idTux2).getPhysicalInformations().setSpeed(1, 0);
        while (coreKernel.getPhysicEngine().getPhysicalEntity(idTux).getPhysicalInformations().getSpeed()
                .elementAt(0) != 0) {
            coreKernel.update();
            Thread.sleep(25);
        }
        coreKernel.getPhysicEngine().getPhysicalEntity(idTux).getPhysicalInformations().setSpeed(0, -1);
        coreKernel.getPhysicEngine().getPhysicalEntity(idTux2).getPhysicalInformations().setSpeed(0, 1);
        while (coreKernel.getPhysicEngine().getPhysicalEntity(idTux2).getPhysicalInformations().getSpeed()
                .elementAt(1) != 0) {
            coreKernel.update();
            Thread.sleep(25);
        }
        coreKernel.getPhysicEngine().getPhysicalEntity(idTux).getPhysicalInformations().setSpeed(-1, 1);
        coreKernel.getPhysicEngine().getPhysicalEntity(idTux2).getPhysicalInformations().setSpeed(-1, -1);
        while (coreKernel.getPhysicEngine().getPhysicalEntity(idTux2).getPhysicalInformations().getSpeed()
                .elementAt(1) != 0) {
            coreKernel.update();
            Thread.sleep(25);
        }

    }
}
