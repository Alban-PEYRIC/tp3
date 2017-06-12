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
        super(x, 0, 20, 20);
        setFill(javafx.scene.paint.Color.ALICEBLUE);
        setCursor(Cursor.CLOSED_HAND);

        setOnMousePressed(me -> {
            initPaddleTranslateY = getTranslateY();
            paddleDragAnchorY = me.getSceneY();
        });
        setOnMouseDragged(me -> {
            double dragY = me.getSceneY() - paddleDragAnchorY;
            paddleY.setValue(initPaddleTranslateY + dragY);
        });

        translateYProperty().bind(paddleY);
        paddleY.setValue(200);
    }
}




