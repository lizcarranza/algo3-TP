package org.example.juego;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class View {
    private Button buttons[][];
    private GridPane grid;
    private Scene s;
    private TilePane tilePane;

    public View(Stage stage){
        s = new Scene(createContent());
        stage.setScene(s);
        stage.setTitle("Minesweeper");
        stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/595/595582.png"));

        stage.show();
    }

    private Parent createContent() {

        grid = new GridPane();
        for (int j = 0; j < 10; j++){
            for (int i= 0; i<10; i++){
                grid.add(new Button("0"), i, j);
            }
        }


        return grid;
    }
}