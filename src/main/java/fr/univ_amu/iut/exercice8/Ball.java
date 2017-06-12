package fr.univ_amu.iut.exercice8;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.awt.*;

public class Ball extends Circle {

    private final DoubleProperty velocityX;//en pixel par nanosecond
    private final DoubleProperty velocityY;//en pixel par nanosecond

    public Ball() {
        super(250,250,10, Color.BLUEVIOLET);

        velocityX = new SimpleDoubleProperty(150E-9);
        velocityY = new SimpleDoubleProperty(100E-9);

    }

    public boolean collided(Shape other) {
        throw new RuntimeException("Not yet implemented !");
    }


    public double getVelocityX() {
        return velocityX.get();
    }

    public void setVelocityX(double velocityX) {
        this.velocityX.set(velocityX);
    }

    public DoubleProperty velocityXProperty() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY.get();
    }

    public void setVelocityY(double velocityY) {
        this.velocityY.set(velocityY);
    }

    public DoubleProperty velocityYProperty() {
        return velocityY;
    }
}
