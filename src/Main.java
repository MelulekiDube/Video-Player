/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 *
 * @author Meluleki
 */
public class Main extends Application {

    Player player;
    FileChooser filechooser;

    /**
     * Set the state and show the videos
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        filechooser = new FileChooser();
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.mplayer.pause();
                File fl = filechooser.showOpenDialog(primaryStage);
                if (fl != null) {
                    try {
                        player = new Player(fl.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player, 720, 535, Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        file.getItems().add(open);
        menu.getMenus().add(file);
        player = new Player("file:///C:/ts.mp4.MP4");
        player.setTop(menu);
        Scene scene = new Scene(player, 720, 535, Color.BLACK);
        File files = new File(player.media.getSource());
        primaryStage.setTitle(files.getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
