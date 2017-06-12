package fr.univ_amu.iut.exercice7;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import static javafx.beans.binding.Bindings.negate;
import static javafx.beans.binding.Bindings.when;

public class Ball {

    private final DoubleProperty positionX;
    private final DoubleProperty positionY;
    private final DoubleProperty velocityX; //en pixel par nanosecond
    private final DoubleProperty velocityY; //en pixel par nanosecond
    private final DoubleProperty radius;
    private final Pane parent;
    private Circle ball;

    private BooleanExpression isBouncingOffVerticalWall;
    private BooleanExpression isBouncingOffHorizontalWall;

    private NumberBinding bounceOffVerticalWall;
    private NumberBinding bounceOffHorizontalWall;

    public Ball(Pane parent) {
        this.velocityX = new SimpleDoubleProperty(250E-9);
        this.velocityY = new SimpleDoubleProperty(100E-9);
        this.positionX = new SimpleDoubleProperty(100);
        this.positionY = new SimpleDoubleProperty(100);
        this.radius = new SimpleDoubleProperty(20);
        this.parent = parent;
        this.ball = new Circle();
        ball.setRadius(radius.doubleValue());
        ball.setCenterY(positionY.doubleValue());
        ball.setCenterX(positionX.doubleValue());



        parent.getChildren().add(ball);

        createBindings();
    }

    private void createBindings() {
        ball.radiusProperty().bind(radius);
        ball.centerXProperty().bind(positionX);
        ball.centerYProperty().bind(positionY);

        isBouncingOffVerticalWall = positionX.lessThan(radius).or(positionX.greaterThan(parent.widthProperty().subtract(radius)));
        isBouncingOffHorizontalWall = positionY.lessThanOrEqualTo(radius).or(positionY.greaterThanOrEqualTo(parent.heightProperty().subtract(radius)));

        bounceOffHorizontalWall = Bindings.when(isBouncingOffHorizontalWall).then(velocityY.negate()).otherwise(velocityY);
        bounceOffVerticalWall = Bindings.when(isBouncingOffVerticalWall).then(velocityX.negate()).otherwise(velocityX);

    }

    public void move(long elapsedTimeInNanoseconds) {


        velocityY.setValue(bounceOffHorizontalWall.doubleValue());
        velocityX.setValue(bounceOffVerticalWall.doubleValue());




        positionX.setValue(positionX.doubleValue()+velocityX.doubleValue()*elapsedTimeInNanoseconds);
        positionY.setValue(positionY.doubleValue()+velocityY.doubleValue()*elapsedTimeInNanoseconds);


    }
}
