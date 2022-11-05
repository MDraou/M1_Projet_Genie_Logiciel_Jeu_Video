package sample;

import CoreKernel.CoreKernel;
import graphic.GraphicEngine;
import physicpackage.PhysicEngine;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Prototype {
    public static void main(String[] args) {
        CoreKernel coreKernel = new CoreKernel(new PhysicEngine(), new GraphicEngine(1500, 1300, "OISEAU"));
        coreKernel.start();
        Dimension2D dimension = new Dimension(70, 70);
        coreKernel.createEntity(new Point2D.Double(250, 150), "image.png", dimension);


    }
}
