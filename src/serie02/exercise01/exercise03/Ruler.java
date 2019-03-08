package serie02.exercise01.exercise03;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ruler extends Application {

    public static Canvas canvas;
    public static int pos;
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1500, 400);
        canvas = new Canvas();
        canvas.heightProperty().bind(scene.heightProperty());
        canvas.widthProperty().bind(scene.widthProperty());
        pos = 20;


        ruler(6);

        root.getChildren().add(canvas);

        stage.setScene(scene);
        stage.show();
    }

    public static void ruler(int n){
        if(n == 0) return;

        ruler(n-1);
        drawLine(n);
        ruler(n-1);

        return;
    }

    public static void drawLine(int k){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setLineWidth(1);
        if(pos == 20){
            gc.moveTo(pos-10, 200);
            gc.lineTo(pos, 200);
            gc.stroke();
        }
        gc.moveTo(pos, 200);
        gc.lineTo(pos, 200 - k * 10);
        gc.stroke();
        gc.moveTo(pos, 200);
        gc.lineTo(pos+10, 200);
        gc.stroke();
        pos += 10;
    }
}
