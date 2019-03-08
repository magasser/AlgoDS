package serie02.exercise01.exercise02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FloodFill extends Application {
    public static final int SIZE = 10;
    public static final int A = 100;
    public static final int B = 100;

    public static Canvas canvas;
    public static boolean[][] points = new boolean[A][B];

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root , 800, 800);
        canvas = new Canvas(scene.getWidth(), scene.getHeight());

        root.getChildren().add(canvas);

        points = makeHeart(A,B);
        drawGrid();
        floodFill(points, 15, 15, A, B);

        stage.setScene(scene);
        stage.show();
    }

    public void floodFill(boolean[][] points, int x, int y, int a, int b){
        if(a-1 < x || b-1 < y) return;
        if(x < 0 || y < 0) return;
        if(points[x][y]) return;

        drawPoint(x,y);

        floodFill(points, x+1, y, a, b);
        floodFill(points, x, y+1, a, b);
        floodFill(points, x-1, y, a, b);
        floodFill(points, x, y-1, a, b);
    }

    public boolean[][] makeHeart(int a, int b){
        boolean[][] heart = new boolean [a][b];

        for(int x = 10; x < 50; x++){
            heart[x][10] = true;
        }
        for(int y = 10; y < 50; y++){
            heart[10][y] = true;
        }
        for(int x = 10; x < 51; x++){
            heart[x][50] = true;
        }
        for(int y = 10; y < 50; y++){
            heart[50][y] = true;
        }


        return heart;
    }

    public static void drawPoint(int x, int y){
        points[x][y] = true;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(x*SIZE, y*SIZE, SIZE, SIZE);
    }

    public static void drawGrid(){
        for(int x = 0; x < points.length; x++){
            for(int y = 0; y < points[x].length; y++){
                if(points[x][y]){
                    drawPoint(x,y);
                }
            }

        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
