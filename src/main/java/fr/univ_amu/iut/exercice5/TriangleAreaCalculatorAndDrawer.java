package fr.univ_amu.iut.exercice5;

import com.sun.prism.paint.*;
import fr.univ_amu.iut.exercice3.TriangleArea;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Color;


public class TriangleAreaCalculatorAndDrawer extends Application {
    private TriangleArea triangleArea = new TriangleArea();

    private Slider x1Slider = new Slider(0, 10, 0);
    private Slider x2Slider = new Slider(0, 10, 0);
    private Slider x3Slider = new Slider(0, 10, 0);

    private Slider y1Slider = new Slider();
    private Slider y2Slider = new Slider();
    private Slider y3Slider = new Slider();

    private Label x1Label = new Label("X1 :");
    private Label x2Label = new Label("X2 :");
    private Label x3Label = new Label("X3 :");

    private Label y1Label = new Label("Y1 :");
    private Label y2Label = new Label("Y2 :");
    private Label y3Label = new Label("Y3 :");

    private Label areaLabel = new Label("Area :");
    private TextField areaTextField = new TextField();

    private Line p1p2 = new Line();
    private Line p2p3 = new Line();
    private Line p3p1 = new Line();

    private Pane drawPane = new Pane();

    private GridPane root = new GridPane();

    @Override
    public void start(Stage stage) throws Exception {
        configGridPane();
        configSliders();
        addSliders();
        addArea();
        addPointLabels();
        addDrawPane();
        createBinding();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Triangle Area Calculator");
        stage.show();
    }




    private void configSliders() {
        configSlider(x1Slider);
        configSlider(y1Slider);

        configSlider(x2Slider);
        configSlider(y2Slider);

        configSlider(x3Slider);
        configSlider(y3Slider);
    }

    private void addDrawPane() {
        root.add(drawPane, 1,11,2,1);
        drawPane.setMinWidth(500);
        drawPane.setMinHeight(500);
        drawPane.setStyle("-fx-background-color: gray");
        drawPane.getChildren().addAll(p1p2,p2p3,p3p1);

    }

    private void configSlider(Slider slider) {
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);
            slider.setSnapToTicks(true);
            slider.setBlockIncrement(1);
            slider.setMajorTickUnit(5);
            slider.setMin(0);
            slider.setMax(10);

    }

    private void configGridPane() {
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(50);
        column1.setMinWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setFillWidth(true);
        root.getColumnConstraints().addAll(column1, column2);

    }

    private void addArea() {
        root.add(areaTextField,2, 10);
        root.add(areaLabel,1,10);
    }

    private void addSliders() {
        root.add(x1Label,1,1);
        root.add(x1Slider, 2, 1);

        root.add(y1Label,1,2);
        root.add(y1Slider, 2, 2);

        root.add(x2Label,1,4);
        root.add(x2Slider, 2, 4);

        root.add(y2Label,1,5);
        root.add(y2Slider, 2, 5);

        root.add(x3Label,1,7);
        root.add(x3Slider, 2, 7);

        root.add(y3Label,1,8);
        root.add(y3Slider, 2, 8);
    }

    private void addPointLabels() {
        Label P1Label = new Label("P1 :");
        Label P2Label = new Label("P2 :");
        Label P3Label = new Label("P3 :");

        root.add(P1Label,2,0,8,1);
        root.add(P2Label,2,3,8,1);
        root.add(P3Label,2,6,8,1);
    }

    private void createBinding() {
        triangleArea.x1Property().bind(x1Slider.valueProperty());
        triangleArea.x2Property().bind(x2Slider.valueProperty());
        triangleArea.x3Property().bind(x3Slider.valueProperty());
        triangleArea.y1Property().bind(y1Slider.valueProperty());
        triangleArea.y2Property().bind(y2Slider.valueProperty());
        triangleArea.y3Property().bind(y3Slider.valueProperty());

        p1p2.startXProperty().bind(x1Slider.valueProperty().multiply(50));
        p1p2.endXProperty().bind(x2Slider.valueProperty().multiply(50));

        p1p2.startYProperty().bind(y1Slider.valueProperty().multiply(50));
        p1p2.endYProperty().bind(y2Slider.valueProperty().multiply(50));
        p2p3.startXProperty().bind(x2Slider.valueProperty().multiply(50));
        p2p3.endXProperty().bind(x3Slider.valueProperty().multiply(50));
        p2p3.startYProperty().bind(y2Slider.valueProperty().multiply(50));
        p2p3.endYProperty().bind(y3Slider.valueProperty().multiply(50));
        p3p1.startXProperty().bind(x3Slider.valueProperty().multiply(50));
        p3p1.endXProperty().bind(x1Slider.valueProperty().multiply(50));
        p3p1.startYProperty().bind(y3Slider.valueProperty().multiply(50));
        p3p1.endYProperty().bind(y1Slider.valueProperty().multiply(50));

        areaTextField.textProperty().bind(triangleArea.areaProperty().asString());


    }
}
