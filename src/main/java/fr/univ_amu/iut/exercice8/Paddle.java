package fr.univ_amu.iut.exercice8;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.Color;

public class Paddle extends Rectangle {
    private DoubleProperty paddleY = new SimpleDoubleProperty();

    private double initPaddleTranslateY;
    private double paddleDragAnchorY;


    public Paddle(double x) {


    }
}
